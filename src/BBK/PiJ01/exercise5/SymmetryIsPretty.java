/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.exercise5;

import BBK.PiJ01.common.Exercise;
import BBK.PiJ01.common.IOGeneric;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class SymmetryIsPretty implements Exercise {
    public String getTitle() {
        return "Symmetry is pretty";
    }
    
    public String getDescription() {
        return "Checks if a matrix is symmetric and/or triangular.";
    }
    
    public void run() {
        MatrixChecker mc = new MatrixChecker();
        int[] a = new int[]{1,2,3};
        int[] b = new int[]{1,2,1};
        System.out.println("is "+a+" sym? " + mc.isSymmetrical(a));
        System.out.println("is "+b+" sym? " + mc.isSymmetrical(b));

        a = new int[]{1,2,2,3};
        b = new int[]{1,2,2,1};
        System.out.println("is "+a+" sym? " + mc.isSymmetrical(a));
        System.out.println("is "+b+" sym? " + mc.isSymmetrical(b));
        
        Matrix m;
        try{
            m = new Matrix(3,3);
        } catch(Matrix.MatrixError e) {
            System.out.println("Couldn't initialise the matrix.");
            return;
        }
        
        m.setRow(0, "1,12,13");
        m.setRow(1, "2,4,15");
        m.setRow(2, "3,5,6");
        m.prettyPrint();
        m.printSymmetry(m);
        
        m.setRow(0, "1,2,1");
        m.setRow(1, "2,4,3");
        m.setRow(2, "1,3,1");
        m.prettyPrint();
        m.printSymmetry(m);
        
        m.setRow(0, "1,0,0");
        m.setRow(1, "2,4,0");
        m.setRow(2, "1,3,1");
        m.prettyPrint();
        m.printSymmetry(m);
        
        m.setRow(0, "1,2,1");
        m.setRow(1, "0,4,3");
        m.setRow(2, "0,0,1");
        m.prettyPrint();
        m.printSymmetry(m);
    }
}
