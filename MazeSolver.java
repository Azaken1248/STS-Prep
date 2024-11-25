import java.util.Scanner;

public class MazeSolver {
    public static void printSoln(int board[][], int n){
        System.out.println();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int board[][], int n, int x, int y){
        return (x >= 0 && y >= 0 && x < n && y < n && board[x][y] == 1);
    }

    public static boolean mazeSolve(int board[][], int n){
        int soln[][] = new int[n][n];
        if(!mazeSolveUtil(board, n, 0, 0, soln)){
            System.out.println("No Solutions Exist !!");
            return false;
        }else{
            printSoln(soln, n);
            return true;
        }
    }

    public static boolean mazeSolveUtil(int board[][], int n, int x, int y, int soln[][]){
        if(x == n - 1 && y == n - 1 && board[x][y] == 1){
            soln[x][y] = 1;
            return true;
        }
        if(isSafe(board, n, x, y)){
            soln[x][y] = 1;

            if(mazeSolveUtil(board, n, x + 1, y, soln)) return true;

            if(mazeSolveUtil(board, n, x, y + 1, soln)) return true;

            soln[x][y] = 0;
        }

        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the maze (n x n): ");
        int n = sc.nextInt();

        int maze[][] = new int[n][n];

        System.out.println("Enter the maze (1 for open cell, 0 for blocked cell): ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        mazeSolve(maze, n);

        sc.close();
    }
}
