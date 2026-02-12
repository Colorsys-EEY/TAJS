import java.awt.*;
import java.awt.image.BufferedImage;

public class Clone extends GamaObject{
    private BufferedImage player_image;
    private BufferedImage player_jump;
    private BufferedImage player_walk1;
    private BufferedImage player_walk2;
    Game game;
    Handler handler;
    public Clone(int x, int y, int gx, int gy, ID id, Player.Char chare,Handler handler,Game game) {
        super(x, y, gx, gy, id, chare);
        this.handler = handler;
        this.game=game;
        SpriteSheet ss = new SpriteSheet(Game.playersheet);
        player_image = ss.grabAImage(11,1,48,48,48);
        player_jump = ss.grabAImage(10,4,48,48,48);
        player_walk1 = ss.grabAImage(10, 2, 48, 48, 48);
        player_walk2 = ss.grabAImage(10, 3, 48, 48, 48);
    }

    @Override
    public void tick() {
        if (handler.clonemod3 == false) {
            if (gy <= 0) {
                y += gy;
                gy++;
            }
            if (gy > 0 && game.backpush == 0 && game.frontpush == 0) {
                y += gy - handler.clonemod2;
                gy++;
            }
        }
        collision();
    }
    private void collision(){
        for (int i = 0;i<handler.object.size();i++){
            GamaObject tempObject = handler.object.get(i);
            if (tempObject.getId()==ID.Wall||tempObject.getId()==ID.Bullet||tempObject.getId()==ID.Inkwall){
                if(getBounds().intersects(tempObject.getBounds())){
                    for (int e=0;e<5;e++){
                        if (tempObject.y+16>=y&&getBounds().intersects(tempObject.getBounds())){
                            y--;
                        }
                    }
                    setGy(0);
                }
            }
        }

    }
    @Override
    public void render(Graphics g) {
        if (handler.clonemod3){
            g.drawImage(player_image, x, y, null);
        }else {
            g.drawImage(player_walk1,x,y,null);
        }
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32,39);
    }

    @Override
    public Rectangle getBounds2() {
        return new Rectangle(x-48,y,80,49);
    }
}
