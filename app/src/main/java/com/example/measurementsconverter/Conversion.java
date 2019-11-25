package com.example.measurementsconverter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.example.measurementsconverter.Unit.SQ_KILOMETRES;
import static com.example.measurementsconverter.Unit.SQ_METRES;
import static com.example.measurementsconverter.Unit.SQ_SENTIMETRES;

public enum Conversion {
    SQUARE(R.string.square, Arrays.asList(SQ_SENTIMETRES,SQ_KILOMETRES,SQ_METRES)),
    COOKING(R.string.cooking,Collections.emptyList()),
    CURRENCY(R.string.currency,Collections.emptyList()),
    STORAGE(R.string.storage,Collections.emptyList()),
    ENERGY(R.string.energy,Collections.emptyList()),
    FUEL(R.string.fuel,Collections.emptyList()),
    LENGTH(R.string.length,Collections.emptyList())
    ;


    public int mLabelRes;

    Conversion(int i, List<Unit> conversion) {
        mLabelRes = i;
    }
}
