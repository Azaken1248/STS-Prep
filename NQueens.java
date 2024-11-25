import java.util.Scanner;

public class NQueens {
    public static void printBoard(int board[][], int n){
        System.out.println();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                char chr = (board[i][j] == 1) ? 'Q':'.';
                System.out.print(chr + " ");
            }
            System.out.println();
        }
    }
    
    public static boolean isSafe(int board[][], int n, int row, int col){
        for(int i = 0; i < n; i++){
            if(board[row][i] == 1) return false;
        }
        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 1) return false;
        }
        for(int i = row, j = col; i < n && j >= 0; i++, j--){
            if(board[i][j] == 1) return false;

        }

        return true;
    }

    public static void solveNQueens(int board[][], int n){
        if(!solveNQueensUtil(board, n, 0)){
            System.out.println("No Soultion Exists !!");
        } else{
            printBoard(board, n);
        }
    }
    public static boolean solveNQueensUtil(int board[][], int n, int col){
        if(col >= n){
            return true;
        }
        
        for(int row = 0; row < n; row++){
            if(isSafe(board, n, row, col)){
                board[row][col] = 1;

                if(solveNQueensUtil(board, n, col + 1)) return true;

                board[row][col] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the board (n x n): ");
        int n = sc.nextInt();

        int[][] board = new int[n][n];

        solveNQueens(board, n);

        sc.close();
    }
}
