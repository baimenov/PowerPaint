/**
 * 
 */
package draw;

import java.awt.Shape;
import java.awt.event.MouseEvent;

/**
 * Interface for tool objects.
 * @author baimenov
 * @version November 23 2016
 */
public interface Tool {
    
    /**
     * Starts painting the object as soon as mouse was pressed.
     * @param theEvent MouseEvent.
     */
    void pressPainting(MouseEvent theEvent);
    
    /**
     * Keeps track of the object being painted as the mouse is being dragged.
     * @param theEvent MouseEvent
     * @return Shape.
     */
    Shape dragPainting(MouseEvent theEvent);
    
    /**
     * Stops painting the object as soon as mouse was released.
     * @param theEvent MouseEvent
     * @return Shape that will be painted.
     */
    Shape releasePainting(MouseEvent theEvent);
}
