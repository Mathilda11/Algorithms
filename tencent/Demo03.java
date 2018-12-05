package tencent;

/*
小Q今天在上厕所时想到了这个问题：有n个数，两两组成二元组，相差最小的有多少对呢？相差最大呢？

输入描述:

 输入包含多组测试数据。

 对于每组测试数据：

 N - 本组测试数据有n个数

 a1,a2...an - 需要计算的数据

 保证:

 1<=N<=100000,0<=ai<=INT_MAX.

输出描述:

对于每组数据，输出两个数，第一个数表示差最小的对数，第二个数表示差最大的对数。

输入例子1:

6
45 12 45 32 5 6

输出例子1:

1 2
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
 
public class Demo03 {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++){
                a[i] = sc.nextInt();
            }
             
            Arrays.sort(a);
            //如果数组中的值全相同，直接两两组合
            if(a[0] == a[n-1]){
                int tmp = (n*(n-1))/2;
                System.out.println(tmp + " " + tmp);
                continue;
            }
            //map用来统计{差值：对数}
            Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
            for(int i=0;i<n;i++){
                if(map.containsKey(a[i]))
                    map.put(a[i], map.get(a[i])+1);
                else
                    map.put(a[i], 1);
            }
            //求差最小个数
            int minres = 0;
            if(map.size() == n){ //无重复
                int min = Math.abs(a[1]-a[0]);
                for(int i=2;i<n;i++){
                    int tmp = Math.abs(a[i]-a[i-1]);
                    if(tmp == min) //如果此时最小值已经等于tmp
                        minres++;
                    else if(tmp < min){ //最小值是新的数
                        min = tmp;
                        minres = 1;
                    }
                }
            }else{//有重复
                for(Integer key : map.keySet()){
                    int val = map.get(key);
                    if(val > 1){ //对数就是重复的数字两两组成的个数
                        minres += (val * (val-1))/2;
                    }
                }
            }
            //求差最大个数
            int maxres = 0;
            List<Integer> keyset = new ArrayList<Integer>(map.keySet());
            int val1 = map.get(keyset.get(0));
            int val2 = map.get(keyset.get(keyset.size()-1));
            maxres = val1 * val2;
            System.out.println(minres + " " + maxres);         
        }
    }
 
}
