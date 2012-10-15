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
public class CreatingMatrices implements Exercise {
    public String getTitle() {
        return "Creating Matrices";
    }
    
    public String getDescription() {
        return "Creates a matrix, modifies it by element, row, and column.\n"
                + "It then prints it prettily.";
    }
    
    public void run() {
        Matrix m;
        try {
            m = new Matrix(3,4);
        } catch(Matrix.MatrixError e) {
            System.out.println("Matrix dimensions set badly.");
            return;
        }
        m.setElement(2,3,-10);
        m.setRow(1, "66666,777777,8888888");
        m.setColumn(0, "2,33,444,5555");
        m.prettyPrint();
        IOGeneric.printResult(m.toString(), "-");
    }
}
