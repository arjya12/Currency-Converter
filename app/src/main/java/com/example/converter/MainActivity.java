package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    String[] items = {"BDT", "CAD", "USD", "EUR"};
    String[] anotherItems = {"BDT", "CAD", "USD", "EUR"};

    AutoCompleteTextView autoCompleteTextView;
    AutoCompleteTextView anotherAutoCompleteTextView;

    private TextInputLayout textInputLayout3;
    TextInputLayout textInputLayout4;

    ArrayAdapter<String> adapterItems;
    ArrayAdapter<String> anotherAdapterItems;

    Button button;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputLayout3 = findViewById(R.id.textInputLayout3);

        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        adapterItems = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, items);
        autoCompleteTextView.setAdapter(adapterItems);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, "Item: " + item, Toast.LENGTH_SHORT).show();
            }
        });

        anotherAutoCompleteTextView = findViewById(R.id.anotherAutoCompleteTextView);
        anotherAdapterItems = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, anotherItems);
        anotherAutoCompleteTextView.setAdapter(anotherAdapterItems);

        anotherAutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, "Another Item: " + item, Toast.LENGTH_SHORT).show();
            }
        });

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertCurrency();
            }
        });
    }


    private void convertCurrency() {
        TextInputLayout inputLayout = findViewById(R.id.textInputLayout3);
        TextView resultTextView = findViewById(R.id.textView4);

        String amountStr = inputLayout.getEditText().getText().toString();
        String sourceCurrency = autoCompleteTextView.getText().toString().toUpperCase();
        String targetCurrency = anotherAutoCompleteTextView.getText().toString().toUpperCase();

        if (!amountStr.isEmpty()) {
            double amount = Double.parseDouble(amountStr);
            double result = 0.0;

            if (sourceCurrency.equals("CAD")) {
                if (targetCurrency.equals("BDT")) {
                    result = amount * 81.72;
                } else if (targetCurrency.equals("USD")) {
                    result = amount * 0.74;
                } else if (targetCurrency.equals("EUR")) {
                    result = amount * 0.68;
                }
            } else if (sourceCurrency.equals("BDT")) {
                if (targetCurrency.equals("USD")) {
                    result = amount * 0.0091;
                } else if (targetCurrency.equals("EUR")) {
                    result = amount * 0.0084;
                } else if (targetCurrency.equals("CAD")) {
                    result = amount * 0.012;
                }
            } else if (sourceCurrency.equals("USD")) {
                if (targetCurrency.equals("BDT")) {
                    result = amount * 109.43;
                } else if (targetCurrency.equals("CAD")) {
                    result = amount * 1.36;
                } else if (targetCurrency.equals("EUR")) {
                    result = amount * 0.92;
                }
            } else if (sourceCurrency.equals("EUR")) {
                if (targetCurrency.equals("BDT")) {
                    result = amount * 119.15;
                } else if (targetCurrency.equals("USD")) {
                    result = amount * 1.09;
                } else if (targetCurrency.equals("CAD")) {
                    result = amount * 1.48;
                }
            }
            resultTextView.setText(String.valueOf(result));
        } else{
            Toast.makeText(this, "Please enter an amount", Toast.LENGTH_SHORT).show();
        }
    }
}


