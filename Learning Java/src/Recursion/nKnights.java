package Recursion;

public class nKnights {
    public static void main(String[] args) {
        int n = 3;
        boolean[][] board = new boolean[n][n];
        System.out.println("total number of ways to solve: " + findPos(board, 0));
    }

    static int findPos(boolean[][] board, int row){
        if(row==board.length) {
            display(board);
            return 1;
        }

        int count = 0;

        for(int col=0; col<board[0].length; col++){
            if(isSafe(board, row, col)){
                board[row][col] = true;
                count += findPos(board, row+1);
                board[row][col] = false;
            }
        }

        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
//        row-1, col-2
//                row-2, col-1
//                        row-2, col+1
//                                row-1, col+2
        if(row-1>=0 && col-2>=0 && board[row-1][col-2])
            return false;
        if(row-2>=0 && col-1>=0 && board[row-2][col-1])
            return false;
        if(row-2>=0 && col+1<board[0].length && board[row-2][col+1])
            return false;
        if(row-1>=0 && col+2<board[0].length && board[row-1][col+2])
            return false;

        return true;
    }

    private static void display(boolean[][] board){
        for(int i = 0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j])
                    System.out.print( "K ");
                else
                    System.out.print("X ");
            }
            System.out.println();
        }
        System.out.println("-------");

    }
}
