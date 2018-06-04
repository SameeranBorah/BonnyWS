package com.utils.arrays;

public class QuickSort {
    private static int rearrange(int arr[], int low, int high){
    int pivot=high;
    int j=low-1;
    for(int i=low;i<high;i++)
    {
        if(arr[i]<=arr[pivot]){
            j++;
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
    }
    int temp=arr[high];
    arr[high]=arr[j+1];
    arr[j+1]=temp;
    return j+1;
}
    private static void sort(int arr[],int low, int high){
        if(low<high) {
            int pi = rearrange(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }


    }

    private static void display(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }

    public static void main(String[] args) {
        int arr[] = {-2, 1, 2, -4, -5, 8, -1, -9, 3, 7};
        sort(arr, 0, 9);
        display(arr);
    }

}