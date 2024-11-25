import java.util.ArrayList;
import java.util.Scanner;

public class Combinations {
    public static void getCombinations(String str, int start, int r,  ArrayList<String> combinations){
        if(combinations.size() == r){
            for(String s: combinations){
                System.out.print(s);
            }
            System.out.println();
        }

        for(int i = start; i < str.length(); i++){
            combinations.add("" + str.charAt(i));
            getCombinations(str, i + 1, r, combinations);
            combinations.removeLast();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine();
        int r = sc.nextInt();

        ArrayList<String> combinations = new ArrayList<>();
        
        getCombinations(str, 0, r, combinations);

        sc.close();
    }
}
