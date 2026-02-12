import java.awt.image.BufferedImage;

public class SpriteSheet {
    private BufferedImage sprite;

    public SpriteSheet(BufferedImage ss){
        this.sprite=ss;
    }

    public BufferedImage grabImage(int col,int row, int width,int height){
        BufferedImage img = sprite.getSubimage(row*32-32,col*32-32,width,height);
        return img;
    }
    public BufferedImage grabAImage(int col, int row,int width, int height,int size){
        BufferedImage img = sprite.getSubimage(row*size-size,col*size-size,width,height);
        return img;
    }
}
