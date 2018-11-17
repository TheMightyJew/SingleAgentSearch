import java.util.*;

public class BreadthFirstSearch  extends ASearch
{
	// Define lists here ...
	private Queue<ASearchNode> open_list;
	private Set<ASearchNode> closed_list;

	@Override
	public String getSolverName() 
	{
		return "BFS";
	}

	@Override
	public ASearchNode createSearchRoot
	(
		IProblemState problemState
	) 
	{
		ASearchNode newNode = new BlindSearchNode(problemState);
		return newNode;
	}
	
	@Override
	public void initLists() 
	{
        open_list = new LinkedList<>();
        closed_list = new HashSet<>();
	}

	@Override
	public ASearchNode getOpen
	(
		ASearchNode node
	) 
	{
//	    if(open_list.contains(node)){
//	        Iterator<ASearchNode> i = open_list.iterator();
//	        while (i.hasNext()){
//	            ASearchNode tmp = i.next();
//	            if (node.equals(tmp)){
//	                ASearchNode res = tmp;
//	                open_list.remove(res);
//	                return res;
//                }
//            }
//        }

		//best remove
//		for (ASearchNode t:open_list) {
//			if (node.equals(t)) {
//				ASearchNode res = t;
//				open_list.remove(res);
//				return res;
//			}
//		}
		for (ASearchNode t:open_list) {//best without remove
			if (node.equals(t)) {
				return t;
			}
		}

		return null;
	}

	@Override
	public boolean isOpen
	(
		ASearchNode node
	) 
	{
		return open_list.contains(node);
	}
	
	@Override
	public boolean isClosed
	(
		ASearchNode node
	) 
	{
		return closed_list.contains(node);
	}

	@Override
	public void addToOpen
	(
		ASearchNode node
	) 
	{
		open_list.add(node);
	}

	@Override
	public void addToClosed
	(
		ASearchNode node
	) 
	{
	    closed_list.add(node);
	}

	@Override
	public int openSize() 
	{
		return open_list.size();
	}

	@Override
	public ASearchNode getBest() 
	{
		return open_list.poll();
	}

	

}
