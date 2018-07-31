package com.example.lenovo.pocketbook;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.litepal.crud.DataSupport;

public class MainActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void purchase(View v)
    {
       Intent intent = new Intent(MainActivity.this, PlusLessActivity.class);
       startActivity(intent);
    }
    public void bill(View v)
    {
        Intent intent  = new Intent(MainActivity.this, BillActivity.class);
        startActivity(intent);
    }
    public void clearData(View v)
    {
        DataSupport.deleteAll(Stuff.class);
        DataSupport.deleteAll(Stuff1.class);
    }
}
