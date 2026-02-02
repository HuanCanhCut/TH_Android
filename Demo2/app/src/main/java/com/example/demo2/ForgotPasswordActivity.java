package com.example.demo2;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.demo2.base.BaseActivity;

public class ForgotPasswordActivity extends BaseActivity {

    TextView loginLink;

    @Override
    protected boolean enableImeInset() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forgot_password);

        View root = findViewById(R.id.main);
        int basePaddingBottom = root.getPaddingBottom();


        loginLink = findViewById(R.id.loginLink);
        loginLink.setOnClickListener(v -> finish());
    }
}