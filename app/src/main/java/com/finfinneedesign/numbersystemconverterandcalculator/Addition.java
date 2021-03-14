package com.finfinneedesign.numbersystemconverterandcalculator;

public class Addition {
    String num1,num2,resultText="";
    int type, fn;
    long number1,number2,result;

    public Addition(String num1, String num2 ,int type, int fn) {
        this.num1 = num1;
        this.num2 = num2;
        this.type=type;
        this.fn=fn;
        cal();
    }

    private void cal() {
        Conversion conversion;
        switch(type)
        {
            case 1:
                conversion=new Conversion(num1,"Binary","Decimal");
                number1=Long.parseLong(conversion.getN());
                conversion=new Conversion(num2,"Binary","Decimal");
                number2=Long.parseLong(conversion.getN());
                break;

            case 3:
                conversion=new Conversion(num1,"Octal","Decimal");
                number1=Long.parseLong(conversion.getN());
                conversion=new Conversion(num2,"Octal","Decimal");
                number2=Long.parseLong(conversion.getN());
                break;


            case 4:
                conversion=new Conversion(num1,"Hexadecimal","Decimal");
                number1=Long.parseLong(conversion.getN());
                conversion=new Conversion(num2,"Hexadecimal","Decimal");
                number2=Long.parseLong(conversion.getN());
                break;

            default:
                number1=Long.parseLong(num1);
                number2=Long.parseLong(num2);
        }

        switch(fn)
        {
            case 1:
                result=number1+number2;
                break;
            case 2:
                result=number1-number2;
                break;
            case 3:
                result=number1*number2;
                break;
            case 4:
                if(number1<number2){
                    result=0;
                }else {
                    result = number1 / number2;
                }
                break;
            case 5:
                result=number1%number2;
                break;
        }

        switch(type)
        {
            case 1:
                if(result==0)
            {
                resultText="0";
            }
            else if(result>-1){;
                    conversion = new Conversion(String.valueOf(result), "Decimal", "Binary");
                    resultText = conversion.getN();
                }
                else
                {
                    conversion = new Conversion(String.valueOf(-result), "Decimal", "Binary");
                    resultText = "-"+conversion.getN();
                }


                break;

            case 3:
                if(result==0)
            {
                resultText="0";
            }
            else if(result>-1) {
                    conversion = new Conversion(String.valueOf(result), "Decimal", "Octal");
                    resultText = conversion.getN();
                }
                else
                {
                    conversion = new Conversion(String.valueOf(-result), "Decimal", "Octal");
                    resultText = "-"+conversion.getN();
                }

                break;

            case 4:
                if(result==0)
                {
                    resultText="0";
                }
                else if(result>-1) {
                    conversion = new Conversion(String.valueOf(result), "Decimal", "Hexadecimal");
                    resultText = conversion.getN();
                }
                else
                {
                    conversion = new Conversion(String.valueOf(-result), "Decimal", "Hexadecimal");
                    resultText = "-"+conversion.getN();
                }

                break;

            default:
                resultText=String.valueOf(result);
        }

    }


    protected String getResultText()
    {
        return resultText;
    }






}
