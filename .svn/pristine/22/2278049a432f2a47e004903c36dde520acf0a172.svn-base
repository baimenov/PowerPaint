/**
 * 
 */
package draw;

import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;


/**
 * Ellipse Tool Class that creates and paints Ellipses.
 * @author baimenov
 * @version November 19 2016
 */
public class EllipseTool extends AbstractTool {
    
    /**
     * X coordinate of a top left corner of ellipse.
     */
    private int myInitX;
    
    /**
     * Y coordinate of a top left corner of ellipse.
     */
    private int myInitY;
    
    /**
     * Ellipse that will be painted.
     */
    private Ellipse2D myEllipse;
    
    /**
     * Sets location of a top left corner of an ellipse.
     * @param theEvent MouseEvent with X and Y coordinates.
     */
    public void pressPainting(final MouseEvent theEvent) {
        myInitX = theEvent.getX();
        myInitY = theEvent.getY();
        myEllipse = new Ellipse2D.Double(0, 0, 0, 0);
    }
    
    /**
     * Updates the Ellipse as mouse is being dragged.
     * @param theEvent MouseEvent with X and Y coordinates.
     * @return Ellipse.
     */
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
        myEllipse.setFrame(x, y, width, height);
        return myEllipse;
    }
    
    /**
     * Returns final Ellipse to be painted once mouse was released.
     * @param theEvent MouseEvent with X and Y coordinates.
     * @return Ellipse.
     */
    public Shape releasePainting(final MouseEvent theEvent) {
        return myEllipse;
    }
}
