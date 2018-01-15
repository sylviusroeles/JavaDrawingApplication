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
public class Rectangle extends JPanel {

    private int width, height;
    private int[][] corners = new int[2][2];
    Color c;

    public Rectangle() {
        corners = new int[][]{{0, 0}, {0, 0}};
    }
    
    public Rectangle(int width, int height, int[][] corners, Color c){
        this.width = width;
        this.height = height;
        this.corners = new int[][]{{corners[0][0],corners[0][1]},{corners[1][0], corners[1][1]}};
        this.c = c;
    }
    
    //Get the width of the Rectangle
    public int getWidth() {
        return width;
    }

    //Set the width of the Rectangle
    public int getHeight() {
        return height;
    }

    //Get the height of the Rectangle
    public void setHeight(int height) {
        this.height = height;
    }

    //Set the height of the Rectangle
    public void setWidth(int width) {
        this.width = width;
    }

    //Gets the 2d array with the corner coordinates of the Rectangle
    public int[][] getCorners() {
        return corners;
    }

    //Sets the index of the 2d array with a corner coordinate of the Rectangle
    public void setCorner(int i, int y, int value) {
        corners[i][y] = value;
    }

    public void setCorners(int[][] corners) {
        this.corners = corners;
        this.setWidth(corners[1][0] - corners[0][0]);
        this.setHeight(corners[1][1] - corners[0][1]);
    }

    //Sets the colour of the Rectangle
    public void setColor(Color c) {
        this.c = c;
    }

    /*
        This method is the second paint method, when all the calculation are done in the first.
     */
    public void Ppaint(Graphics g) {
        g.setColor(c);
        g.drawRect(corners[0][0], corners[0][1], width, height);
        //System.out.println("cornerx: " + corners[0][0] + " cornery: " + corners[0][1] + " width: " + width + " height: " + height);
    }
}
