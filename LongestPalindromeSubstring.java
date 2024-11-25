import java.util.Scanner;

public class LongestPalindromeSubstring {
    private static boolean checkPalindrome(String str){
        boolean isPalindrome = true;
        
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != str.charAt(str.length() - 1 - i)){
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        
        String ans = "";

        for(int i = 0; i < str.length(); i++){
            for(int j = i; j < str.length(); j++){
                String sub = str.substring(i,j + 1);
                
                if(checkPalindrome(sub) && ans.length() < sub.length()){
                    ans = sub;
                }
            }
        }

        System.out.println(ans);

        sc.close();
    }
}
