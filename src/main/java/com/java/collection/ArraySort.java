package com.java.collection;

public class ArraySort {
    /**
     * 选择排序
     * 
     * @param arr
     */
    public static void selectSort(int[] arr) {
        //外环控制数组中的下标数
        for (int x = 0; x < arr.length; x++) {
            //内循环进行比较
            for (int y = x + 1; y < arr.length; y++) {
                if (arr[x] > arr[y]) {
                    int temp = arr[x];//最大值，用临时变量存
                    arr[x] = arr[y];//小值放在前
                    arr[y] = temp;//大值放在后
                }
            }
        }
    }

    /**
     * 获取数组中最大元素:根据元素下标来判断
     * 
     * @param arr
     */
    public static int getMaxElement(int[] arr) {
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        return arr[max];
    }

    /**
     * 获取数组中最大元素2：取值计算
     * 
     * @param arr
     * @return
     */
    public static int getMaxElement_2(int[] arr) {
        int max = arr[0];
        for (int x = 1; x < arr.length; x++) {
            if (arr[x] > max) {
                max = arr[x];
            }
        }
        return max;
    }

    /**
     * 打印数组
     * 
     * @param arr
     */
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 2, 1, 5, 7 };
        //        System.out.println(getMaxElement(arr));
        //        System.out.println(getMaxElement_2(arr));
        System.out.println("--------------------排序前---------------");
        printArray(arr);
        selectSort(arr);
        System.out.println("--------------------排序后---------------");
        printArray(arr);

    }
}
