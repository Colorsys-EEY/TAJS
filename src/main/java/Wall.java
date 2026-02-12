import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.util.Random;

public class Wall extends GamaObject{
    Handler handler;
    private BufferedImage Wallone;
    private BufferedImage Wallimg;
    private BufferedImage Wallleft;
    private BufferedImage Walliddle;
    private BufferedImage Wallright;
    private int slow;
    public boolean Left;
    public boolean Right;
    public boolean OK;
    Colorscheme csm=new Colorscheme();

    public Wall(int x, int y, int gx, int gy, ID id,Handler handler) {
        super(x, y, gx, gy, id, Player.Char.none);
        this.handler=handler;
        SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
        Wallimg = ss.grabImage(1,4,32,32);
        Wallleft = ss.grabImage(1,1,32,32);
        Walliddle = ss.grabImage(1,2,32,32);
        Wallright = ss.grabImage(1,3,32,32);

    }

    Random random = new Random();
    public void tick() {
        if (slow>0){
            slow--;
        }else{
            x-=gx;
            if (handler.SlowTime>0){
                x+=gx/2;
            }
            int lefti=0;
            int righty=0;
            OK=false;
            for(int i = 0;i<handler.object.size();i++){
                GamaObject tempObject = handler.object.get(i);
                if (x<=tempObject.x+50&&x>tempObject.x&&tempObject!=this&&tempObject.id==ID.Wall&&y==tempObject.y){
                    lefti++;
                    if (x>= tempObject.x+18){OK=true;}
                }
                if (x>=tempObject.x-50&&x<tempObject.x&&tempObject!=this&&tempObject.id==ID.Wall&&y==tempObject.y){righty++;}
                if (x<=tempObject.x+50&&x>tempObject.x&&tempObject!=this&&tempObject.id==ID.Inkwall&&y==tempObject.y){
                    lefti++;
                    if (x>= tempObject.x+18){OK=true;}
                }
                if (x>=tempObject.x-50&&x<tempObject.x&&tempObject!=this&&tempObject.id==ID.Inkwall&&y==tempObject.y){righty++;}

            }
            if(lefti==0){
                Left=false;
            }else{
                Left=true;
            }
            if (righty==0){
                Right=false;
            }else{
                Right=true;
            }

        }

        for(int i=0;i<handler.particles.size();i++){
            Particle tempobject=handler.particles.get(i);
            if (tempobject.getBounds().intersects(this.getBounds2())) {
                if (tempobject.acid) {
                    handler.removeObject(this);
                    for (int i1 = 0; i1 < 28; i1++) {
                        handler.particles.add(new jumpparticle(x, y, 3, 3, 0,255,255, false,false));
                    }
                    if (random.nextInt(5) < 1) {
                        if (random.nextInt(2) < 1) {
                            Game.Liebe++;
                        } else if (random.nextInt(2) < 1) {
                            Game.Bildung++;
                        } else if (random.nextInt(2) < 1) {
                            Game.Geld++;
                        }
                    }
                }else if (tempobject.stop){
                    slow=300;
                }
            }
        }


    }


    public void render(Graphics g) {
        if (Left&&Right){
            Wallone=Walliddle;
        }else if(Left&& !Right){
            Wallone=Wallright;
        } else if (!Left&&Right) {
            Wallone=Wallleft;
        }else {
            Wallone=Wallimg;
        }
        float ncolor;
        if (id==ID.Wall){
            if (slow>0){
                float speedcolor= handler.Colorspeed;
                while (speedcolor<0){
                    speedcolor+=1;
                }
                if (Game.GRAPHICS){
                    //128
                    csm.drawGradiant(g,speedcolor,0f,0f,128,32,32,x,y);
                }else{
                    g.setColor(Color.getHSBColor(0f,0f,0f));
                    g.fillRect(x,y,32,32);
                }
                if (Game.SHOWHIT){
                    g.setColor(Color.white);
                    g.drawRect(x-10,y-10,52,52);
                }
                g.drawImage(Wallone, x, y, null);

            }else{
                float speedcolor= handler.Colorspeed;
                while (speedcolor<0){
                    speedcolor+=1;
                }
                if (Game.GRAPHICS){
                    //128
                    csm.drawGradiant(g,speedcolor,1f,1f,128,32,32,x,y);
                }else{
                    g.setColor(Color.getHSBColor(speedcolor,1f,1f));
                    g.fillRect(x,y,32,32);
                }
                if (Game.SHOWHIT){
                    g.setColor(Color.white);
                    g.drawRect(x-10,y-10,52,52);
                }
                g.drawImage(Wallone, x, y, null);
                if (Left&&OK&&Game.GRAPHICS){
                    csm.drawGradiant(g,speedcolor,1f,1f,128,32,32,x-18,y);
                    g.drawImage(Walliddle,x-18,y,null);
                }
            }

        }else if (id==ID.Inkwall){
            float speedcolor= handler.Colorspeed;
            while (speedcolor<0){
                speedcolor+=1;
            }
            ncolor=speedcolor-0.5f;
            if (ncolor<0){
                ncolor+=1;
            }

            if (Game.GRAPHICS){
                csm.drawGradiant(g,ncolor,1,1f,-128,32,32,x,y);
            }else{
                g.setColor(Color.getHSBColor(ncolor,1f,1f));
                g.fillRect(x,y,32,32);
            }
            g.drawImage(Wallone, x, y, null);
        }

    }


    public Rectangle getBounds() {
        return new Rectangle(x,y,32,32);
    }
    public Rectangle getBounds2(){return new Rectangle(x-10,y-10,52,52);}
}
