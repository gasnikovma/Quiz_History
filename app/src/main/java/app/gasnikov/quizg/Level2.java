package app.gasnikov.quizg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


import java.util.Random;

public class Level2 extends AppCompatActivity {
    Dialog d,f;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String[] a=new String[6];
    Button[] answers = new Button[3];
    final Random random = new Random();

ImageView person;


    Button l1back;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.level_3);
        l1back= (Button)findViewById(R.id.l1_back);
        answers[0]=(Button)findViewById(R.id.variant1);
        answers[1]=(Button)findViewById(R.id.variant2);
        answers[2]=(Button)findViewById(R.id.variant3);
        person=findViewById(R.id.person);



        for(int i=0;i<3;i++) {

            int finalI = i;
            f=new Dialog(this);
            f.setContentView(R.layout.explanation);
            f.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон за
            f.setCancelable(false);
            answers[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int ranswer=Integer.parseInt (a[3].trim ());

                    if (v.getId() == answers[finalI].getId() && ranswer == (finalI+1)) {

                        v.setBackgroundColor(getResources().getColor(R.color.green));
                        db.collection("question2").document("q"+String.valueOf(random.nextInt(16)+1)).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                if (task.isSuccessful()) {
                                    DocumentSnapshot document = task.getResult();
                                    if (document.exists()) {
                                        a[0]=(String)document.get("item1");
                                        a[1]=(String)document.get("item2");
                                        a[2]=(String)document.get("item3");
                                        a[3]=(String)document.get("rightanswer");
                                        a[4]=(String)document.get("item4");
                                        a[5]=(String)document.get("image");
                                        for (int i = 0; i < 3; i++) {
                                            answers[i].setText(a[i]);
                                            answers[i].setBackgroundResource(R.drawable.button_start);
                                        }
                                        Glide.with(Level2.this).load(a[5]).into(person);

                                    }

                                }
                            }

                        });
                    }
                    else{

                        v.setBackgroundColor(getResources().getColor(R.color.red));
                        TextView t=f.findViewById(R.id.explanation);
                        t.setText(a[4]);
                        f.show();
                        Button next=(Button)f.findViewById(R.id.next);
                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                f.dismiss();
                            }
                        });


                        db.collection("question2").document("q"+String.valueOf(random.nextInt(16)+1)).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                if (task.isSuccessful()) {
                                    DocumentSnapshot document = task.getResult();
                                    if (document.exists()) {

                                        a[0]=(String)document.get("item1");
                                        a[1]=(String)document.get("item2");
                                        a[2]=(String)document.get("item3");
                                        a[3]=(String)document.get("rightanswer");
                                        a[4]=(String)document.get("item4");
                                        a[5]=(String)document.get("image");
                                        for (int i = 0; i < 3; i++) {
                                            answers[i].setText(a[i]);
                                            answers[i].setBackgroundResource(R.drawable.button_start);
                                        }
                                        Glide.with(Level2.this).load(a[5]).into(person);


                                    }

                                }
                            }
                        });


                    }
                };
            });
        }



        l1back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(Level2.this,Levels.class);
                    startActivity(intent);
                    finish();
                }
                catch(Exception e){

                }

            }
        });
        d=new Dialog(this);
        d.setContentView(R.layout.dialog);
        ImageView dial=d.findViewById(R.id.historicbackground);
        dial.setImageResource(R.drawable.l2);
        TextView question= d.findViewById(R.id.explanation);
        question.setText(R.string.ltwo);

        d.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон за
        d.setCancelable(false);

        FloatingActionButton btn=(FloatingActionButton)d.findViewById(R.id.button_cancel_dialog);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Level2.this,Levels.class);
                startActivity(i);
                finish();
                d.dismiss();
            }

        });
        Button btnstart=(Button)d.findViewById(R.id.next);
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.collection("question2").document("q"+String.valueOf(random.nextInt(16)+1)).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if(task.isSuccessful()){
                            DocumentSnapshot document= task.getResult();
                            if(document.exists()){

                                a[0]=(String)document.get("item1");
                                a[1]=(String)document.get("item2");
                                a[2]=(String)document.get("item3");
                                a[3]=(String)document.get("rightanswer");
                                a[4]=(String)document.get("item4");
                                a[5]=(String)document.get("image");



                                for(int i=0;i<3;i++){
                                    answers[i].setText(a[i]);
                                }
                                Glide.with(Level2.this).load(a[5]).into(person);

                            }

                        }
                    }


                });
                d.dismiss();



            }
        });
        d.show();



    }
    public void onBackPressed(){
        try{
            Intent intent = new Intent(Level2.this,Levels.class);
            startActivity(intent);
            finish();
        }
        catch(Exception e){

        }

    }

}