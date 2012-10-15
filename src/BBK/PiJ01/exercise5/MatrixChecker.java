/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.exercise5;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class MatrixChecker {
    public boolean isSymmetrical(int[] array) {
        int max_index = array.size()-1
        int check_to = array.size()/2-1
        return array[0..check_to] == array[max_index..max_index-check_to] as int[]
    }
    
    public boolean isSymmetrical(int[][] matrix) {
        int size = matrix.size()
        if (matrix.collect{ it.size() } != [size]*size)
            return false
            
        if (size == 1)
            return true
        
        for (i in 0..size-2) {
            if (!isSymmetrical( matrix[i][1+i..size-1] + matrix.collect{ it[i] }[1+i..size-1] as int[]))
                return false
        }
        return true
    }
    
    public boolean isTriangular(int[][] matrix) {
        int width = matrix[0].size()
        for (i in 1..matrix.size()-1) {
            println "checking row i="+i+": " + matrix[i][0..[i, width].min()-1]
            if (matrix[i][0..[i, width].min()-1].toSet() != [0].toSet())
                return false
        }
        return true
    }
}
