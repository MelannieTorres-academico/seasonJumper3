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


	private BufferedImage playerAutumnBack;
	private BufferedImage playerAutumnFront;
	private BufferedImage playerAutumnLeft;
	private BufferedImage playerAutumnRight;

	private BufferedImage level1;

	private BufferedImage margarite;

	private BufferedImage tree;
	private BufferedImage goal;

	private BufferedImage volumeOn;
	private BufferedImage volumeOff;

	private BufferedImage fireworks;

	public static ImageLoader imgL;

  private final static String IMAGE_DIR = "img/";

	public ImageLoader() {

		try {
			margarite = ImageIO.read(new File(IMAGE_DIR+"margarite.png"));

			level1 = ImageIO.read(new File(IMAGE_DIR+"level1.png"));
			autumn = ImageIO.read(new File(IMAGE_DIR+"autumn.png"));
			spring = ImageIO.read(new File(IMAGE_DIR+"spring.png"));
  		summer = ImageIO.read(new File(IMAGE_DIR+"summer.png"));
  		winter = ImageIO.read(new File(IMAGE_DIR+"winter.png"));
  		espinita = ImageIO.read(new File(IMAGE_DIR+"espinita.png"));
  		hierbita = ImageIO.read(new File(IMAGE_DIR+"hierbita.png"));
  		fuegito = ImageIO.read(new File(IMAGE_DIR+"fueguito.png"));
			hielito = ImageIO.read(new File(IMAGE_DIR+"hielito.png"));
			treeSummer = ImageIO.read(new File(IMAGE_DIR+"treeSummer.png"));
			treeWinter = ImageIO.read(new File(IMAGE_DIR+"treeWinter.png"));
			treeSpring = ImageIO.read(new File(IMAGE_DIR+"treeSpring.png"));
			treeAutumn = ImageIO.read(new File(IMAGE_DIR+"treeAutumn.png"));

			playerAutumnBack = ImageIO.read(new File(IMAGE_DIR+"playerAutumnBack.png"));
			playerAutumnFront = ImageIO.read(new File(IMAGE_DIR+"playerAutumnFront.png"));
			playerAutumnLeft = ImageIO.read(new File(IMAGE_DIR+"playerAutumnLeft.png"));
			playerAutumnRight = ImageIO.read(new File(IMAGE_DIR+"playerAutumnRight.png"));

			volumeOn = ImageIO.read(new File(IMAGE_DIR+"volumeOn.png"));
			volumeOff = ImageIO.read(new File(IMAGE_DIR+"volumeOff.png"));

			goal = ImageIO.read(new File(IMAGE_DIR+"meta.png"));
			fireworks = ImageIO.read(new File(IMAGE_DIR+"fireworks.png"));

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
	if(image_name.equalsIgnoreCase("level1")){ return level1; }
    if(image_name.equalsIgnoreCase("autumn")){ return autumn; }
    if(image_name.equalsIgnoreCase("spring")){ return spring; }
    if(image_name.equalsIgnoreCase("winter")){ return winter; }
    if(image_name.equalsIgnoreCase("summer")){ return summer; }
    if(image_name.equalsIgnoreCase("espinita")){ return espinita; }
    if(image_name.equalsIgnoreCase("hierbita")){ return hierbita; }
    if(image_name.equalsIgnoreCase("fueguito")){ return fuegito; }
	if(image_name.equalsIgnoreCase("hielito")){ return hielito; }
	if(image_name.equalsIgnoreCase("treeSummer")){ return treeSummer; }
	if(image_name.equalsIgnoreCase("treeSpring")){ return treeSpring; }
	if(image_name.equalsIgnoreCase("treeWinter")){ return treeWinter; }
	if(image_name.equalsIgnoreCase("treeAutumn")){ return treeAutumn; }

	if(image_name.equalsIgnoreCase("margarite")){ return margarite;}
	if(image_name.equalsIgnoreCase("volumeon")){ return volumeOn; }
	if(image_name.equalsIgnoreCase("volumeoff")){ return volumeOff; }
	if(image_name.equalsIgnoreCase("goal")){ return goal; }
	if(image_name.equalsIgnoreCase("fireworks")){ return fireworks; }

    return null;
	}


}
