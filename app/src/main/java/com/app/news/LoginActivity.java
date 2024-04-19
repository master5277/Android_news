package com.app.news;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    private TextView register ;
    private Button login;
    private EditText et_username ;
    private EditText et_password;
    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        register = findViewById(R.id.register);
        login = findViewById(R.id.login);
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        mSharedPreferences = getSharedPreferences("user",MODE_PRIVATE);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转注册页面
                Intent  intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                if (TextUtils.isEmpty(username)&&TextUtils.isEmpty(password))
                {
                    Toast.makeText(LoginActivity.this, "请输入登录信息", Toast.LENGTH_SHORT).show();
                }else
                {
                    String name = mSharedPreferences.getString("username",null);
                    String pwd = mSharedPreferences.getString("password",null);
                    if (username.equals(name)&&password.equals(pwd))
                    {
                        //登陆成功
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                    }else
                    {
                        Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}