package com.example.bai3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtA, edtB;
    TextView txtKQ;
    Button btnCong, btnTru, btnNhan, btnChia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        txtKQ = findViewById(R.id.txtKQ);

        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);

        btnCong.setOnClickListener(v -> tinhToan("+"));
        btnTru.setOnClickListener(v -> tinhToan("-"));
        btnNhan.setOnClickListener(v -> tinhToan("*"));
        btnChia.setOnClickListener(v -> tinhToan("/"));
    }

    private void tinhToan(String phepToan) {
        String aStr = edtA.getText().toString();
        String bStr = edtB.getText().toString();

        if (aStr.isEmpty() || bStr.isEmpty()) {
            txtKQ.setText("Vui lòng nhập đủ số");
            return;
        }

        double a = Double.parseDouble(aStr);
        double b = Double.parseDouble(bStr);
        double kq = 0;

        switch (phepToan) {
            case "+": kq = a + b; break;
            case "-": kq = a - b; break;
            case "*": kq = a * b; break;
            case "/":
                if (b == 0) {
                    txtKQ.setText("Không thể chia cho 0");
                    return;
                }
                kq = a / b;
                break;
        }

        txtKQ.setText("Kết quả: " + kq);
    }
}
