/**
 * 
 */
package org.feng.demo.sort;

/**
 * 归并排序（递归实现）
 * 
 * @author Administrator 2017年8月31日 下午7:02:21
 */
public class MergeSortTest {

	/**
	 * 打印一个int数组
	 * 
	 * @param a
	 */
	public static void printArray(int[] a) {
		if (a != null) {
			for (int num : a) {
				System.out.print(num + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[] nums = { 3, 4, 5, 3, 1, 0, 3, 9, 11, 10 };
		printArray(nums);
		MergeSort(nums, 0, nums.length - 1);
		printArray(nums);
	}

	/**
	 * @param nums
	 * @param i
	 * @param j
	 */
	private static void MergeSort(int[] nums, int start, int end) {
		// 至少规模为两个数才能进行归并递归过程
		if (start < end) {
			int middle = (start + end) / 2;
			MergeSort(nums, start, middle);
			MergeSort(nums, middle + 1, end);
			merge(nums, start, middle, end);
		}
	}

	/**
	 * 从一个数组序列中按照middle将左右两端升序排列的数进行升序归并
	 * 
	 * @param nums
	 * @param start
	 * @param middle
	 * @param end
	 */
	private static void merge(int[] nums, int start, int middle, int end) {
		// 并非链表的合并，因此需要辅助空间，最大达O(n)的空间复杂度
		int[] a1 = new int[middle - start + 1];
		int[] a2 = new int[end - middle];
		for (int i = 0, k = start; i < a1.length; i++, k++) {
			a1[i] = nums[k];
		}
		for (int i = 0, k = middle + 1; i < a2.length; i++, k++) {
			a2[i] = nums[k];
		}
		// 模拟合并链表的思路
		int p1 = 0, p2 = 0, p3 = start;// 两个数组的指针
		while (p1 < a1.length && p2 < a2.length) {			
			if (a1[p1] <= a2[p2]) {
				nums[p3++] = a1[p1++];
			} else {
				nums[p3++] = a2[p2++];
			}
		}
		// 处理剩余数组
		if (p1 == a1.length) {
			for (int i = p2; i < a2.length; i++) {
				nums[p3++] = a2[i];
			}
		} else {
			for (int i = p1; i < a1.length; i++) {
				nums[p3++] = a1[i];
			}
		}
	}
	
}
