package com.example.mychecklistapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    private TextView titleTextView;
    private TextView detailTextView;
    private ImageView logoImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail); // Ensure this matches your layout file name

        titleTextView = findViewById(R.id.titleTextView);
        detailTextView = findViewById(R.id.detailTextView);
        logoImageView = findViewById(R.id.logoImageView);

        // Get the item details and image resource ID from the Intent
        String itemTitle = getIntent().getStringExtra("itemTitle");
        String itemDetail = getIntent().getStringExtra("itemDetail");
        int imageResId = getIntent().getIntExtra("imageResId", -1); // Default value -1 if not found

        // Set the text and image
        titleTextView.setText(itemTitle);
        detailTextView.setText(itemDetail);
        if (imageResId != -1) {
            logoImageView.setImageResource(imageResId);
        }
    }
}