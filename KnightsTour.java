
public class KnightsTour {
    public static final int N = 8;

    public static final int cx[] = {1, 1, 2, 2, -1, -1, -2, -2};
    public static final int cy[] = {2, -2, 1, -1, 2, -2, 1, -1};

    public static void printBoard(int board[][], int N){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static boolean isSafe(int board[][],int N, int x, int y){
        return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
    }

    public static int getDegree(int board[][], int N, int x, int y){
        int count = 0;
        for(int i = 0; i < 8; i++){
            int newX = x + cx[i];
            int newY = y + cy[i];
            if(isSafe(board, N, newX, newY)){
                count++;
            }
        }

        return count;
    }

    public static boolean solve(int startX, int startY, int board[][], int N){
        board[startX][startY] = 0;
        
        int moveCount = 1;

        int currX = startX;
        int currY = startY;

        while(moveCount < N * N){
            int minDegree = N + 1;

            int nextX = -1;
            int nextY = -1;


            for(int i = 0; i < 8; i++){
                int newX = currX + cx[i];
                int newY = currY + cy[i];
                if(isSafe(board, N, newX, newY)){
                    int degree = getDegree(board, N, newX, newY);
                    if(degree < minDegree){
                        nextX = newX;
                        nextY = newY;
                        minDegree = degree;
                    }
                }
            }

            if(nextX == -1 && nextY == -1){
                return false;
            }

            board[nextX][nextY] = moveCount;
            currX = nextX;
            currY = nextY;
            moveCount++;

        }

        return true;

    }

    public static void startTour(){
        int board[][] = new int[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                board[i][j] = -1;
            }
        }

        if(solve(0, 0, board, N)){
            printBoard(board, N);
        }else{
            System.out.println("No Solutions Exist !!");
        }
    }

    public static void main(String[] args) {
        startTour();
    }
}
