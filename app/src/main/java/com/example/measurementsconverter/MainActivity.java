package com.example.measurementsconverter;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements MainAdapter.OnDimensionListener {

    private static final int SQUARE_ACTIVITY = 0;
    private static final int COOKING_ACTIVITY = 1;
    private static final int CURRENCY_ACTIVITY = 2;
    private static final int STORAGE_ACTIVITY = 3;
    private static final int ENERGY_ACTIVITY = 4;
    private static final int FUEL_ACTIVITY = 5;
    private static final int LENGTH_ACTIVITY = 6;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView(savedInstanceState == null);

    }

    private void initRecyclerView(boolean isFirstCreate) {
        final RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MainAdapter(Arrays.asList(Conversion.values()),this));
    }

    @Override
    public void onDimensionClick(int position) {
        Log.d("WorkOnClick","Position-" + position );

        Intent intent = new Intent(this, ConverterActivity.class);
        intent.putExtra("positionOfClickedDimension", position);
        startActivity(intent);
    }
}
