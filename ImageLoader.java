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
	private BufferedImage treeSummer;
	private BufferedImage treeWinter;
	private BufferedImage treeAutumn;
	private BufferedImage treeSpring;
	public static ImageLoader imgL;
	public static ImageLoader level1Spring;
	public static ImageLoader level1Winter;
	public static ImageLoader level1Summer;
	public static ImageLoader level1Autumn;

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
			treeSummer = ImageIO.read(new File(IMAGE_DIR+"treeSummer.png"));
			treeWinter = ImageIO.read(new File(IMAGE_DIR+"treeWinter.png"));
			treeSpring = ImageIO.read(new File(IMAGE_DIR+"treeSpring.png"));
			treeAutumn = ImageIO.read(new File(IMAGE_DIR+"treeAutumn.png"));
			level1Summer = ImageIO.read(new File(IMAGE_DIR+"level1Summer.png"));
			level1Winter = ImageIO.read(new File(IMAGE_DIR+"level1Winter.png"));
			level1Spring = ImageIO.read(new File(IMAGE_DIR+"level1Spring.png"));
			level1Autumn = ImageIO.read(new File(IMAGE_DIR+"level1Autumn.png"));
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
	if(image_name.equalsIgnoreCase("treeSummer")){ return treeSummer; }
	if(image_name.equalsIgnoreCase("treeSpring")){ return treeSpring; }
	if(image_name.equalsIgnoreCase("treeWinter")){ return treeWinter; }
	if(image_name.equalsIgnoreCase("treeAutumn")){ return treeAutumn; }
	if(image_name.equalsIgnoreCase("level1Summer")){ return level1Summer; }
	if(image_name.equalsIgnoreCase("level1Winter")){ return level1Winter; }
	if(image_name.equalsIgnoreCase("level1Autumn")){ return level1Autumn; }
	if(image_name.equalsIgnoreCase("level1Spring")){ return level1Spring; }


    return null;
	}


}
