import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class BallPanel extends JPanel {
    private static final int MAX_BALLS = 20;
    private List<Ball> balls = new ArrayList<>();

    public BallPanel() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (balls.size() < MAX_BALLS) {
                    addBall(e.getX(), e.getY());
                }
            }
        });

        Timer timer = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                moveBalls();
                repaint();
            }
        });
        timer.start();
    }

    private void addBall(int x, int y) {
        Random random = new Random();
        Color randomColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        balls.add(new Ball(x, y, randomColor));
    }

    private void moveBalls() {
        for (Ball ball : balls) {
            ball.move();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Ball ball : balls) {
            ball.draw(g);
        }
    }
}

class Ball {
    private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;
    private Color color;

    public Ball(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        Random random = new Random();
        this.xSpeed = random.nextInt(5) + 1;
        this.ySpeed = random.nextInt(5) + 1;
        this.color = color;
    }

    public void move() {
        x += xSpeed;
        y += ySpeed;
        if (x <= 0 || x >= 770) {
            xSpeed = -xSpeed;
        }
        if (y <= 0 || y >= 570) {
            ySpeed = -ySpeed;
        }
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, 30, 30);
    }
}

public class BouncingBallsApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Balls");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        BallPanel ballPanel = new BallPanel();
        frame.add(ballPanel);
        frame.setVisible(true);

        // Create a thread to continuously repaint the panel
        Thread animationThread = new Thread(() -> {
            while (true) {
                ballPanel.repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        animationThread.start();
    }
}
