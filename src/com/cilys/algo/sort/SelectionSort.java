package com.cilys.algo.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 原理：在未排序的数组中找到最小（最大）元素，存放到数组的起始位置
 * 再从剩余未排序的元素中寻找最小（最大）元素，放到已排序数组的末尾，直到完成排序
 * 平均时间复杂度：O(n^2)
 * 最好情况：O(n^2)
 * 最坏情况：O(n^2)
 * 空间复杂度：O(1)
 * 排序方式：In-place内排序，占用常数内存，不占用额外内存
 * 稳定性：不稳定（如果a原本在b的前面，而a = b，排序后a可能在b的后面）
 */
public class SelectionSort implements SortImpl {

    public static void main(String[] args) {
        SelectionSort s = new SelectionSort();
        s.sort(testArrays);
        System.out.println(Arrays.toString(testArrays));
    }


    @Override
    public int[] sort(int[] arrays) {
        if (arrays == null || arrays.length < 1) {
            return arrays;
        }
        for (int i = 0; i < arrays.length; i++) {
            int minIndex = i;
            for (int j = i; j < arrays.length; j++) {
                if (arrays[j] < arrays[minIndex]) {
                    //找到最小的那个数的索引
                    minIndex = j;
                }
            }
            int tmp = arrays[minIndex];
            arrays[minIndex] = arrays[i];
            arrays[i] = tmp;
        }
        return arrays;
    }
}