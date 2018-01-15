/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawingapp;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sylvius
 */
public class Command {

    Ellipse ellipse;
    Rectangle rectangle;
    Select select = new Select();
    Move move = new Move();
    Resize resize = new Resize();
    Graphics g;
    ArrayList<Object> currShapes = new ArrayList<>();

    public Command() {

    }

    public Command(Graphics g) {
        this.g = g;
    }

    /* 
    Sets the graphics to use when painting
     */
    public void setGraphics(Graphics g) {
        this.g = g;
    }

    /* 
    Select command for finding the shape closest to the mouse
     */
    public Object Select(ArrayList<Object> list, MouseEvent evt) {
        try {
            return select.FindClosestShape(list, evt);
        } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(Command.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    boolean isResizing = false;

    public void setIsResizing(boolean isResizing) {
        this.isResizing = isResizing;
    }

    public boolean getIsResizing() {
        return isResizing;
    }
     /* 
    Resize command for resizing an object. 
    The two method above are indicators to see if a shape is being resized
     */   
    public void Resize(Object o, MouseEvent evt) {
        try {
            resize.Resize(o, evt);
        } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(Command.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    boolean isMoving = false;

    public void setisMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }

    public boolean getisMoving() {
        return isMoving;
    }
     /* 
    move command for moving an object. 
    The two method above are indicators to see if a shape is being resized
     */   
    public void Move(Object o, MouseEvent evt) {
        try {
            if (isMoving) {
                move.Move(o, evt);
            }
        } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(Command.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /* Stub for future group stuff */
    public void Group(int size) {
        System.out.println("Group");
    }

    //Creates a new Ellipse
    public Object Ellipse(int sx, int sy, int width, int height) {
        ellipse = new Ellipse();
        ellipse.setCorners(new int[][]{{sx, sy}, {sx + width, sy + height}});
        ellipse.Ppaint(g);
        System.out.println("Ellipse");
        return ellipse;
    }

    //Creates a Rectangle
    public Object Rectangle(int sx, int sy, int width, int height) {
        rectangle = new Rectangle();
        rectangle.setCorners(new int[][]{{sx, sy}, {sx + width, sy + height}});
        rectangle.Ppaint(g);
        System.out.println("Rectangle");
        return rectangle;
    }
    
    //Future ornament stuff
    public void Ornament(String alignment, String s) {
        System.out.println("Ornament");
    }
    
    //Undo command
    public void Undo(ArrayList<Object> list) {
        try {
            repaintAll(list);
        } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(Command.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Redo command
    public void Redo(ArrayList<Object> list) {
        try {
            repaintAll(list);
        } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(Command.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    public void repaintAll(ArrayList<Object> shapes) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        clearAll();
        int index = 0;
        for (Object shape : shapes) {
            index++;
            Class param[] = new Class[1];
            param[0] = Graphics.class;
            try {
                Method test = shape.getClass().getMethod("Ppaint", param);
                test.invoke(shape, g);
            } catch (NullPointerException ex) {
                System.out.println(ex);
            }
        }
    }
}
