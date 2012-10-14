package BBK.PiJ01.common;


import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class IOGeneric {
    /*
    *    Generic user input/output class used in many exercises.
    */
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static String getString() throws BadInput{
        //return System.console().readLine();
        try {
            return br.readLine();
        } catch(IOException e) {
            throw new BadInput("Couln't get input. IO problem?");
        }
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

    public static void printResult(String result, String ...params) {
        String spacer = getSingleDefault(params, "-");
        
        String header_footer = multiplyString(spacer, result.length());
        
        System.out.println(header_footer);
        System.out.println(result);
        System.out.println(header_footer);
    }
    
    private static <T> T getSingleDefault(T[] params, T default_value) {
        assert params.length == 1;
        if (params[0] == null)
            params[0] = default_value;
        return params[0];
    }
    
    public static void printTitle(String title, String ...params) {
        String spacer = getSingleDefault(params, "-");
        
        String spaces_either_side = multiplyString(spacer, Math.max(39-title.length()/2, 10));
        
        System.out.println(spaces_either_side + " " + title + " " + spaces_either_side);
    }
    
    public static void printSpacers(String ...params) {
        String spacer = getSingleDefault(params, "-");
        
        System.out.println( multiplyString(spacer, 80) );
    }
    
    public static int chooseFromList(List<String> lst) throws BadInput, IndexOutOfBoundsException {
        // Returns list index of chosen item
        
        for (int i=0; i<lst.size(); i++) {
            System.out.format("[%d] %s\n", i, lst.get(i));
        }
        
        int choice_int = getInteger();
        
        if ((1 < choice_int) || (choice_int > lst.size()))
            throw new IndexOutOfBoundsException();
        
        return choice_int;
    }
    
    public static int chooseFromList(String[] lst) throws BadInput {
        ArrayList<String> array_list = new ArrayList<String>();
        Collections.addAll(array_list, lst);
        return chooseFromList(array_list);
    }
}


