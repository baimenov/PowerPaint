package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Shape;

/**
 * Class to initialize and store old paintings.
 * @author baimenov
 * @version November 23 2016
 */
public class OldPaintings {
    
    /**
     * Index of character of a class name that determines class.
     */
    private static final int CLASS_DEFINER = 20;
    
    /**
     * Shape Size.
     */
    private final BasicStroke myStroke;
    
    /**
     * Shape type.
     */
    private final Shape myShape;
    
    /**
     * Draw Color of shape.
     */
    private final Color myDrawColor;
    
    /**
     * Fill color of shape.
     */
    private final Color myFillColor;
    
    /**
     * Shape is filled or not.
     */
    private final boolean myFilled;
    
    /**
     * Initializes a shape, it will then be stored as an old painting.
     * @param theStroke size of the Shape.
     * @param theShape Type of Shape.
     * @param theDrawColor Draw color of Shape.
     * @param theFillColor Fill Color of Shape.
     * @param theFilled shape is filled or not.
     */
    public OldPaintings(final BasicStroke theStroke, final Shape theShape,
                        final Color theDrawColor, final Color theFillColor,
                        final boolean theFilled) {
        myStroke = theStroke;
        myShape = theShape;
        myDrawColor = theDrawColor;
        myFillColor = theFillColor;
        if (theShape.getClass().toString().charAt(CLASS_DEFINER) == 'E'
                        || theShape.getClass().toString().charAt(CLASS_DEFINER) == 'R') {
            myFilled = theFilled;
        } else {
            myFilled = false;
        }
        
    }
    
    /**
     * Returns size of the shape.
     * @return myStroke
     */
    public BasicStroke getStroke() {
        return myStroke;
    }
    
    /**
     * Returns type of shape.
     * @return myShape
     */
    public Shape getShape() {
        return myShape;
    }
    
    /**
     * Returns draw color of shape.
     * @return myDrawColor
     */
    public Color getDrawColor() {
        return myDrawColor;
    }
    
    /**
     * Returns fill color of shape.
     * @return myFillColor
     */
    public Color getFillColor() {
        return myFillColor;
    }
    
    /**
     * Returns true if shape is filled, false otherwise.
     * @return myFilled
     */
    public boolean isFilled() {
        return myFilled;
    }
    
}
