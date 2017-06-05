package com.example.user.s1030340;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;




public class firstActivity extends AppCompatActivity {

    //
    String str = "";
    String s = "";
    String str2 = "";
    RadioGroup rg;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        // find button
        final Button btn0 = (Button) findViewById(R.id.btn0);
        final Button btn1 = (Button) findViewById(R.id.btn1);
        final Button btn2 = (Button) findViewById(R.id.btn2);
        final Button btn3 = (Button) findViewById(R.id.btn3);
        final Button btn4 = (Button) findViewById(R.id.btn4);
        final Button btn5 = (Button) findViewById(R.id.btn5);
        final Button btn6 = (Button) findViewById(R.id.btn6);
        final Button btn7 = (Button) findViewById(R.id.btn7);
        final Button btn8 = (Button) findViewById(R.id.btn8);
        final Button btn9 = (Button) findViewById(R.id.btn9);
        final Button dot = (Button) findViewById(R.id.btn_dot);
        final TextView tv01 = (TextView) findViewById(R.id.editText);
        Button btnA = (Button) findViewById(R.id.btn_add);
        Button btnS = (Button) findViewById(R.id.btn_sub);
        Button btnM = (Button) findViewById(R.id.btn_mul);
        Button btnD = (Button) findViewById(R.id.btn_div);
        Button btnE = (Button) findViewById(R.id.btn_eq);
        final RadioButton decimal = (RadioButton) findViewById(R.id.radioButton);
        final RadioButton binary = (RadioButton) findViewById(R.id.radioButton2);
        rg =(RadioGroup) findViewById(R.id.radioGroup) ;





        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = str + btn0.getText().toString();
                tv01.setText(str);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = str + btn1.getText().toString();
                tv01.setText(str);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = str + btn2.getText().toString();
                tv01.setText(str);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = str + btn3.getText().toString();
                tv01.setText(str);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = str + btn4.getText().toString();
                tv01.setText(str);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = str + btn5.getText().toString();
                tv01.setText(str);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = str + btn6.getText().toString();
                tv01.setText(str);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = str + btn7.getText().toString();
                tv01.setText(str);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = str + btn8.getText().toString();
                tv01.setText(str);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = str + btn9.getText().toString();
                tv01.setText(str);
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = str + dot.getText().toString();
                tv01.setText(str);
            }
        });
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = "+";
                str2 = str;
                str = "";
            }
        });
        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = "-";
                str2 = str;
                str = "";
            }
        });
        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = "*";
                str2 = str;
                str = "";
            }
        });
        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = "/";
                str2 = str;
                str = "";
            }
        });
        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Double aa;

                if (s.equals("+")) {
                    aa = Double.parseDouble(str2) + Double.parseDouble(str);
                    tv01.setText(aa.toString());

                } else if (s.equals("-")) {
                    aa = Double.parseDouble(str2) - Double.parseDouble(str);
                    tv01.setText(aa.toString());

                } else if (s.equals("*")) {
                    aa = Double.parseDouble(str2) * Double.parseDouble(str);
                    tv01.setText(aa.toString());

                } else if (s.equals("/")) {
                    aa = Double.parseDouble(str2) / Double.parseDouble(str);
                    tv01.setText(aa.toString());

                }else
                    aa = 0.0;

                final Integer bb;
                if (s.equals("+")) {
                    bb = Integer.parseInt(str2) + Integer.parseInt(str);
                    tv01.setText(bb.toString());


                } else if (s.equals("-")) {
                    bb = Integer.parseInt(str2) - Integer.parseInt(str);
                    tv01.setText(bb.toString());

                } else if (s.equals("*")) {
                    bb = Integer.parseInt(str2) *Integer.parseInt(str);
                    tv01.setText(bb.toString());

                } else if (s.equals("/")) {
                    bb = Integer.parseInt(str2) / Integer.parseInt(str);
                    tv01.setText(bb.toString());

                }else
                    bb = 0;
                int i = Integer.parseInt(bb.toString());
                final String binStr=Integer.toBinaryString(i);
                rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if(decimal.getId()==checkedId)
                            tv01.setText(aa.toString());
                        if(binary.getId()==checkedId)
                            tv01.setText(binStr);
                    }
                });
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
                intent.setClass(firstActivity.this, firstActivity.class);
                startActivity(intent);
                firstActivity.this.finish();
                break;
            case R.id.mi02:
                Intent intent1 = new Intent();
                intent1.setClass(firstActivity.this, secondActivity.class);
                startActivity(intent1);
                firstActivity.this.finish();
                break;
            case R.id.mi03:
                Intent intent2 = new Intent();
                intent2.setClass(firstActivity.this, thirdActivity.class);
                startActivity(intent2);
                firstActivity.this.finish();
                break;

        }

        return super.onOptionsItemSelected(item);
    }


}
