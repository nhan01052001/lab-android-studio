package com.example.loginconnectdb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityDangNhap extends AppCompatActivity {
//    private FirebaseAuth mAuth;
    private TextView txtRegister;
    private EditText txtEmail, txtPass;
    private Button btnSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.active_dang_nhap);
        txtRegister = findViewById(R.id.txtDangKy);
        txtEmail = findViewById(R.id.txtEmail);
        txtPass = findViewById(R.id.txtPassword);
        btnSignIn = findViewById(R.id.btnDangKy);
//        mAuth = FirebaseAuth.getInstance();
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityDangNhap.this,MainDangKy.class);
                startActivity(intent);
            }
        });
//        btnSignIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String strEmail = txtEmail.getText().toString().trim();
//                String strPass = txtPass.getText().toString().trim();
//                mAuth.signInWithEmailAndPassword(strEmail,strPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if(task.isSuccessful()){
//                            Intent intent = new Intent(ActivityDangNhap.this,ActivityFinish.class);
//                            startActivity(intent);
//                            finishAffinity();
//                        }else{
//                            Intent intent = new Intent(ActivityDangNhap.this,MainDangKy.class);
//                            startActivity(intent);
//                            finishAffinity();
//                        }
//                    }
//                });
//            }
//        });

    }
}
