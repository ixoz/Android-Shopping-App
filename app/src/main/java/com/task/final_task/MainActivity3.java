package com.task.final_task;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView userViewDisplay = findViewById(R.id.userViewDisplay);
        ImageView productImage1 = findViewById(R.id.productImage1);
        ImageView productImage2 = findViewById(R.id.productImage2);
        ImageView productImage3 = findViewById(R.id.productImage3);
        Button addToCartButton1 = findViewById(R.id.addToCartButton1);
        Button addToCartButton2 = findViewById(R.id.addToCartButton2);
        Button addToCartButton3 = findViewById(R.id.addToCartButton3);
        EditText quantityInput1 = findViewById(R.id.quantityInput1);
        EditText quantityInput2 = findViewById(R.id.quantityInput2);
        EditText quantityInput3 = findViewById(R.id.quantityInput3);

        String username = getIntent().getStringExtra("username");
        if (username != null && !username.isEmpty()) {
            userViewDisplay.setText(username);
        } else {
            userViewDisplay.setText("Guest");
        }

        productImage1.setOnClickListener(v -> openDetails("Smartphone", "₹12999", "A high-performance smartphone.", R.drawable.smartphone));
        productImage2.setOnClickListener(v -> openDetails("Headphones", "₹3500", "Wireless headphones with noise cancellation.", R.drawable.headphones));
        productImage3.setOnClickListener(v -> openDetails("Elone", "₹3400000", "Luxury product.", R.drawable.elone));

        addToCartButton1.setOnClickListener(v -> addToCart("Smartphone", "₹12999", quantityInput1.getText().toString(), R.drawable.smartphone));
        addToCartButton2.setOnClickListener(v -> addToCart("Headphones", "₹3500", quantityInput2.getText().toString(), R.drawable.headphones));
        addToCartButton3.setOnClickListener(v -> addToCart("Elone", "₹3400000", quantityInput3.getText().toString(), R.drawable.elone));
    }

    private void openDetails(String name, String price, String desc, int imgRes) {
        Intent intent = new Intent(this, MainActivity5.class);
        intent.putExtra("product_name", name);
        intent.putExtra("product_price", price);
        intent.putExtra("product_description", desc);
        intent.putExtra("product_image", imgRes);
        startActivity(intent);
    }

    private void addToCart(String name, String price, String quantity, int imgRes) {
        if (quantity.isEmpty()) {
            Toast.makeText(this, "Enter quantity", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this, MainActivity4.class);
        intent.putExtra("product_name", name);
        intent.putExtra("product_price", price);
        intent.putExtra("product_quantity", quantity);
        intent.putExtra("product_image", imgRes);
        startActivity(intent);
    }
}
