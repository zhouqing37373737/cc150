package array;

/**Write a method to replace all spaces in a string with "%20",you may
 * assume that the string has sufficient space at the end of the 
 * string to hold the additional characters, and that you are given
 * the "true" length of the string.
 * Please use character array if implement in java
 * 
 * @author zhouqing
 *
 */

public class CC1dot4 {
	
	/** examine every character, if a space(not consecutive),
	 * push back the rest part and insert,if a space(consecutive)
	 * move forward the rest.
	 * 
	 * TimeC O(n^2)
	 * @param str
	 * @return
	 */
	public String replaceSpace(String str){
		
		char[] strcc=str.toCharArray();
		char[] strc=new char[256];
		int len=str.length();
		for(int i=0;i<str.length();i++){
			strc[i]=strcc[i];
		}
		
		
		for(int i=0;i<len;i++){
			
			if(strc[i]==' '){
				//no-consecutive
				if(strc[i+1]!=' '){
				//move forward 2 chars
					for(int j=len-1;j>i;j--){
						strc[j+2]=strc[j];			
					}
				
					strc[i]='%';
					strc[i+1]='2';
					strc[i+2]='0';
					
					len+=2;
				}
				//consecutive
				else{
					//move back 1 char
					for(int j=i+1;j<len;j++){
						strc[j-1]=strc[j];
					}
					len-=1;
					//MISTAKE!!
					i-=1;
				}
				
			}
		}
		
	 StringBuilder sbu=new StringBuilder();
	 for(int i=0;i<len;i++){
		 sbu.append(strc[i]);
	 }
	 
	 return sbu.toString();
		
	}

	/**REVERSE traversing
	 * 
	 * Interacting Spaces,GUARANTEE when origin is mapped to new, the character in new is priorly mapped.
	 *  
	 * when you are sure every character
	 * is after its original place, start from the
	 * back; else if every character is prior to its
	 * original place, start from the beginning
	 * 
	 * this method overlooks multiple spaces, as is the CC answer
	 * TimeC-->O(n)
	 * 
	 * @param str
	 * @param len
	 * @return
	 */
	public String replaceSpace2(char[] str,int len){
		
		int spaceNum=0;
	
		for(int i=0;i<len;i++){
			if(str[i]==' ')
				spaceNum++;
		}

		
		int newlen=len+spaceNum*2-1;
		for(int i=len-1;i>=0;i--){
			
			if(str[i]==' '){
				
				str[newlen]='0';
				str[newlen-1]='2';
				str[newlen-2]='%';
				newlen-=3;
			}
			
			else{
				
				str[newlen]=str[i];
				newlen--;
			}			
			
		}
		StringBuilder sbu=new StringBuilder();
		for(int i=0;i<len+spaceNum*2;i++){
			sbu.append(str[i]);
		}
		return sbu.toString();
	}
	
	public static void main(String args[]){
		
		String str="ha    s haha   ha   h";
	    char[] strc=new char[256];
	    for(int i=0;i<str.length();i++){
	    	strc[i]=str.charAt(i);
	    }
	    
		CC1dot4 tester=new CC1dot4();
		
		System.out.println(str+" --> "+tester.replaceSpace2(strc, str.length()));
		
		
	}
	
}
