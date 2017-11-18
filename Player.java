import java.awt.Color;
import java.awt.Graphics;
import java.awt. Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author olerma
 */
public class Player  extends GameObject{

    private final int pWITDH = 32;
    private final int pHEIGHT = 32;
    private int dx = 1;
    private int dy = 1;
    HUD hud;


    Random r = new Random();

    public Player(int x, int y, ID id){
        super(x, y, id);
        hud=new HUD();
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, pWITDH, pHEIGHT);
    }

    public Rectangle getOffsetBounds(){
        return new Rectangle (x - dx, y - dy, pWITDH + 2*dy, pHEIGHT + 2*dx);
    }

    //Colisión de lados

     public Rectangle getOffsetBoundsUp(){
        return new Rectangle (x - dx, y - dy, pWITDH + 2*dx, dy);
    }

    public Rectangle getOffsetBoundsDown(){
        return new Rectangle (x - dx, y + pHEIGHT, pWITDH + 2*dx, dy);
    }

    public Rectangle getOffsetBoundsRight(){
        return new Rectangle (x + pWITDH, y -dy , dx, pHEIGHT + 2*dy);
    }

    public Rectangle getOffsetBoundsLeft(){
        return new Rectangle (x - dx, y -dy , dx, pHEIGHT + 2*dy);
    }

    public void tick(){
        x += velX;
        y += velY;
        hud.modifyScore(-1);
    }

    public void render(Graphics g){
        g.drawImage(ImageLoader.getImageLoader().getImage("margarite"),x,y,null);
    }

    public void setVelX(int velX){ this.velX = velX; }
    public void setVelY(int velY){ this.velY = velY; }

    public void moveX(int dx){ x += dx; }
    public void moveY(int dy){ y += dy; }
    public int getVelX(){return velX; }
    public int getVelY(){ return velY; }
    public int getScore(){ return hud.getScore();}
    public int getX(){return x;}
    public int getY(){return y;}

}
