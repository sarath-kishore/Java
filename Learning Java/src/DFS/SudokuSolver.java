package DFS;

public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(board);
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }
        public static void solveSudoku(char[][] board) {
            dfs(board);
        }

        static boolean dfs(char[][] board){
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[0].length; j++){
                    if(board[i][j] == '.'){
                        for(char key='1'; key <= '9'; key++){
                            if(checkCell(board, i, j, key)){
                                board[i][j] = key;
                                if(!dfs(board))
                                    board[i][j] = '.';
                                else
                                    return true;
                            }
                        }

                        return false; // unable to place any key here. backtrack.
                    }
                }
            }

            return true;
        }

        static boolean checkCell(char[][] board, int r, int c, char key){

            for(int i=0; i<board.length; i++){
                //check vertical
                if(board[i][c] == key)
                    return false;

                //check horizontal
                if(board[r][i] == key)
                    return false;

                //check sub-section
                if(board[3 * (r / 3) + i/3][3 * (c / 3) + i%3] == key)
                    return false;
            }

            //check vertical
            // for(int i=0; i<board.length; i++){
            //     if(board[i][c] == key)
            //         return false;
            // }

            // //check horizontal
            // for(int j=0; j<board[0].length; j++){
            //     if(board[r][j] == key)
            //         return false;
            // }

            // //check sub-section
            // for(int i=0; i<3; i++){
            //     for(int j=0;j<3; j++){
            //         if(board[3 * (r / 3) + i][3 * (c / 3) + j] == key)
            //             return false;
            //     }
            // }

            return true;
        }
}
