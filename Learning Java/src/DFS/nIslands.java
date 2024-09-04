package DFS;

import java.util.List;
public class nIslands {
    public static void main(String[] args) {
        int[][] arr = {{1,1,0,0,0},
                        {1,1,0,0,0},
                        {0,0,1,0,0},
                        {0,0,0,1,1}};
         int count = 0;
         for(int i=0; i<arr.length; i++){
             for(int j=0; j<arr[0].length; j++){
                if(arr[i][j]==1){
                    count++;
                    DFS(arr, i, j);
                }
             }
         }

         System.out.println(count);
    }

    public static void DFS(int[][] arr, int i, int j){

        // this is redundant. this method would only be called if the coordinates are 1.
//        if(arr[i][j]==0){
//            return;
//        }


        arr[i][j] = 0;

        if(j+1<arr[0].length && arr[i][j+1]==1){
            DFS(arr, i, j+1);
        }
        if(i+1<arr.length && arr[i+1][j]==1) {
            DFS(arr, i+1, j);
        }
        if(i-1>=0 && arr[i-1][j]==1){
            DFS(arr, i-1, j);
        }
        if(j-1>=0 && arr[i][j-1]==1){
            DFS(arr, i, j-1);
        }

    }
}
