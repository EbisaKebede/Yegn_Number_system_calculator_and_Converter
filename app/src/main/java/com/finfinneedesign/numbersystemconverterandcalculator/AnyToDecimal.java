package com.finfinneedesign.numbersystemconverterandcalculator;

import android.util.Log;

public class AnyToDecimal {
    long n,number;
    long base;
    String res="",num;

    public AnyToDecimal(long base, String num) {
        this.base = base;
        this.num=num;
        if (base!=16) {
            convert1();
        }
        else{
            convert16();
        }
    }

    public void convert1()
    {
        this.n = Long.parseLong(num);
        int i=0;
        while (n>0)
        {
            int dig = (int) (n % 10);
            number=number+(long)(dig*Math.pow(base,i));
            i++;
            n=n/10;
        }
        res=String.valueOf(number);
    }


    public void convert16()
    {
        int i=num.length()-1;
        int j=0;
        while (i>=0)
        {
            String dig=String.valueOf(num.charAt(i));
            switch (dig) {
                case "A":
                    dig = "10";
                    break;
                case "B":
                    dig = "11";
                    break;
                case "C":
                    dig = "12";
                    break;
                case "D":
                    dig = "13";
                    break;
                case "E":
                    dig = "14";
                    break;
                case "F":
                    dig = "15";
                    break;
            }
            number=number+(Long.parseLong(dig)*(long)Math.pow(base,j));
            i--;
            j++;

        }
        res=String.valueOf(number);

    }

    public String getRes() {
        Log.i("Any toDecimal",res);
        return res;
    }
}
