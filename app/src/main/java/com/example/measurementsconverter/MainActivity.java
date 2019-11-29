package com.example.measurementsconverter;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements MainAdapter.OnDimensionListener {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView(savedInstanceState == null);
    }

    private void initRecyclerView(boolean isFirstCreate) {
        final RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MainAdapter(Arrays.asList(Conversion.values()), this));
    }

    @Override
    public void onDimensionClick(int position) {
        Log.d("WorkOnClick", "Position-" + position);

        Intent intent = new Intent(this, ConverterActivity.class);
        intent.putExtra("CLICKED_POSITION", Conversion.values()[position]);
        startActivity(intent);
    }
}
