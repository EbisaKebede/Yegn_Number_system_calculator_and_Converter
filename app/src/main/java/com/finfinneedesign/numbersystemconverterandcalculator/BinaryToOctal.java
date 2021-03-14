package com.finfinneedesign.numbersystemconverterandcalculator;

public class BinaryToOctal {
    String num,res="";

    public BinaryToOctal(String num) {
        this.num = num;
        convertBinarytoOctal();
    }


      public void  convertBinarytoOctal()
        {
            int l=num.length();
            if (l%3!=0)
            {
                for(int i=0;i<(3-l%3);i++)
                {
                    num="0"+num;
                }
            }
            int i=0;
            while(i<l)
            {
                switch(num.substring(i,i+3))
                {
                    case "000":
                        res+="0";
                        break;
                    case "001":
                        res+="1";
                        break;
                    case "010":
                        res+="2";
                        break;
                    case "011":
                        res+="3";
                        break;
                    case "100":
                        res+="4";
                        break;
                    case "101":
                        res+="5";
                        break;
                    case "110":
                        res+="6";
                        break;
                    case "111":
                        res+="7";
                        break;
                }
                i=i+3;
            }


        }



    public String getRes() {
        return res;
    }
}







