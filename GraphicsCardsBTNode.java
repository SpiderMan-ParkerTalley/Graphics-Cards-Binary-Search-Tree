/** 
 * This is class is used to create GraphicsCards nodes that will be used in a 
 * binary search tree.
 * Functions include: getters/setters, isLeaf, treeSize, treeCopy, 
 * preorderPrint, postorderPrint, inorderPrint, removeRightmost, removeLeftmost,
 * and treeSum.
 * @author Parker Talley
*/

public class GraphicsCardsBTNode {
    /**
     * Stores the data of the node.
     */
    private GraphicsCards data;
    
    /**
     * Stores the location of the node to the left of the current node.
     */
    private GraphicsCardsBTNode left;

    /**
     * Stores the location of the node to the left of the current node.
     */
    private GraphicsCardsBTNode right;

    // Constructor(s)
    public GraphicsCardsBTNode(GraphicsCards data) {
        this.data = data;
    }
    // Overloaded Constructor
    public GraphicsCardsBTNode(GraphicsCards initialData, 
        GraphicsCardsBTNode initialLeft, GraphicsCardsBTNode initialRight) {
            this.data = initialData;
            this.left = initialLeft;
            this.right = initialRight;
    }

    // Setter(s)
    public void setData(GraphicsCards data) {
        this.data = data;
    }

    public void setLeft(GraphicsCardsBTNode left) {
        this.left = left;
    }

    public void setRight(GraphicsCardsBTNode right) {
        this.right = right;
    }

    // Getter(s)
    public GraphicsCards getData() {
        return data;
    }

    public GraphicsCardsBTNode getLeft() {
        return left;
    }

    public GraphicsCardsBTNode getRight() {
        return right;
    }

    /**
     * Grabs the left most data from the calling nodes perspective and returns 
     * it.
     * @return the GraphicsCards that is left most.
     */
    public GraphicsCards getLeftmostData() {
        if (this.left == null)
			return this.data;
		else
			return this.left.getLeftmostData();
    }

    /**
     * Grabs the right most data from the calling nodes perspective and returns
     * it.
     * @return the GraphicsCards that is right most.
     */
    public GraphicsCards getRightmostData() {
        if (right == null)
			return data;
		else
			return right.getRightmostData();
    }

    /**
     * Deterines if a GraphicsCardsBTNode is a leaf or not.
     * @return true: if the BTNode is a leaf, meaning it has no children.
     * false: if the BTNode is not a leaf, meaning it has atleast one child.
     */
	private boolean isLeaf() {
		return (this.left == null) && (this.right == null);
	}

    /**
     * Determines how many nodes are linked to the root.
     * @param root the starting point of the binary search tree.
     * @return the amound of nodes that are linked to the root.
     */
	public static int treeSize(GraphicsCardsBTNode root) {
		if (root == null)
			return 0;
		else
            // 1 (for the root) + nodes from left + node from right.
			return 1 + treeSize(root.left) + treeSize(root.right); 
	}

    /**
     * Creates a copy of a GraphicsCardsBTNode and all other nodes attached.
     * @param root the starting point to make a copy of.
     * @return a copy of a GrpahicsCardsBTNode and all other nodes attached.
     */
    public static GraphicsCardsBTNode treeCopy(GraphicsCardsBTNode root) {
        if(root == null) {
            return null;
        }
        else {
            GraphicsCardsBTNode leftCopy = treeCopy(root.getLeft());
            GraphicsCardsBTNode rightCopy = treeCopy(root.getRight());
            return new GraphicsCardsBTNode(root.data, leftCopy, rightCopy);
        }
    }

    /**
     * Displays all nodes attached from left - root - right.
     */
	public void preorderPrint() {
		System.out.print(this.data + "\t");
		if (left != null)
			left.preorderPrint();
		if (right != null)
			right.preorderPrint();
	}

    /**
     * Displays all nodes attached from root - left - right.
     */
	public void postorderPrint() {
		if (left != null)
			left.postorderPrint();
		if (right != null)
			right.postorderPrint();

		System.out.print(this.data + "\t");
	}

    /**
     * Displays all nodes attached from lift - right - root.
     */
	public void inorderPrint() {
		if (left != null)
			left.inorderPrint();
		System.out.print(data + "\t");
		if (right != null)
			right.inorderPrint();
	}

    /**
     * Removes and returns the rightmost node from the calling node.
     * @return the rightmost node from the calling node.
     */
    public GraphicsCardsBTNode removeRightmost() {
        if (right == null)
			return left;
		else {
			right = right.removeRightmost();
			return this;
		}
	}

    /**
     * Removes and returns the leftmost node from the calling node.
     * @return the leftmost node from teh calling node.
     */
    public GraphicsCardsBTNode removeLeftmost() {
		if (left == null)
			return right;
		else {
			left = left.removeLeftmost();
			return this;
		}
	}

    /**
     * Determines the qunaity of GraphicsCardsNode and all GraphicsCardsNode(s)
     * that are attached to the calling node.
     * @param node the starting point to count the quanity of GraphicsCard(s).
     * @return the total quanity of all GraphicsCardsNode(s).
     */
    public static int treeSum(GraphicsCardsBTNode node) {
		if(node == null) {
			return 0;
		}
		else if(node.isLeaf()) {
			return node.getData().getQuanity();
		}
		else {
			return node.getData().getQuanity() + treeSum(node.getLeft()) + 
                treeSum(node.getRight());
		}
	}

    /**
     * Searchs the node for a specified string and displays the node's
     * information if a match is found.
     * @param str the string to search for.
     */
    public void searchNodeDisplay(String str) {
        if(this.getData().getName() == str) {
            System.out.println(this.getData() + " ");
        }
		if(this.getLeft() != null)
			this.getLeft().searchNodeDisplay(str);
		if(this.getRight() != null)
			this.getRight().searchNodeDisplay(str);
	}

    /**
     * Searches a specified node to determine if it contains a string. Uses 
     * recursion to check if the node contains a left or right child node and 
     * calls the function if true.
     * @param node the specified node to determine if it contains the string.
     * @param str the specified string to search the for.
     * @return true: if the string if found; false: if the string is not found.
     */
    public static boolean searchNodeContains(GraphicsCardsBTNode node, String str) {
        /* Not contained if specified string is null. */
        if (str == null) {
            return false;
        }
        /* Determines if the node's data is not null AND if the node's name is
        equal to the str. */
        if((node.getData() != null) && (node.getData().getName() == str)) {
            return true;
        }
        /* Recusion, determines if the right side has a value and 
        calls function again if it does. */
        if((node.getRight() != null) && searchNodeContains(node.getRight(), str)){
            return true;
        }
        /* Recusion, determines if the left side has a value and 
        calls function again if it does. */
        if((node.getLeft() != null) && searchNodeContains(node.getLeft(), str)) {
            return true;
        }
        /* If none of the if statements are true, str is not found and return 
        false.*/
        return false;
    }

    /**
     * Determines the number of nodes that are connected to the element.
     * @param element the starting point to count all connected element(s).
     * @return the number of elements attached OR connected to element.
     */
    public static int countNode(GraphicsCardsBTNode element) {
        // base case
        if(element == null) {
            return 0;
        }
        // recursive calling to left child and right child
        return 1 + countNode(element.left) + countNode(element.right);
    }

    /**
     * Determines the number of nodes within the specified values.
     * @param low 
     * @param high
     * @return
     */
    public int getCount(int low, int high) {
        // Base Case
        if(this.getData() == null) {
            return 0;
        }
 
        // If current node is in range, then
        // include it in count and recur for
        // left and right children of it
        if(this.getData().getQuanity() >= low && this.getData().getQuanity() <= high) {
            if(this.getLeft() != null && this.getRight() != null) {
                return 1 + this.getLeft().getCount(low, high) +
                    this.getRight().getCount(low, high);
            }
            if(this.getLeft() != null) {
                return 1 + this.getLeft().getCount(low, high);
            }
            if(this.getRight() != null) {
                return 1 + this.getRight().getCount(low, high);
            }
        }    
                 
        // If current node is smaller than low,
        // then recursive for right child
        else if(this.getData().getQuanity() < low && this.getRight() != null)
            return this.getRight().getCount(low, high);
         
        // Else recursive for left child
        else if(this.getLeft() != null)
            return this.getLeft().getCount(low, high);
        
        // Because otherwise Java will get angry...
        return 0;
    }
}
