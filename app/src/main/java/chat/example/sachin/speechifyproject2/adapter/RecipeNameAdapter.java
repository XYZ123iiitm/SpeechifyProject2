package chat.example.sachin.speechifyproject2.adapter;

        import android.content.Context;
        import android.content.Intent;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.TextView;

        import java.util.ArrayList;
        import java.util.List;

        import chat.example.sachin.speechifyproject2.IngredientNamesActivity;
        import chat.example.sachin.speechifyproject2.R;
        import chat.example.sachin.speechifyproject2.model.Recipe;

/**
 * Created by Sachin on 28-03-2016.
 */
public class RecipeNameAdapter extends BaseAdapter {

    List<Recipe> recipeList=new ArrayList<>();
    Context context;
    public RecipeNameAdapter(Context context,List<Recipe> recipeList) {
        this.context=context;
        this.recipeList=recipeList;
        for(Recipe r:recipeList) {
            String name =r.getName();
            Log.d("name", name);
        }
    }

    @Override
    public int getCount() {
        return recipeList.size();
    }

    @Override
    public Object getItem(int position) {
        return recipeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final  Recipe r=((Recipe)getItem(position));
        String name=r.getName();
        Log.d("name1",name);
        ViewHolder holder;
        if( convertView == null ) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate( R.layout.fragment_recipe_name, parent, false );
            holder.recipeName = (TextView) convertView.findViewById( R.id.recipeName);
            convertView.setTag( holder );
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.recipeName.setText(name);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, IngredientNamesActivity.class );
                String name=r.getIngredient_data().get(0).getIngredient_name();
                Log.d("click",name);
                intent.putExtra(IngredientNamesActivity.Ingredient_LIST,r);
                context.startActivity( intent );
            }
        });

        return convertView;
    }


    class ViewHolder {
        TextView recipeName;
    }
}
