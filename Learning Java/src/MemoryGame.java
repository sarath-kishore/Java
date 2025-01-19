import java.util.Scanner;

public class MemoryGame {
    public static void main(String[] args) {
        char[][] board = {  {'X', 'O', 'P', 'A'},
                            {'Q', 'O', 'X', 'R'},
                            {'I', 'A', 'R', 'P'},
                            {'Q', 'I', 'W', 'W'}
                    };
        boolean[][] open = new boolean[board.length][board[0].length];
        int[] prev = {-1, -1};
        int[] gameOver = new int[]{board.length * board[0].length};
        Scanner sn = new Scanner(System.in);
        int[] curr = new int[2];

        while(gameOver[0] > 0){
            printBoard(board, open);
            System.out.println("Enter r and c");
            curr[0] = sn.nextInt();
            curr[1] = sn.nextInt();
            updateBoard(board, open, curr, prev, gameOver);
        }
        printBoard(board, open);
        System.out.println("Game over! Thank you for playing.");
    }

    static void updateBoard(char[][] board, boolean[][] open, int[]curr, int[]prev, int[] gameOver){
        if(prev[0] == -1){
            // opening the first card
            open[curr[0]][curr[1]] = true;
            prev[0] = curr[0];
            prev[1] = curr[1];
            // prev = curr; // will this propagate to the main function? copy by reference
            return;
        }

        if(prev[0] == curr[0] && prev[1] == curr[1]) {
            System.out.println("Card already open. Pick a different one.");
            return;
        }

        if(board[prev[0]][prev[1]] == board[curr[0]][curr[1]]){
            // card match found.
            open[curr[0]][curr[1]] = true;
            gameOver[0] -= 2;
        }else{
            // card not matched. Close the previous card.
            open[prev[0]][prev[1]] = false;
        }
        prev[0] = -1;
        prev[1] = -1;
        return;
    }

    static void printBoard(char[][]board, boolean[][]open){
        for(int i=0; i< board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(open[i][j]){
                    System.out.print(board[i][j] + "\t");
                }else
                    System.out.print("-\t");
            }
            System.out.println();
        }
    }
}
