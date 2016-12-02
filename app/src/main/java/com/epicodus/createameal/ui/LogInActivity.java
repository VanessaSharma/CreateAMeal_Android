package com.epicodus.createameal.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.createameal.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LogInActivity extends AppCompatActivity {
    @Bind(R.id.userName) EditText mUserName;
    @Bind(R.id.userPassword) EditText mUserPassword;
    @Bind(R.id.logInButton) Button mLogInButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        ButterKnife.bind(this);

        mLogInButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String userName = mUserName.getText().toString();
                String password = mUserPassword.getText().toString();
                Intent intent = new Intent(LogInActivity.this, UserActivity.class);
                intent.putExtra("userName", userName);
                startActivity(intent);

            }
        });
    }
}
