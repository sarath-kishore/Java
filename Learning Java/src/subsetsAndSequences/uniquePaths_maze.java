package subsetsAndSequences;

import java.util.ArrayList;
import java.util.List;

public class uniquePaths_maze {
    public static void main(String[] args) {
//        int m = 3;
//        int n = 7;
//        System.out.println("Unique paths count : " + countPaths(m, n));
//        System.out.println("Unique paths count : " + countPaths2(m, n));
//        System.out.println("Unique paths through maze : " + getPaths(0, 0, m ,n, "") + " - Path count: " + straightPathCounter);
//        System.out.println("Unique paths through maze including diagonal : " + getPathsDiagonal(0, 0, m ,n, "") + " - Path count: " + diagonalPathCounter);

        int m = 3;
        int n = 3;
        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int[][] pathN = new int[m][n];

//        pathRestrictions(0,0 , "", board);
        allPathsPrint(0,0 , "", board, pathN, 1);

    }



    static void allPathsPrint(int r, int c, String path, boolean[][] board, int[][]pathN, int step){
        // includes four directional traversal.
        // Up, Down, Left, Right allowed.

        int m = board.length-1;
        int n = board[0].length-1;

        if(!board[r][c])
            return;

        pathN[r][c] = step;

        if(r==m && c==n){
            // found path
            for(int[] i : pathN){
                for(int j : i){
                    System.out.print(j + " ");
                }
                System.out.println();
            }
            System.out.println(path);

            System.out.println();
            return;
        }

        board[r][c] = false;

        if(c<n) {
            allPathsPrint(r, c + 1, path + 'R', board, pathN, step+1);
        }
        if(r<m) {
            allPathsPrint(r + 1, c, path + 'D', board, pathN, step+1);
        }
        if(c>0) {
            allPathsPrint(r, c - 1, path + 'L', board, pathN, step+1);
        }
        if(r>0) {
            allPathsPrint(r - 1, c, path + 'U', board, pathN, step+1);
        }

        board[r][c] = true;
        pathN[r][c] = 0;

    }


    static void pathRestrictions(int r, int c, String path, boolean[][] board){
        int m = board.length-1;
        int n = board[0].length-1;
        if(r==m && c==n){
            System.out.println(path);
            return;
        }

        if(!board[r][c])
            return;

        if(c<n)
            pathRestrictions(r, c + 1, path + 'R', board);
        if(r<m)
            pathRestrictions(r + 1, c, path + 'D', board);

    }

    static int straightPathCounter = 0;
    static int diagonalPathCounter = 0;

    static List<String> getPaths(int r, int c, int m, int n, String path){
        // does not include diagonal traversal. Only Down and Right allowed.
        if(r==m-1 && c==n-1){
            List<String> temp = new ArrayList<>();
            temp.add(path);
            straightPathCounter++;
            return temp;
        }

        List<String> ans = new ArrayList<>();
        if(c<n)
            ans.addAll(getPaths(r, c+1, m, n, path+'R'));
        if(r<m)
            ans.addAll(getPaths(r+1, c, m, n, path+'D'));

        return ans;
    }

    static List<String> getPathsDiagonal(int r, int c, int m, int n, String path){
        // includes diagonal traversal. Right, Down and diagonal allowed. Vertical, Horizontal, Diagonal
        if(r==m-1 && c==n-1){
            List<String> temp = new ArrayList<>();
            temp.add(path);
            diagonalPathCounter++;
            return temp;
        }

        List<String> ans = new ArrayList<>();
        if(c<n)
            ans.addAll(getPathsDiagonal(r, c+1, m, n, path+'H'));
        if(r<m && c<n)
            ans.addAll(getPathsDiagonal(r+1, c+1, m, n, path+'D'));
        if(r<m)
            ans.addAll(getPathsDiagonal(r+1, c, m, n, path+'V'));

        return ans;
    }


    static int countPaths(int r, int c){
        // only vertical and horizontal traversal.

        if(r==1 && c==1){
            return 1;
        }

        int ans = 0;
         if(c-1>0)
        ans += countPaths(r, c-1);
         if(r-1>0)
        ans += countPaths(r-1, c);

        return ans;
    }

    static int countPaths2(int r, int c){
        // only vertical and horizontal traversal.
        // uses memoization and dynamic programming
//        https://www.youtube.com/watch?v=sLuKQ9mZFz0


        int[][]dp = new int[r][c];

        for(int i=0; i<r; i++){
            dp[i][0] = 1;
        }

        for(int j=0; j<c; j++){
            dp[0][j] = 1;
        }

        for(int i=1; i<r; i++){
            for(int j=1; j<c; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[r-1][c-1];

    }
}
