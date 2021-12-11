import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * To define a blank shape. Which will be used to fill the grids out of the pits.
 * @auther Lifan Zeng.
 */
public class Blank_GridShape extends GridShape{
    private int x, y, width;

    /**
     * To construct a blank grid.
     */
    public Blank_GridShape(int x, int y, int width){
        super(x, y, width, Color.lightGray);
        this.x = x;
        this.y = y;
        this.width = width;
    }

    /**
     * To draw a blank grid with a rectangle border.
     * @param g2 - the parameter of Graphics2D.
     */
    public void draw(Graphics2D g2){
        Rectangle2D rectangle = new Rectangle2D.Double(x, y, width, width);
        g2.draw (rectangle);
    }
}