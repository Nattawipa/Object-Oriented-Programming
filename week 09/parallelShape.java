import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class parallelShape extends JPanel{

    private Path2D.Double parallelogram;

    public parallelShape(){
        parallelogram = new Path2D.Double();
        parallelogram.moveTo(0,0);
        parallelogram.lineTo(500,0);
        parallelogram.lineTo(1000,500);
        parallelogram.lineTo(500,500);
        parallelogram.closePath();

        setPreferredSize(new Dimension(100, 100));
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.BLACK);
        g2d.fill(parallelogram);
    }
    public static void main(String[] args){
        JFrame f = new JFrame();
        f.add(new parallelShape(), BorderLayout.CENTER);
        f.pack();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}