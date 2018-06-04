package com.codes.practice;

public class QuickSort {
    static int partition(int arr[],int low, int high)
    {
        int j=low-1;
        for(int i=low;i<high;i++){
            if(arr[i]<=arr[high]){
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
    static void quickSort(int arr[],int low, int high){
        if (low<high){
            int pi=partition(arr, low, high);
            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
    }

    public static void main(String[] args) {
        int arr[]={9,1,0,6,3,8,0,1,2,3};
        quickSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
    }
}
