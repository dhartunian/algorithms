import java.io.BufferedReader;
import java.util.Arrays;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class InversionCounter {
	
	static int[] mylist;
	
	public static int countInversions(int[] mysublist) {
		if (mysublist.length == 1) return 0;
		else {
			int half = mysublist.length / 2;
			int[] leftlist =  Arrays.copyOfRange(mysublist, 0, half);
			int[] rightlist = Arrays.copyOfRange(mysublist, half, mysublist.length);
			int left = countInversions(leftlist);
			int right = countInversions(rightlist);
			int split = countSplitInversions(leftlist, rightlist);
			return left + right + split;
		}
	}
	
	public static int countSplitInversions(int[] leftlist, int[] rightlist) {
		Arrays.sort(leftlist);
		Arrays.sort(rightlist);
		int i = 0;
		int j = 0;
		int inversions = 0;
		while (i < leftlist.length && j < rightlist.length) {
			if (rightlist[j] < leftlist[i]) {
				inversions = inversions + leftlist.length - i;
				j++;
			} else {
				i++;
			}
		}
		return inversions;
	}
	
	public static void main(String[] args) {
//		int[] left = {1, 3, 5};
//		int[] right = {2, 4, 6};
//		int[] both = {1,3,5,2,4,6};
//		int inversions = countSplitInversions(left, right);
//		int inversions = countInversions(both);
//		System.out.println(inversions);
//		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		try {
			BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream("IntegerArray.txt")));
			mylist = new int[100000];
			try {
				String line = r.readLine();
				int i = 0;
				while (line != null && !line.equals("")) {
					mylist[i] = Integer.parseInt(line);
					i++;
					line = r.readLine();				
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(countInversions(mylist));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}