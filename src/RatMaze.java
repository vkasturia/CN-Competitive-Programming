import java.util.Scanner;

public class RatMaze {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] maze = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                maze[i][j] = in.nextInt();
            }
        }
        ratInAMaze(maze);
    }

    public static void ratInAMaze(int maze[][]){
        int size = maze.length;
        int [][] solution = new int[size][size];
        mazeHelper(maze, solution, 0, 0, size);
    }

    public static void mazeHelper(int[][] maze, int[][] solution, int x, int y, int size){
        if ( x == size - 1 && y == size - 1){
            solution[x][y] = 1;
            printSolutionMatrix(solution, size);
            return;
        }
        if ( x >= size || x <= -1 || y >= size || y <= -1 || maze[x][y] == 0 || solution[x][y] == 1){
            return;
        }

        solution[x][y] = 1;
        mazeHelper(maze, solution, x-1, y, size); //left
        mazeHelper(maze, solution, x+1, y, size); //right
        mazeHelper(maze, solution, x, y-1, size); //up
        mazeHelper(maze, solution, x, y+1, size); //down
        solution[x][y] = 0;
        return;
    }

    public static void printSolutionMatrix(int[][] solution, int size){
        for (int i = 0; i < size; i++){
            for (int j = 0; j< size; j++){
                System.out.print(solution[i][j] + " ");
            }
        }

        System.out.println();
    }
}
