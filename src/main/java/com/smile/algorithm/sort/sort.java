package com.smile.algorithm.sort;

public class sort {
    static void swap(int num[], int a, int b){
        int temp=num[a];
        num[a]=num[b];
        num[b]=temp;
    }


//    插入排序
    public static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int insertNum = nums[i];
            int insertIndex;
            for (insertIndex = i - 1; insertIndex >= 0 && nums[insertIndex] > insertNum; insertIndex--) {
                nums[insertIndex + 1] = nums[insertIndex];
            }
            nums[insertIndex + 1] = insertNum;
        }
    }

    // 希尔排序
    public static void shellSort(int[] nums) {
        for (int d = nums.length / 2; d > 0 ; d /= 2) {
            for (int i = d; i < nums.length; i++) {
                int insertNum = nums[i];
                int insertIndex;
                for (insertIndex = i - d; insertIndex >= 0 && nums[insertIndex] > insertNum; insertIndex -= d) {
                    nums[insertIndex + d] = nums[insertIndex];
                }
                nums[insertIndex + d] = insertNum;
            }
        }
    }

    //    直接选择排序
    public static void selectSort(int[] nums){
        int minIndex;
        for(int index=0;index<nums.length;index++){
            minIndex=index;
            for(int i=index+1;i< nums.length;i++){
                if(nums[i]< nums[minIndex]){
                    minIndex=i;
                }
            }
            if(index!=minIndex){
                swap(nums,index,minIndex);
            }
        }
    }

//    冒泡排序
    public static void bubbleSort(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            for (int j=0;j<nums.length-i-1;j++){
                if(nums[j]>nums[j+1]){
                    swap(nums,j,j+1);
                }
            }
        }
    }

    public static void betterBubbleSort(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            boolean isNotSwap=true;
            for(int j=0;j<nums.length-1-i;j++){
                if(nums[j]>nums[j+1]){
                    swap(nums,j,j+1);
                    isNotSwap=false;
                }
            }
            if(isNotSwap){
                break;
            }
        }
    }
}
