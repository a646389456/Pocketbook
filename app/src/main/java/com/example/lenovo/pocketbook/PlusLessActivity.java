package com.example.lenovo.pocketbook;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.tablemanager.Connector;

public class PlusLessActivity extends Activity implements PlusLessInterface
{
    private EditText leixing;
    private EditText pinpai;
    private EditText jiage;
    private EditText shuliang;
    private StuffPresenter stuffPresenter;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plusless);
        initView();
    }
    public void initView()
    {
        leixing = (EditText) findViewById(R.id.typesHint);
        pinpai = (EditText) findViewById(R.id.brandHint);
        jiage = (EditText) findViewById(R.id.priceHint);
        shuliang = (EditText) findViewById(R.id.numberHint);
        Connector.getDatabase();
    }
    public void plus(View v)
    {
        stuffPresenter = new StuffPresenter(this);
        stuffPresenter.plus(leixing.getText().toString(), pinpai.getText().toString(), Integer.valueOf(jiage.getText().toString()), Integer.valueOf(shuliang.getText().toString()));
        stuffPresenter.plusSucceed();
        stuffPresenter.clear();
    }
    public void less(View v)
    {
        stuffPresenter = new StuffPresenter(this);
        stuffPresenter.less(leixing.getText().toString(), pinpai.getText().toString(), Integer.valueOf(jiage.getText().toString()), Integer.valueOf(shuliang.getText().toString()));
        stuffPresenter.lessSucceed();
        stuffPresenter.clear();
    }
    public void dialogPlusSucceed()
    {
        Toast.makeText(PlusLessActivity.this,"进货成功^_^", Toast.LENGTH_SHORT).show();
    }
    public void dialogLessSucceed()
    {
        Toast.makeText(PlusLessActivity.this,"出货成功^_^", Toast.LENGTH_SHORT).show();
    }
    public void clear()
    {
        leixing.getText().clear();
        pinpai.getText().clear();
        jiage.getText().clear();
        shuliang.getText().clear();
    }
}
