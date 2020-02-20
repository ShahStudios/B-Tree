package UAlbanyBTree;

// Import Packages: 
import java.util.Collection;
import java.util.LinkedList;

// Sub Class:
public class LeafNode extends Node {

	//---------------------------------------------------------------------------------------------------------------------------------
	//													[Declare Fields: LinkedList] 
	
	public LinkedList<Integer> list = new LinkedList<Integer>();
			
	//---------------------------------------------------------------------------------------------------------------------------------
	// 										[Declare Constructor: Collection<Integer> / LinkedList]
	
	public LeafNode(Collection<Integer> values) {	
		
		for (Integer element : values) {
			list.add(element);
		}
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------
	// 													[Declare Accesor: GetList]
	
	public LinkedList<Integer> getList() {
		return list;
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------
}