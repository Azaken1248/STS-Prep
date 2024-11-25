
public class KnightsTour {
    static final int N = 8; 

    static final int[] cx = {1, 1, 2, 2, -1, -1, -2, -2};
    static final int[] cy = {2, -2, 1, -1, 2, -2, 1, -1};

    public static void printBoard(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int x, int y, int[][] board) {
        return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
    }

    public static int getDegree(int x, int y, int[][] board) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int newX = x + cx[i];
            int newY = y + cy[i];
            if (isSafe(newX, newY, board)) {
                count++;
            }
        }
        return count;
    }

    public static boolean solveKnightsTour(int startX, int startY, int[][] board) {
        board[startX][startY] = 0;
        int moveCount = 1;

        int currX = startX;
        int currY = startY;

        while (moveCount < N * N) {
            int nextX = -1;
            int nextY = -1;
            int minDegree = N + 1;

            for (int i = 0; i < 8; i++) {
                int newX = currX + cx[i];
                int newY = currY + cy[i];
                if (isSafe(newX, newY, board)) {
                    int degree = getDegree(newX, newY, board);
                    if (degree < minDegree) {
                        nextX = newX;
                        nextY = newY;
                        minDegree = degree;
                    }
                }
            }

            if (nextX == -1 && nextY == -1) {
                return false;
            }

            board[nextX][nextY] = moveCount;
            currX = nextX;
            currY = nextY;
            moveCount++;
        }

        return true; 
    }

    public static void startTour() {
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = -1;
            }
        }

        int startX = 0;
        int startY = 0;

        if (solveKnightsTour(startX, startY, board)) {
            printBoard(board);
        } else {
            System.out.println("No solution exists");
        }
    }

    public static void main(String[] args) {
        startTour();
    }
}
