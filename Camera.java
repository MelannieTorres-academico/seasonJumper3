/**
 *
 * @author olerma
 */
public class Camera {
    private float x, y, width, height;

    public Camera(float x, float y, float width, float height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void tick(GameObject object){
        x +=((object.getX()) - x -width/2) *0.05f;
        y +=((object.getY()) - y -height/2) *0.05f;
    }

    public float getX(){ return x; }
    public float getY(){ return y; }
    public void setX(float x){ this.x = x; }
    public void setY(float y){ this.y = y; }
}
