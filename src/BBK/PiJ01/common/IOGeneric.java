/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BBK.PiJ01.common;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class IOGeneric {
    /*
    *    Generic user input/output class used in many exercises.
    */
    static int getInteger(){
        int num;
        try {
            String str = System.console().readLine();
            num = Integer.parseInt(str);
        } catch(NumberFormatException e) {
            throw new BadInput();
        }
        return num;
    }
    
    static double getDouble(){
        double num;
        try {
            String str = System.console().readLine();
            num = Double.parseDouble(str);
        } catch(NumberFormatException e) {
            throw new BadInput();
        }
        return num;
    }
    
    public static String multiplyString(String input, int number_of_times) {
        StringBuffer s = new StringBuffer();
        for (int i=0; i<number_of_times; i++) {
                s.append(input);
        }
        return s.toString();
    }

    static void printResult(String result) {
        s.
        System.out.println '-'.multiply( result.length() );
        System.out.println result;
        System.out.println '-'.multiply( result.length() );
    }
    
    static int chooseFromList(def lst) {
        // Returns list index of chosen item
        for (item in lst) {
            println "["+item[0]+"]" + item[1..item.size()-1];
        }
        String[] first_letters = lst.collect{it[0].toLowerCase()}
        String str = System.console().readLine().toLowerCase()[0]
        
        if (str in first_letters)
            return first_letters.findIndexOf{it==str}
        else
            throw new BadInput()
            
    }
    
    static def chooseFromMap(def map) {
        int index = chooseFromList(map.keySet())
        return map.values().toList()[index]
    }
    
    static def getChar() {
        String str = System.console().readLine()
        if (str.length() != 1)
            throw new BadInput(str)
        return str[0]
    }
}