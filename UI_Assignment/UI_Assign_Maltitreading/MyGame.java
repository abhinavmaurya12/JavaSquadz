import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyGame extends JPanel implements ActionListener {

    int y3, x4, y4, z1, z2, r1, r2, r3;
    int x1 = 500, x2 = 900, y1 = 30, y2 = 200, x3, w;
    Color c1, c2;
    JPanel p1, p2;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;

    public void show() {

        setPreferredSize(new Dimension(900, 650));
        setBackground(new Color(130, 209, 218));
        c1 = new Color(r1, r2, r3);
        setLayout(null);

        p1 = new JPanel();
        p2 = new JPanel();
        b1 = new JButton("START");
        b2 = new JButton("STOP");

        b3 = new JButton("RED");
        b4 = new JButton("GREEN");
        b5 = new JButton("BLUE");

        b4.setBounds(200, 350, 40, 30);
        b5.setBounds(250, 350, 40, 30);
        p1.setBounds(520, 520, 400, 35);
        p2.setBounds(420, 570, 600, 35);

        p1.add(b1);
        p1.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6 = new JButton("PINK");

        p2.add(b6);
        b6.addActionListener(this);
        b7 = new JButton("ORANGE");

        p2.add(b7);
        b7.addActionListener(this);
        b8 = new JButton("YELLOW");

        p2.add(b7);
        b8.addActionListener(this);
        b9 = new JButton("MAGENTA");

        p2.add(b8);
        b9.addActionListener(this);
        b10 = new JButton("BLACK");

        b10.addActionListener(this);
        add(p1);
        add(p2);

        setVisible(true);

        b1.setBackground(Color.gray);
        b2.setBackground(Color.gray);
        b3.setBackground(Color.red);
        b4.setBackground(Color.green);
        b5.setBackground(Color.blue);
        b6.setBackground(Color.pink);
        b7.setBackground(Color.orange);
        b8.setBackground(Color.yellow);
        b9.setBackground(Color.black);
        b10.setBackground(Color.black);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(c1);
        g.fillOval(x1, y1, 50, 50);
        g.fillOval(x2, y2, 50, 50);

        z1 = c1.getRGB();
        if (z1 == z2) {
            //g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString("WIN", 700, 50);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b3) {
            c2 = Color.RED;
            z2 = c2.getRGB();
        }
        if (e.getSource() == b4) {
            c2 = Color.GREEN;
            z2 = c2.getRGB();
        }
        if (e.getSource() == b5) {
            c2 = Color.BLUE;
            z2 = c2.getRGB();
        }
        if (e.getSource() == b6) {
            c2 = Color.PINK;
            z2 = c2.getRGB();
        }
        if (e.getSource() == b7) {
            c2 = Color.orange;
            z2 = c2.getRGB();
        }
        if (e.getSource() == b8) {
            c2 = Color.yellow;
            z2 = c2.getRGB();
        }
        if (e.getSource() == b9) {
            c2 = Color.magenta;
            z2 = c2.getRGB();
        }
        if (e.getSource() == b10) {
            c2 = Color.BLACK;
            z2 = c2.getRGB();
        }
        if (e.getSource() == b1) {
            w = 1;

            new Thread1(this);
            new Thread2(this);
            new Thread3(this);
            new Thread4(this);
            new Thread5(this);
            new Thread6(this);
            new Thread7(this);
            new Thread8(this);
            new Thread9(this);

        }
        if (e.getSource() == b2) {
            w = 0;
        }
    }

    public static void main(String[] args) {

        JFrame jf = new JFrame("Game Centered Output");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Heading
        JLabel heading = new JLabel("Ball Game Design Copy By Abhinav Maurya");
        heading.setFont(new Font("Arial", Font.BOLD, 28));
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setForeground(Color.orange); // optional for visibility

        // Game panel
        MyGame gamePanel = new MyGame();
        gamePanel.show();

        // Create vertical layout
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BorderLayout());
        wrapper.add(heading, BorderLayout.NORTH);
        wrapper.add(gamePanel, BorderLayout.CENTER);

        jf.setContentPane(wrapper);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }
}

class Thread1 extends Thread {

    MyGame ball;

    Thread1(MyGame ball) {
        this.ball = ball;
        start();
    }

    public void run() {
        System.out.println("THREAD1");
        while (ball.w == 1) {
            if (ball.x1 >= 1150) {
                ball.x1 = 300;
            }
            if (ball.x2 >= 1150) {
                ball.x2 = 300;
            }
            if (ball.y1 >= 400) {
                ball.y1 = 100;
            }
            if (ball.y2 >= 400) {
                ball.y2 = 100;
            } else {
                ball.x1 = ball.x1 + 10;
                ball.x2 = ball.x2 + 4;
                ball.y1 = ball.y1 + 4;
                ball.y2 = ball.y2 + 3;
            }

            ball.repaint();
        }
        try {
            Thread.sleep(50000);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}

class Thread2 extends Thread {

    MyGame ball;

    Thread2(MyGame ball) {
        this.ball = ball;
        start();
    }

    public void run() {
        while (ball.w == 1) {
            ball.c1 = Color.red;
            ball.repaint();
        }

        try {
            Thread.sleep(50000);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}

class Thread3 extends Thread {

    MyGame ball;

    Thread3(MyGame ball) {
        this.ball = ball;
        start();
    }

    public void run() {
        System.out.println("THREAD3");
        while (ball.w == 1) {
            ball.c1 = Color.GREEN;
            ball.repaint();
        }

        try {
            Thread.sleep(50000);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}

class Thread4 extends Thread {

    MyGame ball;

    Thread4(MyGame ball) {
        this.ball = ball;
        start();
    }

    public void run() {
        System.out.println("THREAD4");
        while (ball.w == 1) {
            ball.c1 = Color.BLUE;
            ball.repaint();
        }

        try {
            Thread.sleep(50000);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}

class Thread5 extends Thread {

    MyGame ball;

    Thread5(MyGame ball) {
        this.ball = ball;
        start();
    }

    public void run() {
        System.out.println("THREAD5");
        while (ball.w == 1) {
            ball.c1 = Color.PINK;
            ball.repaint();
        }

        try {
            Thread.sleep(50000);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}

class Thread6 extends Thread {

    MyGame ball;

    Thread6(MyGame ball) {
        this.ball = ball;
        start();
    }

    public void run() {
        while (ball.w == 1) {
            ball.c1 = Color.orange;
            ball.repaint();
        }

        try {
            Thread.sleep(50000);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}

class Thread7 extends Thread {

    MyGame ball;

    Thread7(MyGame ball) {
        this.ball = ball;
        start();
    }

    public void run() {
        while (ball.w == 1) {
            ball.c1 = Color.YELLOW;
            ball.repaint();
        }

        try {
            Thread.sleep(50000);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}

class Thread8 extends Thread {

    MyGame ball;

    Thread8(MyGame ball) {
        this.ball = ball;
        start();
    }

    public void run() {
        while (ball.w == 1) {
            ball.c1 = Color.GREEN;
            ball.repaint();
        }

        try {
            Thread.sleep(50000);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}

class Thread9 extends Thread {

    MyGame ball;

    Thread9(MyGame ball) {
        this.ball = ball;
        start();
    }

    public void run() {
        System.out.println("THREAD3");
        while (ball.w == 1) {
            ball.c1 = Color.GREEN;
            ball.repaint();
        }

        try {
            Thread.sleep(50000);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}