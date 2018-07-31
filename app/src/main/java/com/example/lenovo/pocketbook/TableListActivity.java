package com.example.lenovo.pocketbook;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.litepal.crud.DataSupport;

import java.util.List;

public class TableListActivity extends Activity
{
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table);
        ListView listView = (ListView) findViewById(R.id.listView);
        List<Stuff> stuffs = DataSupport.findAll(Stuff.class);
        List<Stuff1> stuffs1 = DataSupport.findAll(Stuff1.class);
        String[] stuffsItem = new String[stuffs.size() + stuffs1.size() + 4];
        int i = 0;
        stuffsItem[i] = "进货->    " + "类型：" + "     " + "品牌：" + "     " + "单价：" + "     " + "数量";
        Integer zongzhichu = 0;
        Integer zongshouru = 0;
        i = i + 1;
        for(Stuff stuff : stuffs)
        {
            stuffsItem[i] = "                " + stuff.getLeixing() + "     " + stuff.getPinpai() + "     " + stuff.getJiage().toString() + "     " + stuff.getShuliang().toString();
            zongzhichu += stuff.getJiage() * stuff.getShuliang();
            i++;
        }
        stuffsItem[i] = "总支出：" + "                  " + zongzhichu.toString();
        i = i + 1;
        stuffsItem[i] = "出货->    " + "类型：" + "     " + "品牌：" + "     " + "单价：" + "     " + "数量";
        i = i + 1;
        for(Stuff1 stuff1 : stuffs1)
        {
            stuffsItem[i] = "               " + stuff1.getLeixing() + "     " + stuff1.getPinpai() + "     " + stuff1.getJiage().toString() + "     " + stuff1.getShuliang().toString();
            zongshouru += stuff1.getJiage() * stuff1.getShuliang();
            i++;
        }
        stuffsItem[i] = "总收入：" + "                  " + zongshouru.toString();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.array_item, stuffsItem);
        listView.setAdapter(adapter);
    }
}
