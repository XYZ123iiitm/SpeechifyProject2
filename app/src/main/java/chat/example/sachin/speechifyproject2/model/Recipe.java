package chat.example.sachin.speechifyproject2.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Sachin on 28-03-2016.
 */
public class Recipe implements Serializable{
    private  String id;
    private String name;
    private List<Ingredient> ingredient_data;

    public Recipe(String id, String name, List<Ingredient> ingredient_data) {
        this.id = id;
        this.name = name;
        this.ingredient_data = ingredient_data;
    }

    protected Recipe(Parcel in) {
        id = in.readString();
        name = in.readString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredient_data() {
        return ingredient_data;
    }

    public void setIngredient_data(List<Ingredient> ingredient_data) {
        this.ingredient_data = ingredient_data;
    }
}
