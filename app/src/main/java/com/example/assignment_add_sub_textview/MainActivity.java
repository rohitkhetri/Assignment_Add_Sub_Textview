package com.example.assignment_add_sub_textview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private LinearLayout linearLayout, linear2;
    private Button btnAdd, btnSub, btnEqual;
    private EditText edttxt;
    private TextView txtAddition;
    private int Viewcount =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.linearLayout);
        linear2 = findViewById(R.id.linear2);

        edttxt = findViewById(R.id.editText);
        txtAddition = findViewById(R.id.txtAddition);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnEqual = findViewById(R.id.btnEqual);

        btnAdd.setOnClickListener(new btnAdd());
        btnSub.setOnClickListener(new btnSub());
        btnEqual.setOnClickListener(new btnEqual());
    }
    private class btnAdd implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            EditText newEditText = new EditText(MainActivity.this);

            newEditText.setId(View.generateViewId());
            newEditText.setText(edttxt.getText().toString());

            linear2.addView(newEditText);
            Viewcount++;

            edttxt.getText().clear();
        }
    }

    private class btnSub implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int count = linear2.getChildCount();
            if (count > 0) {
                linear2.removeViewAt(0);
                Viewcount--;
            }
        }
    }

    private class btnEqual implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int sum = 0;

            for (int i = 0; i < linear2.getChildCount(); i++) {
                View childView = linear2.getChildAt(i);
                if (childView instanceof TextView) {
                    String valueStr = ((TextView) childView).getText().toString();
                    if (!valueStr.isEmpty()) {
                        int value = Integer.parseInt(valueStr);
                        sum += value;
                    }
                }
            }
            txtAddition.setText("Addition of given numbers is: " + String.valueOf(sum));
        }
    }


}