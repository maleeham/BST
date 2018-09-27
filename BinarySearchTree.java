/** @author 
 *  Binary search tree (starter code)
 **/

package bxk180012;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;


public class BinarySearchTree<T extends Comparable<? super T>> implements Iterable<T> {
    static class Entry<T> {
        T element;
        Entry<T> left, right;
        public Entry(T x, Entry<T> left, Entry<T> right) {
            this.element = x;
            this.left = left;
            this.right = right;
        }
    }
    
    Entry<T> root;
    int size;

    public BinarySearchTree() {
	root = null;
	size = 0;
    }

    /** TO DO: Is x contained in tree?
     */
    public boolean contains(T x) {
    	Entry<T> t = find(x);
    	if(t == null || t.element != x) {
    		return false;
    	} else {
    		return true;
    	}
    }

    /** TO DO: Is there an element that is equal to x in the tree?
     *  Element in tree that is equal to x is returned, null otherwise.
     */
    public T get(T x) {
    	Entry<T> t = find(x);
    	if (t.element.compareTo(x) == 0)
    	{
    		return x;
    	} else {
    		return null;
    	}
    }

    /** TO DO: Add x to tree. 
     *  If tree contains a node with same key, replace element by x.
     *  Returns true if x is a new element added to tree.
     */
    public boolean add(T x) {
    	if (size == 0) {
    		root = new Entry<T>(x, null,null);
    		size++;
    		return true;
    	} else {
    		Entry<T> t = find(x);
    		if(t.element.compareTo(x) == 0) {
    			t.element = x;
    			return false;
    		} else if (x.compareTo(t.element) < 0) {
    			t.left = new Entry<T>(x,null,null);			
    		} else {
    			t.right = new Entry<T>(x,null,null);
    		}
    		size++;
    	}
	return true;
    }

    /** TO DO: Remove x from tree. 
     *  Return x if found, otherwise return null
     */
    public T remove(T x) {
    	T result;
    	if(root ==  null)
    		return null;
    	Entry<T> t= find(x);
    	if (t.element.compareTo(x) != 0)
    		return null;
    	result = t.element;
    	if(t.left == null || t.right == null)
    		byPass(t);
    	else {
    		s.push(t);
    		Entry<T> minRight = find(t.right,x);
    		t.element = minRight.element;
    		byPass(minRight);
    		
    	}
    size--;
	return result;
    }
    void byPass(Entry<T> t) {
    	Entry<T> parent = s.isEmpty()?null:s.peek();
    	Entry<T> child = t.left == null? t.right : t.left;
    	if(parent == null) {
    		System.out.println("ele");
    		root = child;
    	} else if (parent.left == t) {
    		parent.left = child;
    	} else {
    		parent.right = child;
    	}
    }
    

    public T min() {
    	if(size == 0) {
    		return null;
    	} 
    	Entry<T> t = root;    	
    	while(t.left != null) {
    		t = t.left;
    	}   	
	  return t.element;
    }

    public T max() {
    	if(size == 0) {
    		return null;
    	} 
    	Entry<T> t = root;    	
    	while(t.right != null) {
    		t = t.right;
    	}   	
	  return t.element;
    }
    Stack<Entry<T>> s = new Stack<Entry<T>>();
    Entry<T> find(Entry<T> t, T x){
    	if (t==null || t.element == x) {
    		return t;
    	}
    	while(true) {
    		if (x.compareTo(t.element) < 0) {
    			if (t.left ==null)
    				break;
    			else {
    				s.push(t);
    				t = t.left;
    			}
    			
    		} 
    		else if (x == t.element) {
    			//s.push(t);
    			break;
    		}
    		else if (x.compareTo(t.element) > 0) {
    			if(t.right == null)
    				break;
    			else {
    				s.push(t);
    				t = t.right;
    			}
    		}
    	}
    	return t;
    }
    Entry<T> find(T x){
    	return find(root, x);
    }

    // TODO: Create an array with the elements using in-order traversal of tree
    public Comparable[] toArray() {
	Comparable[] arr = new Comparable[size];
	Entry<T> node = root;
	int i = 0;
	while(node != null) {
	    node = node.left;
	    arr[i++] = node.element;
	    node = node.right;
	}
	return arr;
    }

    public void printTree() {
	System.out.print("[" + size + "]");
	printTree(root);
	System.out.println();
    }

    // Inorder traversal of tree
    void printTree(Entry<T> node) {
	if(node != null) {
	    printTree(node.left);
	    System.out.print(" " + node.element);
	    printTree(node.right);
	}
    }

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	 public static void main(String[] args) {
			BinarySearchTree<Integer> t = new BinarySearchTree<>();
		        Scanner in = new Scanner(System.in);
		    	
			      while (in.hasNext()) {
					int com = in.nextInt();
					switch (com) {
					case 1: 
						int numberToInsert = in.nextInt();
						System.out.print("Add " + numberToInsert + " : ");
			            t.add(numberToInsert);
			            t.printTree();
			            break;
					
					case 2:
						int numberToSearch = in.nextInt();
						System.out.print("Search " + numberToSearch + " : ");
			            System.out.println(t.contains(numberToSearch));
			            t.printTree();
			            break;
					case 3:
						int ele = t.min();
			            System.out.println("minimum="+ele);
			            break;
					case 4:
						int element = t.max();
			            System.out.println("maximum="+element);
			            break;
					case 5:
						int numberToremove = in.nextInt();
						System.out.print("remove " + numberToremove + " : ");
			            System.out.println(t.remove(numberToremove));
			            t.printTree();
			            break;
					case 6:
						int numberToget = in.nextInt();
						System.out.print("Get " + numberToget + " : ");
			            System.out.println(t.get(numberToget));
			            t.printTree();
			            break;
					case 7:
					    Comparable[] arr = t.toArray();
		                System.out.print("Final: ");
		                for(int i=0; i<t.size; i++) {
		                    System.out.print(arr[i] + " ");
		                }
		                System.out.println();
					}	
			      }
			      
			      
			      
//		        while(in.hasNext()) {
//		            int x = in.nextInt();
//		            if(x > 0) {
//		             
//		            } 
//		 //               else if(x < 0) {
////		                System.out.print("Remove " + x + " : ");
////		                t.remove(-x);
////		                t.printTree();
////		            } else {
////		               
////		                return;
////		            }           
//		        }
		    }
}
/*
Sample input:
1 3 5 7 9 2 4 6 8 10 -3 -6 -3 0

Output:
Add 1 : [1] 1
Add 3 : [2] 1 3
Add 5 : [3] 1 3 5
Add 7 : [4] 1 3 5 7
Add 9 : [5] 1 3 5 7 9
Add 2 : [6] 1 2 3 5 7 9
Add 4 : [7] 1 2 3 4 5 7 9
Add 6 : [8] 1 2 3 4 5 6 7 9
Add 8 : [9] 1 2 3 4 5 6 7 8 9
Add 10 : [10] 1 2 3 4 5 6 7 8 9 10
Remove -3 : [9] 1 2 4 5 6 7 8 9 10
Remove -6 : [8] 1 2 4 5 7 8 9 10
Remove -3 : [8] 1 2 4 5 7 8 9 10
Final: 1 2 4 5 7 8 9 10 

*/
