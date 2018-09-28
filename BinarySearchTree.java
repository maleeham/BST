/** @author Bahavya Kashetty, bxb180012
 * 			Maleeha Shabeer Koul, msk180001
 *  Binary search tree implementation
 *  Date created: 09/27/2018
 **/

package msk180001;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class BinarySearchTree<T extends Comparable<? super T>> {
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
    Comparable[] inOrder;
    int inOrderIndex = 0;
    
    /**
     * Constructor
     */
    public BinarySearchTree() {
	root = null;
	size = 0;
    }

    /** To check if x is contained in tree
     * @return boolean if element found or not
     * @param Element x of Entry<T> to be found 
     */
    public boolean contains(T x) {
    	Entry<T> t = find(x);
    	if(t == null || t.element != x) {
    		return false;
    	} else {
    		return true;
    	}
    }

    /** If there is an element that is equal to x in the tree.
     *  @return Element in tree that is equal to x, null otherwise.
     *  @param Element to be found
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

    /** Adds x to tree. 
     *  If tree contains a node with same key, replaces element by x.
     *  @return true if x is a new element added to tree.
     *  @param element to be added
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

    /** Removes x from tree. 
     *  @return x if found, else null
     *  @param the element x to be deleted
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
    
    /** Helper method:
     * Pre-condition : 't' has atmost one child
     * @param t
     */
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
    
    /**
     * Get the minimum element of the tree
     * @return t minimum
     */
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

    /**
     * Get the maximum element of the tree
     * @return t maximum
     */
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
    
    //Stack declared as class variable 
    Stack<Entry<T>> s = new Stack<Entry<T>>();
    
    /** Helper method:
     * Finds the entry containing x
     * @param t
     * @param x
     * @return entry containing x
     */
    Entry<T> find(Entry<T> t, T x){
    	if (t==null || t.element == x) {
    		return t;
    	}
    	while(true) {
    		if (x.compareTo(t.element) < 0) {
    			if (t.left == null)
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

    /**
     * Creates an array with the elements using in-order traversal of tree
     * @return array 
     */
    public Comparable[] toArray() {
    this.inOrder = new Comparable[size];
    storeInorder(root);

	return this.inOrder;    
   }


    void storeInorder(Entry<T> node) 
    { 
        if (node == null) 
            return; 
  
        /* first recur on left child */
        storeInorder(node.left); 
  
        /* then store the data of node */
        inOrder[inOrderIndex++] = node.element;
  
        /* now recur on right child */
        storeInorder(node.right);

    } 

    /**
     * Prints the tree
     */
    public void printTree() {
	System.out.print("[" + size + "]");
	printTree(root);
	System.out.println();
    }

    /**
     * Inorder traversal of tree
     * @param node
     */
    void printTree(Entry<T> node) {
	if(node != null) {
	    printTree(node.left);
	    System.out.print(" " + node.element);
	    printTree(node.right);
	}
    }

	/**
	 * DRIVER CLASS / MAIN CLASS
	 * @param args
	 * SWITCH CASE:
	 * 		case 1: ADD element
	 *  	case 2: SEARCH element
	 *   	case 3: MINIMUM element
	 *    	case 4: MAXIMUM element
	 *     	case 5: REMOVE element
	 *      case 6: GET element
	 *      case 7: ARRAY element 		
	 */
	 public static void main(String[] args) {
			BinarySearchTree<Integer> t = new BinarySearchTree<>();
		        Scanner in = new Scanner(System.in);
		    	System.out.println("PRESS:"+"\n1 for add \n2 for search\n3 for minimum\n4 for maximum\n5 for remove\n6 for get\n7 for array");
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
		    }
}
