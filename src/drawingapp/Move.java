/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawingapp;

import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author Sylvius
 */
public class Move {

    /* 
        This method Moves a shape around.
        The shape is selected from the selectedShape global.
        The shape's corners are being set to the new values by invoking the method.
        Finally the repaintAll() method is being called to repaint all shapes with their new coordinates.
     */
    public void Move(Object closestObject, MouseEvent evt) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int mousex = evt.getX();
        int mousey = evt.getY();
        Class param[] = new Class[3];
        param[0] = int.class;
        param[1] = int.class;
        param[2] = int.class;
        Method setcorners = closestObject.getClass().getMethod("setCorner", param);
        setcorners.invoke(closestObject, 0, 0, mousex);
        setcorners.invoke(closestObject, 0, 1, mousey);
    }

}
