package Week6Day1;

public class StringCla {

	public static void main(String[] args) {
		
		String s = "Welcome-java";
		String s1 = s.replace('-', ' ');
		System.out.println(s1);
		char[] ch = s1.toCharArray();
		
		
		int l = s.length();
		
		for(int i =l-1; i>=0; i--) {
//			if (ch.equals('e')) {
//				
//			}
			System.out.print(ch[i]);
		}
		
		

	}

}
