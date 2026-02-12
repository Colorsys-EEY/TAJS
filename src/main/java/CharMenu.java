import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharMenu {
    File file;
    File path;
    File progression;
    File ArcSeed;
    public static int ArcSeeder=1;
    public static String Theme0;
    public static int PROGRESS=0;
    public static int Endless_Difficulty_Score=0;
    public static int Endless_Difficulty_Glitch=0;
    public static int Endless_Difficulty_Enemy=1;
    public static int Endless_Difficulty_Obstacle=0;
    Scanner scanner;
    String[] strings= new String[50];
    boolean Burckhardt1;
    boolean Marko1;
    boolean Mattis1;
    boolean Drauge1;
    boolean Jasnon1;
    boolean Hanno1;
    public static boolean Mattis2;
    Game game;
    public CharMenu(Game game){
        this.game=game;
        file= new File("C:/Users/Public/Documents");
        if (file.exists()){
            System.out.println("Windows");
            file=new File("C:/Users/Public/Documents/Unlocked.txt");
            path=new File("C:/Users/Public/Documents/TAJS");
            progression=new File("C:/Users/Public/Documents/TAJS/Progress.txt");
            Theme0 = "C:/Users/Public/Documents/TAJS/res";
            ArcSeed=new File("C:/Users/Public/Documents/TAJS/Seeder.data");
            if (!path.exists()){
                path.mkdirs();
            }
            if (progression.exists()){
                try {
                    Scanner scunner = new Scanner(progression);
                    PROGRESS=scunner.nextInt();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }else {
                try {
                    progression.createNewFile();
                    FileWriter writy= new FileWriter(progression);
                    writy.write("0");
                    writy.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (ArcSeed.exists()){
                try {
                    Scanner scunner = new Scanner(ArcSeed);
                    ArcSeeder=scunner.nextInt();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }else {
                try {
                    ArcSeed.createNewFile();
                    FileWriter writy= new FileWriter(ArcSeed);
                    writy.write("1");
                    ArcSeeder=1;
                    writy.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }else {
            file=new File("/home");
            String contents[]= file.list();
            file=new File("/home/"+contents[0]+"/Unlocked.txt");
            path=new File("/home/"+contents[0]+"/.TAJS");
            progression=new File("/home/"+contents[0]+"/.TAJS/Progress.txt");
            Theme0="/home/"+contents[0]+"/.TAJS/res";
            System.out.println(Theme0);
            ArcSeed=new File("/home/"+contents[0]+"/.TAJS/Seeder.data");
            if (!path.exists()){
                path.mkdirs();
            }
            if (progression.exists()){
                try {
                    Scanner scunner = new Scanner(progression);
                    PROGRESS=scunner.nextInt();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }else {
                try {
                    progression.createNewFile();
                    FileWriter writy= new FileWriter(progression);
                    writy.write("0");
                    writy.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (ArcSeed.exists()){
                try {
                    Scanner scunner = new Scanner(ArcSeed);
                    ArcSeeder=scunner.nextInt();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }else {
                try {
                    ArcSeed.createNewFile();
                    FileWriter writy= new FileWriter(ArcSeed);
                    writy.write("1");
                    ArcSeeder=1;
                    writy.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("CharMenu Initialized");
        }
        Burckhardt1=true;
        Marko1=true;
        Mattis1=true;
        Drauge1=true;
        Jasnon1=true;
        Hanno1=true;
    }
    BufferedImage etta;
    BufferedImage Burckhardt;
    BufferedImage MarkoI;
    BufferedImage MattisI;
    BufferedImage DraugeI;
    BufferedImage JasnonI;
    BufferedImage HannoI;
    BufferedImage CaroI;
    BufferedImage AndreI;
    BufferedImage RabeaI;
    BufferedImage RikeI;
    BufferedImage IpekI;
    BufferedImage MilanI;
    BufferedImage KikiI;
    BufferedImage ShaniceI;
    BufferedImage EmelyI;
    public void tick(){

        if (!file.exists()){
            try {
                file.createNewFile();
                scanner=new Scanner(file);
                int i=0;
                while (scanner.hasNext()){
                    strings[i]=scanner.next();
                    i++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int i1=0;
        try {
            scanner=new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNext()){
            strings[i1]=scanner.next();
            i1++;
        }
        int z=0;
        int Marko=0;
        int Mattis=0;
        int Drauge=0;
        int Jasnon=0;
        int Hanno=0;
        for (int i=0;i<50;i++){
            if (strings[i]==null){
                break;
            }
            if (strings[i].equals("Burckhardt")){
                z++;
            }
            if (strings[i].equals("Marko")){
                Marko++;
            }
            if (strings[i].equals("Mattis")){
                Mattis++;
            }
            if (strings[i].equals("Drauge")){
                Drauge++;
            }
            if (strings[i].equals("Jasnon")){
                Jasnon++;
            }
            if (strings[i].equals("Hanno")){
                Hanno++;
            }
        }
        if (z<1){
            Burckhardt1=true;
        }
        if (Marko<1){
            Marko1=true;
        }
        if (Mattis<1){
            Mattis1=true;
        }
        if (Drauge<1){
            Drauge1=true;
        }
        if (Jasnon<1){
            Jasnon1=true;

        }
        if (Hanno<1){
            Jasnon1=true;
        }

        SpriteSheet ss = new SpriteSheet(Game.playersheet);
        etta = ss.grabAImage(1, 1, 48, 48, 48);
        Burckhardt = ss.grabAImage(2, 1, 48, 48, 48);
        MarkoI = ss.grabAImage(7,1,48,48,48);
        MattisI=ss.grabAImage(6,1,48,48,48);
        DraugeI=ss.grabAImage(4,1,48,48,48);
        JasnonI=ss.grabAImage(9,1,48,48,48);
        HannoI=ss.grabAImage(10,1,48,48,48);
        CaroI=ss.grabAImage(13,1,48,48,48);
        AndreI=ss.grabAImage(14,1,48,48,48);
        RabeaI=ss.grabAImage(15,1,48,48,48);
        RikeI=ss.grabAImage(16,1,48,48,48);
        IpekI=ss.grabAImage(17,1,48,48,48);
        MilanI=ss.grabAImage(18,1,48,48,48);
        KikiI=ss.grabAImage(19,1,48,48,48);
        ShaniceI=ss.grabAImage(12,1,48,48,48);
        EmelyI=ss.grabAImage(8,1,48,48,48);
    }
    public void render(Graphics g){
        if (WorldSelect.Story) {
            if (PROGRESS == 0) {
                g.drawImage(etta, 510, 510, null);
            }
            if (PROGRESS == 1) {
                g.drawImage(Burckhardt, 88, 20, null);
            }
            if (PROGRESS == 2) {
                g.drawImage(MarkoI, 156, 20, null);
            }
            if (PROGRESS == 3) {
                g.drawImage(MattisI, 224, 20, null);
            }
            if (PROGRESS == 6) {
                g.drawImage(DraugeI, 288, 20, null);
            }
            if (PROGRESS == 4) {
                g.drawImage(JasnonI, 352, 20, null);
            }
            if (PROGRESS == 5) {
                g.drawImage(HannoI, 416, 20, null);
            }
        }else {
            g.drawImage(etta, 24, 20, null);
            g.drawImage(Burckhardt, 88, 20, null);
            g.drawImage(MarkoI, 156, 20, null);
            g.drawImage(MattisI, 224, 20, null);
            g.drawImage(DraugeI, 288, 20, null);
            g.drawImage(JasnonI, 352, 20, null);
            g.drawImage(HannoI, 416, 20, null);
            g.drawImage(CaroI,480,20,null);
            g.drawImage(AndreI,544,20,null);
            g.drawImage(RabeaI,608,20,null);
            g.drawImage(RikeI,672,20,null);
            g.drawImage(IpekI,736,20,null);
            g.drawImage(MilanI,800,20,null);
            g.drawImage(KikiI,864,20,null);
            g.drawImage(ShaniceI,928,20,null);
            g.drawImage(EmelyI,992,20,null);
            g.setColor(Color.BLACK);
            g.drawString("Seed: "+ArcSeeder,0,500);
        }
    }
}
