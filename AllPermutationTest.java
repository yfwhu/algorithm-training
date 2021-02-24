/**
 * 递归的思路实现字符数组的全排列序列输出
 * 
 * @author Administrator 2017年8月30日 下午9:06:20
 */
public class AllPermutationTest {

	public static final synchronized void main(String[] args) {
		char[] seqs = new char[] { 'A', 'B', 'C', 'D' };
		printAllPermutation(seqs, 0, seqs.length - 1);
	}

	/**
	 * @param seqs
	 * @param to
	 * @param from
	 */
	private static void printAllPermutation(char[] seqs, int from, int to) {
		// 如果当前递归过程发现只剩下一个元素时意味着一个序列已经成型
		if (from == to) {
			for (char ch : seqs) {
				System.out.print(ch + "\t");
			}
			System.out.println();
		} else {
			for (int i = from; i <= to; i++) {
				// 将from位置的元素依次取遍当前区间[from, to]的所有选项，模拟人脑的全排列思考过程
				swap(seqs, from, i);
				printAllPermutation(seqs, from + 1, to);
				swap(seqs, from, i);// 回溯原始状态
			}
		}
	}

	/**
	 * @param seqs
	 * @param from
	 * @param to
	 */
	private static void swap(char[] seqs, int from, int to) {
		// TODO Auto-generated method stub
		char temp = seqs[from];
		seqs[from] = seqs[to];
		seqs[to] = temp;
	}

}
