package org.pondar.firstapp;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{

    /* not used for anything - but just to show some types */
    private String test = "test";
    private int number = 2;
    protected String myName = "martin";
    private float floating = 1.2f;
    private Toast toast;
    Person p = new Person(60, "Per");
    ArrayList<Person> people = new ArrayList<>();
    Random random = new Random();
    Context context;
    int duration = toast.LENGTH_LONG;

    //The onCreate method will be called EVERY time
    //our app comes into the foreground view for the user
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        context = getApplicationContext();

        for (int i = 0; i < 5; i++)
        {
            people.add(new Person(random.nextInt(), "Simon"));
        }

        for (Person p : people)
        {
            toast = Toast.makeText(context, p.toString(p), duration);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();

        }

        super.onCreate(savedInstanceState);
        //This line sets the xml file "activity_main" in the layout folder as our main layout
        setContentView(R.layout.activity_main);
        //we find our toolbar (defined in the activity_main.xml file)
        Toolbar toolbar = findViewById(R.id.toolbar);
        //we set this as our toolbar
        setSupportActionBar(toolbar);

        //We find our floating action button - again defined in the activity_main
        FloatingActionButton fab = findViewById(R.id.fab);
        //we also need to set a listener, so something happens, when the user
        //clicks the button.
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //you can read about what the Snackbar does or
                //simple try the app on your device or on your emulator.
                view.setVisibility(View.GONE);
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // it will look for the menu_main.xml file in the menu folder.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch(item.getItemId())
        {
            case R.id.action_settings:
                //well, actually we will just display a message to the user here.
                toast = Toast.makeText(this,"Settings Pressed",Toast.LENGTH_LONG);
                toast.show();
                return true;

                case R.id.action_another:
                toast = Toast.makeText(this, "Something was pressed", Toast.LENGTH_SHORT);
                toast.show();
                return true;

                default:
                return super.onOptionsItemSelected(item);
        }
    }
}