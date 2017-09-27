package com.example.android.contacts;

/**
 * Created by nmatveev on 21.09.2017.
 */

public class Contact {
    String mName;
    String mNumber;

    public Contact(String name, String number) {
        mName = name;
        mNumber = number;
    }

    public String getContactName() {
        return mName;
    }

    public String getContactNumber() {
        return mNumber;

    }

}
