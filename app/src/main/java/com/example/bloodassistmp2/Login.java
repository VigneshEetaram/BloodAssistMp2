package com.example.bloodassistmp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private Button button,mSignInbtn;
    EditText uEmail,uPassword;
    ProgressBar progressBar;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        uEmail = findViewById(R.id.email);
        uPassword = findViewById(R.id.passWord);
        progressBar = findViewById(R.id.progressBar);
        fAuth = FirebaseAuth.getInstance();
        mSignInbtn = findViewById(R.id.signIn);

        mSignInbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = uEmail.getText().toString().trim();
                String password = uPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    uEmail.setError("Email Field is Required.");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    uPassword.setError("Password Field is Required.");
                    return;
                }
                if (password.length() < 8) {
                    uPassword.setError("Password must be lesser than 8 characters");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //authenticate the use

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Login.this, "Signed in Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), HomePage.class));
                        }else{
                            Toast.makeText(Login.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

        button = (Button) findViewById(R.id.csg);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainPage();
            }
        });
        button = (Button)findViewById(R.id.register);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegister();
            }
        });
        button = (Button)findViewById(R.id.ar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegisterAsAdmin();
            }
        });

    }
    public void openMainPage()
    {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
    public void openRegister()
    {
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);

    }
    public void openRegisterAsAdmin()
    {
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);

    }

}