import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author olerma
 */
public class HUD {


    private int score = 60000;
    public static int level = 1;
    public static int HEALTH=100;
    /*public void tick(){
      //  HEALTH = Game.clamp(HEALTH, 0, MAXHEALTH);
        score++;
    }*/

    public void render(Graphics g){
       g.drawString("Score: " + score/50, 10, 48);
       g.drawString("Level: " + level, 10, 64);
    }
    public void setScore(int s){
      score=s;
    }
    public int getScore(){
      return score/50;
    }
    public void modifyScore(int ds){
      score+=ds;
    }
    public void upLevel(){
      level++;
    }

    /*public int getTime(){
        return score/50;
    }*/

}
