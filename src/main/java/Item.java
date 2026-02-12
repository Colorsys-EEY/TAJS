import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.time.temporal.ChronoField;

public class Item extends GamaObject{
    private BufferedImage Vile;
    private BufferedImage Heart;
    private BufferedImage Book;
    private BufferedImage Coin;
    private BufferedImage muni;
    private BufferedImage ink;
    private BufferedImage Acid;
    private BufferedImage Slowpotion;
    private BufferedImage Bigpotion;
    private BufferedImage redChromosome;
    private BufferedImage greenChromosome;
    private BufferedImage blueChromosome;
    private BufferedImage Time;
    private BufferedImage Coffe;
    private BufferedImage Controller;
    private BufferedImage Cpu;
    private BufferedImage Pixel;
    private BufferedImage Electricity;
    private Player.Char aChar;
    Game game;
    public Item(int x, int y, int gx, int gy, ID id,Handler handler,Game game) {
        super(x, y, gx, gy, id, Player.Char.none);
        this.handler = handler;
        this.game=game;
        SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
        Vile = ss.grabImage(3,1,32,32);
        Heart = ss.grabImage(2,3,32,32);
        Book = ss.grabImage(2,1,32,32);
        Coin = ss.grabImage(2,2,32,32);
        muni = ss.grabImage(3,2,32,32);
        ink = ss.grabImage(3,4,32,32);
        Acid = ss.grabImage(4,1,32,32);
        Slowpotion = ss.grabImage(4,2,32,32);
        Bigpotion =ss.grabImage(4,3,32,32);
        redChromosome= ss.grabImage(5,3,32,32);
        greenChromosome= ss.grabImage(5,2,32,32);
        blueChromosome= ss.grabImage(5,1,32,32);
        Time=ss.grabImage(4,4,32,32);
        Coffe=ss.grabImage(5,4,32,32);
        Controller=ss.grabImage(6,4,32,32);
        Cpu=ss.grabImage(6,1,32,32);
        Pixel=ss.grabImage(6,2,32,32);
        Electricity=ss.grabImage(6,3,32,32);
    }
    Handler handler;
    public void tick() {
        if (game.gamestate!= Game.STATE.ShaniceMode) {
            x -= gx;
        }
        collision();
    }

    public void render(Graphics g) {
        if (id== ID.Heart){
            Graphics2D g2d =  (Graphics2D) g;
            g.setColor(Color.RED);
            for (int i = 0;i<handler.object.size();i++){
                GamaObject player = handler.object.get(i);
                if (player.getChar()== Player.Char.Burckardt){
                    g.drawImage(Vile,x,y,null);
                }else if (player.getChar()== Player.Char.Drauge){
                    g.drawImage(Vile,x,y,null);
                }else if (player.getChar()== Player.Char.Etta){
                    g.drawImage(Heart,x,y,null);
                }else if (player.getChar()== Player.Char.Marko){
                    g.drawImage(Heart,x,y,null);
                }else if (player.getChar()== Player.Char.Mattis){
                    g.drawImage(Heart,x,y,null);
                }else if (player.getChar()== Player.Char.Jasnon){
                    g.drawImage(Acid,x,y,null);
                }else if(player.getChar()==Player.Char.Hanno){
                    g.drawImage(redChromosome,x,y,null);
                } else if (player.getChar()== Player.Char.Caro) {
                    g.drawImage(Time,x,y,null);
                }else if (player.chare== Player.Char.Shanice) {
                    g.drawImage(Controller,x,y,null);
                }else if (player.chare== Player.Char.Emely) {
                    g.drawImage(Cpu,x,y,null);
                } else if (player.chare!= Player.Char.none) {
                    g.drawImage(Heart,x,y,null);
                }
            }

        }else if (id == ID.Book){
            Graphics2D g2d =  (Graphics2D) g;
            g.setColor(Color.GREEN);
            for (int i = 0;i<handler.object.size();i++){
                GamaObject player = handler.object.get(i);
                if (player.getChar()== Player.Char.Burckardt||player.getChar()== Player.Char.Drauge){
                    g.drawImage(Book,x,y,null);
                }else if (player.getChar()== Player.Char.Etta){
                    g.drawImage(Book,x,y,null);
                }else if (player.getChar()== Player.Char.Marko){
                    g.drawImage(muni,x,y,null);
                }else if (player.getChar()== Player.Char.Mattis){
                    g.drawImage(ink,x,y,null);
                }else if (player.getChar()== Player.Char.Jasnon){
                    g.drawImage(Slowpotion,x,y,null);
                }else if(player.getChar()==Player.Char.Hanno){
                    g.drawImage(greenChromosome,x,y,null);
                }else if (player.getChar()== Player.Char.Caro){
                    g.drawImage(Book,x,y,null);
                }else if (player.chare== Player.Char.Emely) {
                    g.drawImage(Pixel,x,y,null);
                } else if (player.chare!= Player.Char.none) {
                    g.drawImage(Book,x,y,null);
                }
            }
        }else {
            Graphics2D g2d =  (Graphics2D) g;
            g.setColor(Color.YELLOW);
            for (int i = 0;i<handler.object.size();i++){
                GamaObject player = handler.object.get(i);
                if (player.getChar()== Player.Char.Jasnon){
                    g.drawImage(Bigpotion,x,y,null);
                }else if (player.chare== Player.Char.Hanno){
                    g.drawImage(blueChromosome,x,y,null);
                }else if (player.chare== Player.Char.Rabea){
                    g.drawImage(Coffe,x,y,null);
                }else if (player.chare== Player.Char.Emely) {
                    g.drawImage(Electricity,x,y,null);
                }else if (player.chare!= Player.Char.none){
                    g.drawImage(Coin,x,y,null);
                }
            }

        }
        if (Game.SHOWHIT){
            g.setColor(Color.RED);
            g.drawRect(x,y,32,32);

        }
    }
    private void collision(){
        for (int i = 0;i<handler.object.size();i++){
            GamaObject tempObject = handler.object.get(i);
            if (tempObject.getId()==ID.Wall){
                if(getBounds().intersects(tempObject.getBounds())){
                    y--;
                }
            }
            if (tempObject.getId()==ID.Player){
                if (getBounds().intersects((tempObject.getBounds()))){
                    if (id==ID.Heart){
                        game.Liebe++;
                        for (int i1=0;i1<18;i1++){
                            handler.particles.add(new jumpparticle(x,y,3,3,255,0,0,false,false));
                        }
                        System.out.println("Item");
                    }
                    if (id==ID.Book){
                        game.Bildung++;
                        for (int i1=0;i1<18;i1++){
                            handler.particles.add(new jumpparticle(x,y,3,3,0,255,0,false,false));
                        }
                        System.out.println("Item");
                    }
                    if (id==ID.Coin){
                        game.Geld++;
                        for (int i1=0;i1<18;i1++){
                            handler.particles.add(new jumpparticle(x,y,3,3,255,255,0,false,false));
                        }
                        System.out.println("Item");
                    }
                    x=-3100;

                }
            }else if (tempObject.id == ID.Bullet){
                if (getBounds().intersects((tempObject.getBounds()))){
                    if (id==ID.Heart){
                        game.Liebe++;
                        for (int i1=0;i1<28;i1++){
                            handler.particles.add(new jumpparticle(x,y,3,3,255,0,0,false,false));
                        }
                        System.out.println("Item");
                    }
                    if (id==ID.Book){
                        game.Bildung++;
                        for (int i1=0;i1<28;i1++){
                            handler.particles.add(new jumpparticle(x,y,3,3,0,255,0,false,false));
                        }
                        System.out.println("Item");
                    }
                    if (id==ID.Coin){
                        game.Geld++;
                        for (int i1=0;i1<28;i1++){
                            handler.particles.add(new jumpparticle(x,y,3,3,255,255,0,false,false));
                        }
                        System.out.println("Item");
                    }
                    x=-3100;

                }
            }
        }
        for (int i = 0;i<handler.particles.size();i++){
            Particle tempObject = handler.particles.get(i);
            if (getBounds().intersects((tempObject.getBounds()))){
                if (id==ID.Heart){
                    game.Liebe++;
                    for (int i1=0;i1<18;i1++){
                        handler.particles.add(new jumpparticle(x,y,3,3,255,0,0,false,false));
                    }
                    System.out.println("Item");
                }
                if (id==ID.Book){
                    game.Bildung++;
                    for (int i1=0;i1<18;i1++){
                        handler.particles.add(new jumpparticle(x,y,3,3,0,255,0,false,false));
                    }
                    System.out.println("Item");
                }
                if (id==ID.Coin){
                    game.Geld++;
                    for (int i1=0;i1<18;i1++){
                        handler.particles.add(new jumpparticle(x,y,3,3,255,255,0,false,false));
                    }
                    System.out.println("Item");
                }
                x=-3100;
            }
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x,y,32,32);
    }
    public Rectangle getBounds2(){return new Rectangle(x,y,0,0);}
}
