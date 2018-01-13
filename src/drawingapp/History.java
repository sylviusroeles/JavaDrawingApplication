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
public class History {

    ArrayList<ArrayList<Object>> historylist = new ArrayList<>();
    int historyIndex = 0;

    public History() {
        historylist.add(new ArrayList<>());
    }

    public void setHistoryIndex(int index) {
        if (index > -1 && index < historylist.size()) {
            this.historyIndex = index;
        }
    }

    public int getHistoryIndex() {
        return historyIndex;
    }

    public void addToHistory(ArrayList<Object> o) {
        //System.out.println(o.size());
        historylist.add(new ArrayList<>(o));
        historyIndex++;
    }
    
    public void addToHistoryI(int i, ArrayList<Object> o) {
        //System.out.println(o.size());
        historylist.add(i, new ArrayList<>(o));
        //historyIndex++;
    }

    public ArrayList<Object> getHistoryList() {
        System.out.println(historyIndex + " " + historylist.get(historyIndex).size());
        return historylist.get(historyIndex);
    }
    
    public void HistoryDebug(){
        for(ArrayList<Object> a: historylist){
            System.out.println(a.size());
        }
    }

}
