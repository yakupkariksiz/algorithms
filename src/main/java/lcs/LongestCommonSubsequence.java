package lcs;

class LongestCommonSubsequence {

    public static void main(String[] args) {
        char[] x = "SHINCHAN".toCharArray();
        char[] y = "NOHARAAA".toCharArray();
        System.out.println(method3(x, y, x.length, y.length));
    }

    /**
     * Method1() - recursive solution(Top-down approach)
     * time complexity - O(3^(m+n))
     * space complexity - O(m+n)
     */
    static int method1(char[] x, char[] y, int i, int j) {

        if (i <= 0 || j <= 0) {
            return 0;
        }
        if (x[i - 1] == y[j - 1]) {
            return 1 + method1(x, y, i - 1, j - 1);
        } else {
            return Math.max(method1(x, y, i, j - 1), method1(x, y, i - 1, j));
        }
    }

    // Method2() - recursive solution with memoization
    static int method2(char[] x, char[] y, int i, int j, Integer[][] dp) {
        if (i <= 0 || j <= 0) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (x[i - 1] == y[j - 1]) {
            return 1 + method2(x, y, i - 1, j - 1, dp);
        } else {
            return dp[i][j] = Math.max(method2(x, y, i, j - 1, dp), method2(x, y, i - 1, j, dp));
        }
    }

    // method3() - DP solution(Bottom up approach)
    // time complexity - O(m*n)
    // space complexity - O(m*n)
    static int method3(char[] x, char[] y, int m, int n) {

        int[][] memo = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    memo[i][j] = 0;
                } else if (x[i - 1] == y[j - 1]) {
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }

        return memo[m][n];
    }
}
