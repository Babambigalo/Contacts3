package com.example.android.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateActivity extends AppCompatActivity {
//    EditText et_Names = (EditText) findViewById(R.id.et_name);
//    EditText et_Numbers = (EditText) findViewById(R.id.et_number);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        final EditText et_Names = (EditText) findViewById(R.id.et_name);
//        final EditText et_Numbers = (EditText) findViewById(R.id.et_number);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setImageResource(R.drawable.ic_check_hdpi);



//        if (getIntent().getStringExtra("name")!= null){
//            String dataName = getIntent().getStringExtra("name");
//            String dataNumber = getIntent().getStringExtra("number");
//            et_Names.setText(dataName);
//            et_Numbers.setText(dataNumber);
//        }





        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText et_Names = (EditText) findViewById(R.id.et_name);
                EditText et_Numbers = (EditText) findViewById(R.id.et_number);
                Log.v("et_names ","length = " + et_Names.getText().toString().length());
                Intent toMainActivity = new Intent();
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
            Intent toFirstActivity = new Intent();
            setResult(RESULT_CANCELED, toFirstActivity);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }


}
