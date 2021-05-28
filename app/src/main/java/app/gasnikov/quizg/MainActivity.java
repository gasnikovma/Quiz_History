package app.gasnikov.quizg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private long backTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bstart= (Button)findViewById(R.id.button_start);
        bstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(MainActivity.this,Levels.class);
                    startActivity(intent);
                    finish();

            }
        });

    }

    @Override
    public void onBackPressed() {



        if(backTime+3000>System.currentTimeMillis()){
            super.onBackPressed();

        }
        else Toast.makeText(this,"Нажмите еще раз для выхода",Toast.LENGTH_SHORT).show();
        backTime=System.currentTimeMillis();



    }
}