/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BBK.PiJ01.exercise5;
import BBK.PiJ01.common.*;


import java.util.ArrayList;

/**
 *
 * @author Sam Wright
 */
public class Exercise5 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws BadInput {
        ArrayList<Exercise> exercises = new ArrayList<Exercise>();
        
        exercises.add(new DividingIntegers());
        
        ExerciseChooser ech = new ExerciseChooser(exercises);
        ech.run();
    }
}
