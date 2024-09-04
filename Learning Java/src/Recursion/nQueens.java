package Recursion;

public class nQueens {
    public static void main(String[] args) {
        int n = 5;
        boolean[][] board = new boolean[n][n];
        System.out.println("total number of ways to solve: " + findPos(board, 0));
    }
    static int findPos(boolean[][] board, int row){
        if(row == board.length){
            display(board);
            return 1;
        }

        int count = 0;
        for(int col=0; col<board[0].length; col++){
            if(isPosSafe(board, row, col)){
                board[row][col] = true;
                count += findPos(board, row+1);
                board[row][col] = false;
            }
        }

        return count;
    }

    static void display(boolean[][] board){
        for(int i = 0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j])
                    System.out.print( "Q ");
                else
                    System.out.print("X ");
            }
            System.out.println();
        }
        System.out.println("-------");

    }
    static boolean isPosSafe(boolean[][] board, int r, int c){

        // check vertical
        for(int i=0; i<r; i++){
            if(board[i][c])
                return false;
        }

        // check left diagonal
        int maxLeft = Math.min(r, c);

        for(int i=1; i<=maxLeft; i++){
            if(board[r-i][c-i])
                return false;
        }

        //check right diagonal
        int maxRight = Math.min(r, board[0].length-c-1);

        for(int i=1; i<=maxRight; i++){
            if(board[r-i][c+i])
                return false;
        }

        return true;
    }
}
