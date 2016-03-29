package chat.example.sachin.speechifyproject2;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import chat.example.sachin.speechifyproject2.adapter.IngrediantListAdapter;
import chat.example.sachin.speechifyproject2.adapter.RecipeNameAdapter;
import chat.example.sachin.speechifyproject2.model.Ingredient;
import chat.example.sachin.speechifyproject2.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class IngredientNamesActivity extends Activity {

    ListView listView;
    List<Ingredient> ingredientList;
    IngrediantListAdapter ingrediantListAdapter;
    public static String  Ingredient_LIST="Ingredient_LIST";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_names);
        listView=(ListView)findViewById(R.id.listView);
        ingredientList=new ArrayList<>();
        Intent i=getIntent();
        Recipe r=(Recipe)i.getExtras().getSerializable(Ingredient_LIST);
        ingredientList=r.getIngredient_data();
        if(ingredientList!=null && ingredientList.size()>0){
            ingrediantListAdapter= new IngrediantListAdapter(this,ingredientList);
            listView.setAdapter(ingrediantListAdapter);
        }
        else{

            Log.d("ingrediantList.size()", r.getName());
        }

    }
}
