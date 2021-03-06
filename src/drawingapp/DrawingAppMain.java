/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawingapp;

import java.awt.Color;
import java.awt.Graphics;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sylvius
 */
public class DrawingAppMain extends javax.swing.JFrame {

    /**
     * Creates new form DrawingAppMain
     */
    State state = new State();
    Rectangle rectangle;
    Ellips ellips;
    Select select = new Select();

    public DrawingAppMain() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EllipsButton = new javax.swing.JButton();
        RectangleButton = new javax.swing.JButton();
        DrawingField = new javax.swing.JPanel();
        MouseCoords = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Select = new javax.swing.JButton();
        Move = new javax.swing.JButton();
        Resize = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DrawingApp");
        setBackground(new java.awt.Color(204, 204, 204));

        EllipsButton.setText("Ellips");
        EllipsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EllipsButtonActionPerformed(evt);
            }
        });

        RectangleButton.setText("Rectangle");
        RectangleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RectangleButtonActionPerformed(evt);
            }
        });

        DrawingField.setBackground(new java.awt.Color(204, 204, 204));
        DrawingField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        DrawingField.setForeground(new java.awt.Color(204, 204, 204));
        DrawingField.setMaximumSize(new java.awt.Dimension(796, 505));
        DrawingField.setPreferredSize(new java.awt.Dimension(796, 505));
        DrawingField.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                DrawingFieldMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                DrawingFieldMouseMoved(evt);
            }
        });
        DrawingField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DrawingFieldMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                DrawingFieldMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout DrawingFieldLayout = new javax.swing.GroupLayout(DrawingField);
        DrawingField.setLayout(DrawingFieldLayout);
        DrawingFieldLayout.setHorizontalGroup(
            DrawingFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 794, Short.MAX_VALUE)
        );
        DrawingFieldLayout.setVerticalGroup(
            DrawingFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Drawing Tools");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Other Tools");

        Select.setText("Select");
        Select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectActionPerformed(evt);
            }
        });

        Move.setText("Move");
        Move.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoveActionPerformed(evt);
            }
        });

        Resize.setText("Resize");
        Resize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(EllipsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MouseCoords)
                    .addComponent(RectangleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Select, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Move, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Resize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(DrawingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EllipsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RectangleButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Select)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Move)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Resize)
                        .addGap(0, 320, Short.MAX_VALUE))
                    .addComponent(DrawingField, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MouseCoords)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EllipsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EllipsButtonActionPerformed
        state.SetState(1);
    }//GEN-LAST:event_EllipsButtonActionPerformed

    private void RectangleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RectangleButtonActionPerformed
        state.SetState(2);
    }//GEN-LAST:event_RectangleButtonActionPerformed

    private void DrawingFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DrawingFieldMousePressed
        Graphics g = DrawingField.getGraphics();
        switch (state.GetState()) {
            case 1:
                ellips = new Ellips();
                ellips.initEllips(evt.getX(), evt.getY());
                break;
            case 2:
                rectangle = new Rectangle();
                rectangle.initRectangle(evt.getX(), evt.getY());
                break;
            case 3: {
                try {
                    select.setGraphics(g);
                    select.FindClosestShape(evt);
                } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    Logger.getLogger(DrawingAppMain.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case 4: {
                select.setGraphics(g);
                try {
                    if(!select.getIsMoving()){
                        select.Move(evt);
                        select.setIsMoving(true);
                    } else {
                        select.setIsMoving(false);
                    }
                } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    Logger.getLogger(DrawingAppMain.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case 5: {
                select.setGraphics(g);
                    if(!select.getIsResizing()){
                    try {
                        select.Resize(evt);
                    } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                        Logger.getLogger(DrawingAppMain.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        select.setIsResizing(true);
                    } else {
                        select.setIsResizing(false);
                    }
                break;
            }
            default:
                break;
        }
    }//GEN-LAST:event_DrawingFieldMousePressed

    private void DrawingFieldMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DrawingFieldMouseReleased
        Graphics g = DrawingField.getGraphics();
        switch (state.GetState()) {
            case 1:
                ellips.endEllips(evt.getX(), evt.getY());
                ellips.setColor(Color.black);
                ellips.paint(g);
                select.addShape(ellips);
                break;
            case 2:
                rectangle.endRectangle(evt.getX(), evt.getY());
                rectangle.setColor(Color.black);
                rectangle.paint(g);
                select.addShape(rectangle);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_DrawingFieldMouseReleased

    private void DrawingFieldMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DrawingFieldMouseMoved
        MouseCoords.setText("(x:" + evt.getX() + ",y:" + evt.getY() + ")");
        if (state.GetState() == 4 && select.getSelectedShape() != null && select.getselectedIsValid()) {
            try {
                select.Move(evt);
            } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(DrawingAppMain.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullPointerException ex) {

            }
        }
        if (state.GetState() == 5 && select.getSelectedShape() != null && select.getselectedIsValid()) {
            try {
                select.Resize(evt);
            } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(DrawingAppMain.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullPointerException ex) {

            }
        }
    }//GEN-LAST:event_DrawingFieldMouseMoved

    private void DrawingFieldMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DrawingFieldMouseDragged
        DrawingFieldMouseMoved(evt);
    }//GEN-LAST:event_DrawingFieldMouseDragged

    private void SelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectActionPerformed
        state.SetState(3);
    }//GEN-LAST:event_SelectActionPerformed

    private void MoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoveActionPerformed
        state.SetState(4);
    }//GEN-LAST:event_MoveActionPerformed

    private void ResizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResizeActionPerformed
        state.SetState(5);
    }//GEN-LAST:event_ResizeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DrawingAppMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DrawingAppMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DrawingAppMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DrawingAppMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DrawingAppMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DrawingField;
    private javax.swing.JButton EllipsButton;
    private javax.swing.JLabel MouseCoords;
    private javax.swing.JButton Move;
    private javax.swing.JButton RectangleButton;
    private javax.swing.JButton Resize;
    private javax.swing.JButton Select;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
