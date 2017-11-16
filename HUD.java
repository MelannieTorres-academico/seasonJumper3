import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author olerma
 */
public class HUD {

    private static final int MAXHEALTH = 2;
    private int greenValue = 255;
    public static int HEALTH = MAXHEALTH;
    private int score = 0;
    public static int level = 1;

    public void tick(){
      //  HEALTH = Game.clamp(HEALTH, 0, MAXHEALTH);
        score++;
    }

    public void render(Graphics g){
       g.drawString("Score: " + score/50, 10, 48);
       g.drawString("Level: " + level, 10, 64);
    }

    public int getTime(){
        return score/50;
    }

}
