import javax.swing.*;
import java.awt.*;

public class MazeSolverDarkUI {
    private static final int CELL_SIZE = 50; // Size of each grid cell
    private int n; // Maze size (n x n)
    private int[][] maze; // The maze
    private int[][] solution; // Solution matrix
    private JButton[][] cells; // GUI cells
    private JFrame frame; // Main window

    public MazeSolverDarkUI(int size) {
        n = size;
        maze = new int[n][n];
        solution = new int[n][n];
        cells = new JButton[n][n];
        createAndShowGUI();
    }

    @SuppressWarnings("unused")
    private void createAndShowGUI() {
        // Set dark theme
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        UIManager.put("control", new Color(45, 45, 45));
        UIManager.put("nimbusLightBackground", new Color(55, 55, 55));
        UIManager.put("text", Color.WHITE);

        frame = new JFrame("Maze Solver - Minimalist Dark UI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        // Maze Grid Panel
        JPanel gridPanel = new JPanel(new GridLayout(n, n));
        gridPanel.setBackground(new Color(30, 30, 30));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                JButton cell = new JButton();
                cell.setBackground(new Color(50, 50, 50)); // Default cell color
                cell.setOpaque(true);
                cell.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 80), 1));
                final int x = i, y = j;
                cell.addActionListener(e -> toggleCell(x, y));
                cells[i][j] = cell;
                gridPanel.add(cell);
            }
        }

        // Buttons Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(new Color(30, 30, 30));
        JButton solveButton = createStyledButton("Solve Maze");
        solveButton.addActionListener(e -> solveMaze());
        buttonPanel.add(solveButton);

        JButton resetButton = createStyledButton("Reset Maze");
        resetButton.addActionListener(e -> resetMaze());
        buttonPanel.add(resetButton);

        // Add panels to frame
        frame.add(gridPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setSize(n * CELL_SIZE, n * CELL_SIZE + 100);
        frame.setVisible(true);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(70, 70, 70));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100)));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    private void toggleCell(int x, int y) {
        maze[x][y] = 1 - maze[x][y]; // Toggle between 1 and 0
        cells[x][y].setBackground(maze[x][y] == 1 ? new Color(34, 139, 34) : new Color(50, 50, 50));
    }

    private void solveMaze() {
        resetSolution();
        if (mazeSolve(maze, n)) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (solution[i][j] == 1) {
                        cells[i][j].setBackground(new Color(0, 120, 215)); // Highlight solution path
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(frame, "No Solutions Exist!!", "Maze Solver", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resetMaze() {
        maze = new int[n][n];
        resetSolution();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells[i][j].setBackground(new Color(50, 50, 50));
            }
        }
    }

    private void resetSolution() {
        solution = new int[n][n];
    }

    private boolean isSafe(int[][] board, int x, int y) {
        return (x >= 0 && y >= 0 && x < n && y < n && board[x][y] == 1);
    }

    private boolean mazeSolveUtil(int[][] board, int x, int y) {
        if (x == n - 1 && y == n - 1 && board[x][y] == 1) {
            solution[x][y] = 1;
            return true;
        }
        if (isSafe(board, x, y)) {
            solution[x][y] = 1;

            if (mazeSolveUtil(board, x + 1, y)) return true;
            if (mazeSolveUtil(board, x, y + 1)) return true;

            solution[x][y] = 0; // Backtrack
        }
        return false;
    }

    private boolean mazeSolve(int[][] board, int size) {
        return mazeSolveUtil(board, 0, 0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String input = JOptionPane.showInputDialog("Enter maze size (n x n):");
            int n = Integer.parseInt(input);
            new MazeSolverDarkUI(n);
        });
    }
}
