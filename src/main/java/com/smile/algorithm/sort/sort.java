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

    public static void binaryInsertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int insertNum = nums[i];
            int insertIndex = -1;
            int start = 0;
            int end = i - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (insertNum > nums[mid])
                    start = mid + 1;
                else if (insertNum < nums[mid])
                    end = mid - 1;
                else {
                    insertIndex = mid + 1;
                    break;
                }
            }
            if (insertIndex == -1)
                insertIndex = start;
            if (i - insertIndex >= 0)
                System.arraycopy(nums, insertIndex, nums, insertIndex + 1, i - insertIndex);
            nums[insertIndex] = insertNum;
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

    public static void quickSort(int[] num,int start,int end){
        if(start<end){
            int pivotIndex=getPivotIndex(num,start,end);
            quickSort(num,start,pivotIndex-1);
            quickSort(num,pivotIndex+1,end);
        }
    }

    public static int getPivotIndex(int[] num,int start,int end){
        int pivot=num[start];
        int low=start;
        int high=end;
        while(low<high){
            while(low<=high&&num[low]<=pivot){
                low++;
            }
            while (low<=high&&num[high]>pivot){
                high--;
            }
            if(low<high){
                swap(num,low,high);
            }
        }
        swap(num,start,high);
        return high;
    }
//    public static void quickSort(int[] nums, int start, int end) {
//        if (start < end) {
//            int pivotIndex = getPivotIndex(nums, start, end);
//            quickSort(nums, start, pivotIndex - 1);
//            quickSort(nums, pivotIndex + 1, end);
//        }
//    }
//
//    public static int getPivotIndex(int[] nums, int start, int end) {
//        int pivot = nums[start];
//        int low = start;
//        int high = end;
//        while (low < high) {
//            while (low <= high && nums[low] <= pivot)
//                low++;
//            while (low <= high && nums[high] > pivot)
//                high--;
//            if (low < high)
//                swap(nums, low, high);
//        }
//        swap(nums, start, high);
//        return high;
//    }
}
