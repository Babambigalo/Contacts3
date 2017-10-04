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
    ContactAdapter mAdapter;
    public int REQUEST_CODE = 1;
    ArrayList<Contact> contacts = new ArrayList<>();



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
                //Log.v("ASD","Intent = "+ getIntent());
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
                RecyclerView rv = (RecyclerView) findViewById(R.id.list);
                rv.setHasFixedSize(true);
                RecyclerView.LayoutManager layManager = new LinearLayoutManager(this );
                rv.setLayoutManager(layManager);
                mAdapter = new ContactAdapter(contacts);
                mAdapter.notifyDataSetChanged();
                rv.setAdapter(mAdapter);
                contacts.add(new Contact(data.getStringExtra("name"), data.getStringExtra("number")));
                Log.v("asd","length = " + contacts.size());

            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

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
