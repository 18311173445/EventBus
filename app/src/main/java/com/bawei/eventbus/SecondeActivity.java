package com.bawei.eventbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bawei.eventbus.bean.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class SecondeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seconde);
        EventBus.getDefault().register(this);
    }
    @Subscribe(sticky = true)
    public void recivers(MessageEvent messageEvent){
        Toast.makeText(this,messageEvent.toString(),Toast.LENGTH_SHORT).show();
    }
    public void dj(View view) {
        EventBus.getDefault().post("啊啊啊啊啊");
        startActivity(new Intent(this,MainActivity.class));
        this.finish();
    }
}
