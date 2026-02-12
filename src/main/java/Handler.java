import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Random;

public class Handler {
    LinkedList<GamaObject> object = new LinkedList<GamaObject>();
    LinkedList<Particle> particles = new LinkedList<Particle>();
    Random random = new Random();
    public float Colorspeed=0.7f;
    public int speed=0;
    public int type=0;
    public int player_tick=0;
    public int distance=0;
    int clonin=0;
    public boolean cloneb=false;
    public static int clonemod1=0;
    public static int clonemod2=0;
    public static boolean clonemod3=false;
    public static int cpmod1=0;
    public static int cpmod2=0;
    public static boolean cpmod3= false;
    public static int EnemysKilled=0;
    public static int Death=0;
    public int doublejump=0;
    public int doublejump1=0;
    public int dash=1;
    public int position;
    public boolean save=false;
    public long save2=0;
    public int gx = 3;
    public int SlowTime=0;
    public boolean DOWNY=true;
    boolean removal=false;
    public int BeaMode=0;
    Player.Char chareto;

    BufferedImage Coin;
    BufferedImage Vile;
    Random seed= new Random(Game.seed);
    Random Eneneyseed= new Random(Game.seed);
    Random itemSeed= new Random(Game.itemseed);
    public void tick(Game game){
        if (ShaniceMode.Shanicemode>0){
            game.gamestate= Game.STATE.ShaniceMode;
            return;
        }
        position+=gx;
        if (position%32<=-2+gx||position%32>=34-gx) {
            if (seed.nextInt(100) + 1 <= 30) {
                if (gx<15) {
                    addObject(new Wall(1067, 300, gx, 0, ID.Wall, this));
                    addObject(new Wall(1067 + 32, 300, gx, 0, ID.Wall, this));
                    if (Eneneyseed.nextInt(200)<=CharMenu.Endless_Difficulty_Enemy){
                        addObject(new Enemy(1067,261,gx,0,ID.Enemy, Player.Char.Enenmy1,this));
                    }
                }else {
                    int tempx = 1067-seed.nextInt(gx) ;
                    addObject(new Wall(tempx, 300+ seed.nextInt(gx-14), gx, 0, ID.Wall, this));
                    if (seed.nextBoolean()) {
                        addObject(new Wall(tempx + 32, 300+ seed.nextInt(gx-14), gx, 0, ID.Wall, this));
                    } else {
                        addObject(new Wall(tempx - 32, 300+ seed.nextInt(gx-14), gx, 0, ID.Wall, this));
                    }

                }
            }
            if (seed.nextInt(100) + 1 <= 26-(gx*2)) {
                if (Eneneyseed.nextInt(200)<=CharMenu.Endless_Difficulty_Enemy){
                    addObject(new Enemy(1067,161,gx,0,ID.Enemy, Player.Char.Enenmy1,this));
                }
                addObject(new Wall(1067, 200, gx, 0, ID.Wall, this));
                addObject(new Wall(1067+32, 200, gx, 0, ID.Wall, this));
            }else if (gx>14){
                if (seed.nextInt(100)+1<=30-gx) {
                    if (Eneneyseed.nextInt(200)<=CharMenu.Endless_Difficulty_Enemy){
                        addObject(new Enemy(1067,161,gx,0,ID.Enemy, Player.Char.Enenmy1,this));
                    }
                    addObject(new Wall(1067, 200, gx, 0, ID.Wall, this));
                    addObject(new Wall(1067+32, 200, gx, 0, ID.Wall, this));
                }
            }

        }

        speed += 36;
        player_tick+=gx*10;
        Colorspeed-=0.000036f;
        distance = distance+(gx-2);

        for(int i = 0;i<object.size();i++){
            GamaObject tempObject = object.get(i);
            if (tempObject.getChar()== Player.Char.Burckardt){
                chareto= Player.Char.Burckardt;
            }else if (tempObject.getChar()== Player.Char.Etta){
                chareto= Player.Char.Etta;
            }else if (tempObject.getChar()== Player.Char.Drauge){
                chareto = Player.Char.Drauge;
            }
        }
        if (chareto== Player.Char.Drauge){
            if (itemSeed.nextInt(3000)==1){
                addObject(new Item(1067,random.nextInt(200)+100,gx,0,ID.Heart,this,game));

            }
        }else if (chareto== Player.Char.Burckardt){
            if (itemSeed.nextInt(1500)==1){
                addObject(new Item(1067,random.nextInt(200)+100,gx,0,ID.Heart,this,game));

            }
        }else {
            if (itemSeed.nextInt(500)==1){
                addObject(new Item(1067,random.nextInt(200)+100,gx,0,ID.Heart,this,game));

            }
        }
        if (itemSeed.nextInt(500)==1){
            addObject(new Item(1067,random.nextInt(200)+100,gx,0,ID.Book,this,game));
        }
        if (itemSeed.nextInt(500)==1){
            addObject(new Item(1067,random.nextInt(200)+100,gx,0,ID.Coin,this,game));
        }
        if (player_tick>=400){
            player_tick=0;
            type++;
            if (type>3){
                type=0;
            }
        }
        if (speed>=100000){
            speed-=100000;
            gx++;

        }
        if (speed<0){
            speed+=100000;
            gx--;
        }
        for(int i = 0;i<object.size();i++){
            GamaObject tempObject = object.get(i);
            if (tempObject.getX()<=-512){
                removeObject(tempObject);
            }
            if (tempObject.y>1000&&tempObject.id==ID.Enemy){
                removal=true;
            }
            if (tempObject.getId()==ID.Player){
                if (Game.Createblocks>0){

                        for (int e=Game.Createblocks;e>0;e--){
                            addObject(new Wall(tempObject.x  +(e*8), tempObject.y+34, gx, 0, ID.Inkwall, this));
                        }
                        Game.Createblocks=0;
                }

                if (tempObject.getY()>750&&!save&&save2<1) {
                    if (tempObject.getChar()== Player.Char.Ipek&&random.nextBoolean()){
                        tempObject.gy=-80;
                        game.Action=50;
                    }else {
                        game.gamestate = Game.STATE.GameOver;
                        game.Timepassed -= 30000;
                    }
                }else if (tempObject.getY()>750&&save||tempObject.getY()>750&&save2>0){
                    game.gamestate = Game.STATE.Game;
                    if (!save){
                        save2--;
                    }
                    save=false;
                    tempObject.y=100;
                    tempObject.gy=0;
                    doublejump=1;

                }
                for (int e =0;e<object.size();e++){
                    GamaObject clone = object.get(e);
                    if (clone.id==ID.clone){
                        if (tempObject.y>600){
                            object.add(new Player(tempObject.x, clone.y, clone.gx,clone.gy,ID.Player,tempObject.chare,this,game));
                            cpmod1=clonemod1;
                            cpmod2=clonemod2;
                            cpmod3=clonemod3;
                            removeObject(clone);
                            removal=true;
                            break;
                        }
                    }
                }
            }else if (tempObject.id==ID.clone){
                if (tempObject.y>750){
                    object.remove(tempObject);
                }
                clonin++;
            } else {
                tempObject.setGx(gx);
                if (game.backpush>0){
                    tempObject.x+= game.backpush;
                }

            }
            if (clonin>0){
                clonin = 0;
                cloneb=true;
            }else{
                cloneb=false;
            }

            tempObject.tick();
            if (removal){
                removal=false;
                object.remove(tempObject);
                break;
            }
        }
        if (SlowTime>0){
            doublejump=1;
            SlowTime--;
        }
        for(int i = 0;i<particles.size();i++){
            Particle tempObject = particles.get(i);
            if (tempObject.x<=-64){
                particles.remove(tempObject);
            }
            if (tempObject.y>=600){
                particles.remove(tempObject);
            }
            if (tempObject.alpha<=0){
                particles.remove(tempObject);
            }
            tempObject.tick(this);
        }
        if (game.Action>0){
            game.Action--;
        }
        if (game.backpush>0){
            game.backpush--;
            Colorspeed+=0.000072f;
            speed-=72;
        }
        if (game.frontpush>0){
            game.frontpush--;
        }
        game.Score=distance/100+ game.Liebe+ game.Geld+game.Bildung;
        Time= (int) (29-(game.Timepassed/60000));
        TimeS= (int) (60-(game.Timepassed/1000));
        while (TimeS<0){
            TimeS+=60;
        }
        while (TimeS>60){
            TimeS-=60;
        }
        if (TimeS<=0&&Time<=0){
            game.gamestate= Game.STATE.Pause;
        }
    }
    int Time;
    int TimeS;
    public void render(Graphics g,Game game){
        GamaObject tempobject;
        g.setColor(Color.black);
        Font fnt2 = new Font("arial",1,20);
        g.setFont(fnt2);
        if (game.Streamermode){
            g.drawString(String.valueOf(Time),460,20);
            g.drawString(String.valueOf(TimeS),490,20);
        }
        SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
        Coin = ss.grabImage(2,2,32,32);
        Vile = ss.grabImage(3,1,32,32);
        for (int i = 0; i< object.size();i++){
            GamaObject tempObject = object.get(i);
            if (tempObject.x>=-32) {
                tempObject.render(g);
            }
            if (tempObject.id==ID.Player){
                tempobject=tempObject;
                if (tempobject.chare== Player.Char.Etta){
                    g.drawImage(Coin,700,20,null);
                }else if (tempobject.chare== Player.Char.Burckardt||tempobject.chare== Player.Char.Drauge){
                    g.drawImage(Vile,532,20,null);

                }else if (tempobject.chare== Player.Char.Jasnon){
                    g.drawString(String.valueOf(KeyInput.Jasniun),0,550);
                }
            }
        }
        for(int i = 0;i<particles.size();i++){
            Particle tempObject = particles.get(i);
            if (tempObject.x>-tempObject.width){
                tempObject.render(g);
            }

        }
        g.setColor(Color.BLACK);
        Font fnt3 = new Font("arial",1,20);
        g.setFont(fnt2);
        g.drawString("Fps:"+game.Frames,10,40);
        g.drawString("Score: "+ game.Score,10,15);
        g.drawString("Lvl: "+(gx-2),120,15);
        g.drawString(String.valueOf(EnemysKilled),11,100);
        g.drawString(String.valueOf(Death),11,200);
        g.drawString(String.valueOf(CharMenu.Endless_Difficulty_Enemy),11,300);
        g.drawString("x"+game.Geld,742,40);
        g.drawString("x"+game.Bildung,658,40);
        g.drawString("x"+game.Liebe,574,40);

    }


    public void addObject(GamaObject object){
        this.object.add(object);
    }

    public void removeObject(GamaObject object){
        this.object.remove(object);
    }
}
