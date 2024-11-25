import java.util.ArrayList;
import java.util.Scanner;

public class SortedUniquePermutation {
    
    private static void generatePermutations(String prefix, String remaining, ArrayList<String> permutations){
        if(remaining.length() == 0){
            permutations.add(prefix);
        }

        for(int i = 0; i < remaining.length(); i++){
            String newPrefix = prefix + remaining.charAt(i);
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);

            generatePermutations(newPrefix, newRemaining, permutations);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine();

        ArrayList<String> permutations = new ArrayList<String>();

        permutations.sort(null);

        generatePermutations("", str, permutations);

        System.out.println(permutations.toString());

        sc.close();

        
    }
}
