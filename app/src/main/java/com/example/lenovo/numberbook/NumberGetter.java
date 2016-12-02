package com.example.lenovo.numberbook;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

import java.util.ArrayList;

/**
 * Created by lenovo on 2016/12/1.
 */

public class NumberGetter {
    private Context mContext;
    private int myContract;
    private  final String[] PHONES_PROJECTION = new String[] {
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER , ContactsContract.CommonDataKinds.Photo.PHOTO_ID, ContactsContract.CommonDataKinds.Phone.CONTACT_ID };

    public  NumberGetter(Context context){
        mContext=context;
    }

    public ArrayList<PhoneNumber> getPhoneNumber(){
        ArrayList<PhoneNumber>mNumber=new ArrayList<>();
        String name;
        String number;
        int nameID=0;
        int numberID=1;
        int contractID=3;


        ContentResolver phonerResolver=mContext.getContentResolver();
        Cursor numberCursor=phonerResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,PHONES_PROJECTION,null,null,null);
        if (numberCursor!=null){

            while (numberCursor.moveToNext()){

                number=numberCursor.getString(numberID);
                if (number==null)
                    continue;
                name=numberCursor.getString(nameID);
                PhoneNumber phoneNumber=new PhoneNumber(name,number);
                mNumber.add(phoneNumber);
                myContract=numberCursor.getInt(contractID);

            }

            numberCursor.close();

        }return mNumber;
}


}
