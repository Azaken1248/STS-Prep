import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class NaturalSortOrder{
    
    
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        
        int n;
        ArrayList<String> list = new ArrayList<String>();

        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            String element = sc.next();
            list.add(element);
        }

        ArrayList<Integer> sorter = new ArrayList<Integer>();

        for(String s : list){
            s = s.substring(0, s.length()-4);
            sorter.add(Integer.parseInt(s.substring(4)));
        }        

        int arr[] = new int[sorter.size()];
        for(int i = 0; i < sorter.size(); i++){
            arr[i] = sorter.get(i);
        }

        for(int i = 1; i < arr.length; i++){
            int j  = i - 1;
            int temp = arr[i];
            while(j >= 0 && temp < arr[j]){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }

        System.out.println(Arrays.toString(arr));
        
        System.out.print("[");
        for(int i = 0; i < arr.length - 1; i++){
            System.out.print("file"+arr[i]+".txt, ");
        }
        System.out.println("file"+arr[arr.length - 1]+"]");

        sc.close();
    }
}