package com.example.bai4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    CheckBox cbCoffee, cbIceCream, cbSnack, cbYogurt, cbPurpleYogurt;
    Button btnOrder;
    TextView tvTotal;

    // Giá tiền
    final int PRICE_COFFEE = 20000;
    final int PRICE_ICE_CREAM = 10000;
    final int PRICE_SNACK = 5000;
    final int PRICE_YOGURT = 6000;
    final int PRICE_PURPLE_YOGURT = 12000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ view
        cbCoffee = findViewById(R.id.cbCoffee);
        cbIceCream = findViewById(R.id.cbIceCream);
        cbSnack = findViewById(R.id.cbSnack);
        cbYogurt = findViewById(R.id.cbYogurt);
        cbPurpleYogurt = findViewById(R.id.cbPurpleYogurt);

        btnOrder = findViewById(R.id.btnOrder);
        tvTotal = findViewById(R.id.tvTotal);

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateTotal();
            }
        });
    }

    private void calculateTotal() {
        int total = 0;

        if (cbCoffee.isChecked()) {
            total += PRICE_COFFEE;
        }

        if (cbIceCream.isChecked()) {
            total += PRICE_ICE_CREAM;
        }

        if (cbSnack.isChecked()) {
            total += PRICE_SNACK;
        }

        if (cbYogurt.isChecked()) {
            total += PRICE_YOGURT;
        }

        if (cbPurpleYogurt.isChecked()) {
            total += PRICE_PURPLE_YOGURT;
        }

        tvTotal.setText("Tổng tiền: " + total + " đ");
    }
}