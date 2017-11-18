import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


/**
 *
 * @author olerma
 */
public class Floor extends GameObject{

    public Floor(int  x, int y, ID id ){
        super(x, y, id);
    }

    public void tick() {}

    public void render(Graphics g) {
       if(id == ID.Autumn){
         g.drawImage(ImageLoader.getImageLoader().getImage("Autumn"), (int)x, (int)y, null);
       }
       if(id == ID.Spring){
         g.drawImage(ImageLoader.getImageLoader().getImage("Summer"), (int)x, (int)y, null);
       }
       if(id == ID.Winter){
         g.drawImage(ImageLoader.getImageLoader().getImage("Winter"), (int)x, (int)y, null);
       }
       if(id == ID.Summer){
         g.drawImage(ImageLoader.getImageLoader().getImage("Spring"), (int)x, (int)y, null);
       }
    }

    public Rectangle getBounds() {
      return null;
        //if(this.id ==ID.TreeAutumn || this.id ==ID.TreeSummer || this.id ==ID.TreeWinter || this.id ==ID.TreeSpring ){
        //    return new Rectangle(x, y, 32, 46);
        //}else{
        //    return new Rectangle(x + 5, y + 5, 20, 20);
        //}
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
