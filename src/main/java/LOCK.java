import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LOCK {
    public Colorscheme scm;
    public float speedcolor;
    File f= new File("C:/Users/Public/Documents/Unlocked.txt");
    FileWriter writer;

    {
        try {
            writer = new FileWriter(f);
            writer.write("This is the severe punishment that you deserve");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tick(){
        speedcolor-=0.0005f;
        if (speedcolor<0){
            speedcolor+=1f;
        }
    }
    public void render(Graphics g){
        scm.drawGradiant(g,speedcolor,0.7f,1f,1400,800,600,0,0);
        g.setColor(Color.black);
        g.drawString("Why did you think that would work you will be punished",250,280);
    }
}
