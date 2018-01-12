/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawingapp;

/**
 *
 * @author Sylvius
 */
public class Math {
    
    public Math(){
        
    }
    
    public int[][] get2dCoordinates(int leftStart, int leftEnd, int topStart, int topEnd){
        if (leftEnd - leftStart < 0 && topEnd - topStart < 0) { //bottom right 1
            int width = leftStart - leftEnd;
            int height = topStart - topEnd;
            System.out.println("bottom right");
            return new int[][]{
                {leftEnd, topEnd}, //top left coordinates
                {width, height}
            };
        } else if (leftEnd - leftStart > 0 && topEnd - topStart > 0) { //top left 3
            int width = leftEnd - leftStart;
            int height = topEnd - topStart;
            System.out.println("top left");
            return new int[][]{
                {leftStart, topStart},
                {width, height}
            };
        } else if (leftStart - leftEnd > 0 && topStart - topEnd < 0) { //top right 2
            int width = leftStart - leftEnd;
            int height = topEnd - topStart;
            System.out.println("top right");
            return new int[][]{
                {leftEnd, topStart},
                {width, height}
            };
        } else if (leftStart - leftEnd < 0 && topStart - topEnd > 0) { //bottom left 4
            int width = leftEnd - leftStart;
            int height = topStart - topEnd;
            System.out.println("bottom left");
            return new int[][]{
                {leftStart, topEnd},
                {width, height}
            };
        } else {
            System.out.println("null");
            return null;
        }
    }
    
}
