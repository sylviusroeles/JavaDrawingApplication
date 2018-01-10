/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawingapp;

import java.awt.Color;
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
    ArrayList<Object> shapeslist = new ArrayList<>();
    Method method;
    int slack = 5;
    int[][] corners = new int[][]{{0, 0}, {0, 0}};
    Graphics g;
    boolean selectedIsValid = false;
    boolean isMoving = false;
    boolean isResizing = false;

    public Select() {
    }

    //Get the boolean value of isMoving, to indicate wheter a shape is being moved
    public boolean getIsMoving() {
        return isMoving;
    }

    //Sets the boolean value of isMoving, to indicate wheter a shape is being moved
    public void setIsMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }

    //Get the boolean value of isMoving, to indicate wheter a shape is being resized
    public boolean getIsResizing() {
        return isResizing;
    }

    //Sets the boolean value of isMoving, to indicate wheter a shape is being moved
    public void setIsResizing(boolean isResizing) {
        this.isResizing = isResizing;
    }

    //Sets the Graphics being used in the application, to draw the shapes
    public void setGraphics(Graphics g) {
        this.g = g;
    }

    //returns the selectedShape
    public Object getSelectedShape() {
        return selectedShape;
    }

    //add a new shape to the arraylist
    public void addShape(Object shape) {
        shapeslist.add(shape);
    }

    //removes a shape from the arraylist
    public void removeShape(Object shape) {
        shapeslist.remove(shape);
    }

    //edits a shape in the arraylist
    public void editShape(Object shape, int index) {
        shapeslist.set(index, shape);
    }

    //sets the boolean value if the selected shape is valid
    public void selectedIsValid(boolean selectedIsValid) {
        this.selectedIsValid = selectedIsValid;
    }

    //returns the boolean value that checks if selected shape is valid (not null)
    public boolean getselectedIsValid() {
        return selectedIsValid;
    }

    //clears all painted shapes from the application
    public void clearAll() {
        g.clearRect(0, 0, 796, 515);
    }

    /* 
        This method repaints all existing shapes in the arraylist.
        Each shapes paint method is being invoked to draw the shape.
        If the current shape index is the selected one, give it a red colour and invoke the setColor method.
     */
    public void repaintAll() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        clearAll();
        for (Object shape : shapeslist) {
            Class param[] = new Class[1];
            param[0] = Graphics.class;
            Method test = shape.getClass().getMethod("Ppaint", param);
            Class setcolorparam[] = new Class[1];
            setcolorparam[0] = Color.class;
            Method setcolor = shape.getClass().getMethod("setColor", setcolorparam);
            if (shape.equals(selectedShape)) {
                setcolor.invoke(shape, Color.red);
            } else {
                setcolor.invoke(shape, Color.black);
            }
            test.invoke(shape, g);
        }
    }

    /* 
        This method finds the shape closest to the mousepointer.
        It then sets the selectedMethod global, for future reference.
        The distance between mousepointer and shape is calculated using line intersection.
        If the mouse is closer then 5 pixels to a shapes line, it will select that shape.
        The shape is returned to stop the execution of the loop.
     */
    public Object FindClosestShape(MouseEvent evt) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        selectedIsValid(false);
        for (Object shape : shapeslist) {
            double distpos;
            method = shape.getClass().getMethod("getCorners");
            corners = (int[][]) method.invoke(shape);
            int mousex = evt.getX();
            int mousey = evt.getY();
            //close to left bound:
            distpos = Line2D.ptLineDist((double) corners[0][0], (double) corners[0][1], (double) corners[0][0], (double) corners[1][1], (double) mousex, (double) mousey);
            //System.out.println("left: " + distpos);
            if (distpos - slack <= 0) {
                selectedShape = shape;
                repaintAll();
                selectedIsValid(true);
                return shape;
            }
            //close to top bound:
            distpos = Line2D.ptLineDist((double) corners[0][0], (double) corners[0][1], (double) corners[1][0], (double) corners[0][1], (double) mousex, (double) mousey);
            //System.out.println("top: " + distpos);
            if (distpos - slack <= 0) {
                selectedShape = shape;
                repaintAll();
                selectedIsValid(true);
                return shape;
            }
            //close to right bound:
            distpos = Line2D.ptLineDist((double) corners[1][0], (double) corners[0][1], (double) corners[1][0], (double) corners[1][1], (double) mousex, (double) mousey);
            //System.out.println("right: " + distpos);
            if (distpos - slack <= 0) {
                selectedShape = shape;
                repaintAll();
                selectedIsValid(true);
                return shape;
            }
            //close to bottom bound:
            distpos = Line2D.ptLineDist((double) corners[0][0], (double) corners[1][1], (double) corners[1][0], (double) corners[1][1], (double) mousex, (double) mousey);
            //System.out.println("bottom: " + distpos);
            if (distpos - slack <= 0) {
                selectedShape = shape;
                repaintAll();
                selectedIsValid(true);
                return shape;
            }
        }
        return null;
    }

    /* 
        This method Moves a shape around.
        The shape is selected from the selectedShape global.
        The shape's corners are being set to the new values by invoking the method.
        Finally the repaintAll() method is being called to repaint all shapes with their new coordinates.
     */
    public void Move(MouseEvent evt) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (isMoving) {
            int mousex = evt.getX();
            int mousey = evt.getY();
            Object closestObject = getSelectedShape();
            if (closestObject != null) {
                Class param[] = new Class[3];
                param[0] = int.class;
                param[1] = int.class;
                param[2] = int.class;
                Method setcorners = closestObject.getClass().getMethod("setCorners", param);
                setcorners.invoke(closestObject, 0, 0, mousex);
                setcorners.invoke(closestObject, 0, 1, mousey);
                repaintAll();
            }
        }
    }

    /*
        This method is for Resizing the shapes.
        The shape is selected from the selectedShape global.
        The shapes setWidth and setHeight methods are invoked to set the new width and height
        Finally the repaintAll() method is being called to repaint all shapes with their new size.
     */
    public void Resize(MouseEvent evt) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (isResizing) {
            int mousex = evt.getX();
            int mousey = evt.getY();
            Object closestObject = getSelectedShape();
            method = closestObject.getClass().getMethod("getCorners");
            corners = (int[][]) method.invoke(closestObject);
            Class param[] = new Class[1];
            param[0] = int.class;
            Method setwidth = closestObject.getClass().getMethod("setWidth", param);
            Method setheight = closestObject.getClass().getMethod("setHeight", param);
            setwidth.invoke(closestObject, mousex - corners[0][0]);
            setheight.invoke(closestObject, mousey - corners[0][1]);
            Class cornerparam[] = new Class[3];
            cornerparam[0] = int.class;
            cornerparam[1] = int.class;
            cornerparam[2] = int.class;
            Method setcorners = closestObject.getClass().getMethod("setCorners", cornerparam);
            setcorners.invoke(closestObject, 1, 0, mousex);
            setcorners.invoke(closestObject, 1, 1, mousey);
            repaintAll();
        }
    }
}
