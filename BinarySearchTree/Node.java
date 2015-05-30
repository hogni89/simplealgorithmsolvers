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

public class Node {

	public Node parent;
	public Node left;
	public Node right;
	public int key;

	public Node(int key) {
		this.key = key;
	}

	public void setLeft(Node node) {
		this.left = node;
		node.parent = this;
	}

	public void setRight(Node node) {
		this.right = node;
		node.parent = this;
	}

	public void print() {
		if(left != null) {
			left.print();
		}
		System.out.println(key);
		if(right != null) {
			right.print();
		}
	}

	public void add(Node node) {
		if(node.key < this.key) {
			if(left != null) {
				left.add(node);
			} else {
				setLeft(node);
			}
		} else {
			if(right != null) {
				right.add(node);
			} else {
				setRight(node);
			}
		}
	}

	public Node search(int key) {
		if(this.key == key) {
			return this;
		} else if(this.key > key) {
			return left;
		} else {
			return right;
		}
	}

	/* Not quite impelemented !
	public void delete() {
		// case 1. We delete leaf
		if( left == null && right == null ) {
			if( parent.left != null && parent.left.key == this.key ) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		}

		if( left != null && right == null || left == null && right != null) {
			Node tmp;
			if(left != null) {
				tmp = left;
			} else {
				tmp = right;
			}
			tmp.parent = this.parent;

			if(parent.left != null && parent.left.key == this.key) {
				parent.left = tmp;
			} else {
				parent.right = tmp;
			}
		}

		if( left != null && right != null) {
			if(parent.left != null && parent.left.key == this.key) {
				parent.left = new Node(successor().key);
				parent.left.left = this.left;
				parent.left.right = this.right;
				parent.left.parent = parent;
			} else {
				parent.right = new Node(successor().key);
				parent.right.left = this.left;
				parent.right.right = this.right;
				parent.right.parent = parent;
			}
			successor().delete();
		}
	}*/

	public Node successor() {
		Node successor = right;
		while(successor.left != null) {
			successor = successor.left;
		}
		return successor;
	}
	
}
