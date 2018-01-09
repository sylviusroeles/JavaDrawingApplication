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
public class State {
    public int state;
    
    /* 
        Sets the Application's current state
        @param state int
        1 = Ellips
        2 = Rectangle
        3 = Select
        4 = Move
        5 = Resize
        @ouput none
    */ 
    public void SetState(int state){
        this.state = state;
    }
    
    /* 
        Get's the Application's current state
        For possible values see SetState() method
        @output state
    */
    public int GetState(){
        return state;
    }
}
