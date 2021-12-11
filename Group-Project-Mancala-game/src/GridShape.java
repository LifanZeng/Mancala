import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Dimension2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * To define the shape of the pits.When the number of the stones is not more than 9, the pit shows the same numbers of small circle.
 * When the number is more than 9, the pit just shows a number.
 * @auther Lifan Zeng.
 */
public class GridShape {
    private int x, y, width;
    private int value;
    private Color c;

    /**
     * Constructs the shape of a pit.
     * @param x - the x position of the shape.
     * @param y - the y position of the shape.
     * @param width - the width of the shape.
     * @param c - the color of the shape.
     */
    public GridShape(int x, int y, int width, Color c){
        this.x = x;
        this.y = y;
        this.width = width;
        this.c=c;
        value=4;
    }


    /**
     * To draw the shape.
     * @param g2 - the parameter of Graphics2D.
     */
    public void draw(Graphics2D g2){
        Rectangle2D rectangle = new Rectangle2D.Double(x, y, width, width);
        g2.draw (rectangle);
        double Cx=rectangle.getCenterX();
        double Cy=rectangle.getCenterY();
        Ellipse2D.Double ecllipse = new Ellipse2D.Double();
        ecllipse.setFrameFromCenter(Cx, Cy,
                0.8* rectangle.getWidth(), 0.95*rectangle.getHeight());
        g2.setColor(Color.ORANGE);
        g2.setStroke(new BasicStroke(2));
        g2.draw(ecllipse);

        Ellipse2D.Double circle1 = new Ellipse2D.Double();
        Ellipse2D.Double circle2 = new Ellipse2D.Double();
        Ellipse2D.Double circle3 = new Ellipse2D.Double();
        Ellipse2D.Double circle4 = new Ellipse2D.Double();
        Ellipse2D.Double circle5 = new Ellipse2D.Double();
        Ellipse2D.Double circle6 = new Ellipse2D.Double();
        Ellipse2D.Double circle7 = new Ellipse2D.Double();
        Ellipse2D.Double circle8 = new Ellipse2D.Double();
        Ellipse2D.Double circle9 = new Ellipse2D.Double();
        g2.setColor(c);
        if (value==1){
            circle1.setFrameFromCenter(Cx, Cy, Cx+8, Cy+8);
            g2.fill(circle1);
        }
        if (value==2){
            circle1.setFrameFromCenter(Cx-12, Cy, Cx-4, Cy+8);
            g2.fill(circle1);
            circle2.setFrameFromCenter(Cx+12, Cy, Cx+20, Cy+8);
            g2.fill(circle2);
        }
        if (value==3){
            circle1.setFrameFromCenter(Cx-12, Cy, Cx-4, Cy+8);
            g2.fill(circle1);
            circle2.setFrameFromCenter(Cx+12, Cy, Cx+20, Cy+8);
            g2.fill(circle2);
            circle3.setFrameFromCenter(Cx, Cy-16, Cx+8, Cy-8);
            g2.fill(circle3);
        }
        if (value==4){
            circle1.setFrameFromCenter(Cx-12, Cy, Cx-4, Cy+8);
            g2.fill(circle1);
            circle2.setFrameFromCenter(Cx+12, Cy, Cx+20, Cy+8);
            g2.fill(circle2);
            circle3.setFrameFromCenter(Cx, Cy-16, Cx+8, Cy-8);
            g2.fill(circle3);
            circle4.setFrameFromCenter(Cx, Cy+16, Cx+8, Cy+8);
            g2.fill(circle4);
        }
        if (value==5){
            circle1.setFrameFromCenter(Cx-16, Cy, Cx-8, Cy+8);
            g2.fill(circle1);
            circle2.setFrameFromCenter(Cx+16, Cy, Cx+24, Cy+8);
            g2.fill(circle2);
            circle3.setFrameFromCenter(Cx, Cy-16, Cx+8, Cy-8);
            g2.fill(circle3);
            circle4.setFrameFromCenter(Cx, Cy+16, Cx+8, Cy+8);
            g2.fill(circle4);
            circle5.setFrameFromCenter(Cx, Cy, Cx+8, Cy+8);
            g2.fill(circle5);
        }
        if(value==6){
            circle1.setFrameFromCenter(Cx-12, Cy, Cx-4, Cy+8);
            g2.fill(circle1);
            circle2.setFrameFromCenter(Cx+12, Cy, Cx+20, Cy+8);
            g2.fill(circle2);
            circle3.setFrameFromCenter(Cx-12, Cy-16, Cx-4, Cy-8);
            g2.fill(circle3);
            circle4.setFrameFromCenter(Cx+12, Cy-16, Cx+20, Cy-8);
            g2.fill(circle4);
            circle5.setFrameFromCenter(Cx-12, Cy+16, Cx-4, Cy+24);
            g2.fill(circle5);
            circle6.setFrameFromCenter(Cx+12, Cy+16, Cx+20, Cy+24);
            g2.fill(circle6);
        }
        if(value==7){
            circle1.setFrameFromCenter(Cx-16, Cy, Cx-8, Cy+8);
            g2.fill(circle1);
            circle2.setFrameFromCenter(Cx+16, Cy, Cx+24, Cy+8);
            g2.fill(circle2);
            circle3.setFrameFromCenter(Cx-16, Cy-16, Cx-8, Cy-8);
            g2.fill(circle3);
            circle4.setFrameFromCenter(Cx+16, Cy-16, Cx+24, Cy-8);
            g2.fill(circle4);
            circle5.setFrameFromCenter(Cx-16, Cy+16, Cx-8, Cy+24);
            g2.fill(circle5);
            circle6.setFrameFromCenter(Cx+16, Cy+16, Cx+24, Cy+24);
            g2.fill(circle6);
            circle7.setFrameFromCenter(Cx, Cy, Cx+8, Cy+8);
            g2.fill(circle7);
        }
        if(value==8){
            circle1.setFrameFromCenter(Cx-16, Cy, Cx-8, Cy+8);
            g2.fill(circle1);
            circle2.setFrameFromCenter(Cx+16, Cy, Cx+24, Cy+8);
            g2.fill(circle2);
            circle3.setFrameFromCenter(Cx-16, Cy-16, Cx-8, Cy-8);
            g2.fill(circle3);
            circle4.setFrameFromCenter(Cx+16, Cy-16, Cx+24, Cy-8);
            g2.fill(circle4);
            circle5.setFrameFromCenter(Cx-16, Cy+16, Cx-8, Cy+24);
            g2.fill(circle5);
            circle6.setFrameFromCenter(Cx+16, Cy+16, Cx+24, Cy+24);
            g2.fill(circle6);
            circle7.setFrameFromCenter(Cx, Cy, Cx+8, Cy+8);
            g2.fill(circle7);
            circle8.setFrameFromCenter(Cx, Cy-16, Cx+8, Cy-8);
            g2.fill(circle8);
        }
        if(value==9){
            circle1.setFrameFromCenter(Cx-16, Cy, Cx-8, Cy+8);
            g2.fill(circle1);
            circle2.setFrameFromCenter(Cx+16, Cy, Cx+24, Cy+8);
            g2.fill(circle2);
            circle3.setFrameFromCenter(Cx-16, Cy-16, Cx-8, Cy-8);
            g2.fill(circle3);
            circle4.setFrameFromCenter(Cx+16, Cy-16, Cx+24, Cy-8);
            g2.fill(circle4);
            circle5.setFrameFromCenter(Cx-16, Cy+16, Cx-8, Cy+24);
            g2.fill(circle5);
            circle6.setFrameFromCenter(Cx+16, Cy+16, Cx+24, Cy+24);
            g2.fill(circle6);
            circle7.setFrameFromCenter(Cx, Cy, Cx+8, Cy+8);
            g2.fill(circle7);
            circle8.setFrameFromCenter(Cx, Cy-16, Cx+8, Cy-8);
            g2.fill(circle8);
            circle9.setFrameFromCenter(Cx, Cy+16, Cx+8, Cy+24);
            g2.fill(circle9);
        }
        if(value>=10){
            String strValue = value+"";
            Font f =new Font("Serif", Font.BOLD, 36);
            g2.setFont(f);
            FontRenderContext context = g2.getFontRenderContext();
            Rectangle2D bounds = f.getStringBounds(strValue, context);
            double strX = ecllipse.getCenterX() - bounds.getWidth()/2;
            double strY = ecllipse.getCenterY() - bounds.getCenterY()/2;
            //g2.setColor(Color.blue);
            g2.drawString(strValue, (int)strX, (int)strY+8);}
    }

    /**
     * To set the stone amount of the pit.
     * @param newValue - the stone amount.
     */
    public void setNumber(int newValue){
        value = newValue;
    }
}