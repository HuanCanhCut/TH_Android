package com.example.bai5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    CheckBox cbCoffee, cbIceCream, cbSnack, cbYogurt, cbPurpleYogurt;
    EditText etCoffee, etIceCream, etSnack, etYogurt, etPurpleYogurt;
    Button btnPay;
    TextView tvTotal;

    final int PRICE_COFFEE = 20000;
    final int PRICE_ICE_CREAM = 10000;
    final int PRICE_SNACK = 5000;
    final int PRICE_YOGURT = 6000;
    final int PRICE_PURPLE_YOGURT = 12000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbCoffee = findViewById(R.id.cbCoffee);
        cbIceCream = findViewById(R.id.cbIceCream);
        cbSnack = findViewById(R.id.cbSnack);
        cbYogurt = findViewById(R.id.cbYogurt);
        cbPurpleYogurt = findViewById(R.id.cbPurpleYogurt);

        etCoffee = findViewById(R.id.etCoffee);
        etIceCream = findViewById(R.id.etIceCream);
        etSnack = findViewById(R.id.etSnack);
        etYogurt = findViewById(R.id.etYogurt);
        etPurpleYogurt = findViewById(R.id.etPurpleYogurt);

        btnPay = findViewById(R.id.btnPay);
        tvTotal = findViewById(R.id.tvTotal);

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateTotal();
            }
        });
    }

    private void calculateTotal() {
        int total = 0;

        if (cbCoffee.isChecked()) {
            total += PRICE_COFFEE * getQuantity(etCoffee);
        }

        if (cbIceCream.isChecked()) {
            total += PRICE_ICE_CREAM * getQuantity(etIceCream);
        }

        if (cbSnack.isChecked()) {
            total += PRICE_SNACK * getQuantity(etSnack);
        }

        if (cbYogurt.isChecked()) {
            total += PRICE_YOGURT * getQuantity(etYogurt);
        }

        if (cbPurpleYogurt.isChecked()) {
            total += PRICE_PURPLE_YOGURT * getQuantity(etPurpleYogurt);
        }

        tvTotal.setText("Tổng tiền: " + total + " đ");
    }

    private int getQuantity(EditText editText) {
        String value = editText.getText().toString().trim();
        if (value.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(value);
    }
}