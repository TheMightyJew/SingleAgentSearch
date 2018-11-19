import java.util.Map;

public class TilePuzzleHeuristic implements IHeuristic
{

	@Override
	public double getHeuristic
	(
		IProblemState problemState
	) 
	{
		TilePuzzleState game=(TilePuzzleState)problemState;
		int[][] map=game._tilePuzzle;
		int ans=0;
		for (int i=0;i<map.length;i++){
			for(int j=0;j<map[i].length;j++){
				int num=map[i][j];
				int numOfMoves=0;
				if(num>0){
					numOfMoves+= Math.abs((num-1)/map.length-i);
					numOfMoves+=Math.abs((num-1)%map.length-j);
					ans+=numOfMoves*num;
				}
			}
		}
		return ans;
	}
	
}
