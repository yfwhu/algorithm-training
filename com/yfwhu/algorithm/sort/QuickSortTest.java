package com.yfwhu.algorithm.sort;

import java.util.Arrays;

/**
 * @ClassName QuickSortTest
 * @Description TODO
 * @Date 2021/3/4 21:40
 * @Created by Administrator
 */
public class QuickSortTest {
    public static void sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int begin, int end) {
        // 递归过程中每一步至少有两个元素才可以进行快排操作
        if (begin < end) {
            int i = begin, j = end;
            // 递归每一轮的哨兵
            int key = nums[begin];
            while (i < j) {
                // i < j 说明哨兵还没有归位
                while (i < j && nums[j] >= key) {
                    j--; // 不断探测右边是否有小于i位置哨兵的元素
                }
                if (i < j) {
                    // 说明探测到右边界小于于i位置哨兵的元素, 将小的元素挪到左边i位置，j作为新的哨兵位置
                    nums[i] = nums[j];
                }
                // 接下来找左边i 大于右边哨兵j的元素
                while (i < j && nums[i] <= key) {
                    i++;
                }
                if (i < j) {
                    // 说明左边探测到大于哨兵j位置的元素，将大的元素挪动到右边j位置，i作为新的哨兵位置
                    nums[j] = nums[i];
                }
            }
            // i == j 哨兵归位
            nums[i] = key;
            // 递归哨兵左右部分
            quickSort(nums, begin, i - 1);
            quickSort(nums, i + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 45, 12, 45, 23, 98, 35, 100, 1};
        sortArray(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{2, 45, 23, 234, 233, 3, 43, 12, 11, 10};
        sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }

}
