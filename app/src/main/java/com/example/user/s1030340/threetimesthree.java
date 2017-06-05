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

public class threetimesthree extends AppCompatActivity {

    String[] str = {"O", "X"};
    ImageButton imgbutton1[] = new ImageButton[9];
    String message = "";
    char mode;
    int num[] = new int[9];
    int j = 0;
    boolean gameover = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(3);
        gridLayout.setRowCount(3);


        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.setMargins(250, 450, 0, 0);
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

        AlertDialog.Builder bld = new AlertDialog.Builder(threetimesthree.this);
        bld.setTitle("請選擇要 O 起手 還是 X 起手")
                .setItems(str, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(threetimesthree.this, str[which] + " first", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(threetimesthree.this, "Game Over!!" + message, Toast.LENGTH_SHORT).show();
            }
            if (((num[0] + num[1] + num[2]) == 3) || ((num[3] + num[4] + num[5]) == 3) || ((num[6] + num[7] + num[8]) == 3) ||
                    ((num[0] + num[3] + num[6]) == 3) || ((num[1] + num[4] + num[7]) == 3) || ((num[2] + num[5] + num[8]) == 3) ||
                    ((num[0] + num[4] + num[8]) == 3) || ((num[2] + num[4] + num[6]) == 3)) {
                Toast.makeText(threetimesthree.this, "O  win game over!! ", Toast.LENGTH_SHORT).show();
                message = "O  win game over!!";
                gameover = true;

            } else if (((num[0] + num[1] + num[2]) == -3) || ((num[3] + num[4] + num[5]) == -3) || ((num[6] + num[7] + num[8]) == -3) ||
                    ((num[0] + num[3] + num[6]) == -3) || ((num[1] + num[4] + num[7]) == -3) || ((num[2] + num[5] + num[8]) == -3) ||
                    ((num[0] + num[4] + num[8]) == -3) || ((num[2] + num[4] + num[6]) == -3)) {
                Toast.makeText(threetimesthree.this, "X  win game over!! ", Toast.LENGTH_SHORT).show();
                message = "X  win game over!!";
                gameover = true;
            } else if (j == 9) {
                Toast.makeText(threetimesthree.this, "tie  game over!!", Toast.LENGTH_SHORT).show();
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
                intent.setClass(threetimesthree.this, firstActivity.class);
                startActivity(intent);
                threetimesthree.this.finish();
                break;
            case R.id.mi02:
                Intent intent1 = new Intent();
                intent1.setClass(threetimesthree.this, secondActivity.class);
                startActivity(intent1);
                threetimesthree.this.finish();
                break;
            case R.id.mi03:
                Intent intent2 = new Intent();
                intent2.setClass(threetimesthree.this, thirdActivity.class);
                startActivity(intent2);
                threetimesthree.this.finish();
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
