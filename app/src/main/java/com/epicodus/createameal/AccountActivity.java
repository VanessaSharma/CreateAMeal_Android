package com.epicodus.createameal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AccountActivity extends AppCompatActivity {
    @Bind(R.id.name) EditText mName;
    @Bind(R.id.email) EditText mEmail;
    @Bind(R.id.password) EditText mPassword;
    @Bind(R.id.createButton)
    Button mCreateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        ButterKnife.bind(this);

        mCreateButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String name = mName.getText().toString();
                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();
                Intent intent = new Intent(AccountActivity.this, UserActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);

            }
        });
    }
}
