package com.example.user.s1030340;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.Toast;

public class fivetimesfive extends AppCompatActivity {

    String[] str = {"O", "X"};
    ImageButton imgbutton1[] = new ImageButton[25];
    String message = "";
    char mode;
    int num[] = new int[25];
    int j = 0;
    boolean gameover = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(5);
        gridLayout.setRowCount(5);


        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.setMargins(50, 300 , 0, 0);
        gridLayout.setLayoutParams(params);
        //

        for (int i = 0; i < imgbutton1.length; i++) {
            imgbutton1[i] = new ImageButton(getApplicationContext());
            imgbutton1[i].setMaxHeight(200);
            imgbutton1[i].setMaxWidth(200);
            imgbutton1[i].setAdjustViewBounds(true);
            imgbutton1[i].setImageResource(R.drawable.orig);
            imgbutton1[i].setOnClickListener (ibltr);
            imgbutton1[i].setId(i);
            gridLayout.addView(imgbutton1[i]);
        }
        setContentView(gridLayout);
        //

        AlertDialog.Builder bld = new AlertDialog.Builder(fivetimesfive.this);
        bld.setTitle("請選擇要 O 起手 還是 X 起手")
                .setItems(str, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(fivetimesfive.this, str[which] + " go first", Toast.LENGTH_LONG).show();
                        if (str[which].equals("O")) {
                            mode = 'O';
                        } else if (str[which].equals("X")) {
                            mode = 'X';
                        }
                    }
                }).show();
        //

    }



    View.OnClickListener ibltr = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            int n = v.getId();
            if (num[n] == 0) {
                if (mode == 'O') {
                    num[n] = 1;
                    imgbutton1[n].setImageDrawable(getResources().getDrawable(R.drawable.cir01));
                    mode = 'X';
                } else {
                    num[n] = -1;
                    imgbutton1[n].setImageDrawable(getResources().getDrawable(R.drawable.x01));
                    mode = 'O';
                }
                j++;
            }

            if (gameover) {
                Toast.makeText(fivetimesfive.this, "Game Over!!" + message, Toast.LENGTH_LONG).show();
            }
            if (((num[0] + num[1] + num[2]+num[3]+num[4]) == 5) ||( (num[5] + num[6] + num[7]+num[8]+num[9]) == 5) || ((num[10] + num[11] + num[12]+num[13]+num[14]) == 5) ||
                    ((num[15] + num[16] + num[17]+num[18]+num[19]) == 5) || ((num[20] + num[21] + num[22]+num[23]+num[24]) == 5) || ((num[0] + num[5] + num[10]+num[15]+num[20]) == 5) ||
                    ((num[1] + num[6] + num[11]+num[16]+num[21]) == 5) || ((num[2] + num[7] + num[12]+num[17]+num[22]) == 5) || ((num[3] + num[8] + num[13]+num[18]+num[23]) == 5) ||
                    ((num[4] + num[9] + num[14]+num[19]+num[24]) == 5) || ((num[0] + num[6] + num[12]+num[18]+num[24]) == 5) || ((num[4] + num[8] + num[12]+num[16]+num[20]) == 5)) {
                Toast.makeText(fivetimesfive.this, "O  win game over!! ", Toast.LENGTH_LONG).show();
                message = "O  win game over!!";
                gameover = true;

            } else if (((num[0] + num[1] + num[2]+num[3]+num[4]) == -5) ||( (num[5] + num[6] + num[7]+num[8]+num[9]) == -5) || ((num[10] + num[11] + num[12]+num[13]+num[14]) == -5) ||
                    ((num[15] + num[16] + num[17]+num[18]+num[19]) == -5) || ((num[20] + num[21] + num[22]+num[23]+num[24]) == -5) || ((num[0] + num[5] + num[10]+num[15]+num[20]) == -5) ||
                    ((num[1] + num[6] + num[11]+num[16]+num[21]) == -5) || ((num[2] + num[7] + num[12]+num[17]+num[22]) == -5) || ((num[3] + num[8] + num[13]+num[18]+num[23]) == -5) ||
                    ((num[4] + num[9] + num[14]+num[19]+num[24]) == -5) || ((num[0] + num[6] + num[12]+num[18]+num[24]) == -5) || ((num[4] + num[8] + num[12]+num[16]+num[20]) == -5)) {
                Toast.makeText(fivetimesfive.this, "X  win game over!! ", Toast.LENGTH_LONG).show();
                message = "X  win game over!!";
                gameover = true;
            } else if (j == 25) {
                Toast.makeText(fivetimesfive.this, "tie  game over!!", Toast.LENGTH_LONG).show();
                message = "tie game over!!";
                gameover = true;
            }
        }
    };




    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater minf=getMenuInflater();
        minf.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.mi01:
                Intent intent = new Intent();
                intent.setClass(fivetimesfive.this, firstActivity.class);
                startActivity(intent);
                fivetimesfive.this.finish();
                break;
            case R.id.mi02:
                Intent intent1 = new Intent();
                intent1.setClass(fivetimesfive.this, secondActivity.class);
                startActivity(intent1);
                fivetimesfive.this.finish();
                break;
            case R.id.mi03:
                Intent intent2 = new Intent();
                intent2.setClass(fivetimesfive.this, thirdActivity.class);
                startActivity(intent2);
                fivetimesfive.this.finish();
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
