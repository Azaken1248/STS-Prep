import java.util.Scanner;

public class MoveHyphen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        
        String hyphens = "";
        String body = "";

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '-'){
                hyphens += str.charAt(i);
            }else{
                body += str.charAt(i);
            }
        }

        System.out.println(hyphens + body);

        sc.close();
    }
}
