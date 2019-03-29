import java.io.*;
import java.util.Scanner;
public class SortingAlgorithms {

	public static void main(String[] args) {
		
		try {
			File f = new File("sortingIn.txt"); // open file input
			Scanner scan = new Scanner(f); // create a scanner to scan file f
			
			FileOutputStream fos = new FileOutputStream("sortingOut.txt"); // open file output
			PrintWriter pw = new PrintWriter(fos); // create a printer to print to file output
			
			while (scan.hasNextLine()) { // while the scanner has another line
				
				int arraySize = scan.nextInt(); // read in the array size
				int[] numbers = new int[arraySize]; // add the numbers to an array of int
				
				pw.print("Numbers : "); // print out the numbers
				for (int i = 0; i < arraySize; i++) {
					numbers[i] = scan.nextInt();
					pw.print(numbers[i] + ", ");
				}
				Sorting.selectComp = 0;
				Sorting.selectAssign = 0;
				Sorting.insertAssign = 0;
				Sorting.insertComp = 0;
				Sorting.bubbleAssign = 0;
				Sorting.bubbleComp = 0;
				Sorting.quickAssign = 0;
				Sorting.quickComp = 0;
				Sorting.mergeAssign = 0;
				Sorting.mergeComp = 0;
				pw.println("\n\nSIZE\tSORT\t\tASSIGNMENTS\t\tCOMPARISONS\t\tTOTAL");
				int selectOp = Sorting.selectionSort(arraySize, numbers);
				pw.println(arraySize + "\t\tSelection\t" + Sorting.selectAssign + "\t\t\t\t" + Sorting.selectComp + "\t\t\t\t" + selectOp);
				//pw.println("\n");
				int insertOp = Sorting.insertionSort(arraySize, numbers);
				pw.println(arraySize + "\t\tInsertion\t" + Sorting.insertAssign + "\t\t\t\t" + Sorting.insertComp + "\t\t\t\t" + insertOp);
				//pw.println("\n");
				int bubbleOp = Sorting.bubbleSort(arraySize, numbers);
				pw.println(arraySize + "\t\tBubble\t\t" + Sorting.bubbleAssign + "\t\t\t\t" + Sorting.bubbleComp + "\t\t\t\t"  + bubbleOp);
				//pw.println("\n");
				int quickOp = Sorting.quickSort(numbers, 0, arraySize-1, arraySize);
				pw.println(arraySize + "\t\tQuick\t\t" + Sorting.quickAssign + "\t\t\t\t" + Sorting.quickComp + "\t\t\t\t" + quickOp);
				//pw.println("\n");
				int mergeOp = Sorting.mergeSort(arraySize, numbers, arraySize);
				mergeOp = Sorting.mergeAssign + Sorting.mergeComp;
				pw.println(arraySize + "\t\tMerge\t\t" + Sorting.mergeAssign + "\t\t\t\t" + Sorting.mergeComp + "\t\t\t" + mergeOp);
				pw.print("\n");


				if (selectOp < insertOp && selectOp < bubbleOp && selectOp < quickOp && selectOp < mergeOp) { // if select takes the least amount of operations
					pw.println("Best sort is Select Sort");
				}
				else if (insertOp < selectOp && insertOp < bubbleOp && insertOp < quickOp && insertOp < mergeOp) { // if insert takes the least amount of operations
					pw.println("Best sort is Insert Sort");
				}
				else if (bubbleOp < selectOp && bubbleOp < insertOp && bubbleOp < quickOp && bubbleOp < mergeOp) { // if bubble takes the least amount of operations
					pw.println("Best sort is Bubble Sort");
				}
				else if (quickOp < selectOp && quickOp < insertOp && quickOp < bubbleOp && quickOp < mergeOp) { // if quick takes the least amount of operations
					pw.println("Best sort is Quick Sort");
				}
				else if (mergeOp < selectOp && mergeOp < insertOp && mergeOp < bubbleOp && mergeOp < quickOp) { // if merge takes the least amount of operations
					pw.println("Best sort is Merge Sort");
				}
				
				pw.println("\n//////////////////////////////////////////////////////////////////////\n");
				
			}
			pw.close(); // close the file
			scan.close();


		}
		catch(FileNotFoundException filenotfoundexception) {
			System.out.println("File not found.");
		}
		catch(IOException ioexception) {
			System.out.println("File input error occured!");
			ioexception.printStackTrace();
		}
	}
	

}
