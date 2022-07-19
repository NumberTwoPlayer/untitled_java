package com.Exercise.java;

/**
 * @Name NumberTwoPlayer
 * @create 2022-07-19-13:28
 */
public class Test01 {
    public static void main(String[] args) {
        int[] arr = {1,13,42,17,99,0,1};
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j + 1]){
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
