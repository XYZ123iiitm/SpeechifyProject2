package chat.example.sachin.speechifyproject2.fragment;

import android.os.Parcelable;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;

import android.os.Bundle;
import android.util.Log;

import chat.example.sachin.speechifyproject2.adapter.RecipeNameAdapter;
import chat.example.sachin.speechifyproject2.model.Ingredient;
import chat.example.sachin.speechifyproject2.model.Recipe;
import chat.example.sachin.speechifyproject2.utils.JSONParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RecipeNameFragment extends ListFragment {

    private RecipeNameAdapter mAdapter;
    private  List<Recipe> recipeList;
    private final String url="http://www.speechify.in/internship/android_task.php";

    public static Fragment getInstance() {
        RecipeNameFragment fragment = new RecipeNameFragment();
        Log.d("dsf1","dsafd");
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setListShown(true);

        recipeList=new ArrayList<>();
        Log.d("dsf2","dsafd");
        getJsonData(url);
        Log.d("dsf4", String.valueOf(recipeList.size()));
        mAdapter = new RecipeNameAdapter( getActivity(),recipeList);
        setListAdapter(mAdapter);
    }

    private  void getJsonData(String url){
        JSONParser jsonParser=new JSONParser();
        JSONObject jsonObject=jsonParser.getJSONFromUrl(url);

        if(jsonObject!=null){
            Log.d("dsf3","dfadsf");
            String status="";
            JSONArray recipe_data=null;
            try {
                status=jsonObject.getString("status");
                recipe_data=jsonObject.getJSONArray("recipe_data");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if(recipe_data!=null){
                for (int i = 0; i < recipe_data.length(); i++) {
                    JSONObject jsonobject = null;
                    try {
                        jsonobject = recipe_data.getJSONObject(i);
                        if(jsonobject!=null){
                            String id=jsonobject.getString("id");
                            String name = jsonobject.getString("name");
                            JSONArray ingredient_data = jsonobject.getJSONArray("ingredient_data");
                            List<Ingredient> ingredientList=new ArrayList<>();
                            if(ingredient_data!=null){
                                Log.d("ingredient_data",String.valueOf(ingredient_data.length()));
                                for (int j=0;j<ingredient_data.length();j++){
                                    JSONObject jsonObject1=ingredient_data.getJSONObject(j);
                                    String ingredient_id=jsonObject1.getString("ingredient_id");
                                    String ingredient_name=jsonObject1.getString("ingredient_name");
                                    Ingredient ingredient=new Ingredient(ingredient_id,ingredient_name);
                                    ingredientList.add(ingredient);
                                }
                            }
                            Recipe recipe=new Recipe(id,name,ingredientList);
                            recipeList.add(recipe);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}