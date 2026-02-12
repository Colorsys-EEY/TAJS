import java.awt.*;

public class Colorscheme {
    void drawGradiant(Graphics g,float color,float Saturation,float brightness,int Factor,int width,int height,int x,int y){
        g.setColor(Color.getHSBColor(color,Saturation,brightness));
        g.fillRect(x,y,width,1);
        for (float i=1;i<height;i++){
            g.setColor(Color.getHSBColor(color-(i/Factor),Saturation,brightness));
            g.fillRect(x, (int) (y+i),width,1);
        }
    }
    void fastGradiant(Graphics g,float color,int fastFactor,int width,int height){
        g.setColor(Color.getHSBColor(color,1f,1f));
        g.fillRect(0,0,width,height);
        for (float i=1;i<height;i++){
            g.setColor(Color.getHSBColor(color-(i/(fastFactor*height)),1f,1f));
            g.fillRect(0, (int) (1+i),width,1);
        }
    }
    void advancedGradiant(Graphics g,float color,float Saturation,float Brightness,int Factor,int saturationFactor,int shadeFactor,int width,int height,int x,int y,String direction){
        g.setColor(Color.getHSBColor(color,Saturation,Brightness));
        if (direction.equals("t")){
            g.fillRect(0,0,width,height);
            for (float i=1;i<height;i++){
                if (saturationFactor!=0&&shadeFactor!=0){
                    g.setColor(Color.getHSBColor(color-(i/Factor),Saturation-(i/saturationFactor),Brightness-(i/shadeFactor)));
                }else{
                    g.setColor(Color.getHSBColor(color-(i/Factor),Saturation,Brightness));
                }
                g.fillRect(x, (int) (y+i),width,1);
            }
        }else if (direction.equals("tl")){
            g.fillRect(x,y,2,2);
            for (float i=1;i<height/2;i++){
                for (float e=1;e<width/2;e++){
                    g.setColor(Color.getHSBColor(color-(((i/Factor)+(e/Factor))/2f),Saturation,Brightness));
                    g.fillRect((int) ((x+e)*2-1), (int) ((y+i)*2-1),2,2);
                }
            }

        }
    }
}
