package com.ualr.layoutassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private final Map<CheckBox, EditText> productWidgetMap = new HashMap<>(4);
    private MaterialButton discountButton;
    private TextView totalPrice;

    // TODO 02. Create a new method called "calculateTotal" for calculating the invoice's total amount of money

    // TODO 03. Bind the "calculateTotal" method to the button with the "CALCULATE TOTAL" label

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productWidgetMap.put(
                (CheckBox) findViewById(R.id.product1Checkbox),
                (EditText) findViewById(R.id.product1Price));
        productWidgetMap.put(
                (CheckBox) findViewById(R.id.product2Checkbox),
                (EditText) findViewById(R.id.product2Price));
        productWidgetMap.put(
                (CheckBox) findViewById(R.id.product3Checkbox),
                (EditText) findViewById(R.id.product3Price));
        productWidgetMap.put(
                (CheckBox) findViewById(R.id.product4Checkbox),
                (EditText) findViewById(R.id.product4Price));

        discountButton = findViewById(R.id.discountButton);
        totalPrice = findViewById(R.id.totalAmount);
        totalPrice.setText(String.format(getText(R.string.total_price_format).toString(), 00.00));
    }

    public void calculateTotal(View view) {
        float total = 0F;
        for (Map.Entry<CheckBox, EditText> entry : productWidgetMap.entrySet()) {

            if (entry.getKey().isChecked()) {
                total += Float.parseFloat(entry.getValue().getText().toString());
            }
        }

        if (discountButton.isChecked() && total > 0F) {
            total *= 0.75;
        }

        totalPrice.setText(String.format(getText(R.string.total_price_format).toString(), total));
    }
}