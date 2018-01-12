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
public class Ellipse extends JPanel {

    int width, height;
    int[][] corners;
    Color c;

    public Ellipse() {
        corners = new int[][]{{0, 0}, {0, 0}};
    }

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

    //Gets the 2d array with the corner coordinates of the Ellips
    public int[][] getCorners() {
        return corners;
    }

    //Sets the index of the 2d array with a corner coordinate of the Ellips
    public void setCorner(int i, int y, int value) {
        corners[i][y] = value;
    }
    
    public void setCorners(int[][] corners){
        this.corners = corners;
        this.setWidth(corners[1][0] - corners[0][0]);
        this.setHeight(corners[1][1] - corners[0][1]);
    }

    //Sets the colour of the Ellips
    public void setColor(Color c) {
        this.c = c;
    }

    /*
        This method is the second paint method, when all the calculation are done in the first.
     */
    public void Ppaint(Graphics g) {
        g.setColor(c);
        g.drawOval(corners[0][0], corners[0][1], width, height);
    }

}
