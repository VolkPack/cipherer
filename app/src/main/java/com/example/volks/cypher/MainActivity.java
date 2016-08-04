package com.example.volks.cypher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Starts Ceaser Cipher Activity
     * @param view
     */
    public void startCeaserCipher(View view)
    {
        Intent ceaser = new Intent(MainActivity.this, CeaserCipher.class);
        MainActivity.this.startActivity(ceaser);
    }
}
