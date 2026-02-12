import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy extends GamaObject{
    Handler handler;
    int Counter;
    int health=0;
    int knockback=0;
    BufferedImage UMN;
    BufferedImage UMN_SHOT;
    public Enemy(int x, int y, int gx, int gy, ID id, Player.Char chare,Handler handler) {
        super(x, y, gx, gy, id, chare);
        this.handler=handler;
        Counter=100;
        SpriteSheet ss = new SpriteSheet(Game.Enemys);
        if (chare== Player.Char.Enenmy1){
            health=3;
        }
        UMN=ss.grabAImage(1,1,48,48,48);
        UMN_SHOT=ss.grabAImage(1,6,48,48,48);
    }

    @Override
    public void tick() {
        if (chare== Player.Char.Enenmy1){
            if (y>600){
                health-=3;
            }
            if (health<1){
                for (int l = 0; l < 60; l++) {
                    handler.particles.add(new jumpparticle(x+16 , y+19, 1, 1, 255,0,0, false, false));
                }
                Handler.EnemysKilled++;
                handler.removeObject(this);
            }
            x-=gx;
            x+=knockback;
            if (knockback>0){
                knockback--;
            }
            if (knockback>=30){
                health-=2;
            }
            if (gy <= 0) {
                y += gy;
                gy++;
            }

            if (gy>0){
                y+=gy;
                if (gy<=30){
                    gy++;
                }
            }
            Counter++;
            for (int i = 0;i<handler.object.size();i++){
                GamaObject tempObject = handler.object.get(i);
                if (tempObject.id==ID.Player){
                    if (tempObject.getBounds().intersects(getBounds2())){
                        if (Counter>=100){
                            Counter=0;
                            handler.addObject(new Projectile(x , y + 12, 0, 0, ID.EnBullet, 10, 0, 2, Player.Char.none, handler));
                        }
                    }
                    if (tempObject.getBounds().intersects(getBounds())){
                        if (tempObject.gx>2){
                            health--;
                            knockback+=20;
                        }else {
                            knockback+=5;
                        }
                    }
                }
                if (tempObject.id==ID.Bullet){
                    if (tempObject.getBounds().intersects(getBounds())) {
                        health -= 3;
                    }
                }
                if (tempObject.getId()==ID.Wall){
                    if (getBounds().intersects(tempObject.getBounds())){
                        for (int e=0;e<5;e++){
                            if (tempObject.y+16>=y&&getBounds().intersects(tempObject.getBounds())){
                                y--;
                            }
                        }
                        setGy(0);
                    }
                }

            }
        }
    }

    @Override
    public void render(Graphics g) {
        if (Counter<60){
            g.drawImage(UMN_SHOT,x,y,null);
        }else {
            g.drawImage(UMN,x,y,null);
        }
        if (Game.SHOWHIT) {
            g.setColor(Color.white);
            g.drawRect(x - 256, y + 10, 256, 4);
            g.setColor(Color.black);
            g.drawRect(x,y,32,39);
        }
    }

    @Override
    public Rectangle getBounds() {
        if (chare== Player.Char.Enenmy1){
            return new Rectangle(x, y, 32,38);
        }
        return null;
    }

    @Override
    public Rectangle getBounds2() {
        if (chare== Player.Char.Enenmy1){
            return new Rectangle(x-256, y+10, 256,4);
        }
        return null;
    }
}
