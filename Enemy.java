import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


/**
 *
 * @author olerma
 */
public class Enemy extends GameObject{

    public Enemy(int  x, int y, ID id ){
        super(x, y, id);
    }

    public void tick() {}

    public void render(Graphics g) {
       if( id == ID.Enemy){
         g.drawImage(ImageLoader.getImageLoader().getImage("treeSpring"), (int)x, (int)y, null);
       }
       if(id == ID.Fuegito){
         g.drawImage(ImageLoader.getImageLoader().getImage("fueguito"), (int)x, (int)y, null);
       }
       if(id == ID.Hielito){
         g.drawImage(ImageLoader.getImageLoader().getImage("hielito"), (int)x, (int)y, null);
       }
       if(id == ID.Hierbita){
         g.drawImage(ImageLoader.getImageLoader().getImage("hierbita"), (int)x, (int)y, null);
       }
       if(id == ID.Espinita){
         g.drawImage(ImageLoader.getImageLoader().getImage("espinita"), (int)x, (int)y, null);
       }
    }

    public Rectangle getBounds() {
        if(this.id ==ID.Enemy){
            return new Rectangle(x, y, 32, 46);
        }else{
            return new Rectangle(x + 5, y + 5, 20, 20);
        }
    }

    public Rectangle getOffsetBoundsUp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Rectangle getOffsetBoundsDown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Rectangle getOffsetBoundsRight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Rectangle getOffsetBoundsLeft() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
