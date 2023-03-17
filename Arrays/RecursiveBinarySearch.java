package Arrays;

public class RecursiveBinarySearch {
    public static void binarySearchRecurs(int[] arr,int start,int end,int key) {
        if(start > end) {
            return;
        }
        int mid = (start + end)/2;
        if(arr[mid] == key) {
            System.out.println("Element found at index: "+mid);
            return;
        }
        if(arr[mid] > key) {
            binarySearchRecurs(arr,start,mid-1,key);
        }
        else {
            binarySearchRecurs(arr,mid+1,end,key);
        }
    }
    public static void main(String[] args) {
        int[] arr = {6};
        binarySearchRecurs(arr,0,0,6);
    }
}
