import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Menu extends MouseAdapter {
    private Game game;
    Random random = new Random();
    Handler handler;
    CharMenu chr;
    Colorscheme csm;
    public static SettingsWindow settingsWindow;
    public Menu(Game game, Handler handler,CharMenu chr){
        this.game= game;
        this.handler = handler;
        this.chr = chr;
        csm=new Colorscheme();
    }
    public void mousePressed(MouseEvent e){
        System.out.println("mousepress");
        int mx = e.getX();
        int my = e.getY();
        if (game.gamestate== Game.STATE.Menu) {
            if (mouseOver(mx, my, 384, 180, 300, 64)) {
                game.gamestate = Game.STATE.ModeSelect;
            }else if (mouseOver(mx,my,384,280,300,64)) {
                game.gamestate = Game.STATE.Settings;
            }else if (mouseOver(mx,my,384,380,300,64)){
                game.gamestate=Game.STATE.ComingSoon;
            }
        }else if (game.gamestate== Game.STATE.CharMenu){
            handler.Eneneyseed=new Random(Game.seed);
            if (WorldSelect.Story) {
                Game.seed=chr.PROGRESS+1;
                Game.itemseed= 2;
                if (mouseOver(mx, my, 510, 510, 48, 48) && chr.PROGRESS == 0) {
                    System.out.println("Changing mode");
                    handler.seed = new Random(Game.seed);
                    handler.itemSeed = new Random(Game.itemseed);
                    handler.gx = 3;
                    handler.speed = 0;
                    handler.distance = 0;
                    handler.Colorspeed = 0.7f;
                    handler.doublejump = 1;
                    game.Geld = 0;
                    game.Bildung = 0;
                    game.Liebe = 0;
                    handler.clonemod1 = 0;
                    handler.clonemod2 = 0;
                    handler.clonemod3 = false;
                    handler.cpmod1 = 0;
                    handler.cpmod2 = 0;
                    handler.cpmod3 = false;
                    handler.position = 0;
                    handler.object.clear();
                    Game.Createblocks = 0;
                    game.gamestate = Game.STATE.Game;
                    AAudioPlayer.Pluyy=false;
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Etta, handler, this.game));
                    int v = 40;
                    while (v > 0) {
                        handler.addObject(new Wall(random.nextInt(1000), 300, 3, 4, ID.Wall, handler));
                        v--;
                    }

                    handler.addObject(new Wall(66, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(82, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(98, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(114, 300, 3, 0, ID.Wall, handler));
                    game.players = 0;
                } else if (mouseOver(mx, my, 88, 20, 48, 48) && chr.PROGRESS == 1) {
                    System.out.println("Changing mode");
                    handler.seed = new Random(Game.seed);
                    handler.itemSeed = new Random(Game.itemseed);
                    handler.gx = 3;
                    handler.speed = 0;
                    handler.distance = 0;
                    handler.Colorspeed = 0.7f;
                    handler.doublejump = 1;
                    game.Geld = 0;
                    game.Bildung = 0;
                    game.Liebe = 0;
                    handler.clonemod1 = 0;
                    handler.clonemod2 = 0;
                    handler.clonemod3 = false;
                    handler.cpmod1 = 0;
                    handler.cpmod2 = 0;
                    handler.cpmod3 = false;
                    handler.position = 0;
                    handler.object.clear();
                    Game.Createblocks = 0;
                    game.gamestate = Game.STATE.Game;
                    AAudioPlayer.Pluyy=false;
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Burckardt, handler, this.game));
                    int v = 40;
                    while (v > 0) {
                        handler.addObject(new Wall(random.nextInt(1000), 300, 3, 4, ID.Wall, handler));
                        v--;
                    }

                    handler.addObject(new Wall(66, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(82, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(98, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(114, 300, 3, 0, ID.Wall, handler));
                    game.players = 1;
                } else if (mouseOver(mx, my, 156, 20, 48, 48) && chr.PROGRESS == 2) {
                    System.out.println("Changing mode");
                    handler.seed = new Random(Game.seed);
                    handler.itemSeed = new Random(Game.itemseed);
                    handler.gx = 3;
                    handler.speed = 0;
                    handler.distance = 0;
                    handler.Colorspeed = 0.7f;
                    handler.doublejump = 1;
                    game.Geld = 0;
                    game.Bildung = 0;
                    game.Liebe = 0;
                    handler.clonemod1 = 0;
                    handler.clonemod2 = 0;
                    handler.clonemod3 = false;
                    handler.cpmod1 = 0;
                    handler.cpmod2 = 0;
                    handler.cpmod3 = false;
                    handler.position = 0;
                    handler.object.clear();
                    Game.Createblocks = 0;
                    game.gamestate = Game.STATE.Game;
                    AAudioPlayer.Pluyy=false;
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Marko, handler, this.game));
                    int v = 40;
                    while (v > 0) {
                        handler.addObject(new Wall(random.nextInt(1000), 300, 3, 4, ID.Wall, handler));
                        v--;
                    }

                    handler.addObject(new Wall(66, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(82, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(98, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(114, 300, 3, 0, ID.Wall, handler));
                    game.players = 2;
                    //addition immer + 64

                } else if (mouseOver(mx, my, 224, 20, 48, 48) && chr.PROGRESS == 3) {
                    System.out.println("Changing mode");
                    handler.seed = new Random(Game.seed);
                    handler.itemSeed = new Random(Game.itemseed);
                    handler.gx = 3;
                    handler.speed = 0;
                    handler.distance = 0;
                    handler.Colorspeed = 0.7f;
                    handler.doublejump = 1;
                    game.Geld = 0;
                    game.Bildung = 0;
                    game.Liebe = 0;
                    handler.clonemod1 = 0;
                    handler.clonemod2 = 0;
                    handler.clonemod3 = false;
                    handler.cpmod1 = 0;
                    handler.cpmod2 = 0;
                    handler.cpmod3 = false;
                    handler.position = 0;
                    handler.object.clear();
                    Game.Createblocks = 0;
                    game.gamestate = Game.STATE.Game;
                    AAudioPlayer.Pluyy=false;
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Mattis, handler, this.game));
                    int v = 40;
                    while (v > 0) {
                        handler.addObject(new Wall(random.nextInt(1000), 300, 3, 4, ID.Wall, handler));
                        v--;
                    }

                    handler.addObject(new Wall(66, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(82, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(98, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(114, 300, 3, 0, ID.Wall, handler));
                    game.players = 3;
                } else if (mouseOver(mx, my, 288, 20, 48, 48) && chr.PROGRESS == 6) {
                    System.out.println("Changing mode");
                    handler.seed = new Random(Game.seed);
                    handler.itemSeed = new Random(Game.itemseed);
                    handler.gx = 3;
                    handler.speed = 0;
                    handler.distance = 0;
                    handler.Colorspeed = 0.7f;
                    handler.doublejump = 1;
                    game.Geld = 0;
                    game.Bildung = 0;
                    game.Liebe = 0;
                    handler.clonemod1 = 0;
                    handler.clonemod2 = 0;
                    handler.clonemod3 = false;
                    handler.cpmod1 = 0;
                    handler.cpmod2 = 0;
                    handler.cpmod3 = false;
                    handler.position = 0;
                    handler.object.clear();
                    Game.Createblocks = 0;
                    game.gamestate = Game.STATE.Game;
                    AAudioPlayer.Pluyy=false;
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Drauge, handler, this.game));
                    int v = 40;
                    while (v > 0) {
                        handler.addObject(new Wall(random.nextInt(1000), 300, 3, 4, ID.Wall, handler));
                        v--;
                    }

                    handler.addObject(new Wall(66, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(82, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(98, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(114, 300, 3, 0, ID.Wall, handler));
                    game.players = 4;
                } else if (mouseOver(mx, my, 352, 20, 48, 48) && chr.PROGRESS == 4) {
                    System.out.println("Changing mode");
                    handler.seed = new Random(Game.seed);
                    handler.itemSeed = new Random(Game.itemseed);
                    handler.gx = 3;
                    handler.speed = 0;
                    handler.distance = 0;
                    handler.Colorspeed = 0.7f;
                    handler.doublejump = 1;
                    game.Geld = 0;
                    game.Bildung = 0;
                    game.Liebe = 0;
                    handler.clonemod1 = 0;
                    handler.clonemod2 = 0;
                    handler.clonemod3 = false;
                    handler.cpmod1 = 0;
                    handler.cpmod2 = 0;
                    handler.cpmod3 = false;
                    handler.position = 0;
                    handler.object.clear();
                    Game.Createblocks = 0;
                    game.gamestate = Game.STATE.Game;
                    AAudioPlayer.Pluyy=false;
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Jasnon, handler, this.game));
                    int v = 40;
                    while (v > 0) {
                        handler.addObject(new Wall(random.nextInt(1000), 300, 3, 4, ID.Wall, handler));
                        v--;
                    }

                    handler.addObject(new Wall(66, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(82, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(98, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(114, 300, 3, 0, ID.Wall, handler));
                    game.players = 5;
                } else if (mouseOver(mx, my, 416, 20, 48, 48) && chr.PROGRESS == 5) {
                    System.out.println("Changing mode");
                    handler.seed = new Random(Game.seed);
                    handler.itemSeed = new Random(Game.itemseed);
                    handler.gx = 3;
                    handler.speed = 0;
                    handler.distance = 0;
                    handler.Colorspeed = 0.7f;
                    handler.doublejump = 1;
                    game.Geld = 0;
                    game.Bildung = 0;
                    game.Liebe = 0;
                    handler.clonemod1 = 0;
                    handler.clonemod2 = 0;
                    handler.clonemod3 = false;
                    handler.cpmod1 = 0;
                    handler.cpmod2 = 0;
                    handler.cpmod3 = false;
                    handler.position = 0;
                    handler.object.clear();
                    Game.Createblocks = 0;
                    game.gamestate = Game.STATE.Game;
                    AAudioPlayer.Pluyy=false;
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Hanno, handler, this.game));
                    int v = 40;
                    while (v > 0) {
                        handler.addObject(new Wall(random.nextInt(1000), 300, 3, 4, ID.Wall, handler));
                        v--;
                    }

                    handler.addObject(new Wall(66, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(82, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(98, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(114, 300, 3, 0, ID.Wall, handler));
                    game.players = 6;
                }
            }else {
                Game.seed=CharMenu.ArcSeeder;
                Game.itemseed=CharMenu.ArcSeeder+1;
                if (mouseOver(mx, my, 24, 20, 48, 48) ) {
                    System.out.println("Changing mode");
                    handler.seed = new Random(Game.seed);
                    handler.itemSeed = new Random(Game.itemseed);
                    handler.gx = 3;
                    handler.speed = 0;
                    handler.distance = 0;
                    handler.Colorspeed = 0.7f;
                    handler.doublejump = 1;
                    game.Geld = 0;
                    game.Bildung = 0;
                    game.Liebe = 0;
                    handler.clonemod1 = 0;
                    handler.clonemod2 = 0;
                    handler.clonemod3 = false;
                    handler.cpmod1 = 0;
                    handler.cpmod2 = 0;
                    handler.cpmod3 = false;
                    handler.position = 0;
                    handler.object.clear();
                    Game.Createblocks = 0;
                    game.gamestate = Game.STATE.Game;
                    AudioThread.sound=2;
                    AAudioPlayer.Pluyy=false;
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Etta, handler, this.game));
                    int v = 40;
                    while (v > 0) {
                        handler.addObject(new Wall(random.nextInt(1000), 300, 3, 4, ID.Wall, handler));
                        v--;
                    }

                    handler.addObject(new Wall(66, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(82, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(98, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(114, 300, 3, 0, ID.Wall, handler));
                    game.players = 0;
                } else if (mouseOver(mx, my, 88, 20, 48, 48) ) {
                    System.out.println("Changing mode");
                    handler.seed = new Random(Game.seed);
                    handler.itemSeed = new Random(Game.itemseed);
                    handler.gx = 3;
                    handler.speed = 0;
                    handler.distance = 0;
                    handler.Colorspeed = 0.7f;
                    handler.doublejump = 1;
                    game.Geld = 0;
                    game.Bildung = 0;
                    game.Liebe = 0;
                    handler.clonemod1 = 0;
                    handler.clonemod2 = 0;
                    handler.clonemod3 = false;
                    handler.cpmod1 = 0;
                    handler.cpmod2 = 0;
                    handler.cpmod3 = false;
                    handler.position = 0;
                    handler.object.clear();
                    Game.Createblocks = 0;
                    game.gamestate = Game.STATE.Game;
                    AudioThread.sound=1;
                    AAudioPlayer.Pluyy=false;
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Burckardt, handler, this.game));
                    int v = 40;
                    while (v > 0) {
                        handler.addObject(new Wall(random.nextInt(1000), 300, 3, 4, ID.Wall, handler));
                        v--;
                    }

                    handler.addObject(new Wall(66, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(82, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(98, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(114, 300, 3, 0, ID.Wall, handler));
                    game.players = 1;
                } else if (mouseOver(mx, my, 156, 20, 48, 48)) {
                    System.out.println("Changing mode");
                    handler.seed = new Random(Game.seed);
                    handler.itemSeed = new Random(Game.itemseed);
                    handler.gx = 3;
                    handler.speed = 0;
                    handler.distance = 0;
                    handler.Colorspeed = 0.7f;
                    handler.doublejump = 1;
                    game.Geld = 0;
                    game.Bildung = 0;
                    game.Liebe = 0;
                    handler.clonemod1 = 0;
                    handler.clonemod2 = 0;
                    handler.clonemod3 = false;
                    handler.cpmod1 = 0;
                    handler.cpmod2 = 0;
                    handler.cpmod3 = false;
                    handler.position = 0;
                    handler.object.clear();
                    Game.Createblocks = 0;
                    game.gamestate = Game.STATE.Game;
                    AudioThread.sound=7;
                    AAudioPlayer.Pluyy=false;
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Marko, handler, this.game));
                    int v = 40;
                    while (v > 0) {
                        handler.addObject(new Wall(random.nextInt(1000), 300, 3, 4, ID.Wall, handler));
                        v--;
                    }

                    handler.addObject(new Wall(66, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(82, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(98, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(114, 300, 3, 0, ID.Wall, handler));
                    game.players = 2;
                    //addition immer + 64

                } else if (mouseOver(mx, my, 224, 20, 48, 48)) {
                    System.out.println("Changing mode");
                    handler.seed = new Random(Game.seed);
                    handler.itemSeed = new Random(Game.itemseed);
                    handler.gx = 3;
                    handler.speed = 0;
                    handler.distance = 0;
                    handler.Colorspeed = 0.7f;
                    handler.doublejump = 1;
                    game.Geld = 0;
                    game.Bildung = 0;
                    game.Liebe = 0;
                    handler.clonemod1 = 0;
                    handler.clonemod2 = 0;
                    handler.clonemod3 = false;
                    handler.cpmod1 = 0;
                    handler.cpmod2 = 0;
                    handler.cpmod3 = false;
                    handler.position = 0;
                    handler.object.clear();
                    Game.Createblocks = 0;
                    game.gamestate = Game.STATE.Game;
                    AudioThread.sound=8;
                    AAudioPlayer.Pluyy=false;
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Mattis, handler, this.game));
                    int v = 40;
                    while (v > 0) {
                        handler.addObject(new Wall(random.nextInt(1000), 300, 3, 4, ID.Wall, handler));
                        v--;
                    }

                    handler.addObject(new Wall(66, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(82, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(98, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(114, 300, 3, 0, ID.Wall, handler));
                    game.players = 3;
                } else if (mouseOver(mx, my, 288, 20, 48, 48)) {
                    System.out.println("Changing mode");
                    handler.seed = new Random(Game.seed);
                    handler.itemSeed = new Random(Game.itemseed);
                    handler.gx = 3;
                    handler.speed = 0;
                    handler.distance = 0;
                    handler.Colorspeed = 0.7f;
                    handler.doublejump = 1;
                    game.Geld = 0;
                    game.Bildung = 0;
                    game.Liebe = 0;
                    handler.clonemod1 = 0;
                    handler.clonemod2 = 0;
                    handler.clonemod3 = false;
                    handler.cpmod1 = 0;
                    handler.cpmod2 = 0;
                    handler.cpmod3 = false;
                    handler.position = 0;
                    handler.object.clear();
                    Game.Createblocks = 0;
                    game.gamestate = Game.STATE.Game;
                    AudioThread.sound=5;
                    AAudioPlayer.Pluyy=false;
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Drauge, handler, this.game));
                    int v = 40;
                    while (v > 0) {
                        handler.addObject(new Wall(random.nextInt(1000), 300, 3, 4, ID.Wall, handler));
                        v--;
                    }

                    handler.addObject(new Wall(66, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(82, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(98, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(114, 300, 3, 0, ID.Wall, handler));
                    game.players = 4;
                } else if (mouseOver(mx, my, 352, 20, 48, 48)) {
                    System.out.println("Changing mode");
                    handler.seed = new Random(Game.seed);
                    handler.itemSeed = new Random(Game.itemseed);
                    handler.gx = 3;
                    handler.speed = 0;
                    handler.distance = 0;
                    handler.Colorspeed = 0.7f;
                    handler.doublejump = 1;
                    game.Geld = 0;
                    game.Bildung = 0;
                    game.Liebe = 0;
                    handler.clonemod1 = 0;
                    handler.clonemod2 = 0;
                    handler.clonemod3 = false;
                    handler.cpmod1 = 0;
                    handler.cpmod2 = 0;
                    handler.cpmod3 = false;
                    handler.position = 0;
                    handler.object.clear();
                    Game.Createblocks = 0;
                    game.gamestate = Game.STATE.Game;
                    AudioThread.sound=9;
                    AAudioPlayer.Pluyy=false;
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Jasnon, handler, this.game));
                    int v = 40;
                    while (v > 0) {
                        handler.addObject(new Wall(random.nextInt(1000), 300, 3, 4, ID.Wall, handler));
                        v--;
                    }

                    handler.addObject(new Wall(66, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(82, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(98, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(114, 300, 3, 0, ID.Wall, handler));
                    game.players = 5;
                } else if (mouseOver(mx, my, 416, 20, 48, 48)) {
                    System.out.println("Changing mode");
                    handler.seed = new Random(Game.seed);
                    handler.itemSeed = new Random(Game.itemseed);
                    handler.gx = 3;
                    handler.speed = 0;
                    handler.distance = 0;
                    handler.Colorspeed = 0.7f;
                    handler.doublejump = 1;
                    game.Geld = 0;
                    game.Bildung = 0;
                    game.Liebe = 0;
                    handler.clonemod1 = 0;
                    handler.clonemod2 = 0;
                    handler.clonemod3 = false;
                    handler.cpmod1 = 0;
                    handler.cpmod2 = 0;
                    handler.cpmod3 = false;
                    handler.position = 0;
                    handler.object.clear();
                    Game.Createblocks = 0;
                    game.gamestate = Game.STATE.Game;
                    AudioThread.sound=10;
                    AAudioPlayer.Pluyy=false;
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Hanno, handler, this.game));
                    int v = 40;
                    while (v > 0) {
                        handler.addObject(new Wall(random.nextInt(1000), 300, 3, 4, ID.Wall, handler));
                        v--;
                    }

                    handler.addObject(new Wall(66, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(82, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(98, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(114, 300, 3, 0, ID.Wall, handler));
                    game.players = 6;
                }else if (mouseOver(mx, my, 480, 20, 48, 48)) {
                    System.out.println("Changing mode");
                    handler.seed = new Random(Game.seed);
                    handler.itemSeed = new Random(Game.itemseed);
                    handler.gx = 3;
                    handler.speed = 0;
                    handler.distance = 0;
                    handler.Colorspeed = 0.7f;
                    handler.doublejump = 1;
                    game.Geld = 0;
                    game.Bildung = 0;
                    game.Liebe = 0;
                    handler.clonemod1 = 0;
                    handler.clonemod2 = 0;
                    handler.clonemod3 = false;
                    handler.cpmod1 = 0;
                    handler.cpmod2 = 0;
                    handler.cpmod3 = false;
                    handler.position = 0;
                    handler.object.clear();
                    Game.Createblocks = 0;
                    game.gamestate = Game.STATE.Game;
                    AudioThread.sound=6;
                    AAudioPlayer.Pluyy=false;
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Caro, handler, this.game));
                    int v = 40;
                    while (v > 0) {
                        handler.addObject(new Wall(random.nextInt(1000), 300, 3, 4, ID.Wall, handler));
                        v--;
                    }

                    handler.addObject(new Wall(66, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(82, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(98, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(114, 300, 3, 0, ID.Wall, handler));
                    game.players = 7;
                }else if (mouseOver(mx, my, 544, 20, 48, 48)) {
                    System.out.println("Changing mode");
                    handler.seed = new Random(Game.seed);
                    handler.itemSeed = new Random(Game.itemseed);
                    handler.gx = 3;
                    handler.speed = 0;
                    handler.distance = 0;
                    handler.Colorspeed = 0.7f;
                    handler.doublejump = 1;
                    game.Geld = 0;
                    game.Bildung = 0;
                    game.Liebe = 0;
                    handler.clonemod1 = 0;
                    handler.clonemod2 = 0;
                    handler.clonemod3 = false;
                    handler.cpmod1 = 0;
                    handler.cpmod2 = 0;
                    handler.cpmod3 = false;
                    handler.position = 0;
                    handler.object.clear();
                    Game.Createblocks = 0;
                    game.gamestate = Game.STATE.Game;
                    AudioThread.sound=11;
                    AAudioPlayer.Pluyy=false;
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Andre, handler, this.game));
                    int v = 40;
                    while (v > 0) {
                        handler.addObject(new Wall(random.nextInt(1000), 300, 3, 4, ID.Wall, handler));
                        v--;
                    }

                    handler.addObject(new Wall(66, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(82, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(98, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(114, 300, 3, 0, ID.Wall, handler));
                    game.players = 8;
                }else if (mouseOver(mx, my, 608, 20, 48, 48)) {
                    System.out.println("Changing mode");
                    handler.seed = new Random(Game.seed);
                    handler.itemSeed = new Random(Game.itemseed);
                    handler.gx = 3;
                    handler.speed = 0;
                    handler.distance = 0;
                    handler.Colorspeed = 0.7f;
                    handler.doublejump = 1;
                    game.Geld = 0;
                    game.Bildung = 0;
                    game.Liebe = 0;
                    handler.clonemod1 = 0;
                    handler.clonemod2 = 0;
                    handler.clonemod3 = false;
                    handler.cpmod1 = 0;
                    handler.cpmod2 = 0;
                    handler.cpmod3 = false;
                    handler.position = 0;
                    handler.object.clear();
                    Game.Createblocks = 0;
                    game.gamestate = Game.STATE.Game;
                    AudioThread.sound=11;
                    AAudioPlayer.Pluyy=false;
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Rabea, handler, this.game));
                    int v = 40;
                    while (v > 0) {
                        handler.addObject(new Wall(random.nextInt(1000), 300, 3, 4, ID.Wall, handler));
                        v--;
                    }

                    handler.addObject(new Wall(66, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(82, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(98, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(114, 300, 3, 0, ID.Wall, handler));
                    game.players = 9;
                }else if (mouseOver(mx, my, 672, 20, 48, 48)) {
                    System.out.println("Changing mode");
                    handler.seed = new Random(Game.seed);
                    handler.itemSeed = new Random(Game.itemseed);
                    handler.gx = 3;
                    handler.speed = 0;
                    handler.distance = 0;
                    handler.Colorspeed = 0.7f;
                    handler.doublejump = 1;
                    game.Geld = 0;
                    game.Bildung = 0;
                    game.Liebe = 0;
                    handler.clonemod1 = 0;
                    handler.clonemod2 = 0;
                    handler.clonemod3 = false;
                    handler.cpmod1 = 0;
                    handler.cpmod2 = 0;
                    handler.cpmod3 = false;
                    handler.position = 0;
                    handler.object.clear();
                    Game.Createblocks = 0;
                    game.gamestate = Game.STATE.Game;
                    AudioThread.sound=11;
                    AAudioPlayer.Pluyy=false;
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Rike, handler, this.game));
                    int v = 40;
                    while (v > 0) {
                        handler.addObject(new Wall(random.nextInt(1000), 300, 3, 4, ID.Wall, handler));
                        v--;
                    }

                    handler.addObject(new Wall(66, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(82, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(98, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(114, 300, 3, 0, ID.Wall, handler));
                    game.players = 10;
                }else if (mouseOver(mx, my, 736, 20, 48, 48)) {
                    System.out.println("Changing mode");
                    handler.seed = new Random(Game.seed);
                    handler.itemSeed = new Random(Game.itemseed);
                    handler.gx = 3;
                    handler.speed = 0;
                    handler.distance = 0;
                    handler.Colorspeed = 0.7f;
                    handler.doublejump = 1;
                    game.Geld = 0;
                    game.Bildung = 0;
                    game.Liebe = 0;
                    handler.clonemod1 = 0;
                    handler.clonemod2 = 0;
                    handler.clonemod3 = false;
                    handler.cpmod1 = 0;
                    handler.cpmod2 = 0;
                    handler.cpmod3 = false;
                    handler.position = 0;
                    handler.object.clear();
                    Game.Createblocks = 0;
                    game.gamestate = Game.STATE.Game;
                    AudioThread.sound=11;
                    AAudioPlayer.Pluyy=false;
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Ipek, handler, this.game));
                    int v = 40;
                    while (v > 0) {
                        handler.addObject(new Wall(random.nextInt(1000), 300, 3, 4, ID.Wall, handler));
                        v--;
                    }

                    handler.addObject(new Wall(66, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(82, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(98, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(114, 300, 3, 0, ID.Wall, handler));
                    game.players = 11;
                }else if (mouseOver(mx, my, 800, 20, 48, 48)) {
                    System.out.println("Changing mode");
                    handler.seed = new Random(Game.seed);
                    handler.itemSeed = new Random(Game.itemseed);
                    handler.gx = 3;
                    handler.speed = 0;
                    handler.distance = 0;
                    handler.Colorspeed = 0.7f;
                    handler.doublejump = 1;
                    game.Geld = 0;
                    game.Bildung = 0;
                    game.Liebe = 0;
                    handler.clonemod1 = 0;
                    handler.clonemod2 = 0;
                    handler.clonemod3 = false;
                    handler.cpmod1 = 0;
                    handler.cpmod2 = 0;
                    handler.cpmod3 = false;
                    handler.position = 0;
                    handler.object.clear();
                    Game.Createblocks = 0;
                    game.gamestate = Game.STATE.Game;
                    AudioThread.sound=11;
                    AAudioPlayer.Pluyy=false;
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Milan, handler, this.game));
                    int v = 40;
                    while (v > 0) {
                        handler.addObject(new Wall(random.nextInt(1000), 300, 3, 4, ID.Wall, handler));
                        v--;
                    }

                    handler.addObject(new Wall(66, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(82, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(98, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(114, 300, 3, 0, ID.Wall, handler));
                    game.players = 12;
                }else if (mouseOver(mx, my, 864, 20, 48, 48)) {
                    System.out.println("Changing mode");
                    handler.seed = new Random(Game.seed);
                    handler.itemSeed = new Random(Game.itemseed);
                    handler.gx = 3;
                    handler.speed = 0;
                    handler.distance = 0;
                    handler.Colorspeed = 0.7f;
                    handler.doublejump = 1;
                    game.Geld = 0;
                    game.Bildung = 0;
                    game.Liebe = 0;
                    handler.clonemod1 = 0;
                    handler.clonemod2 = 0;
                    handler.clonemod3 = false;
                    handler.cpmod1 = 0;
                    handler.cpmod2 = 0;
                    handler.cpmod3 = false;
                    handler.position = 0;
                    handler.object.clear();
                    Game.Createblocks = 0;
                    game.gamestate = Game.STATE.Game;
                    AudioThread.sound=11;
                    AAudioPlayer.Pluyy=false;
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Kiki, handler, this.game));
                    int v = 40;
                    while (v > 0) {
                        handler.addObject(new Wall(random.nextInt(1000), 300, 3, 4, ID.Wall, handler));
                        v--;
                    }

                    handler.addObject(new Wall(66, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(82, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(98, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(114, 300, 3, 0, ID.Wall, handler));
                    game.players = 13;
                }else if (mouseOver(mx, my, 928, 20, 48, 48)) {
                    System.out.println("Changing mode");
                    handler.seed = new Random(Game.seed);
                    handler.itemSeed = new Random(Game.itemseed);
                    handler.gx = 3;
                    handler.speed = 0;
                    handler.distance = 0;
                    handler.Colorspeed = 0.7f;
                    handler.doublejump = 1;
                    game.Geld = 0;
                    game.Bildung = 0;
                    game.Liebe = 0;
                    handler.clonemod1 = 0;
                    handler.clonemod2 = 0;
                    handler.clonemod3 = false;
                    handler.cpmod1 = 0;
                    handler.cpmod2 = 0;
                    handler.cpmod3 = false;
                    handler.position = 0;
                    handler.object.clear();
                    Game.Createblocks = 0;
                    game.gamestate = Game.STATE.Game;
                    AudioThread.sound=4;
                    AAudioPlayer.Pluyy=false;
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Shanice, handler, this.game));
                    int v = 40;
                    while (v > 0) {
                        handler.addObject(new Wall(random.nextInt(1000), 300, 3, 4, ID.Wall, handler));
                        v--;
                    }

                    handler.addObject(new Wall(66, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(82, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(98, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(114, 300, 3, 0, ID.Wall, handler));
                    game.players = 14;
                }else if (mouseOver(mx, my, 992, 20, 48, 48)) {
                    System.out.println("Changing mode");
                    handler.seed = new Random(Game.seed);
                    handler.itemSeed = new Random(Game.itemseed);
                    handler.gx = 3;
                    handler.speed = 0;
                    handler.distance = 0;
                    handler.Colorspeed = 0.7f;
                    handler.doublejump = 1;
                    game.Geld = 0;
                    game.Bildung = 0;
                    game.Liebe = 0;
                    handler.clonemod1 = 0;
                    handler.clonemod2 = 0;
                    handler.clonemod3 = false;
                    handler.cpmod1 = 0;
                    handler.cpmod2 = 0;
                    handler.cpmod3 = false;
                    handler.position = 0;
                    handler.object.clear();
                    Game.Createblocks = 0;
                    game.gamestate = Game.STATE.Game;
                    AudioThread.sound=3;
                    AAudioPlayer.Pluyy=false;
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Emely, handler, this.game));
                    int v = 40;
                    while (v > 0) {
                        handler.addObject(new Wall(random.nextInt(1000), 300, 3, 4, ID.Wall, handler));
                        v--;
                    }

                    handler.addObject(new Wall(66, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(82, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(98, 300, 3, 0, ID.Wall, handler));
                    handler.addObject(new Wall(114, 300, 3, 0, ID.Wall, handler));
                    game.players = 15;
                }
            }
        } else if (game.gamestate== Game.STATE.Settings) {
            if (mouseOver(mx,my,100,120,32,32)){
                if (game.GRAPHICS){
                    game.GRAPHICS=false;
                }else {
                    game.GRAPHICS=true;
                }
            }
            if (mouseOver(mx,my,180,120,32,32)){
                settingsWindow = new SettingsWindow();
                settingsWindow.setSize(300,300);
                settingsWindow.setVisible(true);
            }
            if (mouseOver(mx,my,260,120,32,32)){
                if (game.ANIMATION){
                    game.ANIMATION=false;
                }else {
                    game.ANIMATION=true;
                }
            }
        } else if (game.gamestate==Game.STATE.ModeSelect) {
            if (mouseOver(mx,my,384,180,300,64)){
                WorldSelect.Story=true;
                game.gamestate= Game.STATE.CharMenu;
            }
            if (mouseOver(mx,my,384,280,300,64)){
                WorldSelect.Story=false;
                game.gamestate= Game.STATE.CharMenu;
            }
        }
    }

    public void mouseReleased(MouseEvent e){

    }
    private boolean mouseOver(int mx,int my,int x,int y,int width,int height){
        if (mx> x&&mx<x+width){
            if (my>y&&my<y+height){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    public void tick(){

    }
    public void render(Graphics g){
        g.setColor(Color.RED);
        g.drawImage(game.Play,384,180,null);
        g.drawImage(game.Settings,384,280,null);
        g.drawImage(Game.Online,384,380,null);

    }
}
