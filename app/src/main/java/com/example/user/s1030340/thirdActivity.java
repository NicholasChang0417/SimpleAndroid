package com.example.user.s1030340;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.GridLayout;
import android.widget.Toast;


public class thirdActivity extends AppCompatActivity {
    String[] str = {"A", "B"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.thirdActivity);

        AlertDialog.Builder bld = new AlertDialog.Builder(thirdActivity.this);
        bld.setTitle("A: 3*3  B: 5*5 ")
                .setItems(str, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(thirdActivity.this, str[which] + " selected", Toast.LENGTH_SHORT).show();
                        if (str[which].equals("A")) {
                            Intent myint=new Intent(thirdActivity.this, threetimesthree.class);
                            startActivity(myint);
                        } else if (str[which].equals("B")) {
                            Intent myint1=new Intent(thirdActivity.this, fivetimesfive.class);
                            startActivity(myint1);
                        }
                    }
                }).show();
    }


    //
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater minf=getMenuInflater();
        minf.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.mi01:
                Intent intent = new Intent();
                intent.setClass(thirdActivity.this, firstActivity.class);
                startActivity(intent);
                thirdActivity.this.finish();
                break;
            case R.id.mi02:
                Intent intent1 = new Intent();
                intent1.setClass(thirdActivity.this, secondActivity.class);
                startActivity(intent1);
                thirdActivity.this.finish();
                break;
            case R.id.mi03:
                Intent intent2 = new Intent();
                intent2.setClass(thirdActivity.this, thirdActivity.class);
                startActivity(intent2);
                thirdActivity.this.finish();
                break;

        }

        return super.onOptionsItemSelected(item);
    }

}

