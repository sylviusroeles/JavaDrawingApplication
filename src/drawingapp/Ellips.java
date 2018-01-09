/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawingapp;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Sylvius
 */
public class Ellips extends JPanel {

    int leftStart, topStart;
    int leftEnd, topEnd;
    int width, height;
    int[][] corners;
    Color c;

    //Get the width of the Ellips
    public int getWidth() {
        return width;
    }

    //Set the width of the Ellips
    public void setWidth(int width) {
        this.width = width;
    }

    //Get the height of the Ellips
    public int getHeight() {
        return height;
    }

    //Set the height of the Ellips
    public void setHeight(int height) {
        this.height = height;
    }
    
    //Sets start X and Y coordinates of the newly created Ellips 
    public void initEllips(int left, int top) {
        this.leftStart = left;
        this.topStart = top;
    }
    
    //Sets end X and Y coordinates of the newly created Ellips 
    public void endEllips(int left, int top) {
        this.leftEnd = left;
        this.topEnd = top;
    }

    //Gets the 2d array with the corner coordinates of the Ellips
    public int[][] getCorners() {
        return corners;
    }
    
    //Sets the index of the 2d array with a corner coordinate of the Ellips
    public void setCorners(int i, int y, int value) {
        corners[i][y] = value;
    }
    
    //Sets the colour of the Ellips
    public void setColor(Color c) {
        this.c = c;
    }

    @Override
    /* 
        This method is the method that calculates the top left coordinates and bottom right coordinates
        The outcome is store in the 2d array. The width and height are also calculated.
        Before the Ellips is drawn, the colour is set.
        Finally the Ellips is Drawn.
    */
    public void paint(Graphics g) {
        g.setColor(c);
        if (leftEnd - leftStart < 0 && topEnd - topStart < 0) {
            width = leftStart - leftEnd;
            height = topStart - topEnd;
            g.drawOval(leftEnd, topEnd, width, height); //bottom right 1
            corners = new int[][]{
                {leftEnd, topEnd},
                {leftStart, topStart}
            };
            System.out.println("bottom right");
        } else if (leftEnd - leftStart > 0 && topEnd - topStart > 0) {
            width = leftEnd - leftStart;
            height = topEnd - topStart;
            g.drawOval(leftStart, topStart, leftEnd - leftStart, topEnd - topStart); //top left 3
            corners = new int[][]{
                {leftStart, topStart},
                {leftEnd, topEnd}
            };
            System.out.println("top left");
        } else if (leftStart - leftEnd > 0 && topStart - topEnd < 0) {
            width = leftStart - leftEnd;
            height = topEnd - topStart;
            g.drawOval(leftEnd, topStart, leftStart - leftEnd, topEnd - topStart);//top right 2
            corners = new int[][]{
                {leftEnd, topStart},
                {leftStart, topEnd}
            };
            System.out.println("top right");
        } else if (leftStart - leftEnd < 0 && topStart - topEnd > 0) {
            width = leftEnd - leftStart;
            height = topStart - topEnd;
            g.drawOval(leftStart, topEnd, leftEnd - leftStart, topStart - topEnd);//bottom left 4
            corners = new int[][]{
                {leftStart, topEnd},
                {leftEnd, topStart}
            };
            System.out.println("bottom left");
        }
    }
    
    /*
        This method is the second paint method, when all the calculation are done in the first.
    */
    public void Ppaint(Graphics g) {
        g.setColor(c);
        g.drawOval(corners[0][0], corners[0][1], width, height);
    }

}
