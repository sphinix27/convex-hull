package org.fundacionjala.prog101.convexhull.gui;

import javax.swing.*;

/**
 * Created by AbelBarrientos on 5/5/2017.
 */
public class ConvexHullWindow extends JFrame {
    public ConvexHullWindow(String title)
    {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[])
    {
        ConvexHullWindow window = new ConvexHullWindow("Convex Hull");

        window.setVisible(true);
    }
}
