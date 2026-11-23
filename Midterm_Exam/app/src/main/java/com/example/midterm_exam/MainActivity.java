package com.example.midterm_exam;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private static final String KEY_INDEX = "current_index";

    private TextView tvCounter, tvTitle, tvArtistYear;
    private ImageView ivArtwork;
    private Button btnPrevious, btnNext;

    private int currentIndex = 0;

    private final int[] artworkImages = {
            R.drawable.art1,
            R.drawable.art2,
            R.drawable.art3,
            R.drawable.art4,
            R.drawable.art5,
            R.drawable.art6
    };

    private final String[] artworkTitles = {
            "The Starry Night",
            "Mona Lisa",
            "The Persistence of Memory",
            "The Scream",
            "Girl with a Pearl Earring",
            "Guernica"
    };

    private final String[] artistNames = {
            "Vincent van Gogh",
            "Leonardo da Vinci",
            "Salvador Dali",
            "Edvard Munch",
            "Johannes Vermeer",
            "Pablo Picasso"
    };

    private final String[] creationYears = {
            "1889",
            "1503",
            "1931",
            "1893",
            "1665",
            "1937"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvCounter = findViewById(R.id.tvCounter);
        ivArtwork = findViewById(R.id.ivArtwork);
        tvTitle = findViewById(R.id.tvTitle);
        tvArtistYear = findViewById(R.id.tvArtistYear);
        btnPrevious = findViewById(R.id.btnPrevious);
        btnNext = findViewById(R.id.btnNext);

        if (savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }

        updateArtworkDisplay();

        btnPrevious.setOnClickListener(v -> {
            if (currentIndex > 0) {
                currentIndex--;
                updateArtworkDisplay();
            }
        });

        btnNext.setOnClickListener(v -> {
            if (currentIndex < artworkImages.length - 1) {
                currentIndex++;
                updateArtworkDisplay();
            }
        });

        ivArtwork.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ArtworkDetailsActivity.class);
            intent.putExtra("EXTRA_TITLE", artworkTitles[currentIndex]);
            intent.putExtra("EXTRA_ARTIST", artistNames[currentIndex]);
            intent.putExtra("EXTRA_YEAR", creationYears[currentIndex]);
            startActivity(intent);
        });
    }

    private void updateArtworkDisplay() {
        tvCounter.setText((currentIndex + 1) + " / " + artworkImages.length);
        ivArtwork.setImageResource(artworkImages[currentIndex]);
        tvTitle.setText(artworkTitles[currentIndex]);
        tvArtistYear.setText(artistNames[currentIndex] + " (" + creationYears[currentIndex] + ")");

        btnPrevious.setEnabled(currentIndex > 0);
        btnNext.setEnabled(currentIndex < artworkImages.length - 1);
    }




    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_INDEX, currentIndex);

    }
}