package com.example.measurementsconverter;

public enum Unit {
    SQ_KILOMETRES(R.string.sq_kilimetres, 1_000_000,0.00_000_1),
    SQ_METRES(R.string.sq_metres,1.0,1.0),
    SQ_SENTIMETRES(R.string.sq_santimetres, 0.00_01, 10_000);


    public int mLabelResources;
    public double mConversionToBase;
    public double mConversionFromBase;

    Unit(int labelResources, double conversionToBase, double conversionFromBase){
        mLabelResources = labelResources;
        mConversionToBase = conversionToBase;
        mConversionFromBase = conversionFromBase;
    }
}
