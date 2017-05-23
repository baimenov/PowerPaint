/**
 * 
 */
package draw;

import java.awt.Shape;
import java.awt.event.MouseEvent;

/**
 * Abstract class for all 4 tools.
 * @author baimenov
 * @version November 23 2016
 */
public abstract class AbstractTool implements Tool {
    
    /**
     * Starts painting the object as soon as mouse was pressed.
     * @param theEvent MouseEvent.
     */
    public abstract void pressPainting(MouseEvent theEvent);
    
    /**
     * Keeps track of the object being painted as the mouse is being dragged.
     * @param theEvent MouseEvent
     * @return Shape that will be painted.
     */
    public abstract Shape dragPainting(MouseEvent theEvent);
    
    /**
     * Stops painting the object as soon as mouse was released.
     * @param theEvent MouseEvent
     * @return Shape that will be painted.
     */
    public abstract Shape releasePainting(MouseEvent theEvent);
}
