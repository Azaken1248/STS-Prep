import java.util.Scanner;

public class CaveManeuvering {
    public static int getPathsCount(int m, int n){
        if(m == 1 || n == 1) return 1;

        return getPathsCount(m -1 , n) + getPathsCount(m, n - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int m =sc.nextInt();
        int n = sc.nextInt();

        System.out.println(getPathsCount(m, n));

        sc.close();
    }
}
