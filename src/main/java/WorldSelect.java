import java.awt.*;

public class WorldSelect {
    Game game;
    public static boolean Story=true;
    public static boolean Endless=false;
    public WorldSelect(Game game){
        this.game=game;
    }
    public void tick(){

    }
    public void render(Graphics g){
        g.drawImage(game.Story,384,180,null);
        g.drawImage(game.Arcade,384,280,null);
    }
}
