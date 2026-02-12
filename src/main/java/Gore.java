import java.awt.*;

public class Gore extends Particle{
    int gx=0;
    int gy=0;
    int Enemy_Number;
    public Gore(int x, int y, int width, int height, boolean acid, boolean stop, int Enemy_Number,int Knockback) {
        super(x, y, width, height, acid, stop);
        gy=(int) Knockback/10;
        gx=Knockback-5;
        this.Enemy_Number=Enemy_Number;
    }

    @Override
    public void tick(Handler handler) {
        y-=gy;
        x+=gx;
        if (Enemy_Number==1){

        }
    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,width,height);
    }
}
