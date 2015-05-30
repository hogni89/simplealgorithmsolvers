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

public class BinarySearchTree {

	public static void main(String[] args) {
		int count = args.length;

		// fetch the unsorted list
		ArrayList<Integer> arr = new ArrayList<Integer>(count);
		for( int i = 0; i < count; i++) {
			arr.add(Integer.parseInt(args[i]));
		}

		Node tree = new Node(arr.get(0));

		for( int i = 1; i < arr.size(); i++) {
			tree.add(new Node(arr.get(i)));
		}
	}
}
