/**
 * LCS 最长公共子序列问题
 *
 * @author Administrator 2021年2月24日 下午16:55:29
 */

public class LCSTest {

    private static int[][] flag;

    public static void main(String[] args) {
        // 定义两个字符串
        String strA = "ABDFDRS", strB = "BMDFSG";
        int m = strA.length(), n = strB.length();
        // 标记dp[i][j]的计算依据 -1 表示取值(i, j-1) 0 表示取值(i-1, j-1) 1 表示取值 (i-1, j)
        flag = new int[m + 1][n + 1];
        int length = longestCommonSubsequence(strA, strB);
        String lcs = getLCS(strA, strB);
        System.out.println("LCS is: " + lcs + " 长度为：" + length);
    }

    /***
     * 返回两个字符串最长公共子序列长度
     * LCS 状态转义方程
     *           0                          (i,j=0)
     * C[i, j] = C[i-1, j-1] + 1            (Xi == Xj)
     *           Max{C[i, j-1), C[i-1, j)}  (Xi != Xj)
     * @param strA
     * @param strB
     * @return
     */
    public static int longestCommonSubsequence(String strA, String strB) {
        int m = strA.length(), n = strB.length();
        // 这里利用了java默认给数组对象初始化元素值0的特性 解决了动态规划base case的复制
        int[][] dp = new int[m + 1][n + 1];
        // 因为dp从1开始计数，字符串取字符注意减去1
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (strA.charAt(i - 1) == strB.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    flag[i][j] = 0;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    flag[i][j] = dp[i][j - 1] > dp[i - 1][j] ? -1 : 1;
                }
            }
        }
        return dp[m][n];
    }

    public static String getLCS(String strA, String strB) {
        int m = strA.length(), n = strB.length();
        StringBuilder lcs = new StringBuilder();
        // m和n任何一个等于0说明其中一个字符串已经没有元素回溯完毕
        while (m > 0 && n > 0) {
            if (flag[m][n] == 0) {
                lcs.append(strA.charAt(m - 1));
                m--;
                n--;
            } else if (flag[m][n] < 0) {
                n--;
            } else {
                m--;
            }
        }
        return lcs.reverse().toString();
    }
}