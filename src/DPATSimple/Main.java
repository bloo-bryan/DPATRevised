package DPATSimple;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Main extends JFrame implements ActionListener {
    JButton drawBtn;
    JPanel rootPanel, drawPanel;

    int winWidth = 1200;
    int winHeight = 700;
    Color[] shapeColor = {Color.orange, Color.red, Color.yellow,
            Color.blue, Color.pink, Color.cyan, Color.magenta,
            Color.black, Color.gray};
    File path = new File(System.getProperty("user.dir"));
    BufferedImage image = ImageIO.read(new File(path, "zombie.png"));

    public static void main(String[] args) throws IOException {
        new Main();
    }

    public Main() throws IOException {
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

    // Picks random x & y coordinates

    private int getRandX(){ return (int)(Math.random()*winWidth); }

    private int getRandY(){ return (int)(Math.random()*winHeight); }

    // Picks a random Color from the 9 available

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

//                MyRect rect = RectFactory.getRect(getRandColor());
//                rect.draw(g, getRandX(), getRandY(),
//                        getRandX(), getRandY());
                if(i > 100000) {
                    Circ circ = new Circ(getRandColor(), getRandX(), getRandY(), getRandX(), getRandY());
                    circ.draw(g);
                    //g.setColor(getRandColor());
                    //g.drawOval(getRandX(), getRandY(), getRandX(), getRandY());
                    //g.fillOval(getRandX(), getRandY(), getRandX(), getRandY());
                } else if(i > 50000) {
                    try {
                        g.drawImage(image, getRandX(), getRandY(), getRandColor(), null);
                    } catch(Exception ex) {
                        System.out.println("Cannot read image");
                    }
                } else {
                    Rect rect = new Rect(getRandColor(), getRandX(), getRandY(), getRandX(), getRandY());
                    rect.draw(g);
                    //g.setColor(getRandColor());
                    //g.fillRect(getRandX(), getRandY(), getRandX(), getRandY());
                }

            }
            long endTime = System.currentTimeMillis();

            System.out.println("That took " + (endTime - startTime) + " milliseconds");

        }
    }
}