package com.smile.datastructure.array;

import java.util.Arrays;

public class E01Merge2SortedArray {

    public static void main(String[] args) {
        int[] a1={1,5,6,2,4,10,11};
        int[] a2=new int[a1.length];
//        merge(a1,0,2,3,6,a2,0);
        merge(a1,0,2,3,6,a2);
        System.out.println(Arrays.toString(a2));
    }

    public static void merge1(int[] a1,int i,int iEnd,int j,int jEnd,int[] a2,int k){
        if(i>iEnd){
            System.arraycopy(a1,j,a2,k,jEnd-j+1);
            return;
        }
        if(j>jEnd){
            System.arraycopy(a1,i,a2,k,iEnd-i+1);
            return;
        }
        if(a1[i]<a1[j]){
            a2[k]=a1[i];
            merge1(a1,i+1,iEnd,j,jEnd,a2,k+1);
        }
        else {
            a2[k]=a1[j];
            merge1(a1,i,iEnd,j+1,jEnd,a2,k+1);
        }
    }

//    非递归
    public static void merge(int[] a1,int i,int iEnd,int j,int jEnd,int[] a2){
        int k=0;
        while(i<=iEnd&&j<jEnd){
            if(a1[i]<a1[j]){
                a2[k]=a1[i];
                i++;
            }
            else {
                a2[k]=a1[j];
                j++;

            }
            k++;
        }
        if(i>iEnd){
            System.arraycopy(a1,j,a2,k,jEnd-j+1);
        }
        else{
            System.arraycopy(a1,i,a2,k,iEnd-i+1);
        }
    }
}
