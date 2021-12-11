/**
 * Play B's  game strategy.
 *@author Victor Mendoza.
 */

public class PlayerTwo implements Strategy {

    @Override
    public boolean lastBeadGoal(int beads, int iter) {
        return (beads == 1 && iter == 6);
    }

    @Override
    public boolean lastBeadEmpty(int beads, int iter, int iterData) {
        return (beads == 1 && iter >= 0 && iter < 6 && iterData == 0);
    }

}