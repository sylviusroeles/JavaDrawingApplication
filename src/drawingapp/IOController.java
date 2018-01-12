/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawingapp;

import java.awt.Graphics;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sylvius
 */
public class IOController {

    FileInputStream input = null;
    FileOutputStream output = null;
    BufferedReader br;
    Group group;
    int includetogroup;
    Rectangle rectangle;
    Ellipse ellips;
    Ornament ornament;
    Graphics g;
    boolean nextObjecthasOrnament = false;
    String ornamentText = "";
    Select select = new Select();
    Command command;
    ArrayList<Object> shapes = new ArrayList<>();

    //main method to load a file
    public ArrayList<Object> LoadFile(File file) throws IOException {
        if (isTextFile(file.getName())) {
            return ProcessFile(file);
        }
        return null;
    }

    public void setGraphics(Graphics g) {
        this.g = g;
    }

    public ArrayList<Object> ProcessFile(File file) throws IOException {
        br = new BufferedReader(new FileReader(file));
        try {
            String line = br.readLine();
            while (line != null) {
                String tabbedString = line.replaceAll("    ", "\t");
                int tabindex = 0; //for future group indexing
                for (char c : tabbedString.toCharArray()) {
                    if ("\t".equals("" + c)) {
                        tabindex++;
                    }
                }
                String noTabs = tabbedString.replaceAll("\\t", "");
                String[] SplitLine = noTabs.split(" ");
                command = new Command(g);
                Class param[] = new Class[SplitLine.length - 1];
                Object[] objects = new Object[SplitLine.length - 1];
                for (int i = 1; i < SplitLine.length; i++) {
                    if (SplitLine[i].startsWith("\"") && SplitLine[i].endsWith("\"") || !isNumeric(SplitLine[i])) {
                        param[i - 1] = String.class;
                        objects[i - 1] = SplitLine[i];
                    } else {
                        param[i - 1] = int.class;
                        objects[i - 1] = Integer.parseInt(SplitLine[i]);
                    } 
                }
                try {
                    Method test = command.getClass().getMethod(SplitLine[0].substring(0, 1).toUpperCase() + SplitLine[0].substring(1), param);
                    shapes.add(test.invoke(command, objects));
                } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    Logger.getLogger(IOController.class.getName()).log(Level.SEVERE, null, ex);
                }
                line = br.readLine();
            }
        } finally {
            br.close();
        }
        return shapes;
    }

//checks if the file is a text file
    public boolean isTextFile(String s) {
        return getFileExtension(s).equals("txt");
    }

    //get the file extension from the input
    public static String getFileExtension(String fullName) {
        String fileName = new File(fullName).getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }
    
    //checks if string is numeric
    public static boolean isNumeric(String str) {
        try {
            int d = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /*
                 if (line.startsWith("group")) {
                    group = new Group();
                    includetogroup = Integer.parseInt(SplitLine[1]);
                } else if (line.startsWith("rectangle")) {
                    rectangle = new Rectangle();
                    rectangle.setColor(Color.black);
                    rectangle.setCorners(0, 0, Integer.parseInt(SplitLine[1]));
                    rectangle.setCorners(0, 1, Integer.parseInt(SplitLine[2]));
                    rectangle.setWidth(Integer.parseInt(SplitLine[3]));
                    rectangle.setHeight(Integer.parseInt(SplitLine[4]));
                    rectangle.setCorners(1, 0, Integer.parseInt(SplitLine[1]) + Integer.parseInt(SplitLine[3]));
                    rectangle.setCorners(1, 1, Integer.parseInt(SplitLine[2]) + Integer.parseInt(SplitLine[4]));
                    select.addShape(rectangle);
                    if (includetogroup > 0) {
                        if(nextObjecthasOrnament){
                            
                            group.AddToGroup(rectangle);
                        }
                        includetogroup--;
                    }
                } else if (line.startsWith("ellipse")) {
                    ellips = new Ellips();
                    ellips.setColor(Color.black);
                    ellips.setCorners(0, 0, Integer.parseInt(SplitLine[1]));
                    ellips.setCorners(0, 1, Integer.parseInt(SplitLine[2]));
                    ellips.setWidth(Integer.parseInt(SplitLine[3]));
                    ellips.setHeight(Integer.parseInt(SplitLine[4]));
                    ellips.setCorners(1, 0, Integer.parseInt(SplitLine[1]) + Integer.parseInt(SplitLine[3]));
                    ellips.setCorners(1, 1, Integer.parseInt(SplitLine[2]) + Integer.parseInt(SplitLine[4]));
                    select.addShape(ellips);
                    if (includetogroup > 0) {
                        group.AddToGroup(ellips);
                        includetogroup--;
                    }
                } else if (line.startsWith("ornament")) {
                    ornamentText = SplitLine[1];
                    nextObjecthasOrnament = true;
                    if (includetogroup > 0) {
                        group.AddToGroup(ellips);
                        includetogroup--;
                    }
                }   
    
     */
}
