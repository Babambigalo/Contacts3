package com.example.android.contacts;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by nmatveev on 21.09.2017.
 */


///public class ContactAdapter extends ArrayAdapter<Contact> {


public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>  {
    RecyclerView rv;
    TextView mName;
    TextView mNumber;
    OnItemClickListener mItemClickListener;



    public class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
       public ContactViewHolder(View itemView){
           super(itemView);
           itemView.setOnClickListener(this);
           rv = itemView.findViewById(android.R.layout.simple_list_item_2);
           mName = itemView.findViewById(android.R.id.text1);
           //mNumber = itemView.findViewById(android.R.id.text2);
           mNumber = itemView.findViewById(android.R.id.text2);

       }

        @Override
        public void onClick(View view) {
//            Intent toCreateActivity = new Intent();
//            toCreateActivity.putExtra("name",mName.getText().toString());
//            toCreateActivity.putExtra("number",mNumber.getText().toString());
//
//
//
            EditText et_name = itemView.findViewById(R.id.et_name);
//            EditText et_number = itemView.findViewById(R.id.et_number);
//            et_name.setText(mName.getText());
//            et_number.setText(mNumber.getText());
//
//            itemView.getContext().startActivity(toCreateActivity);
            Toast.makeText(itemView.getContext(),"et_name = " + mName.getText(),Toast.LENGTH_SHORT).show();







        }
    }





    ArrayList<Contact> contacts;
    public ContactAdapter(ArrayList<Contact> dataContacts) {
        contacts=dataContacts;

    }


    @Override
    public int getItemCount() {
        return contacts.size();
    }

    @Override
    public ContactAdapter.ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2,parent,false);
        ContactViewHolder cvh = new ContactViewHolder(itemView);


        return cvh;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        mName.setText(contacts.get(position).getContactName());
        mNumber.setText(contacts.get(position).getContactNumber());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    //    @Override
//    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2,parent,false);
//
//
//    }


//


}
