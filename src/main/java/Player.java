import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Player extends GamaObject{
    private BufferedImage player_image;
    private BufferedImage player_jump;
    private BufferedImage player_walk1;
    private BufferedImage player_walk2;
    private BufferedImage player_Action;
    private BufferedImage Burckhardt;
    private BufferedImage Burckhardt1;
    private BufferedImage Burckhardt2;
    private BufferedImage Burckhardt3;
    private BufferedImage Marko;
    private BufferedImage bigjason;
    private BufferedImage player_smoll;
    public static int big;
    public static boolean Standing=false;
    int pushback;
    Game game;
    Handler handler;
    int previosY;
    int futureY;
    public static int graphicY;
    public enum Char{
      Etta,
      Burckardt,
      Marko,
      Mattis,
      Drauge,
      Jasnon,
      Hanno,
      Caro,
      Andre,
      Rabea,
      Rike,
      Ipek,
      Milan,
      Kiki,
      Shanice,
      Emely,
      Enenmy1,
      Enemy2,
      Enemy3,
      none
    };
    public Player(int x, int y, int gx, int gy, ID id,Char chare,Handler handler,Game game) {
        super(x, y, gx, gy, id,chare);
        this.handler = handler;
        this.game=game;
        SpriteSheet ss = new SpriteSheet(Game.playersheet);
        SpriteSheet ss2 = new SpriteSheet(Game.bigjason);
        if (chare==Char.Etta) {
            player_image = ss.grabAImage(1, 1, 48, 48, 48);
            player_jump = ss.grabAImage(1, 4, 48, 48, 48);
            player_walk1 = ss.grabAImage(1, 2, 48, 48, 48);
            player_walk2 = ss.grabAImage(1, 3, 48, 48, 48);
            player_Action = ss.grabAImage(1,6,48,48,48);
            player_smoll = ss.grabAImage(1,5,48,48,48);
        }else if (chare==Char.Burckardt){
            player_image = ss.grabAImage(2, 1, 48, 48, 48);
            player_jump = ss.grabAImage(2, 4, 48, 48, 48);
            player_walk1 = ss.grabAImage(2, 2, 48, 48, 48);
            player_walk2 = ss.grabAImage(2, 3, 48, 48, 48);
            player_Action = ss.grabAImage(2,6,48,48,48);
            player_smoll = ss.grabAImage(2,5,48,48,48);
            Burckhardt=ss.grabAImage(3,1,48,48,48);
            Burckhardt1=ss.grabAImage(3,4,48,48,48);
            Burckhardt2=ss.grabAImage(3,2,48,48,48);
            Burckhardt3=ss.grabAImage(3,3,48,48,48);
        }else if (chare==Char.Marko){
            player_image = ss.grabAImage(7,1,48,48,48);
            player_jump = ss.grabAImage(7, 4, 48, 48, 48);
            player_walk1 = ss.grabAImage(7, 2, 48, 48, 48);
            player_walk2 = ss.grabAImage(7, 3, 48, 48, 48);
            player_smoll = ss.grabAImage(7,5,48,48,48);
        }else if (chare==Char.Mattis){
            player_image = ss.grabAImage(6,1,48,48,48);
            player_jump = ss.grabAImage(6, 4, 48, 48, 48);
            player_walk1 = ss.grabAImage(6, 2, 48, 48, 48);
            player_walk2 = ss.grabAImage(6, 3, 48, 48, 48);
            player_Action = ss.grabAImage(6,6,48,48,48);
            player_smoll = ss.grabAImage(6,5,48,48,48);
        }else if (chare==Char.Drauge){
            player_image = ss.grabAImage(4,1,48,48,48);
            player_jump = ss.grabAImage(4, 4, 48, 48, 48);
            player_walk1 = ss.grabAImage(4, 2, 48, 48, 48);
            player_walk2 = ss.grabAImage(4, 3, 48, 48, 48);
            player_Action = ss.grabAImage(4,6,48,48,48);
            player_smoll = ss.grabAImage(4,5,48,48,48);
            Burckhardt=ss.grabAImage(5,1,48,48,48);
            Burckhardt1=ss.grabAImage(5,4,48,48,48);
            Burckhardt2=ss.grabAImage(5,2,48,48,48);
            Burckhardt3=ss.grabAImage(5,3,48,48,48);
        }else if (chare==Char.Jasnon){
            player_image = ss.grabAImage(9,1,48,48,48);
            player_jump = ss.grabAImage(9, 4, 48, 48, 48);
            player_walk1 = ss.grabAImage(9, 2, 48, 48, 48);
            player_walk2 = ss.grabAImage(9, 3, 48, 48, 48);
            player_Action = ss.grabAImage(9,6,48,48,48);
            player_smoll = ss.grabAImage(9,5,48,48,48);
        }else if(chare==Char.Hanno){
            player_image = ss.grabAImage(10,1,48,48,48);
            player_jump = ss.grabAImage(10,4,48,48,48);
            player_walk1 = ss.grabAImage(10, 2, 48, 48, 48);
            player_walk2 = ss.grabAImage(10, 3, 48, 48, 48);
            player_Action = ss.grabAImage(10,6,48,48,48);
            player_smoll = ss.grabAImage(10,5,48,48,48);
        } else if (chare==Char.Caro) {
            player_image = ss.grabAImage(13,1,48,48,48);
            player_jump = ss.grabAImage(13,4,48,48,48);
            player_walk1 = ss.grabAImage(13, 2, 48, 48, 48);
            player_walk2 = ss.grabAImage(13, 3, 48, 48, 48);
            player_Action = ss.grabAImage(13,6,48,48,48);
            player_smoll = ss.grabAImage(13,5,48,48,48);
        }else if (chare==Char.Andre) {
            player_image = ss.grabAImage(14,1,48,48,48);
            player_jump = ss.grabAImage(14,4,48,48,48);
            player_walk1 = ss.grabAImage(14, 2, 48, 48, 48);
            player_walk2 = ss.grabAImage(14, 3, 48, 48, 48);
            player_Action = ss.grabAImage(14,6,48,48,48);
            player_smoll = ss.grabAImage(14,5,48,48,48);
        }else if (chare==Char.Rabea) {
            player_image = ss.grabAImage(15,1,48,48,48);
            player_jump = ss.grabAImage(15,4,48,48,48);
            player_walk1 = ss.grabAImage(15, 2, 48, 48, 48);
            player_walk2 = ss.grabAImage(15, 3, 48, 48, 48);
            player_Action = ss.grabAImage(15,6,48,48,48);
            player_smoll = ss.grabAImage(15,5,48,48,48);
        }else if (chare==Char.Rike) {
            player_image = ss.grabAImage(16,1,48,48,48);
            player_jump = ss.grabAImage(16,4,48,48,48);
            player_walk1 = ss.grabAImage(16, 2, 48, 48, 48);
            player_walk2 = ss.grabAImage(16, 3, 48, 48, 48);
            player_Action = ss.grabAImage(16,6,48,48,48);
            player_smoll = ss.grabAImage(16,5,48,48,48);
        }else if (chare==Char.Ipek) {
            player_image = ss.grabAImage(17,1,48,48,48);
            player_jump = ss.grabAImage(17,4,48,48,48);
            player_walk1 = ss.grabAImage(17, 2, 48, 48, 48);
            player_walk2 = ss.grabAImage(17, 3, 48, 48, 48);
            player_Action = ss.grabAImage(17,6,48,48,48);
            player_smoll = ss.grabAImage(17,5,48,48,48);
        }else if (chare==Char.Milan) {
            player_image = ss.grabAImage(18,1,48,48,48);
            player_jump = ss.grabAImage(18,4,48,48,48);
            player_walk1 = ss.grabAImage(18, 2, 48, 48, 48);
            player_walk2 = ss.grabAImage(18, 3, 48, 48, 48);
            player_Action = ss.grabAImage(18,6,48,48,48);
            player_smoll = ss.grabAImage(18,5,48,48,48);
        }else if (chare==Char.Kiki) {
            player_image = ss.grabAImage(19,1,48,48,48);
            player_jump = ss.grabAImage(19,4,48,48,48);
            player_walk1 = ss.grabAImage(19, 2, 48, 48, 48);
            player_walk2 = ss.grabAImage(19, 3, 48, 48, 48);
            player_Action = ss.grabAImage(19,6,48,48,48);
            player_smoll = ss.grabAImage(19,5,48,48,48);
        }else if (chare==Char.Shanice) {
            player_image = ss.grabAImage(12,1,48,48,48);
            player_jump = ss.grabAImage(12,4,48,48,48);
            player_walk1 = ss.grabAImage(12, 2, 48, 48, 48);
            player_walk2 = ss.grabAImage(12, 3, 48, 48, 48);
            player_Action = ss.grabAImage(12,6,48,48,48);
            player_smoll = ss.grabAImage(12,5,48,48,48);
        }else if (chare==Char.Emely) {
            player_image = ss.grabAImage(8,1,48,48,48);
            player_jump = ss.grabAImage(8,4,48,48,48);
            player_walk1 = ss.grabAImage(8, 2, 48, 48, 48);
            player_walk2 = ss.grabAImage(8, 3, 48, 48, 48);
            player_Action = ss.grabAImage(8,6,48,48,48);
            player_smoll = ss.grabAImage(8,5,48,48,48);
        }

        bigjason=ss2.grabAImage(1,1,64,64,64);


        Marko=ss.grabAImage(7,6,48,48,48);
    }


    public void tick() {
        if (handler.BeaMode>0){
            handler.BeaMode--;
            collision();
        }else {
            if (big > 0) {
                big--;
            }
            previosY = y;
            if (gx > 0) {
                x += gx;
                gx--;
            }
            if (!Standing) {
                if (x > 50) {
                    x--;
                } else if (x < 50) {
                    x++;
                }
                if (x > 100) {
                    x--;
                }
                if (x > 200) {
                    x--;
                    pushback = 3;
                }
                if (x > 400 && handler.gx > 3) {
                    x--;
                    pushback = 4;
                }
                if (x > 800 && handler.gx > 4) {
                    x--;
                    pushback = 5;
                }
                if (x > 1067) {
                    x = 1067;
                    gx--;
                }
            }else {
                x-=handler.gx;
                if (x<0){
                    Standing=false;
                }
            }
            SpriteSheet ss = new SpriteSheet(Game.playersheet);

            if (gy <= 0) {
                y += gy;
                gy++;
            }
            collision();
            if (gy > 0 && game.backpush == 0 && gx == 0) {
                if (handler.SlowTime > 0) {
                    y -= gy / 2;
                }
                if (chare==Char.Rike){
                    y-= gy*0.7;
                }
                y += gy - handler.cpmod2;
                if (gy<=30){
                    gy++;
                }
            }
            collision();
            if (handler.doublejump==0&&gy<0 &&chare==Char.Kiki){
                game.Action=2;
            }

            futureY = y + 10;

        }
    }
    private void collision(){
        for (int i = 0;i<handler.object.size();i++){
            GamaObject tempObject = handler.object.get(i);
            if (tempObject.getId()==ID.Wall||tempObject.getId()==ID.Bullet||tempObject.getId()==ID.Inkwall){
                if (getBounds().intersects(tempObject.getBounds())){
                    for (int e=0;e<5;e++){
                        if (tempObject.y+16>=y&&getBounds().intersects(tempObject.getBounds())){
                            y--;
                        }
                    }
                    setGy(0);
                }
            }
            if (tempObject.id==ID.EnBullet){
                if (getBounds().intersects(tempObject.getBounds())){
                    if (gx<1) {
                        y = 740;
                    }else{
                        handler.removeObject(tempObject);
                    }
                }
            }
        }

    }

    public void render(Graphics g) {
        Graphics2D g2d =  (Graphics2D) g;
        if (game.ANIMATION) {
            if (game.gamestate== Game.STATE.ShaniceMode){
                graphicY = y;
            }else if (gy <= -10) {
                graphicY = previosY;
            } else if (gy >= 10) {
                graphicY = futureY;
            } else {
                graphicY = y;
            }
        } else {
            graphicY = y;
        }
        if (big>0){
            g.drawImage(bigjason,x,graphicY,null);
        }else{
            if (game.backpush>0) {
                g.drawImage(Marko,x,graphicY,null);
            }else if (game.Action>0) {
                g.drawImage(player_Action,x,graphicY,null);
            }else if (handler.save||handler.save2>0) {
                if (gy<0) {
                    g.drawImage(Burckhardt1,x,graphicY,null);
                }else if (gx>0) {
                    g.drawImage(Burckhardt1,x,graphicY,null);
                }else if (handler.type==0) {
                    g.drawImage(Burckhardt2,x,graphicY,null);
                }else if (handler.type==2) {
                    g.drawImage(Burckhardt3,x,graphicY,null);
                }else {
                    g.drawImage(Burckhardt,x,graphicY,null);
                }
            }else if (gy<0) {
                g.drawImage(player_jump,x,graphicY,null);
            }else if (gx>0) {
                g.drawImage(player_jump,x,graphicY,null);
            }else if (gy>5) {
                g.drawImage(player_smoll,x,graphicY,null);
            }else if (handler.gx==pushback) {
                g.drawImage(player_image,x,graphicY,null);
            }else if (handler.type==0) {
                g.drawImage(player_walk1,x,graphicY,null);
            }else if (handler.type==2) {
                g.drawImage(player_walk2,x,graphicY,null);
            }else {
                g.drawImage(player_image,x,graphicY,null);
            }
            if (Game.SHOWHIT){
                g.setColor(Color.RED);
                g.drawRect(getBounds().x,getBounds().y,getBounds().width,getBounds().height);
                g.setColor(Color.white);
                g.drawRect(getBounds2().x,getBounds2().y,getBounds2().width,getBounds2().height);
            }
        }

    }


    public Rectangle getBounds() {
        if (big>0){
            return new Rectangle(x,y,50,52);
        }
        if (chare==Char.Rabea){
            return new Rectangle(x,y-1,32,38);
        }
        if (chare==Char.Milan){
            return new Rectangle(x-4,y,36,40);
        }
        return new Rectangle(x, y, 32,39);
    }
    public Rectangle getBounds2(){
        if (big>0){
            return new Rectangle(x-50,y,100,72);
        }
        if (chare==Char.Andre){
            return new Rectangle(x-64,y-32,128,113);
        }
        if (chare==Char.Milan){
            return new Rectangle(x-34,y,70,51);
        }
        return new Rectangle(x-32,y,64,49);
    }

}
