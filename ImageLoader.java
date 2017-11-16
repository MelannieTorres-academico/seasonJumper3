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
  private BufferedImage espinita;
  private BufferedImage hierbita;
  private BufferedImage fuegito;
	private BufferedImage hielito;
	private BufferedImage tree;
	public static ImageLoader imgL;
  private final static String IMAGE_DIR = "img/";


	public ImageLoader() {


		try {
			autumn = ImageIO.read(new File(IMAGE_DIR+"autumn.png"));
			spring = ImageIO.read(new File(IMAGE_DIR+"spring.png"));
      summer = ImageIO.read(new File(IMAGE_DIR+"summer.png"));
      winter = ImageIO.read(new File(IMAGE_DIR+"winter.png"));
      espinita = ImageIO.read(new File(IMAGE_DIR+"espinita.png"));
      hierbita = ImageIO.read(new File(IMAGE_DIR+"hierbita.png"));
      fuegito = ImageIO.read(new File(IMAGE_DIR+"fuegito.png"));
			hielito = ImageIO.read(new File(IMAGE_DIR+"hielito.png"));
			tree = ImageIO.read(new File(IMAGE_DIR+"tree.png"));
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
    if(image_name.equalsIgnoreCase("espinita")){ return espinita; }
    if(image_name.equalsIgnoreCase("hierbita")){ return hierbita; }
    if(image_name.equalsIgnoreCase("fuegito")){ return fuegito; }
		if(image_name.equalsIgnoreCase("hielito")){ return hielito; }
		if(image_name.equalsIgnoreCase("tree")){ return tree; }
    return null;
	}


}
