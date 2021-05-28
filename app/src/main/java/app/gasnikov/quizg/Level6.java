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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Random;

public class Level6 extends AppCompatActivity {
    Dialog d,f;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String[] a=new String[7];
    Button[] answers = new Button[4];
    final Random random = new Random();
    Button l1back;
    TextView t;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_6);
        l1back= (Button)findViewById(R.id.l1_back);
        answers[0]=(Button)findViewById(R.id.variant1);
        answers[1]=(Button)findViewById(R.id.variant2);
        answers[2]=(Button)findViewById(R.id.variant3);
        answers[3]=(Button)findViewById(R.id.que);
        t=(TextView)findViewById(R.id.question);


        for(int i=0;i<4;i++) {

            int finalI = i;
            f=new Dialog(this);
            f.setContentView(R.layout.explanation);
            f.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон за
            f.setCancelable(false);
            answers[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int ranswer=Integer.parseInt (a[5].trim ());

                    if (v.getId() == answers[finalI].getId() && ranswer == (finalI+1)) {
                        v.setBackgroundColor(getResources().getColor(R.color.green));
                        db.collection("question6").document("q"+String.valueOf(random.nextInt(15)+1)).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                if (task.isSuccessful()) {
                                    DocumentSnapshot document = task.getResult();
                                    if (document.exists()) {

                                        a[0] = (String) document.get("item1");
                                        a[1] = (String) document.get("item2");
                                        a[2] = (String) document.get("item3");
                                        a[3] = (String) document.get("item4");
                                        a[4]=(String)document.get("item5");
                                        a[5]=(String)document.get("rightanswer");
                                        a[6]=(String)document.get("question");
                                        for (int i = 0; i < 4; i++) {
                                            answers[i].setText(a[i]);
                                            answers[i].setBackgroundResource(R.drawable.button_start);
                                        }
                                        t.setText(a[6]);

                                    }

                                }
                            }
                        });
                    }
                    else{

                        v.setBackgroundColor(getResources().getColor(R.color.red));
                        TextView r=f.findViewById(R.id.explanation);
                        r.setText(a[4]);
                        f.show();
                        Button next=(Button)f.findViewById(R.id.next);
                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                f.dismiss();
                            }
                        });


                        db.collection("question6").document("q"+String.valueOf(random.nextInt(15)+1)).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                if (task.isSuccessful()) {
                                    DocumentSnapshot document = task.getResult();
                                    if (document.exists()) {

                                        a[0] = (String) document.get("item1");
                                        a[1] = (String) document.get("item2");
                                        a[2] = (String) document.get("item3");
                                        a[3] = (String) document.get("item4");
                                        a[4]=(String)document.get("item5");
                                        a[5]=(String)document.get("rightanswer");
                                        a[6]=(String)document.get("question");
                                        for (int i = 0; i < 4; i++) {
                                            answers[i].setText(a[i]);
                                            answers[i].setBackgroundResource(R.drawable.button_start);
                                        }
                                        t.setText(a[6]);

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
                    Intent intent = new Intent(Level6.this,Levels.class);
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
        dial.setImageResource(R.drawable.l6);
        TextView question= d.findViewById(R.id.explanation);
        question.setText(R.string.lsix);

        d.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон за
        d.setCancelable(false);

        FloatingActionButton btn=(FloatingActionButton)d.findViewById(R.id.button_cancel_dialog);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Level6.this,Levels.class);
                startActivity(i);
                finish();
                d.dismiss();
            }

        });
        Button btnstart=(Button)d.findViewById(R.id.next);
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.collection("question6").document("q"+String.valueOf(random.nextInt(15)+1)).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if(task.isSuccessful()){
                            DocumentSnapshot document= task.getResult();
                            if(document.exists()){

                                a[0]=(String)document.get("item1");
                                a[1]=(String)document.get("item2");
                                a[2]=(String)document.get("item3");
                                a[3]=(String)document.get("item4");
                                a[4]=(String)document.get("item5");
                                a[5]=(String)document.get("rightanswer");
                                a[6]=(String)document.get("question");


                                for(int i=0;i<4;i++){
                                    answers[i].setText(a[i]);
                                }
                                t.setText(a[6]);


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
            Intent intent = new Intent(Level6.this,Levels.class);
            startActivity(intent);
            finish();
        }
        catch(Exception e){

        }

    }

}