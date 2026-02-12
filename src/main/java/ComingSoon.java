import java.awt.*;

public class ComingSoon {
    public float speedcolor;
    public float f;
    public Handler handler;
    Colorscheme scm= new Colorscheme();
    public ComingSoon(Handler handler){
        this.handler=handler;
        speedcolor=0.1f;
    }
    public void tick(Game game){
        speedcolor-=0.00005f;
        if (speedcolor<=0){
            speedcolor+=1f;
        }
    }
    public void render(Graphics g){
        //2400
        scm.advancedGradiant(g,speedcolor,1f,1f,1200,2400,2400,1067,600,0,0,"tl");
        g.setColor(Color.black);
        g.drawImage(Game.PlaceholderBg,0,0,null);
        g.drawString("Coming soon",250,280);
    }
}
