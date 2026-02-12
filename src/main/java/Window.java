import org.imgscalr.Scalr;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Window extends Canvas {
    public static JFrame frame;
    public Window(int width, String title, Game game) {
        int height=600;
        JFrame frame = new JFrame(title);
        this.frame=frame;
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        System.out.println("Window Init");
        game.start();
    }
    public static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws Exception {
        return Scalr.resize(originalImage, Scalr.Method.SPEED, Scalr.Mode.FIT_EXACT, targetWidth, targetHeight);
    }
}
