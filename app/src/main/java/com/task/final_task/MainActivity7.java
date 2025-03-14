package com.task.final_task;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        ImageView productImage = findViewById(R.id.detailProductImage);
        TextView productName = findViewById(R.id.detailProductName);
        TextView productPrice = findViewById(R.id.detailProductPrice);
        TextView productDescription = findViewById(R.id.detailProductDescription);
        EditText quantityInput = findViewById(R.id.detailProductQuantity);
        Button addToCartButton = findViewById(R.id.detailAddToCartButton);

        productName.setText("Elone");
        productPrice.setText("3400000");
        productDescription.setText("High-end luxury product with advanced features. Tesla CyberTruck Spacex");
        productImage.setImageResource(R.drawable.elone);

        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quantity = quantityInput.getText().toString();
                if (quantity.isEmpty() || Integer.parseInt(quantity) <= 0) {
                    Toast.makeText(MainActivity7.this, "Enter a valid quantity!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity7.this, MainActivity4.class);
                    intent.putExtra("product_name", productName.getText().toString());
                    intent.putExtra("product_price", productPrice.getText().toString());
                    intent.putExtra("product_description", productDescription.getText().toString());
                    intent.putExtra("product_quantity", quantity);
                    intent.putExtra("product_image", R.drawable.elone);
                    startActivity(intent);
                }
            }
        });
    }
}
