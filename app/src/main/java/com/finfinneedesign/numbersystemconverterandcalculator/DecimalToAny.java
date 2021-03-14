package com.finfinneedesign.numbersystemconverterandcalculator;
import android.util.Log;

public class DecimalToAny {
    long n;
    long base;
    String res="",num;

    public DecimalToAny(String num, int base) {

        this.num=num;
        this.n=Long.parseLong(num);
        this.base = base;
        convert();

    }


    public void convert()
    {
       //int i=num.length();
            while (n > 0) {
                int dig = (int) (n % base);
                if (base==16 && dig>9)
                {
                    switch (dig)
                    {
                        case 10:
                            res+="A";
                            break;
                        case 11:
                            res+="B";
                            break;
                        case 12:
                            res+="C";
                            break;
                        case 13:
                            res+="D";
                            break;
                        case 14:
                            res+="E";
                            break;
                        case 15:
                            res+="F";
                            break;
                    }
                }
                else
                {
                    res = res + Integer.toString(dig);
                }

                n = n / base;
            }
            reverseString();

    }
    public void reverseString()
    {
        String newRes="";
        int i=res.length()-1;
        while(i>=0)
        {
            newRes+=String.valueOf(res.charAt(i));
            i--;
        }
        res=newRes;
    }


    public String getRes() {
        Log.i("convertDecimal",res);
        return res;
    }
}
