package com.example.android.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateActivity extends AppCompatActivity {

    public Intent toMainActivity = new Intent();
    public EditText et_Names;
    public EditText et_Numbers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {



        et_Names = (EditText)findViewById(R.id.et_name);
        et_Numbers = (EditText)findViewById(R.id.et_number);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setImageResource(R.drawable.ic_check_hdpi);


        Intent intentFromCreateActivity = getIntent();

        if(intentFromCreateActivity.hasExtra(ContactAdapter.numberFieldKey) == true ){
//
            String nameItem = intentFromCreateActivity.getStringExtra(ContactAdapter.nameFieldKey);
            //Log.v("num field = " +intentFromCreateActivity.getStringExtra(ContactAdapter.numberFieldKey),"name field = " +intentFromCreateActivity.getStringExtra(ContactAdapter.nameFieldKey));
            String numberItem = intentFromCreateActivity.getStringExtra(ContactAdapter.numberFieldKey);
            et_Names.setText(nameItem);
            et_Numbers.setText(numberItem);
         }






        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (et_Names.length() != 0 & et_Numbers.length() != 0) {

                    toMainActivity.putExtra("name", et_Names.getText().toString());
                    toMainActivity.putExtra("number", et_Numbers.getText().toString());



                    setResult(RESULT_OK, toMainActivity);
                    finish();
                } else if (et_Names.length() == 0 & et_Numbers.length() == 0) {
                    Toast.makeText(CreateActivity.this, "Please,enter name and phone number", Toast.LENGTH_SHORT).show();
                } else if (et_Names.length() == 0) {
                    Toast.makeText(CreateActivity.this, "Please,enter contact's name", Toast.LENGTH_SHORT).show();
                } else if (et_Numbers.length() == 0) {
                    Toast.makeText(CreateActivity.this, "Please,enter contact's phone number ", Toast.LENGTH_SHORT).show();
                }


//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //Intent toFirstActivity = new Intent();
            setResult(RESULT_CANCELED, toMainActivity);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }


}
