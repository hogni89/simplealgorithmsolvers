/**
 * Author: Høgni Beinisson, hogni@it4.fo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.util.ArrayList;
import java.util.Collections;

public class Quicksort {

	public static void main(String[] args) {
		int count = args.length;
		ArrayList<Integer> arr = new ArrayList<Integer>(count);

		// fetch the unsorted list
		for( int i = 0; i < count; i++) {
			arr.add(Integer.parseInt(args[i]));
		}		

		quickSort(arr, 0, count);
	
		for(int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}

	}

	private static void quickSort(ArrayList<Integer> arr, int p, int q) {
		if(p < q) {
			int r = partition(arr, p, q);
			quickSort(arr, p, r-1);
			quickSort(arr, r+1, q);
		}
	}
	
	private static int partition(ArrayList<Integer> arr, int p, int q) {
		int i = p;
		int x = arr.get(p);
		
		for(int j = i+1; j < q; j++) {
			if( arr.get(j) < x ) {
				int tmp = arr.get(i+1);
				arr.set(i+1, arr.get(j));
				arr.set(j, tmp);
				i++;
			}
		}
		
		arr.set(p, arr.get(i));
		arr.set(i, x);
		
		return i;
	}
}
