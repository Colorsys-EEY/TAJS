import java.awt.*;

public abstract class GamaObject {

    protected int x, y;
    protected int gx,gy;
    protected ID id;
    protected Player.Char chare;

    public GamaObject(int x, int y, int gx, int gy, ID id, Player.Char chare){
        this.x = x;
        this.y = y;
        this.gx = gx;
        this.gy = gy;
        this.id = id;
        this.chare=chare;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();
    public abstract Rectangle getBounds2();

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setGx(int gx){
        this.gx = gx;
    }
    public void setGy(int gy){
        this.gy = gy;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getGx(){
        return gx;
    }
    public int getGy(){
        return gy;
    }
    public void setId(ID id){
        this.id = id;
    }
    public ID getId(){
        return id;
    }
    public Player.Char getChar(){
        return chare;
    }

}
