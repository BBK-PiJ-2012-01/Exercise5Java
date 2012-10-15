/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.exercise5;

import BBK.PiJ01.common.Exercise;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class MatrixOneLiner implements Exercise {
    public String getTitle() {
        return "Matrix one-liner";
    }
    
    public String getDescription() {
        return "Demonstration of extension of Matrix class, where the\n"
             + "entire matrix is set by a single string.\n"
             + "Columns are delimited by \';\', and rows by \',\'.";
    }
    
    public void run() {
        MatrixWithExtendedInput m;
        try{
            m = new MatrixWithExtendedInput(3,4);
        } catch(Matrix.MatrixError e) {
            System.out.println("Matrix dimensions set badly.");
            return;
        }
        m.setMatrix("2,1,1;33,777777,8888888;444,1,1;5555,1,-10");
        m.prettyPrint();
    }
}


class MatrixWithExtendedInput extends Matrix {
    MatrixWithExtendedInput(int width, int height) throws Matrix.MatrixError { 
        super(width, height);
    }

    public void setMatrix(String str) {
        String[] row_strings = str.split(";");
        if (row_strings.length != height)
            return;
        
        int[][] new_array2d = new int[height][width];        
        
        String[] row_list;
        for (int j=0; j<height; j++) {
            row_list = row_strings[j].split(",");
            
            if (row_list.length != width)
                return;
                        
            for (int i=0; i<width; i++) {
                new_array2d[j][i] = Integer.valueOf(row_list[i]);
            }
        }
        
        array2d = new_array2d;
        updateLengths();
    }
}

