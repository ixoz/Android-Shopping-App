package com.task.final_task;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        ImageView cartImage = findViewById(R.id.cartImage);
        TextView cartProductName = findViewById(R.id.cartProductName);
        TextView cartProductPrice = findViewById(R.id.cartProductPrice);
        TextView cartProductQuantity = findViewById(R.id.cartProductQuantity);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString("product_name");
            String price = extras.getString("product_price");
            String quantity = extras.getString("product_quantity");
            int imageResId = extras.getInt("product_image");

            cartProductName.setText(name);
            cartProductPrice.setText(price);
            cartProductQuantity.setText("Quantity: " + quantity);
            cartImage.setImageResource(imageResId);
        }
    }
}
