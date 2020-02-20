package UAlbanyBTree;

// Import Packages: 
import java.util.LinkedList;

// Recursion Search: 
public class Search {

	
	//---------------------------------------------------------------------------------------------------------------------------------
	// 								[SearchLeafList: Return First Element Then Remove If It Is Not Valid] 		
	
	public boolean searchLeafList(LinkedList<Integer> leafValues, int value) {

		if (leafValues.peekFirst() == null) {
			return false;
		}

		else {
			if (leafValues.getFirst() == value) {
				return true;
			}

			else {
				leafValues.removeFirst();
				return searchLeafList(leafValues, value);
			}
		}
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------
	// 										[SearchLeafNode: Function To Call SearchLeafList] 		

	public boolean searchLeafNode(LeafNode leafNode, int value) {

		LinkedList<Integer> listValues = (LinkedList<Integer>) leafNode.getList().clone();

		return searchLeafList(listValues, value);
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------
	// [SearchRootList: Get First Element Instance RootNode, Check Value Between Min/Max, Remove Element If Not In Ranage, Else Repeat] 		
	
	public boolean searchRootList(LinkedList<Node> rootList, int value) {

		if (rootList.peekFirst() == null) {
			return false;
		}

		else if (rootList.getFirst() instanceof RootNode) {
			RootNode rootNode = (RootNode) rootList.getFirst();

			if (rootNode.getMin() <= value && value <= rootNode.getMax()) {
				return searchRootNode(rootNode, value);
			}

			else {
				rootList.removeFirst();
				return searchRootList(rootList, value);
			}
		}

		else if (rootList.getFirst() instanceof LeafNode) {
			LeafNode leafNode = (LeafNode) rootList.getFirst();

			if (searchLeafNode(leafNode, value)) {
				return true;
			}

			else {
				rootList.removeFirst();
				searchRootList(rootList, value);
			}

		}
		return false;
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------
	// 										 [SearchRootNode: Function Call To SearchRootList] 		

	public boolean searchRootNode(RootNode rootValues, int value) {

		LinkedList<Node> listValues = (LinkedList<Node>) rootValues.getList().clone();
		return searchRootList(listValues, value);
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------
	// 								 [SearchRootNode: Print Number Found Or Not Found If Value Is Not True] 		

	public void searchRootNodeValue(RootNode rootValues, int value) {

		if (searchRootNode(rootValues, value) == true) {

			System.out.println("The Number Has Been Found");

		}

		else {

			System.out.println("The Number Has Not Been Found");
		}
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------
}