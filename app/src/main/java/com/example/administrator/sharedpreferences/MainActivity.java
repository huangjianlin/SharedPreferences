package com.example.administrator.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //存储数据
        Button saveData=(Button) findViewById(R.id.save_data);
        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //通过getSharedPreferences方式保存数据，会生成xml文件
                SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("姓名","行风");
                editor.putInt("年龄",27);
                editor.putBoolean("婚否",false);
                editor.apply();
            }
        });
        //读取数据
        Button restoreData=(Button) findViewById(R.id.restore_data);
        restoreData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref=getSharedPreferences("data",MODE_PRIVATE);
                String name=pref.getString("姓名","");
                int age=pref.getInt("年龄",0);
                boolean married=pref.getBoolean("婚否",false);
                Log.d("MainActivity","姓名是："+name);
                Log.d("MainActivity","年龄是："+age);
                Log.d("MainActivity","婚否："+married);
            }
        });
    }
}
