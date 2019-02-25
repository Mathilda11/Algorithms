package leetCode;

import java.util.ArrayList;
import java.util.Collections;

public class offer3 {
	public ArrayList<String> Permutation(String str) { 
		ArrayList<String> list= new ArrayList<String>(); 
		if (str != null && str.length() > 0) { 
			PermutationHelper(str.toCharArray(), 0, list); 
			Collections.sort(list); 
		} 
		return list; 
		}
	public void PermutationHelper(char[] chars,int start,ArrayList<String> list){
		if (start == chars.length-1) { 
			String val = new String(chars); //手动去重 
			if(!list.contains(val)) 
				list.add(val); 
				return; 
		}
	for(int i=start;i<chars.length;i++){ 
		if(i==start || chars[i] != chars[start]){ //第一位固定情况，第一 位与后面的不同进行交换 
			swap(chars,i,start); 
			PermutationHelper(chars,start+1,list); 
			swap(chars,i,start); 
			} 
		} 
	} 
	void swap(char[] str, int i, int j) { 
		if (i != j) { 
			char t = str[i]; 
			str[i] = str[j]; 
			str[j] = t; 
			} } 
	
	public static void main(String[] args) {
		offer3 offer3 = new offer3();
		System.out.println(offer3.Permutation("abc"));
	}

}
