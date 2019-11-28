package com.example.measurementsconverter;

import android.os.Bundle;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ConverterActivity extends AppCompatActivity {

    private static Conversion mConversion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        mConversion = (Conversion) getIntent().getSerializableExtra("positionOfClickedDimension");
//        Bundle arguments = getIntent().getExtras();
//        if(arguments != null){
//            int positionOfDimension = arguments.getInt("positionOfClickedDimension");
//            initFromSpinner(positionOfDimension);
//        }

        Spinner FromSpinner = findViewById(R.id.from_spinner);
        Spinner ToSpinner = findViewById(R.id.to_spinner);
        final List<Unit> unitArray = mConversion.arrayOfUnits;
        final List<String> unitLabels = unitArray.stream().forEach(Enum::toString);

//    private void initFromSpinner(int positionOfDimension) {
//        Spinner spinner = findViewById(R.id.from_spinner);
//        spinner.setAdapter(new FromSpinnerAdapter());
//        spinner.setOnItemClickListener((parent, view, position, id) -> {
//            Conversion selectedConversion = Conversion.values()[positionOfDimension];
//            mFromSpinnerAdapter.setConversion(selectedConversion);
//        });
//    }
}
