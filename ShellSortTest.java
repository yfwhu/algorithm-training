/**
 * 希尔排序（循环）
 * 
 * @author Administrator 2017年9月1日 上午9:59:43
 */
public class ShellSortTest {

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
		int[] nums = { 3, 4, 5, 8, 1, 0, 9, 10, 14, 3, 5, 7, 12};
		printArray(nums);
		shellSort(nums);
		printArray(nums);
	}

	/**
	 * 希尔排序是直接插入排序的一种改进算法，在直接插入排序之前先进行了不同步长子序列的直接插入排序
	 * 使得步长因子变为1的时候直接进行最后一次直接插入排序的时候数组基本有序，从而极大提升了直接插入排序 的效率
	 * 
	 * @param nums
	 */
	private static void shellSort(int[] nums) {
		// TODO Auto-generated method stub
		for (int h = nums.length / 2; h > 0; h = h / 2) {
			// 抛开外层步长计算的循环，内部其实就是一个固定步长的直接插入排序过程
			for (int i = h; i < nums.length; i++) {
				int sentry = nums[i];// 当年h步长某个子序列的枢纽值
				if (sentry < nums[i - h]) {
					// 这一层循环用于对枢纽值归位
					for (int j = i - h; j >= 0; j = j - h) {
						 if (nums[j] > sentry) {
							 nums[j + h] = nums[j];
						 } else {
							 nums[j + h] = sentry; // 哨兵归位
							 break;
						 }
					}
				}// 只有枢纽小于左边第一个值才需要归位
			}
		}
	}

}
