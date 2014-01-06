package array;


/** Given two strings, write a method to decide
 * if one is a permutation of the other
 * @author zhouqing
 *
 */
public class CC1dot3 {
	private int[] flag1=new int[256];
	private int[] flag2=new int[256];
	
	/** store str1 and str2 to the 256 hashArray,
	 * test if each array element contains the same number of
	 * characters.
	 * 
	 * TimeC-->O(n)
	 * @param str1
	 * @param str2
	 * @return
	 */
	public boolean testPermutation(String str1,String str2){
		
		for(int i=0;i<256;i++){
			flag1[i]=0;
			flag2[i]=0;
		}
		
		for(int i=0;i<str1.length();i++){
			flag1[str1.charAt(i)]++;
		}
		for(int i=0;i<str2.length();i++){
			flag2[str2.charAt(i)]++;
		}
		
		for(int i=0;i<256;i++){
			if(flag1[i]!=flag2[i])
				return false;
		}
		
		return true;
		
	}

	public static void main(String[] args){
		
		String str1="hahahahahah";
		String str2="ahahahahaha";
		CC1dot3 tester=new CC1dot3();
		
		System.out.print(str1+" : "+str2+" --> "+tester.testPermutation(str1, str2));
		
	}
}
