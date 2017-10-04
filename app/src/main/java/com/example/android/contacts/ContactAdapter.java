package com.example.android.contacts;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nmatveev on 21.09.2017.
 */


///public class ContactAdapter extends ArrayAdapter<Contact> {


public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>  {
    RecyclerView rv;
    TextView mName;
    TextView mNumber;
    Intent toCreateActivity;
    public final static String nameFieldKey = "name";
    public final static String numberFieldKey = "number";





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
            toCreateActivity = new Intent(view.getContext(),CreateActivity.class);
            toCreateActivity.putExtra(nameFieldKey,mName.getText().toString());
            toCreateActivity.putExtra(numberFieldKey,mNumber.getText().toString());

            view.getContext().startActivity(toCreateActivity);








        }
    }





    ArrayList<Contact> contacts = new ArrayList<>();
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




}
