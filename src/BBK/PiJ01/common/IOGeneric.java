package BBK.PiJ01.common;


import java.util.*;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class IOGeneric {
    /*
    *    Generic user input/output class used in many exercises.
    */
    public static String getString(){
        return System.console().readLine();
    }
    
    public static int getInteger() throws BadInput {
        int num;
        try {
            String str = getString();
            num = Integer.parseInt(str);
        } catch(NumberFormatException e) {
            throw new BadInput();
        }
        
        return num;
        
        
    }
    
    public static double getDouble() throws BadInput {
        double num;
        try {
            String str = getString();
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

    public static void printResult(String result) {
        String header_footer = multiplyString("-", result.length());
        
        System.out.println(header_footer);
        System.out.println(result);
        System.out.println(header_footer);
    }
    
    public static int chooseFromList(List<String> lst) throws BadInput {
        // Returns list index of chosen item
        
        for (int i=0; i<lst.size(); i++) {
            System.out.format("[%d] %s", i+1, lst.get(i));
        }
        
        int choice_int = getInteger();
        
        if ((1 < choice_int) || (choice_int > lst.size()))
            throw new BadInput();
        
        return choice_int-1;
    }
    
    public static int chooseFromList(String[] lst) throws BadInput {
        ArrayList<String> array_list = new ArrayList<String>();
        Collections.addAll(array_list, lst);
        return chooseFromList(array_list);
    }
}