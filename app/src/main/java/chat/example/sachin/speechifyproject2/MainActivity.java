package chat.example.sachin.speechifyproject2;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import chat.example.sachin.speechifyproject2.fragment.RecipeNameFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Log.d("dsf", "dddsafd");
        displayInitialFragment();
    }

    public void displayInitialFragment() {
        Log.d("dsf", "dddsafd");
        getSupportFragmentManager().beginTransaction().replace(R.id.container, RecipeNameFragment.getInstance()).commit();
    }

}
