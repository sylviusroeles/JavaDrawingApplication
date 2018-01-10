/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawingapp;

import java.util.ArrayList;

/**
 *
 * @author Sylvius
 */
public class Group {
    ArrayList<Object> group;
    int tabindex;
    
    public Group(int tabindex){
        this.tabindex = tabindex;
        group = new ArrayList<>();
    }
    
    public void AddToGroup(Object o){
        group.add(o);
        System.out.println("Added to: "+ tabindex);
    }
    
    public void RemoveFromGroup(Object o){
        group.remove(o);
    }
}
