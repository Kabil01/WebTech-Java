import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

class BouncingBallsWithShadows extends JPanel {
    private ArrayList<Ball> balls = new ArrayList<>();

    public BouncingBallsWithShadows() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (balls.size() < 20) {
                    Color randomColor = getRandomColor();
                    Ball newBall = new Ball(e.getX(), e.getY(), randomColor);
                    balls.add(newBall);
                }
            }
        });

        // Create and start a separate animation thread
        Thread animationThread = new Thread(new AnimationRunnable());
        animationThread.start();
    }

    private Color getRandomColor() {
        Random random = new Random();
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set the background color
        setBackground(Color.WHITE);

        for (Ball ball : balls) {
            g.setColor(Color.BLACK);
            g.fillOval(ball.getX(), getHeight() - ball.getDiameter() / 3, ball.getDiameter(), ball.getDiameter() / 3);

            g.setColor(ball.getColor());
            g.fillOval(ball.getX(), ball.getY(), ball.getDiameter(), ball.getDiameter());
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Balls Example");
        BouncingBallsWithShadows bouncingBalls = new BouncingBallsWithShadows();
        frame.add(bouncingBalls);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private class Ball {
        private int x, y;
        private int diameter = 30;
        private int speedX, speedY;
        private Color color;

        public Ball(int x, int y, Color color) {
            this.x = x;
            this.y = y;
            this.color = color;
            Random random = new Random();
            speedX = random.nextInt(5) + 1;
            speedY = random.nextInt(5) + 1;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getDiameter() {
            return diameter;
        }

        public Color getColor() {
            return color;
        }

        public void updatePosition(int panelWidth, int panelHeight) {
            x += speedX;
            y += speedY;

            // Add a 3-D effect by changing the size of the ball when it hits the edge
            if (x < 0 || x + diameter > panelWidth) {
                speedX = -speedX;
                if (x < 0) x = 0; // Ensure the ball stays inside the panel
                else x = panelWidth - diameter; // Correct position at the right edge
                diameter += 5; // Increase the size of the ball
            }

            if (y < 0 || y + diameter > panelHeight) {
                speedY = -speedY;
                diameter -= 5; // Decrease the size of the ball
            }

            // Ensure the diameter stays within a reasonable range
            diameter = Math.max(20, Math.min(80, diameter));
        }
    }

    private class AnimationRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                // Update ball positions
                for (Ball ball : balls) {
                    ball.updatePosition(getWidth(), getHeight());
                }

                // Repaint the panel
                repaint();

                try {
                    Thread.sleep(20); // Delay for smooth animation
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
