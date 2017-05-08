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
        /*panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println(String.format("click at: %d, %d", e.getX(), e.getY()));
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                Graphics g = getGraphics();
                g.setColor(new Color(213, 237, 30));
                g.drawOval(x, y, 1, 1);
                g.drawLine(x, y, x, y);
                g.drawString("(" + x + "," + y + ")", x, y);
            }
        });*/
        panel.addMouseListener(new ConvexHullPanel.ConvexHullMouseListener());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[])
    {
        ConvexHullWindow window = new ConvexHullWindow("Convex Hull");

        //4. Show window
        window.setVisible(true);
    }
}
