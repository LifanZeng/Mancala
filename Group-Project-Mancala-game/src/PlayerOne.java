/**
 * Play A's  game strategy.
 *@author Victor Mendoza.
 */

public class PlayerOne implements Strategy
{
    @Override
    public boolean lastBeadGoal(int beads, int iter) {
        return (beads == 1 && iter == 13);
    }
    @Override
    public boolean lastBeadEmpty(int beads, int iter, int iterData)
    {
        return (beads == 1 && iter > 6 && iter < 13 && iterData == 0);
    }

}