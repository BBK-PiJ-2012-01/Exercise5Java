/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.exercise5;

import BBK.PiJ01.common.BadInput;
import BBK.PiJ01.common.IOGeneric;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class Matrix {
    protected int[][] array2d;      // arrays2d[y][x]
    protected int[][] lengths2d;    // lengths2d[y][x]
    protected int width, height;
    //private MatrixChecker checker = new MatrixChecker()
    
    class MatrixError extends Exception {
        MatrixError() {}
        
        MatrixError(String str) {
            System.out.println("======= Matrix logical error: \"" + str + "\" =======");
            }
    }
    
    public Matrix(int new_width, int new_height) throws MatrixError {
        width = new_width;
        height = new_height;
        verifySize();
        
        array2d = new int[height][width];
        lengths2d = new int[height][width];
        
        for (int i=0; i<width; i++) {
            for (int j=0; j<height; j++) {
                array2d[j][i] = 1;
                lengths2d[j][i] = 1;
            }
        }
    }
    
    private void verifySize() throws MatrixError {
        if (width < 1) 
            throw new MatrixError("Width of matrix must be greater than 1");
        if (height < 1) 
            throw new MatrixError("Height of matrix must be greater than 1");
    }
    
    public void setElement(int i, int j, int value) {
        try {
            array2d[j][i] = value;
            lengths2d[j][i] = String.valueOf(value).length();
        
        } catch(IndexOutOfBoundsException e) {}
    }
    
    public int getElement(int i, int j) throws MatrixError {
        try {
            return array2d[j][i];
        } catch(IndexOutOfBoundsException e) {
            throw new MatrixError();
        } 
    }
    
    public void setRow(int j, String row_str) {
        int[] row_array = strToArray(row_str);
        
        if (row_array.length != width)
            return;
            
        array2d[j] = row_array;
        updateLengths(j);
    }
    
    protected void updateLengths(int j) {
        for (int i=0; i<width; i++) {
            lengths2d[j][i] = String.valueOf(array2d[j][i]).length();
        }
    }
    
    protected void updateLengths() {
        for (int j=0; j<height; j++) {
            updateLengths(j);
        }
    }
    
    protected int[] strToArray(String str) {
        //return str.split(",")*.toInteger()
        String[] splits = str.split(",");
        int[] numbers = new int[splits.length];
        
        for (int n=0; n<splits.length; n++) {
            numbers[n] = Integer.parseInt(splits[n]);
        }
        
        return numbers;
    }
    
    public void setColumn(int i, String column_str) {
        int[] column_array = strToArray(column_str);
        
        if (column_array.length != height)
            return;
            
        for (int j=0; j<height; j++) {
            setElement(i, j, column_array[j]);
        }
    }
    
    public String toString() {
        String[] row_strings = new String[height];
        
        for(int j=0; j<height; j++) {
            row_strings[j] = IOGeneric.intListToString(array2d[j], " , ");
        }
        
        return IOGeneric.listToString(row_strings, "[;]");
    }
    
    public void prettyPrint() {
        int cell_width = getMaxLength();
        int left_spaces, right_spaces;
        String cell_row_line = "+" + IOGeneric.multiplyString("-", cell_width);
        String row_line = IOGeneric.multiplyString(cell_row_line, width) + "+\n|";
        
        for (int j=0; j<height; j++) {
            System.out.print(row_line);
            for (int i=0; i<width; i++) {
                right_spaces = ( cell_width - lengths2d[j][i] ) / 2;
                left_spaces = cell_width - lengths2d[j][i] - right_spaces;
                System.out.print(   IOGeneric.multiplyString(" ", left_spaces)
                                    + array2d[j][i] 
                                    + IOGeneric.multiplyString(" ", right_spaces)
                                    + "|"
                                );
            }
            System.out.print("\n");
        }
        System.out.print(row_line.substring(0, row_line.length()-1));
    }         
    /*
    public boolean isSymmetrical() {
        return checker.isSymmetrical(array2d)
    }
    
    public boolean isTriangular() {
        return checker.isTriangular(array2d)
    }*/
    
    private int getMaxLength() {
        int max_length = 0;
        for (int j=0; j<height; j++) {
            for (int i=0; i<width; i++) {
                max_length = Math.max(max_length, lengths2d[j][i]);
            }
        }
        return max_length;
    }
    
}


