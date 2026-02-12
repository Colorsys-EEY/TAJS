import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ShaniceMode extends KeyAdapter {
    Handler handler;
    Game game;
    public boolean up;
    public boolean down;
    public boolean left;
    public boolean right;
    public static int Shanicemode;
    public ShaniceMode(Handler handler, Game game){
        this.game=game;
        this.handler=handler;
    }
    public void keyPressed(KeyEvent event){
        int key=event.getKeyCode();
        if (key==KeyEvent.VK_W){
            up=true;
        }else if (key==KeyEvent.VK_S){
            down=true;
        }else if (key==KeyEvent.VK_A){
            left=true;
        }else if (key==KeyEvent.VK_D){
            right=true;
        } else if (key==KeyEvent.VK_SHIFT) {
            if (game.gamestate== Game.STATE.ShaniceMode&&Shanicemode<=450){
                Shanicemode=10;
            }
        }
    }
    public void keyReleased(KeyEvent event){
        int key=event.getKeyCode();
        if (key==KeyEvent.VK_W){
            up=false;
        }else if (key==KeyEvent.VK_S){
            down=false;
        }else if (key==KeyEvent.VK_A){
            left=false;
        }else if (key==KeyEvent.VK_D){
            right=false;
        }
    }
    public void tick(){
        if (game.Action>0){
            game.Action--;
        }
        Shanicemode--;
        for (int i = 0; i < handler.object.size(); i++) {
            GamaObject tempObject = handler.object.get(i);
            if (tempObject.getId() == ID.Player) {
                if (game.gamestate== Game.STATE.ShaniceMode) {
                    if (up) {
                        tempObject.gy = -2;
                    }
                    if (down) {
                        tempObject.gy = 2;
                    }
                    if (left) {
                        tempObject.gx = -2;
                    }
                    if (right) {
                        tempObject.gx = 2;
                    }
                    if (tempObject.gx > 0) {
                        tempObject.x += tempObject.gx;
                        tempObject.gx--;
                    }
                    if (tempObject.gx < 0) {
                        tempObject.x += tempObject.gx;
                        tempObject.gx++;
                    }
                    if (tempObject.gy > 0) {
                        tempObject.y += tempObject.gy;
                        tempObject.gy--;
                    }
                    if (tempObject.gy < 0) {
                        tempObject.y += tempObject.gy;
                        tempObject.gy++;
                    }
                    if (Shanicemode<=0){
                        handler.doublejump=1;
                        tempObject.gx=0;
                        tempObject.gy=0;
                        tempObject.tick();
                        game.gamestate= Game.STATE.Game;
                        return;
                    }
                }
            }
            if (tempObject.getId()==ID.Book||tempObject.getId()==ID.Coin||tempObject.getId()==ID.Heart){
                tempObject.tick();
            }
        }

    }
    public void render(Graphics g){
    }
}
