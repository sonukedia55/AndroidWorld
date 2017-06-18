package com.example.lostnfound;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Intent intent = new Intent(this, Main3Activity.class);
        intent.putExtra("catag", "0");
        intent.putExtra("where","1");
        intent.putExtra("catshow",0);
        startActivity(intent);
        finish();
    }
}
