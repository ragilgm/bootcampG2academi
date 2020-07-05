public class TugasArray1 {

	public static void mencetakArray(String[] args) {
		 for(int i = 1; i<4; i++) {
	          System.out.print("args[" + i + "]: " +  args[i]);
	       }
	 }
	 
	   public static void main(String[] args) { 
		   
		   TugasArray array = new TugasArray();
		   
		   int a = Integer.parseInt(args[0]);
		   int result;
		   
		   switch (a) {
		case 1:
			System.out.println("Program Mencetak Array 4");
			mencetakArray(args);
		    break;
		   }
	   }
}

