import java.awt.*;

public class jumpparticle extends Particle{
    int bounce;
    float color;
    int red;
    int green;
    int blue;
    int superalpha;
    public jumpparticle(int x, int y, int width, int height,int red,int green,int blue,boolean acid,boolean stop) {
        super(x, y, width, height, acid,stop);
        this.color=color;
        this.red=red;
        this.green=green;
        this.blue=blue;
        boolean r1=random.nextBoolean();
        alpha =1000;
        int r2 = random.nextInt(4)+1;
        if (r1){
            gx=r2;
        }else {
            gx=-r2;
        }
        gy=-random.nextInt(9)-12;
        bounce=(-gy)+1;

    }


    public void tick(Handler handler) {
        if (gy>12){
            gy=12;
        }
        y+=gy;
        x+=gx;
        gy++;
        alpha-=1;
        if (alpha>255){
            superalpha=255;
        }else {
            superalpha=alpha;
        }

        collision(handler);
    }

    public void collision(Handler handler){
        for (int i = 0;i<handler.object.size();i++){
            GamaObject tempObject = handler.object.get(i);
            if (tempObject.id==ID.Wall){
                if (tempObject.getBounds().intersects(getBounds())){
                    gy=-bounce;
                    bounce--;
                    if (bounce<2){
                        bounce=2;
                    }
                    if (random.nextBoolean()){
                        bounce+= random.nextInt(4);
                    }
                    gx+=random.nextInt(3)-1;
                    y=tempObject.y-height-1;
                }

            }
        }

    }

    public void render(Graphics g) {
        g.setColor(new Color(red,green,blue,superalpha));
        g.fillRect(x,y,width,height);
    }

    public Rectangle getBounds() {
        return new Rectangle(x,y,width,height);
    }
}
