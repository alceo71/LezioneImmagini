package com.example.lezioneimmagini;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ScaleDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AltreImmaginiActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView immagineLivello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altre_immagini);

        setTitle(R.string.titolo_altre_immagini);

        immagineLivello = findViewById(R.id.immagineLivello);

        // Assegno i listener
        findViewById(R.id.bottone_verde).setOnClickListener(this);
        findViewById(R.id.bottone_giallo).setOnClickListener(this);
        findViewById(R.id.bottone_rosso).setOnClickListener(this);
        findViewById(R.id.bottone_transizione_spegni).setOnClickListener(this);
        findViewById(R.id.bottone_transizione_accendi).setOnClickListener(this);

        // Frame scale
        ImageView frame_scale = (ImageView) findViewById(R.id.frame_scale);
        Drawable drawableScale = frame_scale.getDrawable();
        ((ScaleDrawable) drawableScale).setLevel(100);

        // Frame clip
        ImageView frame_clip = (ImageView) findViewById(R.id.frame_clip);
        Drawable drawableClip = frame_clip.getDrawable();
        ((ClipDrawable) drawableClip).setLevel(5000);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.bottone_verde){
            immagineLivello.setImageLevel(2);
        } else  if(view.getId() == R.id.bottone_rosso){
            immagineLivello.setImageLevel(0);
        } else  if(view.getId() == R.id.bottone_giallo){
            immagineLivello.setImageLevel(1);
        } else  if(view.getId() == R.id.bottone_transizione_spegni){
            ImageView immagineTransizione = findViewById(R.id.immagineTransizione);
            ((TransitionDrawable) immagineTransizione.getDrawable()).startTransition(1000);
            ((Button) findViewById(R.id.bottone_transizione_spegni)).setEnabled(false);
            ((Button) findViewById(R.id.bottone_transizione_accendi)).setEnabled(true);
        } else  if(view.getId() == R.id.bottone_transizione_accendi){
            ImageView immagineTransizione = findViewById(R.id.immagineTransizione);
            ((TransitionDrawable) immagineTransizione.getDrawable()).reverseTransition(1000);
            ((Button) findViewById(R.id.bottone_transizione_spegni)).setEnabled(true);
            ((Button) findViewById(R.id.bottone_transizione_accendi)).setEnabled(false);
        }
    }
}
