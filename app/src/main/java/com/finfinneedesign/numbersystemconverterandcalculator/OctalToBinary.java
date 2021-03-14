package com.finfinneedesign.numbersystemconverterandcalculator;

public class OctalToBinary {
    String octnum,res;

    public OctalToBinary(String octnum) {
        this.octnum = octnum;
        OctToBin();
    }

    public void OctToBin()
    {
        long i = 0;

        String binary = "";

        while (i<octnum.length()) {

            char c=octnum.charAt((int)i);
            switch (c) {
                case '0':
                    binary += "000";
                    break;
                case '1':
                    binary += "001";
                    break;
                case '2':
                    binary += "010";
                    break;
                case '3':
                    binary += "011";
                    break;
                case '4':
                    binary += "100";
                    break;
                case '5':
                    binary += "101";
                    break;
                case '6':
                    binary += "110";
                    break;
                case '7':
                    binary += "111";
                    break;
                default:
                    System.out.println( "\nInvalid Octal Digit "+ octnum.charAt((int)i));
                    break;
            }
            i++;
        }

        res=binary;
    }

    public String getRes() {
        return res;
    }
}
