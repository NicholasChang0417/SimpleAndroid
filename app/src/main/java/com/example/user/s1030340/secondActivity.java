package com.example.user.s1030340;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;


public class secondActivity extends AppCompatActivity {
    String[] str = {"→","←","up","down","↘","↖"};
    boolean iChecked[] = new boolean[str.length];
    boolean[] check={false,false,false,false,false,false};
    float xup ,yup ,xdown ,ydown;
    int erro, er2;
    ImageView i01;
    FrameLayout f1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        i01=(ImageView) findViewById(R.id.imageView01);
        f1=(FrameLayout)findViewById(R.id.framelayout);
        //
        AlertDialog.Builder bld= new AlertDialog.Builder(secondActivity.this);
        bld.setTitle("Settings Multiple Choice!!!")
                .setMultiChoiceItems(str,iChecked, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        // Toast.makeText(MainActivity.this,str[which]+(isChecked[which]?" picked!!":" not picked!!"),Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel",null)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String MSG="";
                        for(int index=0;index<6;index++){
                            if(iChecked[index])
                                MSG=MSG+str[index];
                        }

                        for(int i=0;i<6;i++){
                            if (iChecked[i])
                                check[i]=true;
                        }
                    }
                });
        bld.show();

        f1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int act = event.getAction();


                switch (act) {
                    case MotionEvent.ACTION_DOWN:
                        xdown = event.getX();
                        ydown = event.getY();


                        break;
                    case MotionEvent.ACTION_UP:
                        xup = event.getX();
                        yup = event.getY();
                        if (event.getX() > i01.getLeft() && event.getX() < i01.getRight() && event.getY() > i01.getTop() && event.getY() < i01.getBottom())
                            er2 = 1;
                        if (-0.36 < ((yup - ydown) / (xup - xdown)) && ((yup - ydown) / (xup - xdown)) < 0.36 && (xup - xdown) > 0 && erro == 0 && er2 == 0 &&check[0]==true) {
                            i01.setImageResource(R.drawable.a1);

                        }
                        if (-0.36 < ((yup - ydown) / (xup - xdown)) && ((yup - ydown) / (xup - xdown)) < 0.36 && (xup - xdown) < 0 && erro == 0 && er2 == 0 &&check[1]==true) {
                            i01.setImageResource(R.drawable.a2);
                        }

                        if ((2.7 < ((yup - ydown) / (xup - xdown)) || ((yup - ydown) / (xup - xdown)) < -2.7 )&& (yup - ydown) < 0 && erro == 0 && er2 == 0 &&check[2]==true) {
                            i01.setImageResource(R.drawable.a3);

                        }

                        if ((2.7 < ((yup - ydown) / (xup - xdown)) || ((yup - ydown) / (xup - xdown)) < -2.7 )&& (yup - ydown) > 0 && erro == 0 && er2 == 0 &&check[3]==true) {
                            i01.setImageResource(R.drawable.a4);


                        }
                        if (2.14 > ((yup - ydown) / (xup - xdown)) && ((yup - ydown) / (xup - xdown)) > 0.46 && (xup - xdown) > 0 && erro == 0 && er2 == 0 &&check[4]==true) {
                            i01.setImageResource(R.drawable.a5);
                        }
                        if (2.14 > ((yup - ydown) / (xup - xdown)) && ((yup - ydown) / (xup - xdown)) > 0.46 && (xup - xdown) <0 && erro == 0 && er2 == 0 &&check[5]==true) {
                            i01.setImageResource(R.drawable.a6);
                        }



                        er2 = 1;
                        erro = 1;


                        break;
                    case MotionEvent.ACTION_MOVE:

                        if (((yup < i01.getTop() || yup > i01.getBottom()) || (xup < i01.getLeft() || xup > i01.getRight())) && ((ydown < i01.getTop() || ydown > i01.getBottom()) || (xdown < i01.getLeft() || xdown > i01.getRight())))
                            erro = 0;
                        else
                            erro = 1;

                        if (event.getX() > i01.getLeft() && event.getX() < i01.getRight() && event.getY() > i01.getTop() && event.getY() < i01.getBottom())
                            er2 = 0;


                        break;

                }


                return true;
            }


        });
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
                intent.setClass(secondActivity.this, firstActivity.class);
                startActivity(intent);
                secondActivity.this.finish();
                break;
            case R.id.mi02:
                Intent intent1 = new Intent();
                intent1.setClass(secondActivity.this, secondActivity.class);
                startActivity(intent1);
                secondActivity.this.finish();
                break;
            case R.id.mi03:
                Intent intent2 = new Intent();
                intent2.setClass(secondActivity.this, thirdActivity.class);
                startActivity(intent2);
                secondActivity.this.finish();
                break;

        }

        return super.onOptionsItemSelected(item);
    }

}
