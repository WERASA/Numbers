package com.example.lenovo.numberbook;

/**
 * Created by lenovo on 2016/11/29.
 */

public class PhoneNumber {
    private String mNumber;
    private String mName;
    public PhoneNumber(String name,String Number)
    {   mName=name;
        mNumber=Number;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmNumber() {
        return mNumber;
    }

    public void setmNumber(String mNumber) {
        this.mNumber = mNumber;
    }
}
