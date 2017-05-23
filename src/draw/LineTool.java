/**
 * 
 */
package draw;

import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

/**
 * Line Tool Class, creates and paints lines.
 * @author baimenov
 * @version November 19 2016
 */
public class LineTool extends AbstractTool {
    
    /**
     * Coordinate of the initial line of length 1.
     */
    private static final int SAFE_COORDINATE = -100;
    
    /**
     * Initial X Coordinate of a line.
     */
    private int myInitX;
    
    /**
     * Initial Y Coordinate of a line.
     */
    private int myInitY;
    
    /**
     * Current X Coordinate of a Line.
     */
    private int myCurrX;
    
    /**
     * Current Y Coordinate of a Line.
     */
    private int myCurrY;
    
    /**
     * Line2D that will be painted.
     */
    private Line2D myLine;
    
    /**
     * Set Initial coordinates of a line when mouse was pressed.
     * @param theEvent MouseEvent that has X and Y coordinates.
     */
    public void pressPainting(final MouseEvent theEvent) {
        myInitX = theEvent.getX();
        myInitY = theEvent.getY();
        myLine = new Line2D.Double(SAFE_COORDINATE, SAFE_COORDINATE,
                                   SAFE_COORDINATE, SAFE_COORDINATE);
    }
    
    /**
     * Sets current coordinates of a line when mouse is dragged.
     * @param theEvent MouseEvent that has X and Y coordinates.
     * @return Returns Line.
     */
    public Shape dragPainting(final MouseEvent theEvent) {
        myCurrX = theEvent.getX();
        myCurrY = theEvent.getY();
        myLine.setLine(myInitX, myInitY, myCurrX, myCurrY);
        return myLine;
    }
    
    /**
     * Returns the final line one the mouse was released.
     * @param theEvent MouseEvent that has X and Y coordinates.
     * @return Returns Line.
     */
    public Shape releasePainting(final MouseEvent theEvent) {
        return myLine;
    }
}
