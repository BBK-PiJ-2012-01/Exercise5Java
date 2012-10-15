/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.exercise5;
import BBK.PiJ01.common.*;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class DividingIntegers implements Exercise{
    public String getTitle() {
        return "Dividing Numbers";
    }
    
    public String getDescription() {
        return "Calculator that can add, subtract, multiply, \n" +
                "divide, and modulus.";
    }
    
    public void run() {
        //System.out.println("dividing some integers, yadadad...");
        Calculator c = new Calculator();
        c.add(3,4);
        c.subtract(3, 4);
        c.multiply(3, 4);
        c.divide(3, 4);
        c.modulus(3, 4);
    }    
}
    
class Calculator {
    public void add(int a, int b) {
        System.out.println(a + " + " + b + " = " + (a + b));
    }
    
    public void subtract(int a, int b) {
        System.out.println(a + " - " + b + " = " + (a - b));
    }
    
    public void multiply(int a, int b) {
        System.out.println(a + " * " + b + " = " + (a * b));
    }
    
    public void divide(int a, int b) {
        System.out.println(a + " / " + b + " = " + ( (double)a / b));
    }
    
    public void modulus(int a, int b) {
        System.out.println(a + " % " + b + " = " + (a % b));
    }
}
