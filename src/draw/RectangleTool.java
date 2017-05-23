/**
 * 
 */
package draw;

import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

/**
 * Rectangle Tool Class that creates and paints Rectangles.
 * @author baimenov
 * @version November 19 2016
 */
public class RectangleTool extends AbstractTool {
    
    /**
     * Initial upper left X coordinate of a Rectangle.
     */
    private int myInitX;
    
    /**
     * Initial upper left Y Coordinate of a Rectangle.
     */
    private int myInitY;
    
    /**
     * Rectangle that will be painted.
     */
    private Rectangle2D myRectangle;
    
    /**
     * Sets initial upper left coordinates of a rectangle.
     * @param theEvent MouseEvent that delivers the
     * X and Y coordinates.
     */
    public void pressPainting(final MouseEvent theEvent) {
        myInitX = theEvent.getX();
        myInitY = theEvent.getY();
        myRectangle = new Rectangle2D.Double(myInitX, myInitY, 0, 0);
    }
    
    /**
     * Keeps track of rectangle as mouse is being dragged.
     * @param theEvent MouseEvent that delivers current
     * X and Y coordinates.
     */
    @Override
    public Shape dragPainting(final MouseEvent theEvent) {
        int width = theEvent.getX() - myInitX;
        int height = theEvent.getY() - myInitY;
        int x = myInitX;
        int y = myInitY;
        if (height < 0) {
            y += height;
            height = height * (-1);
        }
        if (width < 0) {
            x += width;
            width = width * (-1);
        } 
        myRectangle.setRect(x, y, width, height);
        return myRectangle;
    }
    
    /**
     * Returns final Rectangle to be drawn.
     * @param theEvent MouseEvent that has X and Y coordinates.
     * @return Rectangle to be drawn.
     */
    public Shape releasePainting(final MouseEvent theEvent) {
        return myRectangle;
    }
}
