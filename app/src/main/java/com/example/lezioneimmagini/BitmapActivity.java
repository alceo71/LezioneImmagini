package com.example.lezioneimmagini;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.lezioneimmagini.common.LogUtil;

import java.io.IOException;
import java.io.InputStream;

public class BitmapActivity extends AppCompatActivity  implements View.OnClickListener{

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);

        setTitle(R.string.titolo_bitmap);

        imageView = findViewById(R.id.imageView);

        // Assegna i listener per i bottoni
        findViewById(R.id.buttonSaturno).setOnClickListener(this);
        findViewById(R.id.buttonSole).setOnClickListener(this);
        findViewById(R.id.buttonUrano).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.buttonSole){
            imageView.setImageResource(R.drawable.sole_200);
        } else if(view.getId() == R.id.buttonSaturno){
            imageView.setImageResource(R.drawable.saturno_320);
        } else if(view.getId() == R.id.buttonUrano){
            try {
                InputStream is = getAssets().open("urano_320.jpg");
                Drawable image = Drawable.createFromStream(is,null);
                imageView.setImageDrawable(image);
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
