import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SnakeGame extends JPanel implements ActionListener {

    int maxLength = 400;
    int[] snakeX = new int[maxLength];
    int[] snakeY = new int[maxLength];
    int snakeLength = 3;

    String direction = "RIGHT";
    Timer timer;

    public SnakeGame(){
        snakeX[0] = 80;snakeY[0] = 80;
        snakeX[1] = 60;snakeY[1] = 80;
        snakeX[2] = 40;snakeY[2] = 80;

        timer = new Timer(100, this);
        timer.start();
    }

    public void move(){
        for(int i = snakeLength - 1; i > 0; i--){
            snakeX[i] = snakeX[i - 1];
            snakeY[i] = snakeY[i - 1];
        }

        if(direction.equals("RIGHT")){
            snakeX[0] += 20;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        move();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 600, 600);

        g.setColor(Color.RED);
        g.fillRect(snakeX[0], snakeY[0], 20, 20);

        g.setColor(Color.GREEN);
        for(int i = 1; i < snakeLength; i++){
            g.fillRect(snakeX[i], snakeY[i], 20, 20);
        }
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Snake");
        SnakeGame game = new SnakeGame();
        frame.add(game);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    
    }
}
