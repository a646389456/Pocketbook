package com.example.lenovo.pocketbook;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TableRow;

import org.litepal.crud.DataSupport;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

public class BillActivity extends Activity
{
    private LinkedHashMap kindsMap = new LinkedHashMap<String, Integer>();
    private ArrayList<Integer> colors = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bill);
        BillView billView = (BillView) findViewById(R.id.billView);
        List<Stuff> stuffs = DataSupport.findAll(Stuff.class);
        for(Stuff stuff : stuffs)
        {
           kindsMap.put(stuff.getLeixing(), stuff.getShuliang());
        }
        for (int i = 1; i <= 40; i++)
        {
            int r= (new Random().nextInt(100)+10)*i;
            int g= (new Random().nextInt(100)+10)*3*i;
            int b= (new Random().nextInt(100)+10)*2*i;
            int color = Color.rgb(r,g,b);
            if(Math.abs(r-g)>10&&Math.abs(r-b)>10&&Math.abs(b-g)>10)
            {
                colors.add(color);
            }
        }
        billView.setCenterTitle("仓库分布");
        billView.setDataMap(kindsMap);
        billView.setColors(colors);
        billView.setMinAngle(50);
        billView.startDraw();
    }
    public void onTable(View v)
    {
        Intent intent = new Intent(BillActivity.this, TableListActivity.class);
        startActivity(intent);
        finish();
    }
}