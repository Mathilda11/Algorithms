package leetCode;

import java.util.HashMap;

class DLinkedNode {
    String key;
    int value;
    DLinkedNode pre;
    DLinkedNode next;
}

public class LRUCache {
	 private HashMap cache = new HashMap();
	 private int count;
	 private int capacity;
	 private DLinkedNode head, tail;
	 
	 public LRUCache(int capacity) {
		 this.count = 0;
		 this.capacity = capacity;
		 head = new DLinkedNode();
		 tail = new DLinkedNode();
		 head.next = tail;
		 tail.pre = head;
	 }
	 
	 public int get(String key) {
		 DLinkedNode node = (DLinkedNode) cache.get(key);
		 if(node == null){
		     return -1; // 若访问的节点不存在，返回-1
		 }
		 // 将被访问的节点移动到头部
		 this.moveToHead(node);
		 return node.value;
	 }
	 
	 public void set(String key, int value) {
		 DLinkedNode node = (DLinkedNode) cache.get(key);
		 if(node == null){
		     DLinkedNode newNode = new DLinkedNode();
		     newNode.key = key;
		     newNode.value = value;
		     this.cache.put(key, newNode);
		     this.addNode(newNode);
		     ++count;
		     if(count > capacity){
		         // 移除尾部节点
		         DLinkedNode tail = this.popTail();
		         this.cache.remove(tail.key);
		         --count;
		     }
		 }else{
		     // 更新value.
		     node.value = value;
		     this.moveToHead(node);
		 }
	 }
	 
	/**
	* 在头节点后添加新节点
	*/
	private void addNode(DLinkedNode node){
		node.pre = head;
		node.next = head.next;
		head.next.pre = node;
		head.next = node;
	}
	
	/**
	* 从链表中删除存在的节点
	*/
	private void removeNode(DLinkedNode node){
		DLinkedNode pre = node.pre;
		DLinkedNode next = node.next;
		pre.next = next;
		next.pre = pre;
	}
	
	/**
	* 将节点移动到头部
	*/
	private void moveToHead(DLinkedNode node){
		this.removeNode(node);
		this.addNode(node);
	}
	
	// 移除尾部节点
	private DLinkedNode popTail(){
		DLinkedNode res = tail.pre;
		this.removeNode(res);
		return res;
	}
	
	@Override
	public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        DLinkedNode node = head.next;
        while (node.next != null) {
            stringBuilder.append(String.format("%s:%d ", node.key, node.value));
            node = node.next;
        }
        return stringBuilder.toString();
	}
		
	public static void main(String[] args) {
		LRUCache lruCache = new LRUCache(3);//缓存容量为3
		lruCache.set("1", 1);
		lruCache.set("2", 2);
		lruCache.set("3", 3);
		System.out.println("初始缓存\n"+lruCache);
		lruCache.get("2");
		System.out.println("访问Key为2的缓存\n"+lruCache);
		lruCache.get("1");
		System.out.println("访问Key为1的缓存\n"+lruCache);
		lruCache.set("4", 4);
		System.out.println("添加Key为4的缓存\n"+lruCache);
	}
}
