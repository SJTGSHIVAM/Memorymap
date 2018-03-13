package com.example.shivam.memorymap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import java.util.Random;

public class Memorymap extends AppCompatActivity {

    int avc[]={0,0,0,0,0,0,0,0};   // used for alloting values
    int av[]=new int[16];
    Random k= new Random();
    Button a[]=new Button[16];
    Button rst;
    TextView tv1;
    int count=0;
    int movcount=0;
    int tempnum;
   thelistener xx=new thelistener();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorymap);
        for (int i=0;i<16;i++){
            for (int j = 0; ;){
                j = k.nextInt(8);
                if (avc[j] == 2) continue;
                av[i] = j;
                avc[j]++;
                break;
            }

        }
        a[0]=(Button)findViewById(R.id.a0);
        a[1]=(Button)findViewById(R.id.a1);
        a[2]=(Button)findViewById(R.id.a2);
        a[3]=(Button)findViewById(R.id.a3);
        a[4]=(Button)findViewById(R.id.a4);
        a[5]=(Button)findViewById(R.id.a5);
        a[6]=(Button)findViewById(R.id.a6);
        a[7]=(Button)findViewById(R.id.a7);
        a[8]=(Button)findViewById(R.id.a8);
        a[9]=(Button)findViewById(R.id.a9);
        a[10]=(Button)findViewById(R.id.a10);
        a[11]=(Button)findViewById(R.id.a11);
        a[12]=(Button)findViewById(R.id.a12);
        a[13]=(Button)findViewById(R.id.a13);
        a[14]=(Button)findViewById(R.id.a14);
        a[15]=(Button)findViewById(R.id.a15);
        tv1=(TextView)findViewById(R.id.dpl);
        for (Button i:a) i.setOnClickListener(xx);
          rst=(Button)findViewById(R.id.rst);
          rst.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
             finish();
             System.exit(0);
            }});

    }
    public class thelistener implements View.OnClickListener{
        Button temp,temp1;
        @Override
        public void onClick(View v){
            movcount++;
            temp1=temp;
            temp=(Button)findViewById(v.getId());
            for (int i=0;i<16;i++) {
                if(temp==a[i]&& temp!=temp1) {
                    temp.setText(av[i] + "");
                    if (movcount > 1 ) {
                        if (tempnum == av[i] ) {
                            temp.setBackgroundColor(0xff5500ff);
                            temp1.setBackgroundColor(0xff5500ff);
                            temp.setText(":)");
                            temp1.setText(":)");
                            temp.setEnabled(false);
                            temp1.setEnabled(false);
                            if (++count == 8) {
                                for (Button b : a) b.setVisibility(View.INVISIBLE);
                                tv1.setText("you win! completed in" + movcount + "moves");
                            }
                        } else
                            temp1.setText("");
                    }tempnum=av[i];
                }



                }

            }
        }
}

