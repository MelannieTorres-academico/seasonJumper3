/**
 *
 * @author olerma
 */
public class Camera {
    private float x, y;

    public Camera(float x, float y){
        this.x =x;
        this.y = y;
    }

    public void tick(GameObject object){
        x +=((object.getX()) - x -Game.WIDTH/2) *0.05f;
        y +=((object.getY()) - y -Game.HEIGHT/2) *0.05f;
    }

    public float getX(){ return x; }
    public float getY(){ return y;}
    public void setX(float x){ this.x = x;}
    public void setY(float y){ this.y = y;}
}
