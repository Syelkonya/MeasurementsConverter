package com.example.measurementsconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ConverterActivity extends AppCompatActivity {

    private Conversion mConversion;
    private TextView mSelectedParameterFrom;
    private TextView mSelectedParameterTo;
    private EditText mInputValue;
    private EditText mOutputValue;
    private Unit mUnitFrom;
    private Unit mUnitTo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        mConversion = (Conversion) getIntent().getSerializableExtra("CLICKED_POSITION");

        mSelectedParameterFrom = findViewById(R.id.selected_parameter_from);
        mSelectedParameterTo = findViewById(R.id.selected_parameter_to);
        mInputValue = findViewById(R.id.input_number);
        mOutputValue = findViewById(R.id.output_number);
        Spinner fromSpinner = findViewById(R.id.from_spinner);
        Spinner toSpinner = findViewById(R.id.to_spinner);


        mInputValue.setText(R.string.start_convert_value);
        mOutputValue.setText(R.string.start_convert_value);
        mSelectedParameterFrom.setHint(getString(mConversion.arrayOfUnits.get(0).mLabelResources));

        final List<String> unitLabels = unitArrayToString(mConversion.arrayOfUnits);
        fromSpinner.setAdapter(new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item, unitLabels));
        toSpinner.setAdapter(new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item, unitLabels));

        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mUnitFrom = mConversion.arrayOfUnits.get(position);
                mSelectedParameterFrom.setHint(getString(mUnitFrom.mLabelResources));
                convert();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mUnitTo = mConversion.arrayOfUnits.get(position);
                mSelectedParameterTo.setHint(getString(mUnitTo.mLabelResources));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private List<String> unitArrayToString(List<Unit> unitArray) {
        List<String> unitArrayString = new ArrayList<>();
        for (Unit unit : unitArray)
            unitArrayString.add(getString(unit.mLabelResources));
        return unitArrayString;
    }


    private void convert() {
            String inputValueString = mInputValue.getText().toString();
            double input = Double.parseDouble(inputValueString);
            double result = input * mUnitFrom.mConversionToBase * mUnitTo.mConversionFromBase;
            mOutputValue.setText(result + "");
    }
}
