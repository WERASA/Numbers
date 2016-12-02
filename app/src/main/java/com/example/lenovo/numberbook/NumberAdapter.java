package com.example.lenovo.numberbook;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by lenovo on 2016/11/29.
 */

public class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.NumberHolder> implements View.OnClickListener{

    private Context mContext;
    private ArrayList<PhoneNumber>mNumber;
    private  MyItemClickListener myItemClickListener;
    NumberAdapter(Context context){
        mContext=context;

    }
    public void setOnItemClickListener(MyItemClickListener myItemClickListener){
        this.myItemClickListener=myItemClickListener;
    }
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public NumberHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        NumberHolder numberHolder =new  NumberHolder(v);

        return  numberHolder;
    }

    @Override
    public void onBindViewHolder(final NumberHolder holder, final int position) {
        final NumberHolder numberHolder=(NumberHolder) holder;
        NumberGetter numberGetter=new NumberGetter(mContext);
        ArrayList <PhoneNumber>mNumber=numberGetter.getPhoneNumber();
        TextView  myNumber=(TextView)holder.itemView.findViewById(R.id.mynumber1);
        TextView myName=(TextView)holder.itemView.findViewById(R.id.myname);
        myNumber.setText(mNumber.get(position).getmNumber());
        myName.setText(mNumber.get(position).getmName());
        if(myItemClickListener != null){

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition();
                    myItemClickListener.onItemClickListener(holder.itemView,position);
                }
            });
        }



    }



    @Override
    public int getItemCount() {
        NumberGetter numberGetter=new NumberGetter(mContext);

        mNumber=numberGetter.getPhoneNumber();
        return mNumber.size();
    }

    @Override
    public void onClick(View v) {

    }

    class NumberHolder extends RecyclerView.ViewHolder{




        NumberHolder(View itemView) {
            super(itemView);

        }
    }
}
