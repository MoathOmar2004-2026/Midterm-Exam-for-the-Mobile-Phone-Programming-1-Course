package com.example.midterm_exam;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class ArtworkDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artwork_details);
        TextView tvDetailsInfo = findViewById(R.id.tvDetailsInfo);
        Button btnVisitWebsite = findViewById(R.id.btnVisitWebsite);
        Button btnBack = findViewById(R.id.btnBack);

        Intent intent = getIntent();
        String title = intent.getStringExtra("EXTRA_TITLE");
        String artist = intent.getStringExtra("EXTRA_ARTIST");
        String year = intent.getStringExtra("EXTRA_YEAR");

        String detailsText = "Artwork Title: " + title + "\n"
                + "Artist Name: " + artist + "\n"
                + "Creation Year: " + year;

        tvDetailsInfo.setText(detailsText);

        btnVisitWebsite.setOnClickListener(v -> {
            Uri webpage = Uri.parse("https://google.com");
            Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(webIntent);
        });

        btnBack.setOnClickListener(v -> finish());
    }
}