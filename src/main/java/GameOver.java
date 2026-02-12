import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GameOver extends KeyAdapter {
    File file =new File("C:/Users/Public/Documents");
    Scanner scanner;
    public static String ArcSeed="0";
    String[] strings= new String[50];
    {
        try {
            if (file.exists()){
                System.out.println("Windows");
                file=new File("C:/Users/Public/Documents/Unlocked.txt");
            }else {
                file=new File("/home");
                String contents[]= file.list();
                file=new File("/home/"+contents[0]+"/Unlocked.txt");
            }
            if (file.exists()) {
                scanner = new Scanner(file);
                int i = 0;
                while (scanner.hasNext()){
                    strings[i]=scanner.next();
                    i++;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    FileWriter writer;
    private Game game;
    private Handler handler;
    private CharMenu chr;
    public GameOver(Game game,Handler handler,CharMenu chr){
        this.game=game;
        this.handler = handler;
        this.chr=chr;
    }
    Random random = new Random();
    public void keyPressed(KeyEvent e){
        if (game.gamestate== Game.STATE.GameOver){
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            if (e.getKeyCode() == KeyEvent.VK_ENTER){
                handler.seed = new Random(Game.seed);
                handler.itemSeed= new Random(Game.itemseed);
                handler.Eneneyseed= new Random(Game.seed);
                handler.gx=3;
                handler.speed=0;
                handler.distance=0;
                handler.Colorspeed=0.7f;
                handler.doublejump=1;
                game.Geld=0;
                game.Bildung=0;
                game.Liebe=0;
                handler.clonemod1=0;
                handler.clonemod2=0;
                handler.clonemod3=false;
                handler.cpmod1=0;
                handler.cpmod2=0;
                handler.cpmod3=false;
                handler.position=0;
                handler.object.clear();
                Game.Createblocks=0;
                game.gamestate = Game.STATE.Game;
                if (game.players==0) {
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Etta, handler,this.game));
                }else if (game.players==1){
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Burckardt, handler,this.game));
                }else if (game.players==2){
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Marko, handler,this.game));
                }else if (game.players==3){
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Mattis, handler,this.game));
                }else if (game.players==4){
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Drauge, handler,this.game));
                }else if (game.players==5){
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Jasnon, handler,this.game));
                }else if(game.players==6){
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Hanno, handler,this.game));
                }else if(game.players==7){
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Caro, handler,this.game));
                }else if(game.players==8){
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Andre, handler,this.game));
                }else if(game.players==9){
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Rabea, handler,this.game));
                }else if(game.players==10){
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Rike, handler,this.game));
                }else if(game.players==11){
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Ipek, handler,this.game));
                }else if(game.players==12){
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Milan, handler,this.game));
                } else if (game.players==13) {
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Kiki, handler,this.game));
                } else if (game.players==14) {
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Shanice, handler,this.game));
                } else if (game.players==15) {
                    handler.addObject(new Player(50, 260, 5, 0, ID.Player, Player.Char.Emely, handler,this.game));
                }
                int v = 40;
                while (v > 0) {
                    handler.addObject(new Wall(random.nextInt(1000), 300, 3, 0, ID.Wall,handler));
                    v--;
                }

                handler.addObject(new Wall(66, 300, 3, 0, ID.Wall,handler));
                handler.addObject(new Wall(82, 300, 3, 0, ID.Wall,handler));
                handler.addObject(new Wall(98, 300, 3, 0, ID.Wall,handler));
                handler.addObject(new Wall(114, 300, 3, 0, ID.Wall,handler));
            }else if (e.getKeyCode()== KeyEvent.VK_SPACE||e.getKeyCode()==KeyEvent.VK_D){

            }else if (e.getKeyCode()== KeyEvent.VK_SHIFT){

            }else {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                    game.gamestate = Game.STATE.Menu;
                    AudioThread.sound=0;
                    AAudioPlayer.Pluyy=false;
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }

        }

    }


    public void tick(){
        game.Score=handler.distance/100+ game.Liebe+ game.Geld+ game.Bildung;
        File file = new File("/home/");
        if (file.exists()){
            String contents[]= file.list();
            file = new File("/home/"+contents[0]+"/.TAJS/Progress.txt");
        }else {
            file=new File("C:/Users/Public/Documents/TAJS/Progress.txt");
        }
        //if (WorldSelect.Story) {
        //}
        try {
            FileWriter writer= new FileWriter(file);
            String temp = String.valueOf(CharMenu.PROGRESS);
            writer.write(temp);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void render(Graphics g){

        g.setColor(Color.BLACK);
        Font fnt2 = new Font("arial",1,30);
        g.setFont(fnt2);
        g.drawString("Score: "+ game.Score,150,180);
        for (int i = 0; i<handler.object.size();i++){
            GamaObject tempObject = handler.object.get(i);
            if (tempObject.getId() == ID.Player){
            }
        }


    }
}
