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
		ArrayList<ArrayList> arrays = new ArrayList<ArrayList>();


		// fetch the unsorted list
		for( int i = 0; i < count; i++) {
			ArrayList<Integer> innerList = new ArrayList<Integer>();
			innerList.add(Integer.parseInt(args[i]));
			arrays.add(innerList);
		}


		while(arrays.size() > 1) {
			ArrayList<ArrayList> tmpList = new ArrayList<ArrayList>();
			int i = 0;
			while(i < arrays.size()) {

				if(i+1 < arrays.size()) {
					// Add two lists
					tmpList.add( merge(arrays.get(i), arrays.get(i+1)) );
				} else {
					// Nothing to merge. Just add last element
					tmpList.add( arrays.get(i) );
				}
				// Increment i with two
				i = i + 2;
			}
			arrays = tmpList;
		}

		ArrayList<Integer> innerList = arrays.get(0);
		for(int i = 0; i < innerList.size(); i++) {
			System.out.println(innerList.get(i));
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
