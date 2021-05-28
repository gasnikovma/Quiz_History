package app.gasnikov.quizg;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.ortiz.touchview.TouchImageView;

import java.util.Random;

public class Level8 extends AppCompatActivity {
    Dialog d, f;

    TextView t;

    EditText answer;
    ImageView scheme;

    String intranswer;


    String[] a = new String[5];

    Random random = new Random();
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Button l1back;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.level_8);
        l1back = (Button) findViewById(R.id.l1_back);
        scheme= findViewById(R.id.person) ;



        answer = (EditText) findViewById(R.id.answer);
        f = new Dialog(this);
        f.setContentView(R.layout.explanation);
        f.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон за
        f.setCancelable(false);
        l1back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level8.this, Levels.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }

            }
        });
        answer.setOnKeyListener(new View.OnKeyListener() {
                                    @Override
                                    public boolean onKey(View v, int keyCode, KeyEvent event) {
                                        if(event.getAction() == KeyEvent.ACTION_DOWN &&
                                                (keyCode == KeyEvent.KEYCODE_ENTER))
                                        {
                                            intranswer = answer.getText().toString();
                                            if(intranswer.equals(a[1])||intranswer.equals(a[2])||intranswer.equals(a[3])){
                                                db.collection("question8").document("q"+String.valueOf(random.nextInt(17)+1)).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                                        if (task.isSuccessful()) {
                                                            DocumentSnapshot document = task.getResult();
                                                            if (document.exists()) {
                                                                a[0]=(String)document.get("explanation");
                                                                a[1]=(String)document.get("ranswer");
                                                                a[2]=(String)document.get("ranswer1");
                                                                a[3]=(String)document.get("ranswer2");
                                                                a[4]=(String)document.get("image");
                                                                Glide.with(Level8.this).load(a[4]).into(scheme);
                                                                answer.setText("");

                                                            }

                                                        }
                                                    }

                                                });

                                            }
                                            else {
                                               

                                                t=f.findViewById(R.id.explanation);
                                                t.setText(a[0]);
                                                f.show();
                                                Button next=(Button)f.findViewById(R.id.next);
                                                next.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        f.dismiss();
                                                    }
                                                });


                                                db.collection("question8").document("q"+String.valueOf(random.nextInt(17)+1)).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                                        if (task.isSuccessful()) {
                                                            DocumentSnapshot document = task.getResult();
                                                            if (document.exists()) {
                                                                a[0]=(String)document.get("explanation");
                                                                a[1]=(String)document.get("ranswer");
                                                                a[2]=(String)document.get("ranswer1");
                                                                a[3]=(String)document.get("ranswer2");
                                                                a[4]=(String)document.get("image");
                                                                Glide.with(Level8.this).load(a[4]).into(scheme);
                                                                answer.setText("");




                                                            }

                                                        }
                                                    }
                                                });


                                            }

                                        }
                                        return false;

                                    }

                                }
        );

        d=new Dialog(this);
        d.setContentView(R.layout.dialog);
        ImageView dial=d.findViewById(R.id.historicbackground);
        dial.setImageResource(R.drawable.l8);
        TextView question= d.findViewById(R.id.explanation);
        question.setText(R.string.leight);
        d.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон за
        d.setCancelable(false);

        FloatingActionButton btn=(FloatingActionButton)d.findViewById(R.id.button_cancel_dialog);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Level8.this,Levels.class);
                startActivity(i);
                finish();
                d.dismiss();
            }

        });
        Button btnstart=(Button)d.findViewById(R.id.next);
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.collection("question8").document("q"+String.valueOf(random.nextInt(17)+1)).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if(task.isSuccessful()){
                            DocumentSnapshot document= task.getResult();
                            if(document.exists()){
                                a[0]=(String)document.get("explanation");
                                a[1]=(String)document.get("ranswer");
                                a[2]=(String)document.get("ranswer1");
                                a[3]=(String)document.get("ranswer2");
                                a[4]=(String)document.get("image");
                                Glide.with(Level8.this).load(a[4]).into(scheme);




                            }




                        }
                    }


                });
                d.dismiss();



            }
        });
        d.show();



    }
    public void onBackPressed() {
        try {
            Intent intent = new Intent(Level8.this, Levels.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {

        }

    }


}

