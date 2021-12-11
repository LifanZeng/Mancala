/**
 * An interface to define the game strategy which player use.
 * @author Victor Mendoza.
 */

public interface Strategy
{
    boolean lastBeadGoal(int beads, int iter);
    boolean lastBeadEmpty(int beads, int iter, int integer);
}