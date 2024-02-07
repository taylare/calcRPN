package calcrpn;  

import java.util.Stack;

/**
 * @author Tayla Rechichi
 * Date Created: February 06, 2024
 * Date Updated: NA
 */

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
         return operand;
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
                c = b / a;
        }
        
        results.push(c);
        return Float.toString(c);
            
    }

    @Override
    public String clearEntry() {
        operand = "";
        return "";
    }

    @Override
    public String clear() {
        results.clear();
        operand = "";
        return "";
    }

    @Override
    public String enterPressed() {
        if (!operand.isBlank()) {
             results.push(Float.parseFloat(operand));
             operand = "";
             return " ";
        }else {
            return "";
        }
    }

    @Override
    public String addDecimal() {
        if (!operand.contains(".")){
            operand += ".";
            return ".";
        }
        return "";
    }
 } 