/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawingapp;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 *
 * @author Sylvius
 */
public class Select {

    Object selectedShape = new Object();
    int slack = 5;
    boolean selectedIsValid = false;

    public Select() {
    }

    //Sets the Graphics being used in the application, to draw the shapes

    //returns the selectedShape
    public Object getSelectedShape() {
        return selectedShape;
    }

    //sets the boolean value if the selected shape is valid
    public void selectedIsValid(boolean selectedIsValid) {
        this.selectedIsValid = selectedIsValid;
    }

    //returns the boolean value that checks if selected shape is valid (not null)
    public boolean getselectedIsValid() {
        return selectedIsValid;
    }

    /* 
        This method finds the shape closest to the mousepointer.
        It then sets the selectedMethod global, for future reference.
        The distance between mousepointer and shape is calculated using line intersection.
        If the mouse is closer then 5 pixels to a shapes line, it will select that shape.
        The shape is returned to stop the execution of the loop.
     */
    public Object FindClosestShape(ArrayList<Object> shapeslist, MouseEvent evt) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        selectedIsValid(false);
        for (Object shape : shapeslist) {
            double distpos;
            Method method = shape.getClass().getMethod("getCorners");
            int[][] corners = (int[][]) method.invoke(shape);
            int mousex = evt.getX();
            int mousey = evt.getY();
            //close to left bound:
            distpos = Line2D.ptLineDist((double) corners[0][0], (double) corners[0][1], (double) corners[0][0], (double) corners[1][1], (double) mousex, (double) mousey);
            //System.out.println("left: " + distpos);
            if (distpos - slack <= 0) {
                selectedShape = shape;
                selectedIsValid(true);
                return shape;
            }
            //close to top bound:
            distpos = Line2D.ptLineDist((double) corners[0][0], (double) corners[0][1], (double) corners[1][0], (double) corners[0][1], (double) mousex, (double) mousey);
            //System.out.println("top: " + distpos);
            if (distpos - slack <= 0) {
                selectedShape = shape;
                selectedIsValid(true);
                return shape;
            }
            //close to right bound:
            distpos = Line2D.ptLineDist((double) corners[1][0], (double) corners[0][1], (double) corners[1][0], (double) corners[1][1], (double) mousex, (double) mousey);
            //System.out.println("right: " + distpos);
            if (distpos - slack <= 0) {
                selectedShape = shape;
                selectedIsValid(true);
                return shape;
            }
            //close to bottom bound:
            distpos = Line2D.ptLineDist((double) corners[0][0], (double) corners[1][1], (double) corners[1][0], (double) corners[1][1], (double) mousex, (double) mousey);
            //System.out.println("bottom: " + distpos);
            if (distpos - slack <= 0) {
                selectedShape = shape;
                selectedIsValid(true);
                return shape;
            }
        }
        return null;
    }
}
