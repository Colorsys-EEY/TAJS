import java.awt.*;
import java.util.Random;

public abstract class Particle {
    protected int x;
    protected int y;
    protected int gx;
    protected int gy;
    protected int width;
    protected int height;
    protected boolean acid;
    protected boolean stop;

    protected int alpha;

    protected Random random;

    public Particle(int x,int y,int width,int height,boolean acid,boolean stop){
        this.x=x;
        this.y=y;
        this.gx=gx;
        this.gy=gy;
        this.stop=stop;
        this.acid=acid;
        this.width=width;
        this.height=height;
        this.random=new Random();
    }

    public abstract void tick(Handler handler);

    public abstract void render(Graphics g);

    public abstract Rectangle getBounds();
}
