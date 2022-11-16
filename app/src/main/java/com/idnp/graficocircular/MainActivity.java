package com.idnp.graficocircular;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    GraficoCircular graficoCircular;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] datos={21,47,29,15,23,27,33,28,29,35,33,17,18,28};
        int[] colores={Color.parseColor("#EC7063"),
                Color.parseColor("#ABB2B9"),
                Color.parseColor("#D2B4DE"),
                Color.parseColor("#E59866"),
                Color.parseColor("#F9E79F"),
                Color.parseColor("#DAF7A6"),
                Color.parseColor("#E59866"),
                Color.parseColor("#AED6F1"),
                Color.parseColor("#16A085"),
                Color.parseColor("#5F6A6A"),
                Color.parseColor("#2471A3"),
                Color.parseColor("#B7950B"),
                Color.parseColor("#F1948A"),
                Color.parseColor("#17A589")};
        linearLayout=(LinearLayout)findViewById(R.id.linearLayout);
        linearLayout.addView(new GraficoCircular(this,14,datos,colores));
    }
}