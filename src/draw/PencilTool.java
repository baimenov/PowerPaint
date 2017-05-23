/**
 * 
 */
package draw;

import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;


/**
 * Pencil Tool Class that creates and paints pencil traces.
 * @author baimenov
 * @version November 23 2016
 */
public class PencilTool extends AbstractTool {
    
    /**
     * Path object that will represent a pencil.
     */
    private final Path2D myPath = new GeneralPath();
    
    /**
     * Initializes the initial X and Y coordinates of
     * pencil path.
     * @param theEvent MouseEvent that delivers X and Y
     * coordinates.
     */
    public void pressPainting(final MouseEvent theEvent) {
        myPath.setWindingRule(GeneralPath.WIND_EVEN_ODD);
        myPath.moveTo(theEvent.getX(), theEvent.getY());
    }
    
    /**
     * Keeps track of pencil's current end.
     * @param theEvent MouseEvent that delivers
     * current X and Y coordinates
     */
    @Override
    public Shape dragPainting(final MouseEvent theEvent) {
        myPath.lineTo(theEvent.getX(), theEvent.getY());
        return myPath;
    }
    
    @Override
    public Shape releasePainting(final MouseEvent theEvent) {
        return myPath;
    }
    
}
