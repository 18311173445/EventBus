package com.bawei.eventbus;

import android.app.Person;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bawei.eventbus.bean.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //绑定本类为观察者
        EventBus.getDefault().register(this);
    }
    //接受的方法
    @Subscribe
    public void recevier(String msg)
    {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    public void dd(View view) {
        startActivity(new Intent(this,SecondeActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void dds(View view) {
        EventBus.getDefault().postSticky(new MessageEvent("ssssssssssssssss"));
        startActivity(new Intent(this,SecondeActivity.class));
    }
}
