package leetCode;

public class leeCode_338 {
	public int[] countBits(int num) {
	    int[] ret = new int[num + 1];
	    for(int i = 1; i <= num; i++){
	        ret[i] = ret[i&(i-1)] + 1;	//•n&(n-1) 去除 n 的位级表示中最低的那一位。
	    }
	    return ret;
	}
	
	public static void main(String[] args) {
		leeCode_338 leeCode_338 = new leeCode_338();
		leeCode_338.countBits(6);
	}
}
