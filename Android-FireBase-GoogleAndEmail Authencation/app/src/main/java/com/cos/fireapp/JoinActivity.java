package com.cos.fireapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class JoinActivity extends AppCompatActivity {

    private static final String TAG = "JoinActivity";
    private FirebaseAuth mAuth;
    private TextInputEditText teEmail,tePassword;
    private MaterialButton btnJoin;
    private LinearLayout joinLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        teEmail = findViewById(R.id.te_email);
        tePassword = findViewById(R.id.te_password);
        joinLayout = findViewById(R.id.join_layout);
        btnJoin = findViewById(R.id.btn_join);
        mAuth = FirebaseAuth.getInstance();

        btnJoin.setOnClickListener(v -> {
            String email = teEmail.getText().toString().trim();
            String password = tePassword.getText().toString().trim();

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, task -> {
                       if (task.isSuccessful()){
                           FirebaseUser user = mAuth.getCurrentUser();
                           Log.d(TAG, "onCreate: user:" + user.getEmail());
                           Intent intent = new Intent(JoinActivity.this,HomeActivity.class); //회원가입 되면 바로 로그인상태로 홈액티비로
                           intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TASK); //이전 액티비티 깔끔하게 날림. 뒤로가기 필요없으니
                           startActivity(intent);
                       }else{
                           Log.d(TAG, "onCreate: 로그인 실패"+task.getException());
                           Snackbar.make(joinLayout, "로그인 실패", BaseTransientBottomBar.LENGTH_LONG).show();
                       }
                    });

        });

    }
}