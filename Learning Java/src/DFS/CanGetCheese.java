package DFS;

public class CanGetCheese {
    public static void main(String[] args) {
//        int[][] maze = {{1, 0, 1, 1, 1},
//                {1, 1, 1, 0, 1},
//                {0, 1, 0, 0, 1},
//                {0, 1, 1, 0, 1} };
        int[][] maze = {{1, 1, 0, 0},
                {1, 1, 1, 1},
                {0, 1, 0, 1},
                {0, 1, 0, 1} };
        System.out.println(solution(maze));
    }
        static boolean solution(int[][] maze) {
            // add your logic here
            int n = maze.length;
            int m = maze[0].length;
            boolean[][] vis = new boolean[n][m];

            return dfs(maze, vis, 0, 0);
        }

        static boolean dfs(int[][] maze, boolean[][] vis, int r, int c){
            vis[r][c] = true;
            int n = maze.length;
            int m = maze[0].length;

            if(r == n-1 && c == m-1)
                return true;

            // go down
            if(r+1<n && maze[r+1][c] == 1 && !vis[r+1][c])
                if(dfs(maze, vis, r+1, c))
                    return true;

            // go right
            if(c+1<m && maze[r][c+1] == 1 && !vis[r][c+1])
                if(dfs(maze, vis, r, c+1))
                    return true;

            return false;
        }
}


//    You are given a maze in the form of a matrix of size n * m. Each cell is either clear or blocked denoted by 1 and 0 respectively.
//        A rat sits at the top-left cell and there exists a block of cheese at the bottom-right cell. Both these cells are guaranteed to be clear.
//        You need to find if the rat can get the cheese if it can move only in one of the two directions - down and right. It can’t move to blocked cells.