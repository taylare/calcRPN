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
       
    }

    @Override
    public String operator(String op) {
        
    }

    @Override
    public String clearEntry() {
  
    }

    @Override
    public String clear() {
      
    }

    @Override
    public String enterPressed() {
        
    }

    @Override
    public String addDecimal() {
       
    }
 } 