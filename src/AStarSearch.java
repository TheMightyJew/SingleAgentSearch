import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class AStarSearch   extends ASearch
{
	// Define lists here ...
	private PriorityQueue<ASearchNode> open_list;
	private ArrayList<ASearchNode> closed_list;
	@Override
	public String getSolverName()
	{
		return "AStar";
	}

	@Override
	public ASearchNode createSearchRoot
			(
					IProblemState problemState
			)
	{
		ASearchNode newNode = new HeuristicSearchNode(problemState);
		return newNode;
	}

	@Override
	public void initLists()
	{
		open_list = new PriorityQueue<>(new Comparator<ASearchNode>() {
			@Override
			public int compare(ASearchNode o1, ASearchNode o2) {
				return (int)(o1.getF() - o2.getF());
			}
		});
		closed_list = new ArrayList<>();
	}

	@Override
	public ASearchNode getOpen
			(
					ASearchNode node
			)
	{
		for (ASearchNode t:open_list) {
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
