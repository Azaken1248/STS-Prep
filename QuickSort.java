import java.util.Scanner;
import java.util.Arrays;

public class QuickSort {
    public static int partition(int arr[], int start, int end){
        int i = start - 1;
        int pivot = arr[end];

        for(int j = start; j <= end; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        i++;
        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;

        return i;
    }

    public static void quickSort(int arr[], int start, int end){
        if(start >= end) return;
        
        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int arr[] = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        } 

        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        sc.close();
    }
}
