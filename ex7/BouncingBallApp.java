import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BouncingBallApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Ball");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 700);
        BallPanel ballPanel = new BallPanel();
        frame.add(ballPanel);
        frame.setVisible(true);
    }
}

class BallPanel extends JPanel {
    //initial position of ball is 50,50
    private int x = 50;
    private int y = 50;
    private int xSpeed = 2;
    private int ySpeed = 2;
    private Thread ballThread;

    public BallPanel() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (ballThread == null || !ballThread.isAlive()) {
                    ballThread = new Thread(new BallRunnable());
                    ballThread.setPriority(Thread.NORM_PRIORITY); // Set thread priority (here NORM_PRIORITY = 5)
                    ballThread.start();
                }
            }
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);     //Set blue color
        g.fillOval(x, y, 30, 30);    // (x,y) -> position on screen || (30,30) -> horizontal and vertical radius
    }

    private class BallRunnable implements Runnable {
        public void run() {
            while (true) {
                moveBall();
                repaint();          //repaint to update the screen on each move of ball
                try {
                    Thread.sleep(5); //10 milliseconds interval
                } 
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private synchronized void moveBall() {
            x += xSpeed;    
            y += ySpeed;
            if (x <= 0 || x >= getWidth() - 30) {
                xSpeed = -xSpeed;
            }
            if (y <= 0 || y >= getHeight() - 30) {
                ySpeed = -ySpeed;
            }
        }
    }
}
