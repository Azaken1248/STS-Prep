import java.util.HashSet;
import java.util.Scanner;
public class WeightedSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine();
        String weights = sc.nextLine();
        int maxCost = sc.nextInt();

        HashSet<String> set = new HashSet<String>();

        for(int i = 0; i < str.length(); i++){
            String current = "";
            int cost = 0;
            
            for(int j = i; j < str.length(); j++){
                int weight = weights.charAt(str.charAt(j) - 'a') - '0';
                
                if(weight + cost <= maxCost){
                    current += str.charAt(j);
                    cost += weight;
                    
                    set.add(current);
                }else{
                    break;
                }

                
                
            }
        }

        System.out.println(set.size() + "\n");

        for(String s : set){
            System.out.println(s);
        }

        sc.close();

    }
}
