package org.example;

import javax.swing.*;
import java.awt.*;

public class GameActivity extends JFrame{

    private JLabel countdownLabel;
    private int countdown = 3;

    public GameActivity() {
        int boardWidth = 360;
        int boardHeight = 640;
        JFrame frame = new JFrame("Flappy Bird");
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FlappyBird flappyBird = new FlappyBird();
        frame.add(flappyBird);
        frame.pack(); // Resizes frame to fit the preferred size of flappyBird
        flappyBird.requestFocus();

        frame.setVisible(true); // Show the frame **after** adding components and packing

        //startCountdown();


    }

    public void frameWork(){
        int boardWidth = 360;
        int boardHeight = 640;
        JFrame frame = new JFrame("Flappy Bird");
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FlappyBird flappyBird = new FlappyBird();
        frame.add(flappyBird);
        frame.pack(); // Resizes frame to fit the preferred size of flappyBird
        flappyBird.requestFocus();

        frame.setVisible(true); // Show the frame **after** adding components and packing
    }


    private void startCountdown() {
        Timer timer = new Timer(1000, e -> {
            if (countdown > 0) {
                countdownLabel.setText(String.valueOf(countdown));
                countdown--;
            } else {
                ((Timer) e.getSource()).stop();
                countdownLabel.setText("GO!");
                // Optional: after short delay, start your game logic here
                new Timer(1000, evt -> {

                    // Launch your game window here
                    // Example: new GameWindow();
                }).start();
            }
        });
        timer.start();
    }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(GameActivity::new);
        }
}
