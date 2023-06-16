package com.example.botonerareplay;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import java.util.HashMap;
public class MainActivity extends AppCompatActivity {

    // Declare imageViewAudioMap as a member variable
    HashMap<Integer, Integer> imageViewAudioMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an array of ImageViewIds
        int[] imageViewIds = {R.id.imageView1, R.id.imageView2, R.id.imageView3, R.id.imageView4,
                R.id.imageView5, R.id.imageView6, R.id.imageView7, R.id.imageView8, R.id.imageView9};

        // Initialize the imageViewAudioMap
        imageViewAudioMap = new HashMap<>();
        imageViewAudioMap.put(R.id.imageView1, R.raw.audio_worms);
        imageViewAudioMap.put(R.id.imageView2, R.raw.audio_age);
        imageViewAudioMap.put(R.id.imageView3, R.raw.audio_abe);
        imageViewAudioMap.put(R.id.imageView4, R.raw.audio_sims);
        imageViewAudioMap.put(R.id.imageView5, R.raw.audio_grim);
        imageViewAudioMap.put(R.id.imageView6, R.raw.audio_monkey);
        imageViewAudioMap.put(R.id.imageView7, R.raw.audio_mario);
        imageViewAudioMap.put(R.id.imageView8, R.raw.audio_pacman);
        imageViewAudioMap.put(R.id.imageView9, R.raw.audio_galaga);

        // Loop through the ImageViewIds and set click listeners
        for (int imageViewId : imageViewIds) {
            ImageView imageView = findViewById(imageViewId);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Play the sound corresponding to the ImageView
                    playSound(imageViewId);
                }
            });
        }
    }
    private void playSound(int imageViewId) {
        if (imageViewAudioMap.containsKey(imageViewId)) {
            int audioResourceId = imageViewAudioMap.get(imageViewId);
            MediaPlayer mp = MediaPlayer.create(this, audioResourceId);
            mp.start();
        }
    }
}
