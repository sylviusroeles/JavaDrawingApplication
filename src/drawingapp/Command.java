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
public class Command {
    
    public Command(){
    }
    
    public void Select(){
        
    }
    
    public void Resize(){
        
    }
    
    public void Move(){
        
    }
    
    public void Group(int size){
        System.out.println("Group");
    }
    
    public void Ellipse(int sx, int sy, int width, int height){
        System.out.println("Ellipse");
    }
    
    public void Rectangle(int sx, int sy, int width, int height){
        System.out.println("Rectangle");
    }
    
    public void Ornament(String alignment, String s){
        System.out.println("Ornament");
    }
    
    public void Undo(){
        
    }
    
    public void Redo(){
        
    }
}
