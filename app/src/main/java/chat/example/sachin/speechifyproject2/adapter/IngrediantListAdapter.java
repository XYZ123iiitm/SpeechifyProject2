package chat.example.sachin.speechifyproject2.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import chat.example.sachin.speechifyproject2.R;
import chat.example.sachin.speechifyproject2.model.Ingredient;

/**
 * Created by Sachin on 28-03-2016.
 */
public class IngrediantListAdapter extends BaseAdapter{

    List<Ingredient> ingrediantList=new ArrayList<>();
    Context context;
    public IngrediantListAdapter(Context context,List<Ingredient> ingrediantList) {
        this.context=context;
        this.ingrediantList=ingrediantList;
        if(ingrediantList!=null && ingrediantList.size()>0) {
            for (Ingredient ingredient : ingrediantList) {
                String name = ingredient.getIngredient_name();
                Log.d("name", name);
            }
        }
        else{
            Log.d("ingrediantList.size()"," 0000000000000000 ");
        }
    }

    @Override
    public int getCount() {
        return ingrediantList.size();
    }

    @Override
    public Object getItem(int position) {
        return ingrediantList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String name =((Ingredient)getItem(position)).getIngredient_name();
        Log.d("name1",name);
        ViewHolder holder;
        if( convertView == null ) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate( R.layout.ingredient_item_list, parent, false );
            holder.ingredient_id = (TextView) convertView.findViewById( R.id.ingredient_id);
            holder.ingredient_name = (TextView) convertView.findViewById( R.id.ingredient_name);

            convertView.setTag( holder );
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        String id =((Ingredient)getItem(position)).getIngredient_id();

        holder.ingredient_id.setText(id);
        holder.ingredient_name.setText(name);

        return convertView;
    }

    class ViewHolder {
        TextView ingredient_id,ingredient_name;
    }
}
