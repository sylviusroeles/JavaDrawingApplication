/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawingapp;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sylvius
 */
public class History {

    ArrayList<Object> historylist = new ArrayList<>();
    int historyIndex = 0;

    public History() {

    }

    public void setHistoryIndex(int index) {
        if (index >= -1 && index <= historylist.size()) {
            this.historyIndex = index;
        }
    }

    public int getHistoryIndex() {
        return historyIndex;
    }

    public ArrayList<Object> getVisibleHistory() {
        ArrayList<Object> temp = new ArrayList<>();
        for (int i = 0; i < historyIndex; i++) {
            temp.add(historylist.get(i));
        }
        return temp;
    }

    public void addToHistory(Object o) {
        historylist.add(0, o);
        historyIndex++;
        //System.out.println(historylist.size() + " : " + getVisibleHistory().size());
    }

    public void addToHistoryWithIndex(Object o, int index) {
        historylist.add(index, o);
        //historyIndex++;
        //System.out.println(historylist.size() + " : " + getVisibleHistory().size());
    }

    public void addListToHistory(ArrayList<Object> list) {
        ArrayList<Object> templist = new ArrayList<>();
        templist.addAll(list);
        templist.addAll(historylist);
        historylist.addAll(templist);
        historyIndex += list.size();
    }

    public ArrayList<Object> getHistoryList() {
        return historylist;
    }

    public void HistoryDedug() {
        for (Object o : historylist) {
            try {
                Method method = o.getClass().getMethod("getCorners");
                int[][] corners = (int[][]) method.invoke(o);
                System.out.println(corners[0][0] + " | " + corners[0][1]);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
                Logger.getLogger(History.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
