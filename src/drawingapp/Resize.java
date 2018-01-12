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
public class Resize {

    /*
        This method is for Resizing the shapes.
        The shape is selected from the selectedShape global.
        The shapes setWidth and setHeight methods are invoked to set the new width and height
        Finally the repaintAll() method is being called to repaint all shapes with their new size.
     */
    public void Resize(Object closestObject, MouseEvent evt) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int mousex = evt.getX();
        int mousey = evt.getY();
        Method method = closestObject.getClass().getMethod("getCorners");
        int[][] corners = (int[][]) method.invoke(closestObject);
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
        Method setcorners = closestObject.getClass().getMethod("setCorner", cornerparam);
        setcorners.invoke(closestObject, 1, 0, mousex);
        setcorners.invoke(closestObject, 1, 1, mousey);
    }
}
