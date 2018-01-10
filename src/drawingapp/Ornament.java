/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawingapp;

import java.awt.Graphics;

/**
 *
 * @author Sylvius
 */
public class Ornament {
    
    int x,y;
    String s;
    Graphics g;
    
    public Ornament(String s){
        this.s = s;
    }
    
    public void setGraphics(Graphics g){
        this.g = g;
    }
    
    //Creates the ornament
    public void paintOrnament(){
        g.drawString(s, x, y);
    }
    
}
