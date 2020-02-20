package UAlbanyBTree;

import java.util.LinkedList;

// Main Test Class:
public class BTree {
	
	public static void main(String [] args) {
			
		//---------------------------------------------------------------------------------------------------------------------------------
		// 											  [Declare Fields: Child: IntegerLeaf and Nodes Lists] 		
		
		LinkedList <Integer> integerLeafList = new LinkedList<Integer>();
		LinkedList<Node> nodes = new LinkedList<Node>();
		
		//---------------------------------------------------------------------------------------------------------------------------------
		// 													[RootNode 1 Created: Child: LeafNode1] 												
		int [] NumbersArrayOne = {300, 320, 340, 360};
		
		for (int element : NumbersArrayOne) {
			integerLeafList.add(element);
		}
		
		nodes.add(new LeafNode(integerLeafList));
		
		RootNode rootNodeOne = new RootNode(300, 360, nodes);
				
		//---------------------------------------------------------------------------------------------------------------------------------
		//										   [Clear: List for Nodes,  List Of Numbers For Leaf List] 	
		
		integerLeafList.clear();
		nodes.clear();
		
		//---------------------------------------------------------------------------------------------------------------------------------
		// 											[RootNode 2 Created: Child: RootNode1 and LeafNode2] 	
		
		int [] NumbersArrayTwo = {200, 220, 240, 260};
		
		for (int element : NumbersArrayTwo) {
			integerLeafList.add(element);
		}
		
		nodes.add(new LeafNode(integerLeafList));
		nodes.add(rootNodeOne);

		RootNode rootNodeTwo = new RootNode(200, 399, nodes);
			
		//---------------------------------------------------------------------------------------------------------------------------------
		//		    									[Clear: List for Nodes,  List Of Numbers For Leaf List] 	
		
		integerLeafList.clear();
		nodes.clear();
		
		//---------------------------------------------------------------------------------------------------------------------------------
		// 													[RootNode 3 Ceated: Child: LeftNode3] 	
		
		int [] NumbersArrayThree = {100, 120, 140, 160};
		
		for (int element : NumbersArrayThree) {
			integerLeafList.add(element);
		}
		
		nodes.add(new LeafNode(integerLeafList));
		
		RootNode rootNodeThree = new RootNode(100, 199, nodes);
		
		//---------------------------------------------------------------------------------------------------------------------------------
		// 										[Clear: List for Nodes,  List Of Numbers For Leaf List] 	
		
		integerLeafList.clear();
		nodes.clear();
		
		//---------------------------------------------------------------------------------------------------------------------------------
		// 						[Search: RootNode1, RootNode2, RootNode3 = RootNode4 : Check All Root Integers For Value] 
		
		nodes.add(rootNodeOne);
		nodes.add(rootNodeTwo);
		nodes.add(rootNodeThree);
		
		RootNode rootNodeRange = new RootNode(1, 1000, nodes);
		Search search = new Search();
	      
       // 		  [Check If Values = Value Searched]
                
		System.out.println("---------Validate BTree Success----------");
               
		search.searchRootNodeValue(rootNodeRange, 100);
		search.searchRootNodeValue(rootNodeRange, 120);
		search.searchRootNodeValue(rootNodeRange, 140);
		search.searchRootNodeValue(rootNodeRange, 160);

		search.searchRootNodeValue(rootNodeRange, 200);
		search.searchRootNodeValue(rootNodeRange, 220);
		search.searchRootNodeValue(rootNodeRange, 240);
		search.searchRootNodeValue(rootNodeRange, 260);

		search.searchRootNodeValue(rootNodeRange, 300);
		search.searchRootNodeValue(rootNodeRange, 320);
		search.searchRootNodeValue(rootNodeRange, 340);
		search.searchRootNodeValue(rootNodeRange, 360);
                
       //         [Check If Values != Value Searched]
        
		System.out.println("---------Validate BTree Failure----------");
                
		search.searchRootNodeValue(rootNodeRange, 110);
		search.searchRootNodeValue(rootNodeRange, 130);
		search.searchRootNodeValue(rootNodeRange, 150);
		search.searchRootNodeValue(rootNodeRange, 170);
         
                
       //	[Check If Values Not In Value Range For Search]
                
		System.out.println("----Failure For Values Outside Range-----");

		search.searchRootNodeValue(rootNodeRange, 1100);
		search.searchRootNodeValue(rootNodeRange, 0);
		
		System.out.println("-----------------------------------------");
                
       //---------------------------------------------------------------------------------------------------------------------------------
	}
}