import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class Settings {
    public File file;
    public Settings(){
        file = new File("/home");
        if (file.exists()){
            String contents[]= file.list();
            file=new File("/home/"+contents[0]+"/.TAJS/Settings.data");
            if (file.exists()){
                try {
                    Scanner scanner= new Scanner(file);
                    int[] gamestuff = new int[3];
                    gamestuff[0]= scanner.nextInt();
                    gamestuff[1]= scanner.nextInt();
                    gamestuff[2]= scanner.nextInt();
                    if (gamestuff[0]==1){
                        Game.GRAPHICS=true;
                    }else {
                        Game.GRAPHICS=false;
                    }
                    if (gamestuff[1]==1){
                        Game.ANIMATION=true;
                    }else {
                        Game.ANIMATION=false;
                    }
                    Game.RS=gamestuff[2];
                    SettingsWindow.Slide=gamestuff[2];
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }else {
                try {
                    file.createNewFile();
                    Writer writer=new FileWriter(file);
                    writer.write("1 1 2");
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Didnt make manage to create file");
                }
            }
        }
    }
    public void tick(){
        Game.RS=SettingsWindow.Slide;
        try {
            Menu.settingsWindow.tick();
        }catch (Exception e){
            System.out.println("No SSetting");
        }
        try {
            FileWriter writer=new FileWriter(file);
            int[] gamestuff= new int[3];
            if (Game.GRAPHICS){
                gamestuff[0]=1;
            }else {
                gamestuff[0]=0;
            }
            if (Game.ANIMATION){
                gamestuff[1]=1;
            }else {
                gamestuff[1]=0;
            }
            gamestuff[2]=Game.RS;
            writer.write(gamestuff[0]+" "+gamestuff[1]+" "+gamestuff[2]);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public void render(Graphics g){
        g.setColor(Color.white);
        g.drawString("Graphics:",100,100);
        if (Game.GRAPHICS) {
            g.drawImage(Game.FANCY, 100, 120, null);
        }else {
            g.drawImage(Game.FAST, 100, 120, null);
        }
        g.drawString("RenderSpeed:",180,100);
        if (Game.RS==2){
            g.drawImage(Game.FAST, 180, 120, null);
        }else if (Game.RS==1){
            g.drawImage(Game.FANCY, 180, 120, null);
        }else {
            g.drawImage(Game.FAST, 180, 120, null);
        }
        g.drawString("Animation:",260,100);
        if (!Game.ANIMATION){
            g.drawImage(Game.FAST, 260, 120, null);
        }else if (Game.ANIMATION){
            g.drawImage(Game.FANCY, 260, 120, null);
        }

    }
}
