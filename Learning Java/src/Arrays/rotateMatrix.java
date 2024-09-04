package Arrays;

import java.util.Arrays;

public class rotateMatrix {
    public static void main(String[] args) {
        int[][] mat = {
                {0,0,0},
                {0,1,0},
                {1,1,1}
        };

        int[][] target = {
                {1,1,1},
                {0,1,0},
                {0,0,0}
        };

        System.out.println(findRotation(mat, target));
    }
    public static boolean findRotation(int[][] mat, int[][] target) {
        boolean flag = false;
        for(int k = 1; k<=4; k++){
            rotate90(mat);
            outerloop: for(int i=0; i<mat.length; i++){
                for(int j=0; j<mat[i].length; j++){
                    if(mat[i][j] != target[i][j]){
                        flag = false;
                        break outerloop;
                    }else{
                        flag = true;
                    }
                }
            }
            if(flag==true)
                return true;
        }

        return false;
    }
    public static void rotate90(int[][] mat){
        transpose2(mat);
        for(int[] row: mat){
            reverseArray(row);
        }

        return;
    }

    public static void transpose2(int[][] mat){
        // this transpose method works only for n*n matrices.
        for(int i=0; i<mat.length; i++){
            for(int j=i; j<mat[i].length; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        return;
    }

    public static void reverseArray(int[] arr){
        for(int i=0, j=arr.length-1;i<=j;i++,j-- ){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        return;
    }
    public static int[][] transpose(int[][] matrix) {
        int[][] trans = new int[matrix[0].length][matrix.length];
        // this transpose method works matrix of n*m size

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                trans[j][i] = matrix[i][j];
            }
        }

        return trans;
    }
}
