package com.example.lenovo.numberbook;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.View;

import android.widget.ListView;
import android.widget.TextView;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
   private TextView newNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<PhoneNumber>numbers=new NumberGetter(this).getPhoneNumber();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.mynumber);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       NumberAdapter numberAdapter=new NumberAdapter(this);

        numberAdapter.setOnItemClickListener(new MyItemClickListener() {
            @Override
            public void  onItemClickListener(View view, int position) {
                Intent i=new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+numbers.get(position).getmNumber()));
                startActivity(i);
            }
        });
        recyclerView.setAdapter(numberAdapter);











    }

}
