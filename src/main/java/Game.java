



import javax.print.attribute.standard.Media;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.*;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class  Game extends Canvas implements Runnable {
    public static boolean Verified=true;
    private Handler handler;
    public int amountOfFrames;
    float speedcolor=0;
    public int backpush=0;
    public int Action=0;
    public int frontpush=0;
    public static boolean GRAPHICS=true;
    public static int ARS=2;
    public static int RS=2;
    public static boolean ANIMATION=true;
    public static int Createblocks;
    public static boolean SHOWHIT=false;
    public float height;
    public float width;
    public float last_height=600;
    public float last_width=800;
    Random random = new Random();
    public static int Liebe=0;
    public static int Bildung=0;
    public static int Geld= 0;
    public int players;
    public int Score;
    public boolean Streamermode=false;
    public long Timelast;
    public long TimeNow;
    public long Timepassed;
    private Thread thread;
    private boolean running = false;
    Colorscheme csm= new Colorscheme();

    private Menu menu;
    private GameOver over;
    private CharMenu chm;
    private Pause pause;
    public ComingSoon cms;
    public LOCK lck;
    public Settings setn;
    public WorldSelect wrld;
    public ShaniceMode shn;
    public static int seed=1;
    public static int itemseed=2;

    public enum STATE{
        Menu,
        Game,
        CharMenu,
        GameOver,
        ComingSoon,
        Pause,
        Lock,
        Settings,
        ModeSelect,
        ShaniceMode,
    };

    public static STATE gamestate=STATE.Menu;

    public static BufferedImage sprite_sheet;
    public static BufferedImage playersheet;
    public static BufferedImage gui_sheet;
    public static BufferedImage Burckhardtsheet;
    public static BufferedImage Mrkobg;
    public static BufferedImage Ettabg;
    public static BufferedImage Mattisbg;
    public static BufferedImage Burckhartbg;
    public static BufferedImage DraugeBg;
    public static BufferedImage Burckhardtbg2;
    public static BufferedImage PlaceholderBg;
    public static BufferedImage Matrix;
    public static BufferedImage bigjason;
    public static BufferedImage Enemys;

    public static BufferedImage MENU;
    public static BufferedImage BLURMENU;
    public static BufferedImage Play;
    public static BufferedImage Settings;
    public static BufferedImage Online;
    public static BufferedImage Story;
    public static BufferedImage Arcade;
    public static BufferedImage FAST;
    public static BufferedImage FANCY;

    public static AAudioPlayer audi;

    public Game(){

        handler = new Handler();

        chm= new CharMenu(this);
        over = new GameOver(this,handler,chm);
        menu = new Menu(this,handler,chm);
        cms= new ComingSoon(handler);
        pause = new Pause();
        setn= new Settings();
        wrld=new WorldSelect(this);
        audi = new AAudioPlayer();
        shn = new ShaniceMode(handler,this);
        System.out.println("Gamestates: Initialized");


        BufferedImageLoader loader = new BufferedImageLoader();
        sprite_sheet=loader.loadImage("newSpritesheet.png");
        playersheet=loader.loadImage("newPlayersheet.png");
        gui_sheet=loader.loadImage("newGuisheet.png");
        Mrkobg=loader.loadImage("MarkoBg.png");
        Ettabg=loader.loadImage("Ettabg.png");
        Mattisbg=loader.loadImage("Mattusbg.png");
        Burckhartbg= loader.loadImage("BurckhardtBg.png");
        DraugeBg= loader.loadImage("DraugeBg.png");
        Burckhardtsheet=loader.loadImage("BurckhardtSheet.png");
        bigjason=loader.loadImage("bigjasonNEW.png");
        MENU=loader.loadImage("Menu.png");
        BLURMENU=loader.loadImage("blurmenu.png");
        PlaceholderBg=loader.loadImage("placeholder.png");
        Matrix=loader.loadImage("matrixuuuuuh.png");
        Enemys=loader.loadImage("enemys.png");
        SpriteSheet ss = new SpriteSheet(gui_sheet);
        Play=ss.grabAImage(1,1,300,64,64);
        Settings=ss.grabAImage(6,1,300,64,64);
        Online=ss.grabAImage(3,1,300,64,64);
        Story=ss.grabAImage(2,1,300,64,64);
        Arcade=ss.grabAImage(7,1,300,64,64);
        FAST=gui_sheet.getSubimage(0,976,32,32);
        FANCY=gui_sheet.getSubimage(32,976,32,32);
        System.out.println("Graphic initialized");
        new Window(1067,"TAJS",this);



        this.addKeyListener(new KeyInput(handler,this));
        this.addMouseListener(menu);
        this.addKeyListener(over);
        this.addKeyListener(shn);
        System.out.println("Game Initialized");
    }


    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
        AudioThread thready= new AudioThread();
        Thread thread2 = new Thread(thready);
        thread2.start();

    }
    public synchronized void stop(){
        try {
            thread.join();
            running = false;
        } catch (InterruptedException e) {
            System.out.println("Couldnt join thread");
        }

    }
    int Frames;
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        long lastTime1 = System.currentTimeMillis();
        double amountOfTicks = 60.0;
        amountOfFrames = 60*(ARS+1);
        long maxTime = 1000/amountOfFrames;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        int rendertic=0;
        height=this.getHeight();
        width=this.getWidth();
        try {
            Mrkobg = Window.resizeImage(Mrkobg,(int) width,(int)height);
            Burckhardtbg2 = Window.resizeImage(Burckhartbg,(int) width,(int)height);
            Ettabg = Window.resizeImage(Ettabg,(int) width,(int)height);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        while (running){
            long now = System.nanoTime();
            long now1 = System.currentTimeMillis();
            delta += (now-lastTime)/ns;
            lastTime = now;
            lastTime1= now1;
            rendertic++;
            while (delta >= 1){
                tick();
                delta--;
            }
            if (rendertic>ARS){
                rendertic=0;
            }
            if (running&&rendertic==ARS){
                render();
                frames++;
            }
            now1=System.currentTimeMillis();
            if (now1-lastTime1 <= maxTime){
                try {
                    Thread.sleep(maxTime-(now1-lastTime1));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (System.currentTimeMillis()-timer>1000){
                timer+= 1000;
                Frames =frames;
                frames = 0;
            }


        }
        stop();
    }

    private void tick(){
        amountOfFrames=60*(ARS+1);
        if (GRAPHICS){
            ARS=RS;
        }else {
            ARS=RS*2;
        }
        TimeNow = System.currentTimeMillis();
        height=this.getHeight();
        width=this.getWidth();
        if (last_height!=height||last_width!=width){
            try {
                Mrkobg = Window.resizeImage(Mrkobg,(int) width,(int)height);
                Burckhardtbg2 = Window.resizeImage(Burckhartbg,(int) width,(int)height);
                Ettabg = Window.resizeImage(Ettabg,(int) width,(int)height);
            } catch (Exception e) {
                e.printStackTrace();
            }
            last_width=width;
            last_height=height;
        }
        if (gamestate == STATE.Game){
            if (Streamermode){
                Timepassed+=TimeNow-Timelast;
            }
            if (!this.hasFocus()){
                gamestate=STATE.Pause;
            }
            handler.tick(this);

        }else if (gamestate == STATE.Menu){
            menu.tick();
        }else if (gamestate == STATE.GameOver){
            over.tick();
        }else if (gamestate==STATE.CharMenu){
            chm.tick();
        }else if (gamestate==STATE.Pause){
            pause.tick();
        }else if (gamestate==STATE.ComingSoon){
            cms.tick(this);
        }else if (gamestate==STATE.Lock){
            lck.tick();
        } else if (gamestate==STATE.Settings) {
            setn.tick();
        } else if (gamestate== STATE.ModeSelect) {
            wrld.tick();
        } else if (gamestate== STATE.ShaniceMode) {
            shn.tick();
        }
        Timelast=TimeNow;
    }


    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.GRAY);
        g.fillRect(0,0,(int)width,(int)height);
        if (gamestate == STATE.Game){
            speedcolor=handler.Colorspeed;
            speedcolor-=0.6;
            while (speedcolor<0){
                speedcolor+=1;
            }
            if (handler.SlowTime==0) {
                csm.fastGradiant(g, speedcolor, 6, (int) width, (int) height);
            }else {
                csm.fastGradiant(g,handler.Colorspeed,1, (int) width, (int) height);
            }
            for(int i = 0;i<handler.object.size();i++){
                GamaObject tempObject = handler.object.get(i);
                if (tempObject.id==ID.Player) {
                    if (tempObject.getChar() == Player.Char.Marko) {
                        g.drawImage(Mrkobg, 0, 0, null);
                    } else if (tempObject.getChar() == Player.Char.Etta) {
                        g.drawImage(Ettabg, 0, 0, null);
                    } else if (tempObject.getChar() == Player.Char.Burckardt) {
                        g.drawImage(Burckhartbg, 0, 0, null);
                    } else if (tempObject.getChar() == Player.Char.Mattis) {
                        g.drawImage(Mattisbg, 0, 0, null);
                    } else if (tempObject.getChar() == Player.Char.Drauge) {
                        g.drawImage(DraugeBg, 0, 0, null);
                    } else if (tempObject.getChar() != Player.Char.none && tempObject.id == ID.Player) {
                        g.drawImage(PlaceholderBg, 0, 0, null);
                    }
                }
            }
            handler.render(g,this);
        }else if (gamestate == STATE.Menu){
            g.drawImage(MENU,0,0,null);
            menu.render(g);
        }else if (gamestate == STATE.GameOver){
            handler.Colorspeed-=0.000005f;
            speedcolor=handler.Colorspeed;
            speedcolor-=0.6;
            while (speedcolor<0){
                speedcolor+=1;
            }
            csm.fastGradiant(g,speedcolor,6,(int)width,(int)height);
            for(int i = 0;i<handler.object.size();i++){
                GamaObject tempObject = handler.object.get(i);
                if (tempObject.id==ID.Player) {
                    if (tempObject.getChar() == Player.Char.Marko) {
                        g.drawImage(Mrkobg, 0, 0, null);
                    } else if (tempObject.getChar() == Player.Char.Etta) {
                        g.drawImage(Ettabg, 0, 0, null);
                    } else if (tempObject.getChar() == Player.Char.Burckardt) {
                        g.drawImage(Burckhartbg, 0, 0, null);
                    } else if (tempObject.getChar() == Player.Char.Mattis) {
                        g.drawImage(Mattisbg, 0, 0, null);
                    } else if (tempObject.getChar() == Player.Char.Drauge) {
                        g.drawImage(DraugeBg, 0, 0, null);
                    }
                }
            }

            over.render(g);
        }else if (gamestate == STATE.CharMenu){
            g.drawImage(BLURMENU,0,0,null);
            chm.render(g);
        }else if (gamestate==STATE.Pause){
            pause.render(g);
            for(int i = 0;i<handler.object.size();i++){
                GamaObject tempObject = handler.object.get(i);
                if (tempObject.id==ID.Player) {
                    if (tempObject.getChar() == Player.Char.Marko) {
                        g.drawImage(Mrkobg, 0, 0, null);
                    } else if (tempObject.getChar() == Player.Char.Burckardt) {
                        g.drawImage(Burckhartbg, 0, 0, null);
                    } else if (tempObject.getChar() == Player.Char.Etta) {
                        g.drawImage(Ettabg, 0, 0, null);
                    } else if (tempObject.getChar() == Player.Char.Drauge) {
                        g.drawImage(DraugeBg, 0, 0, null);
                    } else if (tempObject.getChar() == Player.Char.Mattis) {
                        g.drawImage(Mattisbg, 0, 0, null);
                    } else if (tempObject.getChar() != Player.Char.none) {
                        g.drawImage(PlaceholderBg, 0, 0, null);
                    }
                }
            }
            handler.render(g,this);
        }else if (gamestate == STATE.ComingSoon){
            cms.render(g);
        }else if (gamestate==STATE.Lock){
            lck.render(g);
        }else if (gamestate== STATE.Settings){
            csm.fastGradiant(g, speedcolor, 6, (int) width, (int) height);
            g.drawImage(BLURMENU,0,0,null);
            setn.render(g);
        }else if (gamestate== STATE.ModeSelect) {
            csm.fastGradiant(g, speedcolor, 6, (int) width, (int) height);
            g.drawImage(BLURMENU,0,0,null);
            wrld.render(g);
        }else if (gamestate== STATE.ShaniceMode){
            csm.fastGradiant(g, speedcolor, 6, (int) width, (int) height);
            g.drawImage(Matrix,0,0,null);
            handler.render(g,this);
        }
        if (!Verified){
            g.drawString("UNVERIFIED",100,100);
        }
        g.dispose();
        bs.show();
    }

    public static void main(String[]args){

        File file = new File("res/Spritesheet.png");
            new Game();
        try {
            Socket s = new Socket("192.168.178.79",666);
            DataOutputStream dataOutputStream = new DataOutputStream(s.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            dataOutputStream.writeBytes("6efa34b67487600b3031fbd574c0ef3f929c9e8033c00bdac4282240e8dfc616");
            System.out.println("send");
            String Verify=bufferedReader.readLine();
            System.out.println("received");
            if (Verify.equals("Unverified")){
                Verified=false;
            }
        } catch (IOException e) {
            System.out.println("Offline mode");
        }
    }
}
