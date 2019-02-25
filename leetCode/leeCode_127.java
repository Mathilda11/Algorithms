package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 最短单词路径
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * 
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 * @author 54060
 *
 */
public class leeCode_127 {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
	    wordList.add(beginWord); //将开始单词添加到wordList
	    int N = wordList.size();
	    int start = N - 1; //开始单词所在位置
	    int end = 0;
	    while (end < N && !wordList.get(end).equals(endWord)) {
	        end++;	//结束单词所在位置
	    }
	    if (end == N) {
	        return 0;
	    }
	    List<Integer>[] graphic = buildGraphic(wordList);
	    return getShortestPath(graphic, start, end);
	}
	
	private List<Integer>[] buildGraphic(List<String> wordList) {
	    int N = wordList.size();
	    List<Integer>[] graphic = new List[N];
	    //为wordList中的每个单词构建一个集合，集合里面放的是只改变一个字符的字符串的索引。
	    for (int i = 0; i < N; i++) {
	        graphic[i] = new ArrayList<>();
	        for (int j = 0; j < N; j++) {
	            if (isConnect(wordList.get(i), wordList.get(j))) {
	                graphic[i].add(j);
	            }
	        }
	    }
	    return graphic;
	}
	//graphic
	//[[1, 3, 6], [0, 2, 3], [1, 4, 5], [0, 1, 4], [2, 3, 5], [2, 4], [0]]
	private boolean isConnect(String s1, String s2) {
	    int diffCnt = 0;
	    for (int i = 0; i < s1.length() && diffCnt <= 1; i++) {
	        if (s1.charAt(i) != s2.charAt(i)) {
	            diffCnt++;
	        }
	    }
	    return diffCnt == 1;
	}

	private int getShortestPath(List<Integer>[] graphic, int start, int end) {
	    Queue<Integer> queue = new LinkedList<>();
	    boolean[] marked = new boolean[graphic.length];
	    queue.add(start);
	    marked[start] = true;
	    int path = 1;
	    while (!queue.isEmpty()) {
	        int size = queue.size();
	        path++;
	        while (size-- > 0) {
	            int cur = queue.poll();
	            for (int next : graphic[cur]) {
	                if (next == end) {
	                    return path;
	                }
	                if (marked[next]) {
	                    continue;
	                }
	                marked[next] = true;
	                queue.add(next); //广度优先搜索一层一层遍历，每一层得到的所有新节点，要用队列存储起来以备下一层遍历的时候再遍历。
	            }
	        }
	    }
	    return 0;
	}
	
	//注意：此处出现问题。https://blog.csdn.net/Tracycater/article/details/77592472?locationNum=2&fps=1
	public static void main(String[] args) {
		leeCode_127 leeCode_127 = new leeCode_127();
		String[] list = {"hot","dot","dog","lot","log","cog"};
		List<String> wordList = new ArrayList(Arrays.asList(list));//注意数组转List引发错误
		leeCode_127.ladderLength("hit", "cog", wordList);
	}
}
