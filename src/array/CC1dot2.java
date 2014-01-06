package array;

/** Implement a function void reverse(String str) 
 * which reverses a null terminated string 
 * @author zhouqing
 *
 */

public class CC1dot2 {

	public String reverse(String str){
		
		StringBuilder sbu=new StringBuilder(str);
		int len=str.length();
		
		for(int i=0;i<len/2;i++){
			char temp=sbu.charAt(i);
			sbu.deleteCharAt(i);
			sbu.insert(i,sbu.charAt(len-i-2));
			sbu.deleteCharAt(len-i-1);
			sbu.insert(len-i-1, temp);	
		}
		return sbu.toString();
	}
	
	public static void main(String [] args){
		
		String str1="hello!!";
		CC1dot2 tester=new CC1dot2();

		System.out.println(str1+": "+tester.reverse(str1));
		
	}
	
}
