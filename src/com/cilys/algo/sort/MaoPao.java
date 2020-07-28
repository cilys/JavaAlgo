package com.cilys.algo.sort;

import java.util.Arrays;

/**
 * 冒泡法
 * 原理：遍历数组，比较相邻两个数的大小，然后进行交互位置
 * 平均时间复杂度：O(n^2)
 * 最好情况：O(n)
 * 最坏情况：O(n^2)
 * 空间复杂度：O(1)
 * 排序方式：In-place内排序，占用常数内存，不占用额外内存
 * 稳定性：稳定（如果a原本在b的前面，而a = b，排序后a仍然在b的前面）
 */
public class MaoPao {

    public static void main(String[] args) {
        int[] arrays = {9, 7, 5, 3, 1};
        sort(arrays);
        System.out.println(Arrays.toString(arrays));
    }

    public static int[] sort(int[] arrays){
        if (arrays == null || arrays.length == 0) {
            return arrays;
        }

        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays.length -1 -i; j++) {
                if (arrays[j +1] < arrays[j]) {
                    int tmp = arrays[j + 1];
                    arrays[j + 1] = arrays[j];
                    arrays[j] = tmp;
                }
            }
        }
        return arrays;
    }


}