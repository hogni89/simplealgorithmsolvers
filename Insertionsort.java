import java.util.ArrayList;
import java.util.Collections;

public class Insertionsort {

	public static void main(String[] args) {
		int count = args.length;

		// fetch the unsorted list
		ArrayList<Integer> unsorted = new ArrayList<Integer>(count);
		for( int i = 0; i < count; i++) {
			unsorted.add(Integer.parseInt(args[i]));
		}

		// Sort the list - the first element is sorted!
		for( int pointer = 1; pointer < count; pointer++ ) {
			// store tmp pointer
			int tp = pointer;
			// As long as the element at pointer is less than
			// element at pointer - 1, then swap
			while(tp >= 1 && ( unsorted.get(tp) < unsorted.get(tp-1)) ) {
				int tmp = unsorted.get(tp-1);
				unsorted.set(tp-1, unsorted.get(tp));
				unsorted.set(tp, tmp);
				tp--;
			}
		}

		for(int i = 0; i < count; i++) {
			System.out.println(unsorted.get(i));
		}

	}
}
