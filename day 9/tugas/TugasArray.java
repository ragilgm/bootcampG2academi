//author Ragil Gilang Maulana

//membuat class TugasArray
public class TugasArray {
	
//method untuk membuat array dengan menggunakan parameter args
	public void createArray(String[] args) {
		
// membuat variable dan membuat object dari aray dengan panjang 4
		 int[] array = new int[4];
		 System.out.println("-----------------------------");
		
// looping untuk mengisi dan menampikan data dari masing masing index
	 for(int i = 0; i< array.length; i++) {
		 int value = Integer.parseInt(args[i+1]);
		 array[i] = value;
		 System.out.format("| %s | \t", array[i]);
		
   }
	   System.out.println();
	  System.out.println("-----------------------------");
	}

// method untuk membuat array dimensi
	public void arrayDimensi(String[] args) {
		
// membuat variable array multidimensi dan membuat object array dengan baris 2 dan colom 3
		int[][] multiDimensi = new int[2][3];
		
     // looping untuk mengisi setiap index dari multiDimensi
         for(int kol = 0; kol <3; kol++){
        	 
        	 // variable untuk mendeklarasikan index yang di mulai dari 2
        	 // karna index 1 sudah terisi dengan method dan 2 terisi dengan index
				int value = Integer.parseInt(args[kol+2]);
				
			// variable untuk mendeklarasikan index yang di mulai dari 6
			// karna index 1 - 5 sudah terisi dengan method dan object array sebelumnya
				int value1 = Integer.parseInt(args[kol+6]);
				
			// mengisi baris 1 dan kolom 1;
             multiDimensi[0][kol] = value;
             
            // mengisi baris 2 dan kolom 2
				multiDimensi[1][kol] = value1;
         }

     // menampilkan isi dari multiDimensi
     System.out.println("----------------------");
     
     // looping untuk menampilkan output dari masing masing array ke layar
     for(int bar = 0; bar < multiDimensi.length; bar++){
         for(int kol = 0; kol < multiDimensi[bar].length; kol++){
             System.out.format("| %s | \t", multiDimensi[bar][kol]);
         }
         System.out.println("");
     }
     System.out.println("----------------------");
	}
	 
	// main method
	   public static void main(String[] args) { 

		   // menginisialisasikan object dari TugasArray
		   TugasArray array = new TugasArray();
		   
		   // membuat variable untuk parsing index 0 String ke integer
		   int a = Integer.parseInt(args[0]);	   
		   
		   // membuat condition index 0
		   switch (a) {
		case 1:
			System.out.println("Program Mencetak Array 4");
			
			// case 1 memanggil method createArray
			array.createArray(args);
		    break;
		case 2:
			System.out.println("Program Mencetak Array Multi Dimensi");
			
			// case 2 memanggil method arrayDimensi
			array.arrayDimensi(args);
	        break;   
		case 3:
			// case 3 membuat array copy
			int i;
			System.out.println("original array");
			// original array
			int[] hold = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
			
			// looping untuk menampilkan output dari array Hold ke layar
			for(i = 0; i<hold.length;i++) {
				System.out.print(hold[i]+" ");
			}
			System.out.println();
			
			// membuat array 
			int[] myArray = new int[5];
			System.out.println("coppy array");
			
			// looping untuk mmenampilkan index dari myArray ke layar
			for(i = 0; i<5;i++) {
			myArray[i] = Integer.parseInt(args[i]);
			System.out.print(myArray[i]+" ");
			}
			
			System.out.println();
			
			// looping untuk menampilkan array yang sudah di update dengan array baru
			System.arraycopy(myArray, 0, hold, 0, myArray.length);
			System.out.println("new Array");
			for(i = 0; i < hold.length;i++) {
				System.out.print(hold[i]+" ");
			}
	        break;   
	     
		   }
	   }
}




