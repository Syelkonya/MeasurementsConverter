package com.example.measurementsconverter;

import android.os.Bundle;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class ConverterActivity extends AppCompatActivity {

    private FromSpinnerAdapter mFromSpinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        Bundle arguments = getIntent().getExtras();
        if(arguments != null){
            int positionOfDimension = arguments.getInt("positionOfClickedDimension");
            initFromSpinner(positionOfDimension);
        }

    }

    private void initFromSpinner(int positionOfDimension) {
        Spinner spinner = findViewById(R.id.from_spinner);
        spinner.setAdapter(new FromSpinnerAdapter());
//        spinner.setOnItemClickListener((parent, view, position, id) -> {
//            Conversion selectedConversion = Conversion.values()[positionOfDimension];
//            mFromSpinnerAdapter.setConversion(selectedConversion);
//        });
    }
}
