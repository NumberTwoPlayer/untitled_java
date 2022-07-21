package com.Sort.java;

/**
 * @Name NumberTwoPlayer
 * @create 2022-07-18-21:49
 */
public class BubleSort {
    public static void main(String[] args) {
        int[] arr = {1, 23, 17, 19, 0, 33, 97};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int test = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = test;
                }
            }
        }
        for(int i : arr){
            System.out.println(i);
        }
    }
}
