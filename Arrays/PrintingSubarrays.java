package Arrays;

public class PrintingSubarrays {
    public static void printSubarrays(int[] arr) {
        int l = arr.length;
        for(int i=0; i<l; i++) {
            for(int j=i; j<l; j++) {
                for(int k=i; k<=j; k++) {
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        printSubarrays(arr);
    }
}
