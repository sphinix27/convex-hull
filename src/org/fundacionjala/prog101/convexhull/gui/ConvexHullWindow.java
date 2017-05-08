package org.fundacionjala.prog101.convexhull.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by AbelBarrientos on 5/5/2017.
 */
public class ConvexHullWindow extends JFrame {

    //panel
    private JPanel panel;

    public ConvexHullWindow(String title)
    {
        //1. Init components
        super(title);
        //setLayout(null); DO NOT DO THIS

        panel = new ConvexHullPanel();
        panel.setSize(100, 100);

        //2. Set layout
        setSize(200, 150);

        add(panel);

        //3. Add event listeners
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[])
    {
        ConvexHullWindow window = new ConvexHullWindow("Convex Hull");

        //4. Show window
        window.setVisible(true);
    }
}
