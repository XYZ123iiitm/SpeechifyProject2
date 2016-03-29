package chat.example.sachin.speechifyproject2.model;

import java.io.Serializable;

/**
 * Created by Sachin on 28-03-2016.
 */
public class Ingredient implements Serializable{
    private String ingredient_id;
    private  String ingredient_name;

    public Ingredient(String ingredient_id, String ingredient_name) {
        this.ingredient_id = ingredient_id;
        this.ingredient_name = ingredient_name;
    }

    public String getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(String ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public String getIngredient_name() {
        return ingredient_name;
    }

    public void setIngredient_name(String ingredient_name) {
        this.ingredient_name = ingredient_name;
    }
}
