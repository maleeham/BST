README.txt file for BinarySearchTree.java
Date Created: 09/27/2018

@author: Koul Maleeha msk180001
		

Purpose of the class:
	Implementation of Binary Search Tree Data structure	
	
	Class variables:
		Entry<T> stores generic value for each entry type
		root: Entry type variable stores root of the tree
		size: Holds the current size of the tree
		Stack s: Holds the path from root to parent of t
		
	Methods:
		add: Adds a new element to the tree; Replaces the element if it already exists
		remove: Removes the element
		get: returns the element if present
		minimum: Returns the minimum value found in the tree
		maximum: Returns the maximum value found in the tree
		search: Looks up for an element in the tree
		toArray[]: Passes the elements of the tree in an array
		Helper methods used:
				find(T x): to find the element
				bypass(t): to bypass an element
				printTree(): prints the tree
				inOrder(): traverses the tree in in-order
		
Requirements:
	JAVA virtual machine
	Any IDE with JAVA support for ease.
	

Running the file:
		1. Run the java class file using any IDE with JAVA support or using javac command from CMD.
		2. The main class (driver file) is equipped with a switch case with the following format:
				SWITCH CASE:
					case 1: ADD element
					case 2: SEARCH element
					case 3: MINIMUM element
					case 4: MAXIMUM element
					case 5: REMOVE element
					case 6: GET element
					case 7: ARRAY element 
			Select the desired operation using the correspong case number.
		*For testing the functionality of all the functions, it is recommended to add some elements first to the Binary Search Tree using case 1 which is ADD.
			
		
		
**This project was build in JAVA using Eclipse IDE
		
