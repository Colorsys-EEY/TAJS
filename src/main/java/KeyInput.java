import sun.security.jgss.GSSCaller;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class KeyInput extends KeyAdapter {
    boolean jump = true;
    int jmp = 0;
    boolean jump1 = true;
    int jmp1 = 0;
    int emeru=0;
    int timelast = 0;
    int handeltime = 0;
    public static int Jasniun = 0;
    private Handler handler;
    Game game;
    Random random = new Random();

    public KeyInput(Handler handler, Game game) {
        this.handler = handler;
        this.game = game;
    }

    public void keyPressed(KeyEvent e) {
        if (game.gamestate == Game.STATE.ComingSoon) {
            game.gamestate = Game.STATE.Menu;
        }
        if (game.gamestate== Game.STATE.Settings){
            game.gamestate = Game.STATE.Menu;
        }
        for (int i = 0; i < handler.object.size(); i++) {
            GamaObject player = handler.object.get(i);
            if (player.getId() == ID.Player) {
                for (int z = 0; z < handler.object.size(); z++) {
                    if (z <= handler.object.size()) {
                        GamaObject tempObject = handler.object.get(z);
                        if (tempObject.getId() == ID.Wall || tempObject.getId() == ID.Bullet || tempObject.id == ID.Inkwall) {
                            if (tempObject.y - 40 == player.y || tempObject.getBounds2().intersects(player.getBounds2())) {
                                jmp++;
                                if (player.getChar()== Player.Char.Kiki){
                                    handler.doublejump=2;
                                }else {
                                    handler.doublejump = 1;
                                }
                                handler.dash = 1;
                            }
                        }
                    }
                }
            }
        }
        if (jmp > 0) {
            jump = true;
            jmp = 0;
        } else {
            jump = false;
        }
        for (int i = 0; i < handler.object.size(); i++) {
            GamaObject clone = handler.object.get(i);
            if (clone.getId() == ID.clone) {
                for (int z = 0; z < handler.object.size(); z++) {
                    if (z <= handler.object.size()) {
                        GamaObject tempObject = handler.object.get(z);
                        if (tempObject.getId() == ID.Wall || tempObject.getId() == ID.Bullet || tempObject.id == ID.Inkwall) {
                            if (tempObject.y - 40 == clone.y || tempObject.getBounds().intersects(clone.getBounds2())) {
                                jmp1++;
                                handler.doublejump1 = 1;
                                handler.dash = 1;
                            }
                        }
                    }
                }
            }
        }
        if (jmp1 > 0) {
            jump1 = true;
            jmp1 = 0;
        } else {
            jump1 = false;
        }

        int key = e.getKeyCode();
        if (key == KeyEvent.VK_H) {
            if (Game.SHOWHIT) {
                Game.SHOWHIT = false;
            } else {
                Game.SHOWHIT = true;
            }

        }
        for (int i = 0; i < handler.object.size(); i++) {
            GamaObject tempObject = handler.object.get(i);
            if (tempObject.getId() == ID.Player) {
                if (key == KeyEvent.VK_SPACE && jump) {
                    if (tempObject.chare == Player.Char.Etta) {
                        tempObject.setGy(-18);
                    } else if (tempObject.chare == Player.Char.Burckardt) {
                        tempObject.setGy(-17);
                    } else if (tempObject.chare == Player.Char.Marko) {
                        tempObject.setGy(-19);
                    } else if (tempObject.chare == Player.Char.Mattis) {
                        tempObject.setGy(-19);
                    } else if (tempObject.chare == Player.Char.Drauge) {
                        tempObject.setGy(-19);
                    } else if (tempObject.chare == Player.Char.Jasnon) {
                        tempObject.setGy(-19);
                    } else if (tempObject.chare == Player.Char.Hanno) {
                        tempObject.setGy(-18-handler.cpmod1);
                    } else if (tempObject.chare== Player.Char.Caro){
                        tempObject.setGy(-16);
                    }else if (tempObject.chare== Player.Char.Andre){
                        tempObject.setGy(-17);
                    }else if (tempObject.chare== Player.Char.Rabea){
                        tempObject.setGy(-18);
                    }else if (tempObject.chare== Player.Char.Rike){
                        tempObject.setGy(-17);
                    }else if (tempObject.chare== Player.Char.Ipek){
                        tempObject.setGy(-19);
                    }else if (tempObject.chare== Player.Char.Milan){
                        tempObject.setGy(-19);
                    }else if (tempObject.chare== Player.Char.Kiki){
                        tempObject.setGy(-18);
                    }else if (tempObject.chare== Player.Char.Shanice){
                        tempObject.setGy(-18);
                    }else if (tempObject.chare== Player.Char.Emely){
                        tempObject.setGy(-18);
                    }
                } else if (key == KeyEvent.VK_SPACE && handler.doublejump >= 1) {
                    handler.doublejump -= 1;
                    if (tempObject.chare == Player.Char.Etta) {
                        tempObject.setGy(-16);
                    } else if (tempObject.chare == Player.Char.Burckardt) {
                        tempObject.setGy(-17);
                    } else if (tempObject.chare == Player.Char.Marko) {
                        tempObject.setGy(-17);
                    } else if (tempObject.chare == Player.Char.Mattis) {
                        tempObject.setGy(-19);
                    } else if (tempObject.chare == Player.Char.Drauge) {
                        tempObject.setGy(-18);
                    } else if (tempObject.chare == Player.Char.Jasnon) {
                        tempObject.setGy(-19);
                    } else if (tempObject.chare == Player.Char.Hanno) {
                        tempObject.setGy(-19-handler.cpmod1);
                    }else if (tempObject.chare== Player.Char.Caro){
                        tempObject.setGy(-19);
                    }else if (tempObject.chare== Player.Char.Andre){
                        tempObject.setGy(-17);
                    }else if (tempObject.chare== Player.Char.Rabea){
                        tempObject.setGy(-16);
                    }else if (tempObject.chare== Player.Char.Rike){
                        tempObject.setGy(-17);
                    }else if (tempObject.chare== Player.Char.Ipek){
                        tempObject.setGy(-18);
                    }else if (tempObject.chare== Player.Char.Milan){
                        tempObject.setGy(-17);
                    }else if (tempObject.chare== Player.Char.Kiki){
                        tempObject.setGy(-16);
                    }else if (tempObject.chare== Player.Char.Shanice){
                        tempObject.setGy(-17);
                    }else if (tempObject.chare== Player.Char.Emely){
                        tempObject.setGy(-18);
                    }
                }
                if (key == KeyEvent.VK_SHIFT) {
                    if (tempObject.chare == Player.Char.Etta && game.Geld > 0) {
                        if (game.gamestate == Game.STATE.Game) {
                            tempObject.setGy(-23);
                            game.Action=19;
                            game.Geld--;
                        }
                    } else if (tempObject.chare == Player.Char.Burckardt && game.Liebe > 0 && !handler.save) {
                        if (game.gamestate == Game.STATE.Game) {
                            handler.save = true;
                            game.Action=19;
                            game.Liebe--;
                        }

                    } else if (tempObject.chare == Player.Char.Marko && game.Bildung > 0) {
                        if (game.gamestate == Game.STATE.Game) {
                            game.Bildung--;
                            game.backpush = 19;
                            handler.addObject(new Projectile(tempObject.x + 12, tempObject.y + 14, -26, 0, ID.Bullet, -26, 0, 2, Player.Char.none, handler));
                            for (int l = 0; l < 5; l++) {
                                handler.particles.add(new jumpparticle(tempObject.x + 45, tempObject.y + 29, 2, 2, 100,50,0, false, false));
                            }
                        }

                    } else if (tempObject.chare == Player.Char.Mattis && game.Bildung > 0) {
                        if (game.gamestate == Game.STATE.Game) {
                            game.Bildung--;
                            Game.Createblocks += 20;
                            game.Action=19;
                        }

                    } else if (tempObject.chare == Player.Char.Drauge && game.Liebe > 0) {
                        if (game.gamestate == Game.STATE.Game && handler.save2 < 16) {
                            game.Liebe--;
                            if (handler.save2 > 0) {
                                handler.save2 *= 2;
                            } else {
                                handler.save2++;
                            }
                            game.Action=19;
                        }
                    } else if (tempObject.chare == Player.Char.Jasnon) {
                        if (Jasniun == 0) {
                            if (game.Liebe > 0 && game.gamestate == Game.STATE.Game) {
                                handler.addObject(new Projectile(tempObject.x, tempObject.y - 20, 0, 0, ID.Acid, -14, 10, 4, Player.Char.none, handler));
                                game.Liebe--;
                                game.Action=19;
                            }
                        } else if (Jasniun == 1) {
                            if (game.Bildung > 0 && game.gamestate == Game.STATE.Game) {
                                handler.addObject(new Projectile(tempObject.x, tempObject.y - 20, 0, 0, ID.slowpotion, -8  , 10, 4, Player.Char.none, handler));
                                game.Bildung--;
                                game.Action=19;
                            }
                        } else if (Jasniun == 2) {
                            if (game.Geld > 0 && game.gamestate == Game.STATE.Game) {
                                Player.big = 500;
                                game.Geld--;
                                game.Action=19;
                            }
                        }

                    } else if (tempObject.chare == Player.Char.Hanno){
                        if (game.Geld > 1 && game.gamestate == Game.STATE.Game&&!handler.cloneb){
                            handler.addObject(new Clone(tempObject.x+30,tempObject.y,0,0,ID.clone, Player.Char.Hanno,handler,game));
                            handler.clonemod1+=1;
                            handler.clonemod2-=1;
                            game.Geld-=2;
                            game.Action=19;
                        }else if (game.Bildung > 1 && game.gamestate == Game.STATE.Game&&!handler.cloneb){
                            handler.addObject(new Clone(tempObject.x+30,tempObject.y,0,0,ID.clone, Player.Char.Hanno,handler,game));
                            handler.clonemod2+=1;
                            handler.clonemod1-=1;
                            game.Bildung-=2;
                            game.Action=19;
                        }else if (game.Liebe > 1 && game.gamestate == Game.STATE.Game&&!handler.cloneb){
                            handler.addObject(new Clone(tempObject.x+30,tempObject.y,0,0,ID.clone, Player.Char.Hanno,handler,game));
                            if (handler.clonemod3){
                                handler.clonemod3=false;
                            }else {
                                handler.clonemod3=true;
                            }
                            game.Liebe-=2;
                            game.Action=19;
                        }
                    }else if (tempObject.chare == Player.Char.Caro && game.Liebe > 0) {
                        if (game.gamestate == Game.STATE.Game) {
                            handler.SlowTime+=100;
                            game.Action+=100;
                            game.Liebe-=1;
                        }

                    } else if (tempObject.chare== Player.Char.Rabea&&game.Geld>0) {
                        if (game.gamestate== Game.STATE.Game){
                            handler.BeaMode+=100;
                            game.Action+=100;
                            game.Geld--;
                        }
                    }else if (tempObject.chare== Player.Char.Rike) {
                        if (game.gamestate== Game.STATE.Game){
                            tempObject.gy+=10;
                            game.Action+=20;
                        }
                    } else if (tempObject.chare== Player.Char.Shanice&&game.Liebe>0) {
                        if (game.gamestate== Game.STATE.Game){
                            ShaniceMode.Shanicemode+=500;
                            game.Liebe--;
                        }
                    }else if (tempObject.chare== Player.Char.Emely&&game.Liebe>0&&game.Geld>0&&game.Bildung>0){
                        if (emeru==0){
                            emeru=1;
                            ShaniceMode.Shanicemode+=1000;
                            game.Action=1000;
                        } else if (emeru==1) {
                            emeru=2;
                            Game.Createblocks += 60;
                            game.Action=19;
                        }else {
                            emeru=0;
                            tempObject.setGy(-26);
                            handler.doublejump = 0;
                            game.Action=19;
                        }
                        game.Liebe--;
                        game.Geld--;
                        game.Bildung--;
                    }
                }
                if (key == KeyEvent.VK_D && handler.dash == 1) {
                    if (tempObject.chare == Player.Char.Etta) {
                        if (game.gamestate == Game.STATE.Game) {
                            tempObject.gx = 7;
                            handler.dash = 0;
                        }
                    } else if (tempObject.chare == Player.Char.Burckardt) {
                        if (game.gamestate == Game.STATE.Game) {
                            tempObject.gx = 8;
                            handler.dash = 0;
                        }

                    } else if (tempObject.chare == Player.Char.Marko) {
                        if (game.gamestate == Game.STATE.Game) {
                            tempObject.gx = 9;
                            handler.dash = 0;
                        }

                    } else if (tempObject.chare == Player.Char.Mattis) {
                        if (game.gamestate == Game.STATE.Game) {
                            tempObject.gx = 9;
                            handler.dash = 0;
                        }
                    } else if (tempObject.chare == Player.Char.Drauge) {
                        if (game.gamestate == Game.STATE.Game) {
                            tempObject.gx = 10;
                            handler.dash = 0;
                        }
                    } else if (tempObject.chare == Player.Char.Jasnon) {
                        if (game.gamestate == Game.STATE.Game) {
                            tempObject.gx = 9;
                            handler.dash = 0;
                        }
                    } else if (tempObject.chare == Player.Char.Hanno) {
                        if (game.gamestate == Game.STATE.Game) {
                            tempObject.gx = 8;
                            handler.dash = 0;
                        }
                    }else if (tempObject.chare == Player.Char.Caro) {
                        if (game.gamestate == Game.STATE.Game) {
                            tempObject.gx = 8;
                            handler.dash = 0;
                        }
                    }else if (tempObject.chare == Player.Char.Andre) {
                        if (game.gamestate == Game.STATE.Game) {
                            tempObject.gx = 17;
                            handler.dash = 0;
                        }
                    }else if (tempObject.chare == Player.Char.Rabea) {
                        if (game.gamestate == Game.STATE.Game) {
                            tempObject.gx = 7;
                            handler.dash = 0;
                        }
                    }else if (tempObject.chare == Player.Char.Rike) {
                        if (game.gamestate == Game.STATE.Game) {
                            tempObject.gx = 10;
                            handler.dash = 0;
                        }
                    }else if (tempObject.chare == Player.Char.Ipek) {
                        if (game.gamestate == Game.STATE.Game) {
                            tempObject.gx = 12;
                            handler.dash = 0;
                        }
                    }else if (tempObject.chare == Player.Char.Milan) {
                        if (game.gamestate == Game.STATE.Game) {
                            tempObject.gx = 9;
                            handler.dash = 0;
                        }
                    }else if (tempObject.chare == Player.Char.Kiki) {
                        if (game.gamestate == Game.STATE.Game) {
                            tempObject.gx = 8;
                            handler.dash = 0;
                        }
                    }else if (tempObject.chare == Player.Char.Shanice) {
                        if (game.gamestate == Game.STATE.Game) {
                            tempObject.gx = 7;
                            handler.dash = 0;
                        }
                    }else if (tempObject.chare == Player.Char.Emely) {
                        if (game.gamestate == Game.STATE.Game) {
                            tempObject.gx = 9;
                            handler.dash = 0;
                        }
                    }
                }
                if (key == KeyEvent.VK_UP && tempObject.chare == Player.Char.Jasnon) {
                    Jasniun++;
                    if (Jasniun > 2) {
                        Jasniun = 0;
                    }
                }else if (key==KeyEvent.VK_DOWN&&tempObject.chare== Player.Char.Jasnon){
                    Jasniun--;
                    if (Jasniun<0){
                        Jasniun=2;
                    }
                }
                if (key==KeyEvent.VK_S){
                    Player.Standing=true;
                }else {
                    Player.Standing=false;
                }
                if (key==KeyEvent.VK_W&&handler.BeaMode>0){
                    tempObject.y-=6;
                }
                if (key==KeyEvent.VK_S&&handler.BeaMode>0){
                    tempObject.y+=6;
                }
            }else if (tempObject.id==ID.clone){
                if (key == KeyEvent.VK_SPACE&&jump1){
                    if (tempObject.chare == Player.Char.Hanno) {
                        tempObject.setGy(-18-handler.clonemod1);
                    }
                }else if (key == KeyEvent.VK_SPACE&&handler.doublejump1>0){
                    handler.doublejump1--;
                    tempObject.setGy(-19-handler.clonemod1);
                }
            }
        }
        if (game.gamestate== Game.STATE.Pause){
            if (e.getKeyCode() == KeyEvent.VK_R){
                System.out.println("Changing mode");
                handler.gx=3;
                handler.speed=0;
                handler.distance=0;
                handler.Colorspeed=0.7f;
                handler.doublejump=1;
                game.Geld=0;
                game.Bildung=0;
                game.Liebe=0;
                handler.object.clear();
                handler.seed=new Random(Game.seed);
                handler.itemSeed=new Random(Game.itemseed);
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
                }else if (game.players==13) {
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
                handler.addObject(new Wall(200, 300, 3, 0, ID.Wall,handler));
                handler.addObject(new Wall(240, 300, 3, 0, ID.Wall,handler));
                handler.addObject(new Wall(300, 300, 3, 0, ID.Wall,handler));
                handler.addObject(new Wall(600, 300, 3, 0, ID.Wall,handler));
            }else if (e.getKeyCode()== KeyEvent.VK_M){
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                    game.gamestate = Game.STATE.Menu;
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }else if (e.getKeyCode()==KeyEvent.VK_ESCAPE){
                Game.gamestate= Game.STATE.Game;
                return;
            }
        }
        if (game.gamestate== Game.STATE.CharMenu){
            if (key==KeyEvent.VK_1){
                GameOver.ArcSeed+=1;
            }else if (key==KeyEvent.VK_2){
                GameOver.ArcSeed+=2;
            }else if (key==KeyEvent.VK_3){
                GameOver.ArcSeed+=3;
            }else if (key==KeyEvent.VK_4){
                GameOver.ArcSeed+=4;
            }else if (key==KeyEvent.VK_5){
                GameOver.ArcSeed+=5;
            }else if (key==KeyEvent.VK_6){
                GameOver.ArcSeed+=6;
            }else if (key==KeyEvent.VK_7){
                GameOver.ArcSeed+=7;
            }else if (key==KeyEvent.VK_8){
                GameOver.ArcSeed+=8;
            }else if (key==KeyEvent.VK_9){
                GameOver.ArcSeed+=9;
            }else if (key==KeyEvent.VK_0){
                GameOver.ArcSeed+=0;
            }else if (key==KeyEvent.VK_ENTER){
                CharMenu.ArcSeeder= Integer.parseInt(GameOver.ArcSeed);
                GameOver.ArcSeed="0";
            }
        }
        if (game.gamestate== Game.STATE.ModeSelect){
            game.gamestate= Game.STATE.Menu;
        }
        if (game.gamestate== Game.STATE.CharMenu){
            if (key == KeyEvent.VK_ESCAPE) {
                game.gamestate = Game.STATE.ModeSelect;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }

        }
        if (key == KeyEvent.VK_ESCAPE&&game.gamestate== Game.STATE.Game){
            game.gamestate= Game.STATE.Pause;
        }

    }


}