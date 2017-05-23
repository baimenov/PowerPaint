package draw;
import gui.OldPaintings;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

/**
 * Creates and manages changes of the drawing panel.
 * @author baimenov
 * @version November 23 2016
 */

public class DrawPanel extends JPanel {
    
    private static final long serialVersionUID = 1;
    
    /**
     * Coordinate of the initial line of length 1.
     */
    private static final int SAFE_COORDINATE = -100;
    
    /**
     * Index of character that will define the shape type.
     */
    private static final int CLASS_DEFINER = 20;
    
    /**
     * Initial width of the drawing panel.
     */
    private static final int WIDTH = 600;
    
    /**
     * Initial height of the drawing panel.
     */
    private static final int HEIGHT = 400;
    
    /**
     * Background color of a drawing panel.
     */
    private static final Color BACKGROUND_COLOR = Color.WHITE;
    
    /**
     * UW purple color.
     */
    private static final Color UW_PURPLE = new Color(51, 0, 111);
    
    /**
     * UW gold color.
     */
    private static final Color UW_GOLD = new Color(232, 211, 162);
    
    /**
     * Draw Color.
     */
    private Color myDrawColor;
    
    /**
     * Fill Color.
     */
    private Color myFillColor;
    
    /**
     * List of old paintings.
     */
    private final List<OldPaintings> myOldOnes = new ArrayList<OldPaintings>();
    
    /**
     * True if shape is filled, false otherwise.
     */
    private boolean myFilled;
    
    /**
     * Stroke width.
     */
    private BasicStroke myStroke;
    
    /**
     * One of four tools.
     */
    private Tool myTool;
    
    /**
     * Shape that will be painted.
     */
    private Shape myShape;
    
    /**
     * Initializes the drawing panel.
     */
    public DrawPanel() {
        final MouseInputAdapter mia = new MyMouseInputAdapter();
        addMouseListener(mia);
        addMouseMotionListener(mia);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(BACKGROUND_COLOR);
        myTool = new LineTool();
        myStroke = new BasicStroke(1);
        myShape = new Line2D.Double(SAFE_COORDINATE, SAFE_COORDINATE,
                                    SAFE_COORDINATE, SAFE_COORDINATE);
        myDrawColor = UW_PURPLE;
        myFillColor = UW_GOLD;
    }
   
    
    
    
    
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
        for (int i = 0; i < myOldOnes.size(); i++) {
            g2d.setStroke(myOldOnes.get(i).getStroke());
            g2d.setPaint(myOldOnes.get(i).getDrawColor());
            g2d.draw(myOldOnes.get(i).getShape());
            paintFilled(g2d, myOldOnes.get(i).getShape(), myOldOnes.get(i).getFillColor(),
                        myOldOnes.get(i).isFilled());
        }
        g2d.setPaint(myDrawColor);
        g2d.setStroke(myStroke);
        g2d.draw(myShape);
        paintFilled(g2d, myShape, myFillColor, myFilled);
    }
    
    /**
     * Chooses tool that user selected.
     * @param theTool that user selected.
     */
    public void chooseTool(final Tool theTool) {
        myTool = theTool;
    }
    
    /**
     * Sets stroke size.
     * @param theStroke stroke size.
     */
    public void setStroke(final int theStroke) {
        myStroke = new BasicStroke(theStroke);
    }
    
    /**
     * Sets Draw color.
     * @param theColor the draw color.
     */
    public void setDrawColor(final Color theColor) {
        myDrawColor = theColor;
    }
    
    /**
     * Sets Fill color.
     * @param theColor the fill color.
     */
    public void setFillColor(final Color theColor) {
        myFillColor = theColor;
    }
    
    /**
     * Sets myFilled to the value that was passed.
     * @param theFilled true if shape is filled, false otherwise.
     */
    public void setFilled(final boolean theFilled) {
        myFilled = theFilled;
    }
    
    /**
     * Clears the panel from all the current paintings.
     */
    public void clearAll() {
        myOldOnes.clear();
        myShape = new Line2D.Double(SAFE_COORDINATE, SAFE_COORDINATE,
                                    SAFE_COORDINATE, -SAFE_COORDINATE);
        repaint();
    }
    
    /**
     * Fills the shape if choosers chooses to.
     * @param theG2d Graphic component.
     * @param theShape Shape that will be painted.
     * @param theColor Color of Shape.
     * @param theFilled true of Shape is filled.
     */
    private void paintFilled(final Graphics2D theG2d, final Shape theShape,
                             final Color theColor, final boolean theFilled) {
        if (!theFilled) {
            theG2d.draw(theShape);
        } else {
            theG2d.setPaint(theColor);
            final Shape temp = theShape;
            final Rectangle2D rect = temp.getBounds2D();
            final double x = rect.getX() + myStroke.getLineWidth() / 2;
            final double y = rect.getY() + myStroke.getLineWidth() / 2;
            final double w = rect.getWidth() - myStroke.getLineWidth() / 2;
            final double h = rect.getHeight() - myStroke.getLineWidth() / 2;
            final Rectangle2D toDraw = new Rectangle2D.Double(x, y, w, h);
            final Ellipse2D toDrawEllipse = new Ellipse2D.Double(x, y, w, h);
            if (temp.getClass().toString().charAt(CLASS_DEFINER) == 'R') {
                theG2d.fill(toDraw);
            } else if (temp.getClass().toString().charAt(CLASS_DEFINER) == 'E') {
                theG2d.fill(toDrawEllipse);
            }
        }
    }
    
    /**
     * Mouse Input adapter inner class.
     */
    class MyMouseInputAdapter extends MouseInputAdapter {
        
        @Override
        public void mousePressed(final MouseEvent theEvent) {
            
            myTool.pressPainting(theEvent);
        }
        
        @Override
        public void mouseReleased(final MouseEvent theEvent) {
            myOldOnes.add(new OldPaintings(myStroke, myTool.releasePainting(theEvent),
                                           myDrawColor, myFillColor, myFilled));
            
        }
        
        @Override
        public void mouseDragged(final MouseEvent theEvent) {
            myShape = myTool.dragPainting(theEvent);
            repaint();
        }
    }
    
}
