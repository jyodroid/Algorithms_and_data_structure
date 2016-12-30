/**
 * mycodeschool
 * April 19 2014 https://www.youtube.com/watch?v=yEwSGhSsT0U
 */
package algoritms_data_structures;

import algoritms_data_structures.datastructure.BalancedTreeNode;

public class BST {
	
	public boolean isBST(BalancedTreeNode root, int minValue, int maxValue){
		
		if (root == null) return true;
		
		//All elements of tree on left should be lesser data value than node's
		return root.getData() > minValue && root.getData() < maxValue &&
				isBST(root.getLeft(), minValue, root.getData()) && 
				isBST(root.getRight(), root.getData(), maxValue);		
	}
}
