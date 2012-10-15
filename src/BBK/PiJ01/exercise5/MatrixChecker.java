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
    // Iterations start from diagonal element on top row.
    static int[][] TOPRIGHT = new int[][]{{1,0}, {1,0}, {1,1}};
    static int[][] TOPLEFT = new int[][]{{-2,0}, {-1,0}, {-1,-1}};
    static int[][] BOTTOMLEFT = new int[][]{{0,1}, {0,1}, {1,1}};
    static int[][] BOTTOMRIGHT = new int[][]{{-1,1}, {0,1}, {-1,-1}};
    
    public boolean isSymmetrical(int[] array) {
        int max_index = array.length-1;
        int check_to = array.length/2-1;
        
        for (int i=0; i<=check_to; i++) {
            if (array[i] != array[max_index-i])
                return false;
        }
        return true;
    }
    
    public boolean isNonsquareSymmetrical(Matrix m) {
        MatrixIterator tr_itr = new MatrixIterator(m, TOPRIGHT);
        MatrixIterator bl_itr = new MatrixIterator(m, BOTTOMLEFT);
        
        while(tr_itr.hasNext() && bl_itr.hasNext()) {
            if(tr_itr.next() != bl_itr.next()) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean isSymmetrical(Matrix m) {
        if (m.width != m.height)
            return false;
        return isNonsquareSymmetrical(m);
    }
    
    public boolean isUpTriangular(Matrix m) {
        return isTriangular(m, TOPRIGHT);
    }
    
    public boolean isDownTriangular(Matrix m) {
        return isTriangular(m, BOTTOMLEFT);
    }
    
    public boolean isTriangular(Matrix m) {
        return isTriangular(m, BOTTOMLEFT) || isTriangular(m, TOPRIGHT);
    }
        
    public boolean isTriangular(Matrix m, int[][] config) {
        MatrixIterator tr_itr = new MatrixIterator(m, config);
        
        while(tr_itr.hasNext()) {
            if (tr_itr.next() != 0)
                return false;
        }
            
        return true;
    }
}


class MatrixIterator {
    Matrix m;
    private int[] point;
    private int[] starting_point = new int[2];
    private int[] point_vector;
    private int[] starting_point_vector;
    private int[] next_point = new int[2];
    
    
    MatrixIterator(Matrix new_m, int[][] configs) {
        assert configs.length == 3;
        setConfigs(new_m, configs[0], configs[1], configs[2]);
    }
    
    MatrixIterator(Matrix new_m, int[] start, int[] vector, int[] start_vector) {
        setConfigs(new_m, start, vector, start_vector);
    }
    
    private void setConfigs(Matrix new_m, int[] start, int[] vector, int[] start_vector) {
        assert start.length == 2;
        assert vector.length == 2;
        assert start_vector.length == 2;
        
        m = new_m;
        
        starting_point[0] = (start[0] < 0) ? m.width-start[0] : start[0];
        starting_point[1] = (start[1] < 0) ? m.height-start[1] : start[1];
        
        point_vector = vector;
        starting_point_vector = start_vector;
        
        calculateNext();
    }
    
    public boolean hasNext() {
        return isPointLegal(next_point);
    }
    
    public int next() {
        int value = -1;
                
        try {
            value = m.getElement(next_point[0], next_point[1]);
            calculateNext();
        } catch(Matrix.MatrixError e) {}
        
        return value;
    }
    
    private void calculateNext() {
        addPoints(next_point, point_vector, next_point);
        if (!isPointLegal(next_point)) {
            addPoints(starting_point, starting_point_vector, starting_point);
            clonePoints(starting_point, next_point);
        }    
    }
    
    private void addPoints(int[] a, int[] b, int[] result) {
        result[0] = a[0] + b[0];
        result[1] = a[1] + b[1];
    }
    
    private void clonePoints(int[] src, int[] dst) {
        dst[0] = src[0];
        dst[1] = src[1];
    }
    
    private boolean isPointLegal(int[] p) {
        if (0 <= p[0] && p[0] < m.width
                && 0 <= p[1] && p[1] < m.height) {
            return true;
        }
        return false;
    }
}


