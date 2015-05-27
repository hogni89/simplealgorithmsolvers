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
