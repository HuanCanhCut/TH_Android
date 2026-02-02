package com.example.demo2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.demo2.base.BaseActivity;
import com.google.android.material.button.MaterialButton;

public class LoginActivity extends BaseActivity {

    MaterialButton loginButton;
    TextView forgotPassword;
    TextView registerLink;
    ProgressBar loading;

    @Override
    protected boolean enableImeInset() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        initViews();
        initListeners();
    }

    private void initViews() {
        loginButton = findViewById(R.id.loginBtn);
        forgotPassword = findViewById(R.id.forgotPassword);
        registerLink = findViewById(R.id.registerLink);
        loading = findViewById(R.id.loading);
    }

    private void initListeners() {
        forgotPassword.setOnClickListener(v ->
                navigateTo(ForgotPasswordActivity.class)
        );

        registerLink.setOnClickListener(v -> {
            // TODO: open RegisterActivity
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // TODO: login logic
                    loginButton.setEnabled(false);
                    loginButton.setText("");
                    loading.setVisibility(View.VISIBLE);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
//                    loginButton.setEnabled(true);
//                    loginButton.setText("Đăng nhập");
//                    loading.setVisibility(View.GONE);
                }
            }
        });
    }
}
