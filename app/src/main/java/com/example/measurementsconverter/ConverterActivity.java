package com.example.measurementsconverter;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import static com.example.measurementsconverter.Conversion.SQUARE;

public class ConverterActivity extends AppCompatActivity {

    private static Conversion mConversion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        int positionOfDimension = 0;
        Bundle arguments = getIntent().getExtras();
        if(arguments != null){
            positionOfDimension = arguments.getInt("positionOfClickedDimension");
        }
        mConversion = (Conversion)//НУЖНО ВЕРНУТЬ ИМЯ CONVERSION;
        private String getConversionName() {
            for (Conversion conversion : Conversion.values()) {
                if (conversion.ordinal() == positionOfDimension) {
                    return conversion.mLabelRes.toString();
                }
            }
        }
                //getIntent().getSerializableExtra("CLICKED_POSITION");

        Spinner fromSpinner =(Spinner) findViewById(R.id.from_spinner);
        Spinner toSpinner = findViewById(R.id.to_spinner);
        final List<Unit> unitLabelsArray = mConversion.arrayOfUnits;
        List<String> unitLabels = unitArrayToString(unitLabelsArray);
        fromSpinner.setAdapter(new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item, unitLabels));


//    private void initFromSpinner(int positionOfDimension) {
//        Spinner spinner = findViewById(R.id.from_spinner);
//        spinner.setAdapter(new FromSpinnerAdapter());
//        spinner.setOnItemClickListener((parent, view, position, id) -> {
//            Conversion selectedConversion = Conversion.values()[positionOfDimension];
//            mFromSpinnerAdapter.setConversion(selectedConversion);
//        });
    }

    private List<String> unitArrayToString (List<Unit> unitArray){
            List<String> unitArrayString = new ArrayList<>();
            for (Unit unit : unitArray){
                unitArrayString.add(getString(unit.mLabelResources));
                Log.d("TTTTTTTTTTTTTTTTTTTTTT", getString(unit.mLabelResources));
            }
            return unitArrayString;
    }
}
