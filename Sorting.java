
public class Sorting {
	//////////////////////////////////////
	// Assign global variables for each sort's assignments and comparisons
	public static int mergeComp;
	public static int mergeAssign;

	public static int selectComp;
	public static int selectAssign;

	public static int insertComp;
	public static int insertAssign;

	public static int bubbleComp;
	public static int bubbleAssign;

	public static int quickComp;
	public static int quickAssign;

	//////////////////////////////////////
	// Selection Sort
	public static int selectionSort(int arraySize, int[] numbers) {
		int minIndex;
		boolean minFound = false;
		selectAssign++; // minFound assigned to false
		
		selectAssign++; // Initial assignment of i in loop
		selectComp++; // initial comparison of array size and i
		for (int i = 0; i < arraySize-1; i++) {
			minIndex = i;
			selectComp++; // looping comparison of i and array size
			selectAssign += 2; // looping assignment of i++ and minIndex to i
			
			selectAssign++; // initial assignment of j
			selectComp++; // initial comparison of j and arraysize
			for (int j = i+1; j < arraySize; j++) {
				selectComp++; // looping comparison of j and arraysize
				selectAssign++; // looping assignment of j++
				
				selectComp++; // comparison of numbers array at index j and i
				if (numbers[j] < numbers[i]) {
					minIndex = j;
					minFound = true;
					selectAssign += 2; // assignment of minIndex and minFound
					
					selectComp++; // if the minimum comparison to true or false
					if (minFound) {
						swap(numbers, i, minIndex);
						selectAssign += 3; // see swap method for three assignments
					}
				}
			}
			minFound = false;
			selectAssign++;
		}
		int totalSelect = selectAssign + selectComp;
		//System.out.print(arraySize + " \t Selection \t " + selectAssign + " \t\t " + selectComp + " \t\t " + totalSelect);

		return totalSelect;
	}
	//////////////////////////////////////
	// Insertion Sort
	public static int insertionSort(int arraySize, int[] numbers) {
		
		insertAssign++; // initial assignment of i = 2
		insertComp++; // initial comparison of i and arraySize
		for(int i = 2; i <= arraySize; i++) {
			insertComp++; // looping comparison of i and arraySize
			insertAssign++; // looping assignment of i++
			
			int sort = numbers[i-1];
			int s = i -2;
			insertAssign += 2; // assignment of sort and s
			
			insertComp += 3; // initial comparison in while loop
			while (s >= 0 && sort < numbers[s]) {
				
				numbers[s+1] = numbers[s];
				s--;
				insertAssign += 2; // looping assignment of numbers at index s+1 to s
				insertComp += 3; // looping while comparison
			}
		}

		int totalInsert = insertAssign + insertComp;
		//System.out.print(arraySize + " \t Insertion \t " + insertAssign + " \t\t " + insertComp + " \t\t " + totalInsert);
		return totalInsert;
	}
	//////////////////////////////////////
	// Bubble Sort
	public static int bubbleSort(int arraySize, int[] numbers) { 
		boolean swap; // initialize swap boolean value
		
		do { // do while swap is set to true
			bubbleComp++; // looping comparison of swap == true
			
			swap = false;
			bubbleAssign++; // assignment of swap to false
			
			bubbleAssign++; // initial assignment of i to 0
			bubbleComp++; // initial comparison of i and arraysize
			for (int i = 0; i < (arraySize-1); i++) {
				bubbleComp++; // looping comparison of i and arraysize
				bubbleAssign++; // looping assignment of i++
				
				bubbleComp++; // comparison of numbers at index i and i+1
				if (numbers[i] > numbers[i+1]) {
					swap(numbers, i, i+1);
					bubbleAssign += 4; // assignments found in swap method and setting swap to true
					swap = true;
					
				}
			}
		} while (swap == true);
		bubbleComp++;

		int totalBubble = bubbleAssign + bubbleComp;
		//System.out.print(arraySize + " \t Bubble \t " + bubbleAssign + " \t\t " + bubbleComp + " \t\t " + totalBubble);

		return totalBubble;
	}
	//////////////////////////////////////
	// Quick Sort
	public static int quickSort(int[] numbers, int start, int last, int arraySize) {
		quickComp++; // comparison of last-start and 1
		if(last-start >= 1) {
			int pivotIndex;

			pivotIndex = quickPartition(numbers, start, last);
			
			quickAssign++; // pivot index assignment to quickPartition method results

			quickSort(numbers, start, pivotIndex-1, arraySize);
			quickSort(numbers, pivotIndex+1, last, arraySize);
		}
		//if (last==start) {
		int totalQuick = quickComp + quickAssign;
		//	System.out.print(arraySize + " \t Quick \t\t " + quickAssign + " \t\t " + quickComp + " \t\t " + totalQuick);
		//}
		return totalQuick;
	}
	// Partition method of Quick Sort
	public static int quickPartition(int[] a, int low, int high) {
		int pi = low;
		int pivot = a[low];
		quickAssign += 2; // assignment of pi and pivot
		
		quickComp++; // initial comparison of low < high in do-while
		do {
			
			quickComp += 3; // initial 3 comparisons in while loop
			while (low <= high && a[low] <= pivot) {
				quickAssign++; // Assignment of low++ 
				low++;
				quickComp+= 3; // looping comparison in while loop
			}
			
			quickComp++; // initial while comparison
			while (a[high] > pivot) {
				quickAssign++;
				high--;
				quickComp++; // looping comparison of while loop
			}
			
			quickComp++; // initial comparison of low < high
			if (low < high) {
				quickAssign += 3; // Assignments found in swap method
				swap(a, low, high);
			}
		} while (low < high);
		
		swap(a, pi, high);
		quickAssign += 3; // assignments found in swap method
		
		pi = high;
		quickAssign++;// assignment of pi = high
		
		return pi;
	}
	//////////////////////////////////////
	// Merge Sort
	public static int mergeSort(int arraySize, int[] numbers, int size) {
		mergeComp++; // comparison of arraySize and 2
		if (arraySize < 2) {
			return mergeComp + mergeAssign;
		}

		int mid = arraySize / 2;
		int[] l = new int[mid];
		int[] r = new int[arraySize - mid];
		mergeAssign += 3; // assignment of mid, l, and r
		
		mergeAssign++; // initial assignment of i = 0
		mergeComp++; // initial comparison of i and mid
		for (int i = 0; i < mid; i++) {
			mergeComp++; // looping comparison of i and mid
			l[i] = numbers[i];
			mergeAssign+= 2; // looping assignment of i++ and l[i]
		}
		
		mergeAssign++; // initial assignment of i = mid
		mergeComp++; // initial comparison of i and arraysize
		for (int i = mid; i < arraySize; i++) {
			r[i - mid] = numbers[i];
			mergeAssign += 2; // looping assignment of i++ and r at index i-mid
			mergeComp++; // looping comparison of i and arraysize
		}
		
		mergeSort(mid, l, size);
		int totalMerge = mergeSort(arraySize - mid, r, size);
		merge(numbers, l, r, mid, arraySize - mid, size);

		return totalMerge;

	}

	public static void merge(int[] a, int[] l, int[] r, int left, int right, int size) {

		int i = 0;
		int j = 0;
		int k = 0;
		mergeAssign+= 3; // assigning i, j, and k
		
		mergeComp += 3; // while loop initial comparison
		while (i < left && j < right) {
			mergeComp += 3; // looping comparison
			
			mergeComp++; // comparison in if
			if (l[i] <= r[j]) {
				a[k++] = l[i++];
				mergeAssign++; // assigning array a element to array l element at k and i
			}
			else {
				a[k++] = r[j++];
				mergeAssign++; // assignment of array a at k+1 to r at j+1
			}
			mergeComp++;
		}
		mergeComp++; // initial comparison
		while (i < left) {
			mergeComp++; // looping comparison
			a[k++] = l[i++];
			mergeAssign++; // assignment of array a at k+1 to l at i+1
		}
		
		mergeComp++; // initial comparison
		while (j < right) {
			mergeComp++; // looping comparison
			a[k++] = r[j++];
			mergeAssign++; // assignment of array a at k+1 to l at j+1
		}

	}
	//////////////////////////////////////
	// Swap method
	public static void swap(int[] array, int low, int high) {
		int temp = array[low]; // Temporary value assigned to lower of two values
		array[low] = array[high]; // lower value in array assigned to high value
		array[high] = temp; // high value assigned to initial low value stored in the temp value
	}


}
