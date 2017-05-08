package org.fundacionjala.prog101.convexhull.gui;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by AbelBarrientos on 5/5/2017.
 */
public class ConvexHullPanel extends javax.swing.JPanel {

    public ConvexHullPanel()
    {
        setBackground(new Color(73, 93, 119));
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);

        g.setColor(new Color(213, 237, 30));
        g.drawLine(getWidth()/2, 0, getWidth()/2,getHeight());
        g.drawLine(0, getHeight()/2, getWidth(),getHeight()/2);
    }

    public static class ConvexHullMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            System.out.println(String.format("click at: %d, %d", e.getX(), e.getY()));
            System.out.println("Windows size: " + e.getComponent().getSize().toString());
        }
    }
}
