package com.example.loginconnectdb;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainDangKy extends AppCompatActivity {
//    private FirebaseAuth mAuth;
    private EditText txtName,txtEmail, txtXacNhan1,txtXacNhan2;
    private Button btnDangKy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.active_dang_ky);
        txtName = findViewById(R.id.txtName);
        txtEmail = findViewById(R.id.txtEmail);
        txtXacNhan1 = findViewById(R.id.txtPassWord);
        txtXacNhan2 = findViewById(R.id.txtPassword2);
        btnDangKy = findViewById(R.id.btnDangKy);
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strEmail = txtEmail.getText().toString().trim();
                String strPass = txtXacNhan1.getText().toString().trim();
                String strPass2 = txtXacNhan2.getText().toString().trim();
//                if(strPass.equalsIgnoreCase(strPass2)){
//                    mAuth = FirebaseAuth.getInstance();
//                    mAuth.createUserWithEmailAndPassword(strEmail,strPass).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if(task.isSuccessful()){
//                                Intent intent = new Intent(MainDangKy.this,MainActivity.class);
//                                startActivity(intent);
//                                finishAffinity();
//                            }else{
//                                Toast.makeText(MainDangKy.this,"Fail",Toast.LENGTH_SHORT).show();
//                                Log.w("Fail","Fail");
//                            }
//                        }
//                    });
//                }
            }
        });
    }
}
