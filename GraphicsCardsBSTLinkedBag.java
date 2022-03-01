/** 
 * This class is used to create a binary search tree that stores a root or start
 * of the BST.
 * Functions included: setRoot, size, add, search, countOccurrences, contains,
 * countRange, total, remove, displayLowToHigh and addAll.
 * @author Parker Talley
*/


public class GraphicsCardsBSTLinkedBag {
	/**
	 * Stores the root or start of the BSTLinkedBag.
	 */
    private GraphicsCardsBTNode root;

	// Constructor.
    public GraphicsCardsBSTLinkedBag() {
        this.root = null;
    }

	// Setter.
	public void setRoot(GraphicsCardsBTNode root) {
		this.root = root;
	}

	/**
	 * Determines the size of all nodes within the BSTLinkedBag.
	 * @return total ammount of all nodes within the BSTLinkedBag.
	 */
    public int size() {
        return GraphicsCardsBTNode.countNode(root);
    }

	/**
	 * Creates a GraphicsCardsBTNode and adds it to the BSTLinkedBag.
	 * @param element 
	 */
    public void add(GraphicsCards element) {
        GraphicsCardsBTNode newNode = new GraphicsCardsBTNode(element, null, null);
        if(root == null) {
            root = newNode;
        }
        else {
			//if the tree is not empty, start from the root and go down the tree 
            GraphicsCardsBTNode cursor = root;
            GraphicsCardsBTNode parentOfCursor = null;
			
			while (cursor != null){
				//need to keep track of parent of the new node
				parentOfCursor = cursor;
				if(element.getQuanity() <= cursor.getData().getQuanity()) {
					cursor = cursor.getLeft();
				}
				else {
					cursor = cursor.getRight();
				}
			}

			// cursor == null true
	
			if (element.getQuanity() <= parentOfCursor.getData().getQuanity()) {
				parentOfCursor.setLeft(newNode);
			}
			else {
				parentOfCursor.setRight(newNode);
			}
		}
    }

	/**
	 * Search for a node that contains a specified string and display the node.
	 * @param str the string to search for.
	 */
    public void search(String str) {
        if(root == null) {
            System.out.println("There are no nodes in the BST.");
        }
		else {
			root.searchNodeDisplay(str);
		}
    }

	/**
	 * Determines how many of the specified element exist in the 
	 * GraphicsCardsBSTLinkedList.
	 * @param element the element to look for.
	 * @return the number of times the specified element exist in the 
	 * GraphicsCardsBSTLinkedList.
	 */
    public int countOccurrences(GraphicsCardsBTNode element) {
		return countOccurrencesAux(this.root, element);
	}
	
	/**
	 * Auxiliary method for determining if a specific element exist in the 
	 * GraphicsCardsBSTLinkedList.
	 * @param root the start of the GraphicsCardsBSTLinkedList.
	 * @param value the element to searc for.
	 * @return the number of times the specified element exist in the 
	 * GraphicsCardsBSTLinkedList.
	 */
	private int countOccurrencesAux(GraphicsCardsBTNode root, 
        GraphicsCardsBTNode value) {
    	    if (root == null) 
    		    return 0;
    	
    	    int tempCount = 0;
    	    if (root.getData().getName() == value.getData().getName() && 
				root.getData().getQuanity() == value.getData().getQuanity()) 
    		    	tempCount = 1;
    	
    	return tempCount + countOccurrencesAux(root.getLeft(), value) + 
            countOccurrencesAux(root.getRight(), value);
    }

	/**
	 * Determines if the GraphicsCardsBSTLinkedBag contain a specified string.
	 * @param str the specified string to look for.
	 * @return true: if the GraphicsCardsBSTLinkedBag contains the str; false:
	 * if the GraphicsCardsBSTLinkedBag does not contain the str.
	 */
    public boolean contains(String str) {
		return GraphicsCardsBTNode.searchNodeContains(root, str);
    }

	/**
	 * Determines the number of nodes between a specified amount.
	 * @param low the lower amount cut-off.
	 * @param high the higher amount cut-off.
	 * @return the amount of nodes between the specified amount.
	 */
	public int countRange(GraphicsCards low, GraphicsCards high) {
		if(this.root == null) {
			return 0;
		}
		return this.root.getCount(low.getQuanity(), high.getQuanity());
	}

	/**
	 * The total quanity of all GraphicsCardsBTNodes in the BST.
	 * @return the total quanity of all GraphicsCardsBTNodes in the BST.
	 */
	public int total() {
		return GraphicsCardsBTNode.treeSize(this.root);
	}

	/**
	 * Removes the target GraphicsCards from the BST.
	 * @param target the specified GraphicsCards to remove.
	 * @return true: if the target has been removed; false: if the target was 
	 * not removed.
	 */
	public boolean remove(GraphicsCards target){
		
		GraphicsCardsBTNode cursor  = root;
		GraphicsCardsBTNode parentOfCursor = null;
		boolean output = true;
		
		while ((cursor != null) && (cursor.getData() != target)){  // x.equals(y)   !x.equals(y) 
			parentOfCursor = cursor;
			if (target.getQuanity() <= cursor.getData().getQuanity())   // compareTo
				cursor = cursor.getLeft();
			else
				cursor = cursor.getRight();
		}
		
		//Case 1: if cursor is null, target is not found
		if (cursor == null)
			return false;
		else if (cursor.getLeft() == null){
			//case 2: if cursor is root, change root
			if (cursor == root)
				root = cursor.getRight();
			else{
				//case 3: replace cursor with its right subtree
				if (cursor == parentOfCursor.getLeft())
					parentOfCursor.setLeft(cursor.getRight());
				else
					parentOfCursor.setRight(cursor.getRight());
			}	
		}
		else {
			//case 4: replace the cursor with the rightmost element in the left subtree
			cursor.setData(cursor.getLeft().getRightmostData());
			cursor.setLeft(cursor.getLeft().removeRightmost());	
		}
			
		return output;
	}

	/**
	 * Display the GraphicsCardsBTNodes 'inorder'.
	 */
	public void displayLowToHigh() {
		root.inorderPrint();
	}

	/**
	 * Create a copy of the passed BSTLinkedBag and add it to the calling 
	 * BSTLinkedBag.
	 * @param other the BSTLinkedBag to create a copy of.
	 */
	public void addAll(GraphicsCardsBSTLinkedBag other) {
		this.setRoot(GraphicsCardsBTNode.treeCopy(other.root)); ;
	}
}
