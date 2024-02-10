package calcrpn;  

import java.util.Stack;

/**
 * @author Tayla Rechichi
 * Date Created: February 06, 2024
 * Date Updated: NA
 **/

public class CalcBrain implements CalcRPNOperations {
    Stack<Float> results;
    String operand;
    
    public CalcBrain()   {                     //serves as calculator's working memory
        results = new Stack<Float>();          //instantiated stack in the constructor so that stack-
        operand = "";                          //is built in the application memory
    }                                          
    
    @Override
    public String digit(String digit) {
       operand += digit;
       return digit;
    }

    @Override
    public String operator(String op) {
        if (!operand.isEmpty()) {
            float number = Float.parseFloat(operand);
            results.push(number);
            operand = "";
        }
                
        if (results.size() < 2){
            return "";
        }
        
        float a = results.pop();
        float b = results.pop();
        float c = 0;
        
        switch (op) {
            case "+":
                c = a + b;
                break;
            case "-":
                c = b - a;
                break;
            case "*":
                c = b * a;
                break;
            case "/":
                if (a!=0) {
                    c = b / a;
                }else {
                    return "Error";
                }
                break;
            case "^":
                c = (float) Math.pow(b, a);
                break;
        }
        
        results.push(c);
        return " " + op + "\n" + c + " ";      
    }

    @Override
    public String clearEntry() {
        operand = "";
        return "\nCleared Digits\n";
    }

    @Override
    public String clear() {
        results.clear();
        operand = "";
        return "\nClear All\n";
    }
   
    @Override
    public String enterPressed() {
        if (!operand.isBlank()) {
             results.push(Float.parseFloat(operand));
             operand = "";
             return " ";
        }else {
            return " ";
        }
    }

    @Override
    public String addDecimal() {
        if (!operand.contains(".")){
            operand += ".";
        }
        return ".";
    }
 } //end of CalcBrain