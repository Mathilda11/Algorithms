package tencent;

import java.util.Scanner;
/*
给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
输出需要删除的字符个数。

输入描述:

输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.

输出描述:

对于每组数据，输出一个整数，代表最少需要删除的字符个数。

输入例子1:

abcda
google

输出例子1:

2
2

思路：
回文串的特点是，逆序输出和正序输出是一样的。所以这道题可以从这方面来考虑。
如果将此字符串逆序输出，那么两个字符串的最长公共子序列将是最长的回文字符串，那么剩余的值将是要删除的字符个数。

实际上用的是leeCode-动态规划-最长公共子序列
*/
public class Demo01 {
    public static void main(String[] args){
    	//String str = "google";
    	//getResult(str);
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str = scan.nextLine();
            System.out.println(str.length()-getResult(str));
        }
    }
    public static int getResult(String str){
        StringBuilder sb  = new StringBuilder(str);
        String newStr = sb.reverse().toString();
        char[] c1 = str.toCharArray();
        char[] c2 = newStr.toCharArray();
        //最长公共子序列
        int n = str.length();
        int[][] dp = new int[n+1][n+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(c1[i-1]==c2[j-1]){ 
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }

}
