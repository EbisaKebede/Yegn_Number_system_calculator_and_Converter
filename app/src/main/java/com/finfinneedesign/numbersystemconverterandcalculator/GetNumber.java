package com.finfinneedesign.numbersystemconverterandcalculator;
import android.view.View;


public class GetNumber {
    String d;
    GetNumber(View view)
    {
        d=view.getTag().toString();
    }

    public String getD() {
        return d;
    }
}
