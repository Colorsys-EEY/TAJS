import java.awt.*;
import java.awt.image.BufferedImage;

public class Projectile extends GamaObject{
    Handler handler;
    int Velx;
    int Vely;
    int Count=0;
    int Counter;
    public Projectile(int x, int y, int gx, int gy, ID id,int Velx,int Vely,int Counter,Player.Char chare,Handler handler) {
        super(x, y, gx, gy, id, chare);
        this.handler=handler;
        this.Velx=Velx;
        this.Vely=Vely;
        this.Counter=Counter;
    }
    BufferedImage Bullet;
    public void tick() {
        x -= Velx+gx;
        y -=Vely;
        if (Count==Counter) {
            if (Velx<=0){
                //Velx++;
            }
            if (Vely!=0){
                Vely--;
                if (Vely==0){
                    Vely--;
                }
            }
            Count=0;
        }
        Count++;
        SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
        Bullet=ss.grabAImage(3,3,32,32,32);
        if (id==ID.Acid){
            for(int i = 0;i<handler.object.size();i++){
                GamaObject tempObject = handler.object.get(i);
                if (tempObject.getId()==ID.Wall&&tempObject.getBounds().intersects(this.getBounds())&&x>tempObject.x){
                    handler.removeObject(this);
                    for (int i1=0;i1<1;i1++){
                        handler.particles.add(new jumpparticle(x,y,4,4, 100,255,0,true,false));
                    }
                }
                if (tempObject.getId()==ID.Inkwall&&tempObject.getBounds().intersects(this.getBounds())&&x>=tempObject.x){
                    handler.removeObject(this);
                    for (int i1=0;i1<1;i1++){
                        handler.particles.add(new jumpparticle(x,y,4,4, 100,255,0,true,false));
                    }
                }
            }
        }if (id==ID.slowpotion){
            for(int i = 0;i<handler.object.size();i++){
                GamaObject tempObject = handler.object.get(i);
                if (tempObject.getId()==ID.Wall&&tempObject.getBounds().intersects(this.getBounds())&&x>tempObject.x){
                    handler.removeObject(this);
                    for (int i1=0;i1<10;i1++){
                        handler.particles.add(new jumpparticle(x,y,4,4, 0,0,200,false,true));
                    }
                }
                if (tempObject.getId()==ID.Inkwall&&tempObject.getBounds().intersects(this.getBounds())&&x>=tempObject.x){
                    handler.removeObject(this);
                    for (int i1=0;i1<10;i1++){
                        handler.particles.add(new jumpparticle(x,y,4,4, 0,0,200,true,true));
                    }
                }
            }
        }

    }

    public void render(Graphics g) {
        g.drawImage(Bullet,x,y,null);
    }

    public Rectangle getBounds() {
        if (id==ID.Acid||id==ID.slowpotion){
            return new Rectangle(x-16,y,64,32);
        }
        return new Rectangle(x,y,32,32);
    }
    public Rectangle getBounds2(){return new Rectangle(x,y,0,0);}
}
