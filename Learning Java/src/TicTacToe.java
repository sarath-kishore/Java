import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        char player = 'X';
         boolean gameover = false;
        Scanner sn = new Scanner(System.in);
        int row = 0;
        int col = 0;

        for(int i=0;i<3; i++){
            for(int j=0; j<3; j++){
                board[i][j] = ' ';
            }
        }

        while(!gameover){
            printBoard(board);
            System.out.println("Player " + player + ", enter: ");
            row = sn.nextInt();
            col = sn.nextInt();
            if(fillBoard(board, row, col, player)){
                gameover = haveWon(board, player);
                if(gameover){
                    System.out.println("Player " + player + " has won!");
                    printBoard(board);
                    return;
                }else{
                    player = player == 'X' ? 'O' : 'X';
                }
            }else{
                System.out.println("Invalid input! Try again.");
            }
        }
    }

    static void printBoard(char[][] board){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println();

    }
    static boolean haveWon(char[][] board, char player){
        // check cols
        for(int col = 0; col<3; col++){
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player)
                return true;
        }

        // check rows
        for(int row = 0; row<3; row++){
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player)
                return true;
        }

        // check left diagonal
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true;

        // check right diagonal
        if(board[2][0] == player && board[1][1] == player && board[0][2] == player)
            return true;

        return false;
    }
    static boolean fillBoard(char[][]board, int row, int col, char player){
        if(board[row][col] == ' '){
            board[row][col] = player;
            return true;
        }
        return false;
    }


}
