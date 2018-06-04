package com.utils.arrays;

public class AlternatePositiveNegative {
    static void rearrange(int arr[])
    {
        int n=arr.length;
        int j=-1;
        for(int i=0;i<n;i++)
        {
            if(arr[i]<0)
            {
                j++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }

        }
        int arr2[]=new int[n];
        int k=0;
        int l=1;
        for(int i=0;i<n;i++)
        {
            if(i<=j) {
                arr2[k] = arr[i];
                k = k + 2;
            }
            if(i>j){
                arr2[l] = arr[i];
                l=l+2;
            }
        }




        display(arr);
        System.out.println();
        display(arr2);
    }
    public static void display(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(" "+arr[i]);
        }
    }
    public static void main(String[] args) {
        AlternatePositiveNegative a=new AlternatePositiveNegative();
        int arr[]={-2,1,2,-4,-5,8,-1,-9,3,7};
        a.rearrange(arr);

    }
}
