package com.example.bai2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;


public class MainActivity extends AppCompatActivity {

    Button submitBtn;
    TextInputEditText heightInput;
    TextInputEditText weightInput;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initViews();
        listener();
    }

    private void initViews () {
        submitBtn = findViewById(R.id.submitbtn);
        heightInput = findViewById(R.id.height);
        weightInput = findViewById(R.id.weight);
        textView = findViewById(R.id.result);
    }

    private void listener() {
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String heightValue = heightInput.getText().toString().trim();
                String weightValue = weightInput.getText().toString().trim();

                float result = (float) (
                        Float.parseFloat(weightValue) /
                                Math.pow(Float.parseFloat(heightValue), 2)
                );

                if (result < 18.5) {
                    textView.setText("Gầy");
                } else if (result >= 18.5 && result < 24.9) {
                    textView.setText("Bình thường");
                } else if (result == 25) {
                    textView.setText("Thừa cân");
                } else if (result > 25 && result < 29.9) {
                    textView.setText("Tiền béo phì");
                } else if (result >= 30 && result < 34.9) {
                    textView.setText("Béo phì độ I");
                } else if (result >= 35 && result < 39.9) {
                    textView.setText("Béo phì độ II");
                } else if (result >= 40) {
                    textView.setText("Béo phì độ III ");
                }
            }
        });
    }
}