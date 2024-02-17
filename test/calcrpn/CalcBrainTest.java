package calcrpn;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JavaDeveloper
 */
public class CalcBrainTest {
    
    public CalcBrainTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of digit method, of class CalcBrain.
     */
    @Test
    public void testDigit() {
        System.out.println("Testing digits");
        
        // Declare a sample test digit.
        String enterDigit = "3";
        
        // Instantiate the CalcBrain object.
        CalcBrain instance = new CalcBrain();
        
        String expectedResult = "3";
        
        // Call the CalcBrain method digit to insert "3"
        String result = instance.digit(enterDigit);
        
        // Check that the "3" is returned from CalcBrain's digit method.
        assertEquals(expectedResult, result);        
    }
    
    @Test
    public void testAddTwoNumbers() {
        System.out.println("Testing addition");
        String enterFirstDigit = "3";
        String enterSecondDigit = "2";
        String enterOperator = "+";
        CalcBrain instance = new CalcBrain();
        instance.digit(enterFirstDigit);
        instance.enterPressed();
        instance.digit(enterSecondDigit);
        String result = instance.operator(enterOperator);

        String expectedResult = " +\n5.0 ";
        
        float delta = 0.0f;
        assertEquals(Float.parseFloat(expectedResult.replaceAll("\\s",""))
                   , Float.parseFloat(result.replaceAll("\\s",""))
                    ,delta);        
    }

    @Test
    public void testAddThreeNumbers() {
        System.out.println("Testing addition");
        String enterFirstDigit = "3";
        String enterSecondDigit = "2";
        String enterThirdDigit = "4";
        String enterOperator = "+";
        CalcBrain instance = new CalcBrain();
        instance.digit(enterFirstDigit);
        instance.enterPressed();
        instance.digit(enterSecondDigit);
        instance.enterPressed();
        instance.digit(enterThirdDigit);
        
        String result = instance.operator(enterOperator);
        result = instance.operator(enterOperator);
        
        String expectedResult = " +\n9.0 ";
        
        float delta = 0.0f;
        assertEquals(Float.parseFloat(expectedResult.replaceAll("\\s",""))
                   , Float.parseFloat(result.replaceAll("\\s",""))
                    ,delta);        
    }
    
    @Test
    public void testSubtractThreeNumbers() {
        System.out.println("Testing subtraction");
        String enterFirstDigit = "3";
        String enterSecondDigit = "5";
        String enterThirdDigit = "1";
        String enterOperator = "-";
        CalcBrain instance = new CalcBrain();
        instance.digit(enterFirstDigit);
        instance.enterPressed();
        instance.digit(enterSecondDigit);
        instance.enterPressed();
        instance.digit(enterThirdDigit);
        
        String result = instance.operator(enterOperator);
        result = instance.operator(enterOperator);
        
        String expectedResult = " -\n-1.0 ";
        
        float delta = 0.0f;
        
        // Strip out the prefix " -\n" text part of the strings.
        
        assertEquals(Float.parseFloat(expectedResult.replaceAll("^[^\\n]*\\n",""))
                   , Float.parseFloat(result.replaceAll("^[^\\n]*\\n",""))
                    ,delta);        
    }    

    @Test
    public void testSubtractTwoNumbers() {
        System.out.println("Testing subtraction");
        String enterFirstDigit = "3";
        String enterSecondDigit = "2";
        String enterOperator = "-";
        CalcBrain instance = new CalcBrain();
        instance.digit(enterFirstDigit);
        instance.enterPressed();
        instance.digit(enterSecondDigit);
        
        String result = instance.operator(enterOperator);
        
        String expectedResult = " -\n1.0 ";
        
        float delta = 0.0f;
        
        // Strip out the prefix " -\n" text part of the strings.
        
        assertEquals(Float.parseFloat(expectedResult.replaceAll("^[^\\n]*\\n",""))
                   , Float.parseFloat(result.replaceAll("^[^\\n]*\\n",""))
                    ,delta);        
    }  
    
    @Test
    public void testAddTwoDecimals() {
        System.out.println("Testing decimal addition");
        String enterOperator = "+";
        
        CalcBrain instance = new CalcBrain();
        instance.digit("3");
        instance.addDecimal();
        instance.digit("1");
        instance.enterPressed();
        instance.digit("2");
        instance.addDecimal();
        instance.digit("9");
        
        instance.enterPressed();
        
        String result = instance.operator(enterOperator);
        
        String expectedResult = " +\n6.0 ";
        
        float delta = 0.0f;
        
        // Strip out the prefix " -\n" text part of the strings.
        
        assertEquals(Float.parseFloat(expectedResult.replaceAll("^[^\\n]*\\n",""))
                   , Float.parseFloat(result.replaceAll("^[^\\n]*\\n",""))
                    ,delta);        
    }    
    
    @Test
    public void testClearAllPressed() {
        System.out.println("Testing clear all button");
        String enterFirstDigit = "3";
        String enterSecondDigit = "5";
        String enterOperator = "+";
        
        CalcBrain instance = new CalcBrain();
        instance.digit(enterFirstDigit);
        instance.enterPressed();
        instance.digit(enterSecondDigit);
        
        String clearResult = instance.clear();
        
        String result = instance.operator(enterOperator);
        
        String expectedClearResult = "\nClear All\n";               
        
        assertTrue( expectedClearResult.equalsIgnoreCase(clearResult));
        assertTrue( result.equals(""));
    }        
    
    @Test
    public void testClearEntryPressed() {
        System.out.println("Testing clear entry button");
        String enterFirstDigit = "3";
        String enterSecondDigit = "5";
        String enterThirdDigit = "4";
        
        String enterOperator = "+";
        
        CalcBrain instance = new CalcBrain();
        instance.digit(enterFirstDigit);
        instance.enterPressed();
        
        instance.clearEntry();
        
        instance.digit(enterSecondDigit);
        instance.enterPressed();
        
        instance.digit(enterThirdDigit);
        
        String result = instance.operator(enterOperator);
        
        String expectedResult = " +\n9.0 ";
        
        float delta = 0.0f;
        assertEquals(Float.parseFloat(expectedResult.replaceAll("\\s",""))
                   , Float.parseFloat(result.replaceAll("\\s",""))
                    ,delta);        
    }      
    
    @Test
    public void testMultiplyTwoDecimals() {
        System.out.println("Testing multiply decimals");
        String enterOperator = "*";
        
        CalcBrain instance = new CalcBrain();
        instance.digit("3");
        instance.addDecimal();
        instance.digit("1");
        instance.enterPressed();
        instance.digit("2");
        instance.addDecimal();
        instance.digit("9");
        
        instance.enterPressed();
        
        String result = instance.operator(enterOperator);
        
        String expectedResult = " +\n8.99 ";
        
        float delta = 0.0f;
        
        // Strip out the prefix " -\n" text part of the strings.
        
        assertEquals(Float.parseFloat(expectedResult.replaceAll("^[^\\n]*\\n",""))
                   , Float.parseFloat(result.replaceAll("^[^\\n]*\\n",""))
                    ,delta);        
    }   
    
    @Test
    public void testDivideTwoNumbers() {
        System.out.println("Testing division");
        String enterOperator = "/";
        
        CalcBrain instance = new CalcBrain();
        instance.digit("3");
        instance.digit("1");
        instance.enterPressed();
        instance.digit("2");
        
        instance.enterPressed();
        
        String result = instance.operator(enterOperator);
        
        String expectedResult = " +\n15.5 ";
        
        float delta = 0.0f;
        
        // Strip out the prefix " -\n" text part of the strings.
        
        assertEquals(Float.parseFloat(expectedResult.replaceAll("^[^\\n]*\\n",""))
                   , Float.parseFloat(result.replaceAll("^[^\\n]*\\n",""))
                    ,delta);        
    }        
    @Test
    public void testPowerOf() {
        System.out.println("Testing exponent");
        String enterOperator = "^";
        
        CalcBrain instance = new CalcBrain();
        instance.digit("3");
        instance.enterPressed();
        instance.digit("2");
        
        instance.enterPressed();
        
        String result = instance.operator(enterOperator);
        
        String expectedResult = " +\n9.0 ";
        
        float delta = 0.0f;
        
        // Strip out the prefix " -\n" text part of the strings.
        
        assertEquals(Float.parseFloat(expectedResult.replaceAll("^[^\\n]*\\n",""))
                   , Float.parseFloat(result.replaceAll("^[^\\n]*\\n",""))
                    ,delta);        
    }
    @Test
    public void testExpression() {
        System.out.println("Testing expression 2+(5*3)-(2^4-3)/6"); 

        CalcBrain instance = new CalcBrain();
        instance.digit("2");
        instance.enterPressed();
        instance.digit("5");
        instance.enterPressed();
        instance.digit("3");
        instance.enterPressed();
        instance.operator("*");
        instance.operator("+");
        instance.digit("2");
        instance.enterPressed();
        instance.digit("4");
        instance.operator("^");
        instance.digit("3");
        instance.operator("-");
        instance.digit("6");
        instance.operator("/");
        
        String result = instance.operator("-");
                
        String expectedResult = " +\n14.83333 ";
        
        float delta = 0.0001f;
        
        // Strip out the prefix " -\n" text part of the strings.
        
        assertEquals(Float.parseFloat(expectedResult.replaceAll("^[^\\n]*\\n",""))
                   , Float.parseFloat(result.replaceAll("^[^\\n]*\\n",""))
                    ,delta);        
    }
    
    @Test
    public void demoTest() {
        System.out.println("Testing expression: 1 2 + 3 × 4 -"); 

        // Instantiate CalcBrain
        CalcBrain instance = new CalcBrain();

        instance.digit("1");
        instance.enterPressed();
        instance.digit("2");
        instance.operator("+");
        instance.digit("3");
        instance.operator("*");
        instance.digit("4");
        instance.operator("-");

        String result = instance.results.peek().toString();
        String expectedResult = "5.0"; 
        assertEquals(expectedResult, result);  
    }
    
    @Test
    public void demoTest2() {
        System.out.println("Testing expression: 1 - 2 + + 4"); //1 2 - 4 +

        // Instantiate CalcBrain
        CalcBrain instance = new CalcBrain();

        instance.digit("1");
        instance.enterPressed();
        instance.digit("2");
        instance.operator("-");
        instance.digit("4");
        instance.operator("+");
        
        String result = instance.results.peek().toString();
        String expectedResult = "3.0"; 
        assertEquals(expectedResult, result);  
    }

    /**
     * Test of operator method, of class CalcBrain.
     */
    @Test
    public void testOperator() {
        System.out.println("operator");
        CalcBrain instance = new CalcBrain();

        // Case 1: Addition
        instance.digit("3");
        instance.digit("5");
        instance.enterPressed();
        instance.digit("2");
        instance.operator("+");
        float result = instance.results.peek();
        assertEquals(37.0f, result, 0.0f);
        // Test stack after addition operation
        assertEquals(1, instance.results.size()); // Ensure only one item in the stack after addition

        // Case 2: Subtraction
        instance.digit("8");
        instance.operator("-");
        result = instance.results.peek();
        assertEquals(29.0f, result, 0.0f);

        // Test stack after subtraction operation
        assertEquals(1, instance.results.size()); // Ensure only one item in the stack after subtraction

        // Case 3: Multiplication
        instance.digit("4");
        instance.operator("*");
        result = instance.results.peek();
        assertEquals(116.0f, result, 0.0f);

        // Test stack after multiplication operation
        assertEquals(1, instance.results.size()); // Ensure only one item in the stack after multiplication

        // Case 4: Division
        instance.digit("2");
        instance.operator("/");
        result = instance.results.peek();
        assertEquals(58.0f, result, 0.0f);

        // Test stack after division operation
        assertEquals(1, instance.results.size()); // Ensure only one item in the stack after division

        // Case 5: Division by zero
        instance.digit("0");
        String errorMessage = instance.operator("/");
        assertEquals("Error", errorMessage);

        // Test stack after division by zero
        assertEquals(0, instance.results.size()); // Ensure stack is empty after division by zero

        // Case 6: Exponentiation
        instance.clear();
        instance.digit("2");
        instance.enterPressed();
        instance.digit("3");
        instance.operator("^");
        result = instance.results.peek();
        assertEquals(8.0f, result, 0.0f);

        // Test stack after exponentiation operation
        assertEquals(1, instance.results.size()); // Ensure only one item in the stack after exponentiation
    }

    /**
     * Test of clearEntry method, of class CalcBrain.
     */
   @Test
    public void testClearEntry() {
        System.out.println("clearEntry");
        CalcBrain instance = new CalcBrain();
        instance.digit("3");
        String expResult = "\nCleared Digits\n";
        // Check the return value
        String result = instance.clearEntry();
        assertEquals(expResult, result);
        // Check if operand is cleared
        assertTrue(instance.operand.isEmpty());
        // Check if stack is unaffected
        int stackSize = instance.results.size();
        int expectedSize = 0;
        assertEquals(expectedSize, stackSize);   
    }


    /**
     * Test of clear method, of class CalcBrain.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        CalcBrain instance = new CalcBrain();
        instance.digit("3");
        String expResult = "\nClear All\n";
        String result = instance.clear();
        assertEquals(expResult, result);
        // Check the return value
        result = instance.clear();
        assertEquals(expResult, result);
        // Check if stack is cleared
        int stackSize = instance.results.size();
        int expectedSize = 0;
        assertEquals(expectedSize, stackSize);   
        // Check if operand is cleared
        assertTrue(instance.operand.isEmpty());
    }

    /**
     * Test of enterPressed method, of class CalcBrain.
     */
    @Test
    public void testEnterPressed() {
        System.out.println("enterPressed");
        CalcBrain instance = new CalcBrain();
         // Case 1: When no digit is entered
        String result = instance.enterPressed();
        String expResult = " ";
        assertEquals(expResult, result);
        // Check if operand is empty after calling enterPressed()
        assertTrue(instance.operand.isBlank());
        // Case 2: When digits are entered
        instance.digit("3");
        expResult = " ";
        result = instance.enterPressed();
        assertEquals(expResult, result);
        // Check if operand is empty after calling enterPressed() with digits entered
        assertTrue(instance.operand.isBlank());
        // Check the result stack
        instance.digit("1");
        instance.enterPressed();
        float peekResult = instance.results.peek();
        float expectedPeek = 1.0f;
        assertEquals(expectedPeek, peekResult, 0.0f);  
    }
    /**
     * Test of addDecimal method, of class CalcBrain.
     */
    @Test
    public void testAddDecimal() {
        System.out.println("addDecimal");
        CalcBrain instance = new CalcBrain();

        instance.digit("3");
        instance.addDecimal();
        instance.digit("5");
        instance.enterPressed();
        String expResult = "3.5";
        String result = instance.results.peek().toString();
        assertEquals(expResult, result);  
    }
    
    @Test
    public void testMultipleDecimals() {
        System.out.println("addDecimal");
        CalcBrain instance = new CalcBrain();
        //Test 1: 1..2 + 1..2
        instance.digit("1");
        instance.addDecimal();
        instance.addDecimal(); 
        instance.addDecimal();
        instance.digit("2");
        instance.enterPressed();
        instance.digit("1");
        instance.addDecimal();
        instance.addDecimal(); 
        instance.digit("2");
        instance.enterPressed();
        instance.operator("+");

        String result = instance.results.peek().toString();
        String expectedResult = "2.4"; 
        assertEquals(expectedResult, result);  
        //Test 2: .5
        instance.addDecimal();
        instance.digit("5");
        instance.enterPressed();

        result = instance.results.peek().toString();
        expectedResult = "0.5"; 
        assertEquals(expectedResult, result); 
        }
    
    /**
     * Test of stack push, of class CalcBrain
     */
    @Test
    public void testStackPush(){
        System.out.println("Testing stack push");
        CalcBrain instance = new CalcBrain();
        instance.results.push(3.0f);
        instance.results.push(5.0f);
        instance.results.push(9.0f);
        instance.results.push(11.0f);
        int stackSize = instance.results.size(); //checking size of stack
        int expectedSize = 4;
        assertEquals(expectedSize, stackSize);   
    }
    
     /**
     * Test of stack pop, of class CalcBrain
     */
    @Test
    public void testStackPop(){
        System.out.println("Testing stack pop");
        CalcBrain instance = new CalcBrain();
        instance.results.push(7.0f);
        instance.results.push(12.0f);
        instance.results.push(23.0f);
        float popResult = instance.results.pop();
        float expectedPop = 23.0f;
        assertEquals(expectedPop, popResult, 0.0f);
    }
    
     /**
     * Test of stack peek, of class CalcBrain
     */
    @Test
    public void testStackPeek(){
        System.out.println("Testing stack peek");
        CalcBrain instance = new CalcBrain();
        
        instance.results.push(2.0f);
        instance.results.push(4.0f);
        instance.results.push(6.0f);
        instance.results.push(8.0f);
        instance.results.push(10.0f);
        
        float peekResult = instance.results.peek();
        float expectedPeek = 10.0f;
        assertEquals(expectedPeek, peekResult, 0.0f);
        
        //check size remains the same
        int stackSize = instance.results.size();
        int expectedStackSize = 5;
        assertEquals(expectedStackSize, stackSize);
    }
    
    /**
     * Test of stack empty, of class CalcBrain
     */
    @Test
    public void testStackEmpty(){
        System.out.println("Testing empty stack");
        CalcBrain instance = new CalcBrain();
        
        Boolean isEmpty = instance.results.empty();
        assertTrue(isEmpty);
        
        instance.results.push(3.0f);
        
        isEmpty = instance.results.empty();
        assertFalse(isEmpty);
        
        instance.results.pop();
        isEmpty = instance.results.empty();
        assertTrue(isEmpty);
    }
}
