import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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

    Handler handler;
    HUD hud;


    Random r = new Random();

    public Player(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
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
        collision();
        if(HUD.HEALTH == 0){
            System.exit(0);
        }
    }

    private void collision(){
        for(int i =0 ; i <handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getID() == ID.Fuegito || tempObject.getID() == ID.Hielito || tempObject.getID() == ID.Espinita || tempObject.getID() == ID.Hierbita){
                //collision with Basic Enemy
                if(getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH-=2;
                }
            }
             if(tempObject.getID() == ID.BasicMeta){
                //collision with Basic Enemy
                if(getBounds().intersects(tempObject.getBounds())){
                    HUD.level++;
                }

            }

             if(tempObject.getID() == ID.Enemy){
                //collision with Basic Enemy
                 if(getBounds().intersects(tempObject.getBounds())){
                        x += velX* -1;
                        y += velY * -1;
                    }
            }

        }
    }

    public void render(Graphics g){
        /*if(id == ID.Player) {g.setColor(Color.white);}
         if(id == ID.Player2){g.setColor(Color.blue);}
         g.fillRect(x, y, pWITDH, pHEIGHT);*/

        g.drawImage(ImageLoader.getImageLoader().getImage("margarite"),x,y,null);
    }

    public void setVelX(int velX){ this.velX = velX; }
    public void setVelY(int velY){ this.velY = velY; }
    public void moveX(int dx){ x += dx; }
    public void moveY(int dy){ y += dy; }
    public int getVelX(){return velX; }
    public int getVelY(){ return velY; }

}
