package array;

/** Implement an algorithm to determine if a string has all unique characters,
 * What if you cannot use additional data structures?
 * @author zhouqing
 *
 */

public class CC1dot1 {

	private boolean[] flag = new boolean[256];
	
	public boolean testUniqueString(String str){
		
		for(int i=0;i<256;i++){
			
			flag[i]=false;
		}
		
		for(int j=0;j<str.length();j++){
			
			if(flag[str.charAt(j)]==true){
				return false;
			}
			flag[str.charAt(j)]=true;
		}
		
		return true;
		
	}
	
	public static void main(String[] args) {
		
		String a="abcdefgg";
		
		CC1dot1 tester=new CC1dot1();
		
		System.out.println("result for "+a+" :"+tester.testUniqueString(a));
		
		
	}
	
	
}