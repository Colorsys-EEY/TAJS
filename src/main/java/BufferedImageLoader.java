import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class BufferedImageLoader {
    BufferedImage image;
    public BufferedImage loadImage(String path){
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResource(path)));
        } catch (IOException e) {
            System.out.println("couldnt find spriteesheet");
        }
        return image;
    }
}
