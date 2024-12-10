package com.example.wydarzeniewsudetach;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView counter;
    private TextView info;
    private Button likeb;
    private Button remove;
    private Button seeu;
    private Button save;
    private EditText ETemail;
    private EditText ETpass;
    private EditText ETrpass;
    public int count=0;
    public String emailr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        likeb = findViewById(R.id.likeb);
        remove = findViewById(R.id.remove);
        seeu = findViewById(R.id.seeu);
        save = findViewById(R.id.save);
        counter = findViewById(R.id.counter);
        info = findViewById(R.id.info);
        ETemail = findViewById(R.id.ETemail);
        ETpass = findViewById(R.id.ETpass);
        ETrpass = findViewById(R.id.ETrpass);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        likeb.setOnClickListener(v -> addLike());
        remove.setOnClickListener(v -> removeLike());
        save.setOnClickListener(v -> saveinfo());
        seeu.setOnClickListener(v -> showinfo());
    }
    void addLike(){
        count += 1;
        counter.setText(count + " polubień");
    }
    void removeLike(){
        if (count>0) {
            count -= 1;
            counter.setText(count + " polubień");
        }
    }
    void saveinfo(){
        if(ETemail.getText().toString().contains("@")){
            if(ETpass.getText().toString().equals(ETrpass.getText().toString())){
                info.setText("Zarejestrowano " + ETemail.getText().toString());
                emailr = ETemail.getText().toString();
            }
            else{
                info.setText("Hasła się różnią");
            };
        }else{
            info.setText("Nieprawidłowy adres e-mail");
        }
    }
    void showinfo(){
        info.setText(emailr);
    }
}