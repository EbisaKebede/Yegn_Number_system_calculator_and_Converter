package com.finfinneedesign.numbersystemconverterandcalculator;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

public class ValidityChecker{
    String digit;
    boolean check=false;
    TextView fromSystem,toSystem;
    String from,to;
    String errorMsg="Please enter correct number!";
    ValidityChecker(String s,TextView fromSystem,TextView toSystem) {
        digit=s;
        this.fromSystem=fromSystem;
        from=fromSystem.getText().toString();
        to=toSystem.getText().toString();
        this.toSystem=toSystem;
        validityCheck();
    }

    public void validityCheck()
    {
        switch (from) {
            case "Binary":
                Binary();
                break;
            case "Decimal":
                Decimal();
                break;
            case "Octal":
                Octal();
                break;
            default:
                check = true;
                break;
        }
    }

    public void Binary()
    {
        if(!(digit.equals("1") || digit.equals("0")))
        {
            errorMsg="Binary numbers cannot contain the digit "+digit;
        }
        else
        {
            check=true;
        }
    }

    public void Decimal()
    {
        if((digit.equals("A") || digit.equals("B") || digit.equals("C") || digit.equals("D") || digit.equals("E") || digit.equals("F")))
        {
            errorMsg="Decimal numbers cannot contain the digit "+digit;
        }
        else
        {
            check=true;
        }
    }

    public void Octal()
    {
        if((digit.equals("A") || digit.equals("B") || digit.equals("C") || digit.equals("D") || digit.equals("E") || digit.equals("F") || digit.equals("9") || digit.equals("8")))
        {
            errorMsg="Octal numbers cannot contain the digit "+digit;
        }
        else
        {
            check=true;
        }
    }






    public void makeToast(Context vContext){
        Toast.makeText(vContext, errorMsg, Toast.LENGTH_SHORT).show();
    }



    public boolean checked()
    {
        return check;
    }


}
