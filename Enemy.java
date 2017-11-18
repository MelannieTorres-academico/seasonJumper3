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
       if(id == ID.TreeAutumn){
         g.drawImage(ImageLoader.getImageLoader().getImage("TreeAutumn"), (int)x, (int)y, null);
       }
       if(id == ID.TreeSummer){
         g.drawImage(ImageLoader.getImageLoader().getImage("TreeSummer"), (int)x, (int)y, null);
       }
       if(id == ID.TreeWinter){
         g.drawImage(ImageLoader.getImageLoader().getImage("TreeWinter"), (int)x, (int)y, null);
       }
       if(id == ID.TreeSpring){
         g.drawImage(ImageLoader.getImageLoader().getImage("TreeSpring"), (int)x, (int)y, null);
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
        if(this.id ==ID.TreeAutumn || this.id ==ID.TreeSummer || this.id ==ID.TreeWinter || this.id ==ID.TreeSpring ){
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
