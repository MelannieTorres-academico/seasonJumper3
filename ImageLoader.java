import java.awt.*;
import java.awt.image.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;

public class ImageLoader {
	private BufferedImage autumn;
	private BufferedImage spring;
  private BufferedImage summer;
  private BufferedImage winter;
	public static ImageLoader imgL;
  private final static String IMAGE_DIR = "img/";


	public ImageLoader() {


		try {
			autumn = ImageIO.read(new File(IMAGE_DIR+"autumn.png"));
			spring = ImageIO.read(new File(IMAGE_DIR+"spring.png"));
      summer = ImageIO.read(new File(IMAGE_DIR+"summer.png"));
      winter = ImageIO.read(new File(IMAGE_DIR+"winter.png"));
		}
    catch(IOException e){}
	}

	public static ImageLoader getImageLoader(){
		if(imgL == null){
			imgL = new ImageLoader();
		}
		return imgL;
	}

	public BufferedImage getImage(String image_name) {
    if(image_name.equalsIgnoreCase("autumn")){ return autumn; }
    if(image_name.equalsIgnoreCase("spring")){ return spring; }
    if(image_name.equalsIgnoreCase("winter")){ return winter; }
    if(image_name.equalsIgnoreCase("summer")){ return summer; }
    return null;
	}


}
