public class Sorting {
	
	int[] a = { 3, 34, 5,91, 100}; // an array not containing duplicates
	int target; // the element to be searched
	
	public void linearSearch(int target) {
	this.target = target;
	for( int i=0; i<this.a.length; i++) {
	    if(a[i]==target) {
	        System.out.println ( "Element found at index "+i);
	        break; // break should be omitted if the array contains duplicates
	    }
	}
	}
	
	public void binarySearch(int target) {
		this.target = target; // the element to be searched
		int left = 0;
		int middle;
		int right = this.a.length - 1;
		while (left <= right) {
		    middle = (left + right) / 2;
		    if (a[middle] == target) {
		        System.out.println("Element found at index " + middle);
		        break;
		    } else if (a[middle] < target) {
		        left = middle + 1;
		    } else if (a[middle] > target) {
		        right = middle - 1;
		    }
		}
	}

public static void main(String[] args) {
	
	Sorting sort = new Sorting();
	sort.linearSearch(91);
	sort.binarySearch(91);
	
	
	
}

}

paper
-> Linear Search
-> Binary Seach 
-> Bubble sort

