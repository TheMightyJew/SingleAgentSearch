import java.util.*;

public class BreadthFirstSearch  extends ASearch
{
	// Define lists here ...
	private Queue<BlindSearchNode> open_list;
	private ArrayList<BlindSearchNode> closed_list;

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
        open_list = new ArrayDeque<>();
        closed_list = new ArrayList<>();
	}

	@Override
	public ASearchNode getOpen
	(
		ASearchNode node
	) 
	{
		for (BlindSearchNode t:open_list) {
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
		open_list.add((BlindSearchNode)node);
	}

	@Override
	public void addToClosed
	(
		ASearchNode node
	) 
	{
	    closed_list.add((BlindSearchNode)node);
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
