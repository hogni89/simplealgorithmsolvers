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

public class Heapsort {

	public static void main(String[] args) {
		int count = args.length;

		// fetch the unsorted list
		ArrayList<Integer> heap = new ArrayList<Integer>(count);
		heap.add(-1);
		for( int i = 1; i < count; i++) {
			heap.add(Integer.parseInt(args[i]));
		}

		int size = count / 2;
		for(int i = size; i > 0; i--) {
			maxHeapify(heap, i);
		}

		for(int i = 1; i < count; i++) {
			System.out.println(heap.get(i));
		}
	}

	public static void maxHeapify(ArrayList<Integer> heap, int index) {
		int largest = index;
		int left = getLeft(index);
		int right = getRight(index);
		if(left < heap.size() && heap.get(left) > heap.get(index)) {
			largest = left;
		} else if(right < heap.size() && heap.get(right) > heap.get(largest)) {
			largest = right;
		}
		if(largest != index) {
			Collections.swap(heap, index, largest);
			maxHeapify(heap, largest);
		}
	}

	public static int getLeft(int index) {
		return (index * 2);
	}

	public static int getRight(int index) {
		return ((index * 2) + 1);
	}
}
