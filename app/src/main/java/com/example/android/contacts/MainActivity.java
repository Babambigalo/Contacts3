package com.example.android.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public int REQUEST_CODE = 1;
    ArrayList<Contact> contacts = new ArrayList<Contact>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setImageResource(R.drawable.ic_add_hdpi);
        fab.setBackgroundResource(R.color.BackgroundIcon);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent toCreateActivity = new Intent(MainActivity.this, CreateActivity.class);
                Log.v("ASD","Intent = "+ getIntent());
                startActivityForResult(toCreateActivity, REQUEST_CODE);


//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                //EditText et_Names = (EditText) findViewById(R.id.et_name);
                //EditText et_Numbers = (EditText) findViewById(R.id.et_number);
                contacts.add(new Contact(data.getStringExtra("name"), data.getStringExtra("number")));
                RecyclerView rv = (RecyclerView) findViewById(R.id.list);
                rv.setHasFixedSize(true);
                RecyclerView.LayoutManager layManager = new LinearLayoutManager(this );
                rv.setLayoutManager(layManager);
                ContactAdapter adapter = new ContactAdapter(contacts);
                rv.setAdapter(adapter);
            } else
                return;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {



        super.onPause();
    }
}
