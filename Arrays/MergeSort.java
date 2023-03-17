package Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr,int si, int ei) {
        int mid = si + (ei - si)/2;
        if(si >= ei) {
            return;
        }
        mergeSort(arr,si,mid);
        mergeSort(arr,mid+1,ei);
        merge(arr,si,mid,ei);
    }
    public static void merge(int[] arr,int si, int mid, int ei) {
        int[] temp = new int[ei-si+1];
        int i = si; // iterator for the left sorted part
        int j = mid+1; // iterator for the right sorted part
        int k = 0; // iterator for the temporary array

        while((i <= mid) && (j <= ei)) {
            if(arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++; k++;
            }
            else {
                temp[k] = arr[j];
                k++; j++;
            }
        }

        while(i <= mid) {
            temp[k++] = arr[i++];
        }
        while(j <= ei) {
            temp[k++] = arr[j++];
        }
        for(k=0,i=si;k<temp.length;k++,i++) {
            arr[i] = temp[k];
        }
    }
    public static void printArr(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int [] arr = new int[1000];
        for(int i=0; i<arr.length; i++){
            arr[i] = (int) (Math.random()*100);
        }
        System.out.println("Original array: ");
        printArr(arr);
       // int[] arr = {5,4,1,2,5,3};
        mergeSort(arr,0,arr.length-1);
        System.out.println("Sorted array: ");
        printArr(arr);
    }
}
