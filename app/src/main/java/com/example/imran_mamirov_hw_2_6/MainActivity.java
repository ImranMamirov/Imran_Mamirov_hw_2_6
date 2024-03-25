package com.example.imran_mamirov_hw_2_6;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText emailEditText, passwordEditText;
    Button logInBtn;
    TextView welcomeMessage, logInText, welcomeText, registerText, fPassText;
    String email = "admin123@gmail.com";
    String password = "admin123";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            emailEditText = findViewById(R.id.email);
            passwordEditText = findViewById(R.id.password);
            logInBtn = findViewById(R.id.logIn);
            welcomeMessage = findViewById(R.id.welcomeMessage);
            logInText = findViewById(R.id.logInText);
            welcomeText = findViewById(R.id.welcome);
            registerText = findViewById(R.id.registert);
            fPassText = findViewById(R.id.fPassText);

            emailEditText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (s.toString().trim().length() > 0) {
                        logInBtn.setBackgroundTintList(ContextCompat.getColorStateList(MainActivity.this, R.color.orange));
                    } else {
                        logInBtn.setBackgroundTintList(ContextCompat.getColorStateList(MainActivity.this, R.color.gray));
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            passwordEditText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (s.toString().trim().length() > 0) {
                        logInBtn.setBackgroundTintList(ContextCompat.getColorStateList(MainActivity.this, R.color.orange));
                    } else {
                        logInBtn.setBackgroundTintList(ContextCompat.getColorStateList(MainActivity.this, R.color.gray));
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

            logInBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (email.equals(emailEditText.getText().toString()) && password.equals(passwordEditText.getText().toString())) {
                        Toast.makeText(MainActivity.this, "Вы успешно вошли", Toast.LENGTH_SHORT).show();
                        emailEditText.setVisibility(View.GONE);
                        passwordEditText.setVisibility(View.GONE);
                        logInBtn.setVisibility(View.GONE);
                        logInText.setVisibility(View.GONE);
                        welcomeText.setVisibility(View.GONE);
                        registerText.setVisibility(View.GONE);
                        fPassText.setVisibility(View.GONE);
                        welcomeMessage.setVisibility(View.VISIBLE);
                    } else {
                        Toast.makeText(MainActivity.this, "Неправильный логин или пароль", Toast.LENGTH_SHORT).show();
                    }
                    emailEditText.setText("");
                    passwordEditText.setText("");
                }
            });
            return insets;
        });
    }
}
