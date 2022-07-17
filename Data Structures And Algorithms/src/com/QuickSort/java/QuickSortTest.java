package com.QuickSort.java;

import java.util.Arrays;

public class QuickSortTest{
    public static void main(String[] agrs){
        int[] arr = {1,12,32,98,0,-12,-79,0,10,0,1,90,12};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr, int left, int right){
        int i = left;
        int j = right;
        int pivot = arr[(left + right) / 2];
        while(i < j){
            while(arr[i] < pivot){
                i++;
            }
            while(arr[j] > pivot){
                j--;
            }
            if(i >= j){
                break;
            }
            int test = arr[i];
            arr[i] = arr[j];
            arr[j] = test;

            if(arr[i] == pivot){
                j--;
            }
            if(arr[j] == pivot){
                i++;
            }
        }
        if(i == j){
            i++;
            j--;
        }
        if(left < j){
            quickSort(arr, left, j);
        }
        if(right > i){
            quickSort(arr,i, right);
        }

    }

}


