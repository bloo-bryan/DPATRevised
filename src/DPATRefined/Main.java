package DPATRefined;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Main extends JFrame implements ActionListener {
    JButton drawBtn;
    JPanel rootPanel, drawPanel;

    int winWidth = 1200;
    int winHeight = 700;
    Color[] shapeColor = {Color.orange, Color.red, Color.yellow,
            Color.blue, Color.pink, Color.cyan, Color.magenta,
            Color.black, Color.gray};

    public static void main(String[] args){
        new Main();
    }

    public Main(){
        this.setSize(winWidth,winHeight);
        this.setTitle("Shape Generator");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        rootPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout());
        drawPanel = new JPanel();
        drawBtn = new JButton("Start Drawing");
        drawBtn.addActionListener(this);

        rootPanel.add(drawPanel,  BorderLayout.CENTER);
        rootPanel.add(drawBtn, BorderLayout.SOUTH);

        this.add(rootPanel);
        this.setVisible(true);
    }

    private int getRandX(){ return (int)(Math.random()*winWidth); }
    private int getRandY(){ return (int)(Math.random()*winHeight); }
    private Color getRandColor(){
        Random randomGenerator = new Random();
        int randInt = randomGenerator.nextInt(9);
        return shapeColor[randInt];
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == drawBtn) {
            Graphics g = drawPanel.getGraphics();
            long startTime = System.currentTimeMillis();
            for(int i=0; i < 200000; ++i) {
                // Uses rectangles stored in the HashMap to
                // speed up the program

                if(i > 100000) {
                    ShapeStrategy strategy = CircleFactory.getCirc(getRandColor());
                    strategy.draw(g, getRandX(), getRandY(), getRandX(), getRandY());
                    //g.setColor(getRandColor());
                    //g.drawOval(getRandX(), getRandY(), getRandX(), getRandY());
                    //g.fillOval(getRandX(), getRandY(), getRandX(), getRandY());
//                } else if(i > 70000) {
//                    Triangle triangle = TriangleFactory.getTriangle(getRandColor());
//                    for(int j = 0; j < 3; j++) {
//                        triangle.x[j] = getRandX();
//                        triangle.y[j] = getRandY();
//                    }
//                    triangle.draw(g);
                } else {
                    ShapeStrategy strategy = RectangleFactory.getRect(getRandColor());
                    //Rect rect = RectangleFactory.getRect(getRandColor());
                    strategy.draw(g, getRandX(), getRandY(), getRandX(), getRandY());
                }

            }
            long endTime = System.currentTimeMillis();

            System.out.println("That took " + (endTime - startTime) + " milliseconds");

        }
    }
}