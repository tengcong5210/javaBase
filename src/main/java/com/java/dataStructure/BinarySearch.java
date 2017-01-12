package com.java.dataStructure;

/**
 * 二分查找算法
 * 
 * @author linco lee
 */
public class BinarySearch {

    public static int search(int[] arrays, int key) throws Exception {
        int low, high, mid;
        low = 1;//记录最低下标为首位
        high = 10;//定义最高下标记录末位
        while (low <= high) {
            mid = (low + high) / 2;//折半
            if (key < arrays[mid]) {//若查找值比中值小
                high = mid - 1;//最高下标调整到中位下标小一位
            } else if (key > arrays[mid]) {//若查找值比中值大
                low = mid + 1;//最低下标调整到中位下标大一位
            } else {
                return mid;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        int[] a = { 0, 1, 16, 24, 35, 47, 59, 62, 73, 88, 99 };
        int index = search(a, 62);
    }
}
