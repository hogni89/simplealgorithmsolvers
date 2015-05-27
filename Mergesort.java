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

public class Mergesort {

	public static void main(String[] args) {
		int count = args.length;

		// fetch the unsorted list
		ArrayList<Integer> unsorted = new ArrayList<Integer>(count);
		for( int i = 0; i < count; i++) {
			unsorted.add(Integer.parseInt(args[i]));
		}

		ArrayList<Integer> a = new ArrayList<Integer>(3);
		ArrayList<Integer> b = new ArrayList<Integer>(3);

		a.add(3);
		a.add(6);
		a.add(9);

		b.add(1);
		b.add(7);
		b.add(8);

		ArrayList<Integer> result = merge(a,b);

		for(int i = 0; i < 6; i++) {
			System.out.println(result.get(i));
		}
	}

	private static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b) {
		int aLen = a.size();
		int bLen = b.size();
		int count = aLen + bLen;

		ArrayList<Integer> result = new ArrayList<Integer>(count);

		int aPointer = 0;
		int bPointer = 0;
		for(int i = 0; i < count; i++) {

			if( aPointer < aLen && bPointer < bLen ) {
				if(a.get(aPointer) < b.get(bPointer)) {
					result.add(a.get(aPointer));
					aPointer++;
				} else {
					result.add(b.get(bPointer));
					bPointer++;
				}
			} else if( aLen == aPointer ) {
				// Okey, we have used all a elements
				// next element in list is then b element!
				result.add(b.get(bPointer));
				bPointer++;
			} else if( bLen == bPointer ) {
				// Okey, we have used all b elements
				// next element in list is then a element!
				result.add(a.get(aPointer));
				aPointer++;
			}
		}
		return result;
	}
}
