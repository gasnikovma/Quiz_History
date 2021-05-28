package app.gasnikov.quizg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Levels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.levels);
        Button bstart= (Button)findViewById(R.id.back);
        bstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(Levels.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                catch(Exception e){

                }

            }
        });
        Button b1=(Button)findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Levels.this,Level1.class);
                startActivity(i);
                finish();

            }
        });
        Button b2=(Button)findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Levels.this,Level2.class);
                startActivity(i);
                finish();

            }
        });
        Button b3=(Button)findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Levels.this,Level3.class);
                startActivity(i);
                finish();

            }
        });
        Button b4=(Button)findViewById(R.id.button4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Levels.this,Level4.class);
                startActivity(i);
                finish();

            }
        });
        Button b5=(Button)findViewById(R.id.button5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Levels.this,Level5.class);
                startActivity(i);
                finish();

            }
        });
        Button b6=(Button)findViewById(R.id.button6);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Levels.this,Level6.class);
                startActivity(i);
                finish();

            }
        });
        Button b7=(Button)findViewById(R.id.button7);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Levels.this,Level7.class);
                startActivity(i);
                finish();

            }
        });
        Button b8=(Button)findViewById(R.id.button8);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Levels.this,Level8.class);
                startActivity(i);
                finish();

            }
        });



        }
        @Override
    public void onBackPressed(){
        try{
            Intent intent = new Intent(Levels.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        catch(Exception e){

        }

    }



    }
