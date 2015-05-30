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

public class Countingsort {

	public static void main(String[] args) {
		int count = args.length;

		// fetch the unsorted list
		ArrayList<Integer> arr = new ArrayList<Integer>(count);
		for( int i = 0; i < count; i++) {
			arr.add(Integer.parseInt(args[i]));
		}

		ArrayList<Integer> c = getCountArray(arr);
		ArrayList<Integer> aggr = aggregateCountingArray(c);
		ArrayList<Integer> r = concat(aggr, arr);

		for(int i = 0; i < r.size(); i++) {
			System.out.println(r.get(i));
		}
	}

	private static int getK(ArrayList<Integer> arr) {
		int k = 0;
		for(int i = 0; i < arr.size(); i++) {
			if(arr.get(i) > k) {
				k = arr.get(i);
			}
		}
		return k;
	}

	private static ArrayList<Integer> concat(ArrayList<Integer> aggr, ArrayList<Integer> arr) {
		ArrayList<Integer> result = new ArrayList<Integer>(arr.size());
		for(int i = 0; i < arr.size(); i++) {
			result.add(0);
		}
		for( int i = 0; i < arr.size(); i++) {
			int pos = aggr.get(arr.get(i));
			result.set(pos, arr.get(i));
			aggr.set(arr.get(i), pos+1);
		}
		return result;
	}

	private static ArrayList<Integer> aggregateCountingArray(ArrayList<Integer> c) {
		ArrayList<Integer> aggr = new ArrayList<Integer>(c.size());
		aggr.add(0);
		for( int i = 1; i < c.size(); i++) {
			aggr.add(c.get(i-1) + aggr.get(i-1));
		}
		return aggr;
	}

	private static ArrayList<Integer> getCountArray(ArrayList<Integer> arr) {
		int k = getK(arr);

		ArrayList<Integer> c = new ArrayList<Integer>(k+1);
		for( int i = 0; i < k+1; i++ ) {
			// init to 0
			c.add(0);
		}

		for( int i = 0; i < arr.size(); i++) {
			int cIndex = arr.get(i);
			int cCount = c.get(cIndex);
			c.set(cIndex, cCount+1);
		}

		return c;
	}

	
}
