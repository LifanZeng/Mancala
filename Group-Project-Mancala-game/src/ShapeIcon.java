import javax.swing.*;
import java.awt.*;

/**
 * The icon of grids
 * @author Lifan Zeng
 */
public class ShapeIcon implements Icon {
    private GridShape shape;
    private int width;
    private int height;

    /**
     * To construct an icon.
     * @param shape - the shape of the icon.
     * @param width - the width of the icon.
     * @param height - the height of the icon.
     */
    public ShapeIcon(GridShape shape, int width, int height){
        this.shape = shape;
        this.width = width;
        this.height = height;
    }

    /**
     * To paint the shape of the icon.
     * @param c
     * @param g
     * @param x
     * @param y
     */
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        shape.draw(g2);
    }

    /**
     * To get the width of the icon.
     * @return - the width of the icon.
     */
    @Override
    public int getIconWidth() {
        return width;
    }

    /**
     * To get the height of the icon.
     * @return - the height of the icon.
     */
    @Override
    public int getIconHeight() {
        return height;
    }
}