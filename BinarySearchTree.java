package msk180001;

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
    
   
    /** Check if x is contained in tree
     * @returns true is x is contained in tree, false otherwise
     * @param x: the element to be checked
     */
    public boolean contains(T x) {
    	T element= get(x);
    	//if( element==null || T.element  )
	return false;
	else
		return true;
    }

    /** Checks if there is an element that is equal to x in the tree?
     *  @return Element in tree that is equal to x, null otherwise.
     *  @param x: the element to be found
     */
    public T get(T x) {
    	
	return null;
    }

    /** Adds x to tree. 
     *  If tree contains a node with same key, replaces the element by x.
     *  @return true if x is a new element added to tree.
     *  @param x: the element to be added
     */
    public boolean add(T x) {
    	if( .size()=0){
    		root= new Entry(x,null,null);
    		size=1;
    		return true;
    		else{
    			
    		}
    		
    				
    	}
	return true;
    }

    /** Removes x from tree. 
     *  @return x if found, otherwise return null
     *  @param x: the element to be removed
     */
    public T remove(T x) {
	return null;
    }

    
    /** @returns the minimum element of the tree
     */
    public T min() {
	return null;
    }

    /** @returns the maximum element of the tree
     */
    public T max() {
        return null;
    }

    // TODO: Create an array with the elements using in-order traversal of tree
    public Comparable[] toArray() {
	Comparable[] arr = new Comparable[size];
	/* write code to place elements in array here */
	return arr;
    }


	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}



	public static void main(String[] args) {
		BinarySearchTree<Integer> t = new BinarySearchTree<>();
	        Scanner in = new Scanner(System.in);
	        while(in.hasNext()) {
	            int x = in.nextInt();
	            if(x > 0) {
	                System.out.print("Add " + x + " : ");
	                t.add(x);
	                t.printTree();
	            } else if(x < 0) {
	                System.out.print("Remove " + x + " : ");
	                t.remove(-x);
	                t.printTree();
	            } else {
	                Comparable[] arr = t.toArray();
	                System.out.print("Final: ");
	                for(int i=0; i<t.size; i++) {
	                    System.out.print(arr[i] + " ");
	                }
	                System.out.println();
	                return;
	            }           
	        }
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
