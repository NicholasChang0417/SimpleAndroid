package com.example.user.s1030340;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater minf=getMenuInflater();
        minf.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.mi01:
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, firstActivity.class);
                startActivity(intent);
                MainActivity.this.finish();
                break;
            case R.id.mi02:
                Intent intent1 = new Intent();
                intent1.setClass(MainActivity.this, secondActivity.class);
                startActivity(intent1);
                MainActivity.this.finish();
                break;
            case R.id.mi03:
                Intent intent2 = new Intent();
                intent2.setClass(MainActivity.this, thirdActivity.class);
                startActivity(intent2);
                MainActivity.this.finish();
                break;

        }

        return super.onOptionsItemSelected(item);
    }

}
