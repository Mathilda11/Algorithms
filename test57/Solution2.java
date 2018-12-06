package test57;

import java.util.ArrayDeque;
/*
 * 请定义一个队列并实现函数max得到队列里的最大值，要求函数max、push_back和pop_front的时间复杂度都是O(1)。
 * 
 * 思路：
 * 这里需要使用两个队列，一个队列用来保存入队的数据，一个队列用来保存队列的当前最大值。
 * 同时需要注意出队操作，数据队列出队的同时需要判断其索引是否和当前最大值队列首部索引相同，如果相同则同时也将最大值队列头部出队。
 */
public class Solution2 {
	private ArrayDeque<InternalData>  data = new ArrayDeque<InternalData>(); //入队的数据
    private ArrayDeque<InternalData> maximum = new ArrayDeque<InternalData>(); //当前最大值
    private class InternalData{
        int number;
        int index;
        public InternalData(int number,int index) {
            this.number=number;
            this.index=index;
        }
    }
    private int curIndex;
     
    public void push_back(int number) {
        InternalData curData = new InternalData(number,curIndex);
        data.addLast(curData);
         
        while(!maximum.isEmpty() && maximum.getLast().number<number)
            maximum.removeLast();
        maximum.addLast(curData);
         
        curIndex++;  //别漏了这句
    }
     
    public void pop_front() {
        if(data.isEmpty()) {
            System.out.println("队列为空，无法删除！");
            return;
        }
        InternalData curData = data.removeFirst();
        if(curData.index==maximum.getFirst().index)
            maximum.removeFirst();
    }
     
    public int max() {
        if(maximum==null){
            System.out.println("队列为空，无法删除！");
            return 0;
        }
        return maximum.getFirst().number;
    }
}
