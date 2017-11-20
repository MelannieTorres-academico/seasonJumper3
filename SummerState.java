
/*
 * StartState.java
 *
 * Copyright 2017 Edgar Daniel Fernández Rodríguez <edgar.fernandez@me.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 *
 *
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.*;
import java.awt.Font;
import java.awt.image.*;

public class SummerState implements GameState {
	private Scanner scan = new Scanner(System.in); // for user input
	private Color color;
	private Font font;
	GameContext c;
	private boolean[] keyDown=new boolean[4];
	Player player;
	int velX;
	int velY;
	LinkedList<Enemy> enemy = new LinkedList<>();
	Goal goal;
	private int dx=5;
	private int dy=5;
	private volatile boolean pause = false;
	private boolean collision_left=false;
	private boolean collision_right=false;
	private boolean collision_up=false;
	private boolean collision_down=false;
	int t=0;

	  public SummerState(){
	  	loadLevel(ImageLoader.getImageLoader().getImage("level1"));
	  }

		public SummerState(GameContext c){
			this.c = c;
			loadLevel(ImageLoader.getImageLoader().getImage("level1"));
		}


		public void draw(Graphics g){
			g.drawImage(ImageLoader.getImageLoader().getImage("summer"),500,750,null);
			player.render(g);

			for(int i = 0; i  < enemy.size(); i++){ enemy.get(i).render(g); }
      goal.render(g);
			win_lose();
		}


		public void processKey(KeyEvent e){
			int key = e.getKeyCode();
			if(pause==false){
						if(key == KeyEvent.VK_SPACE){autumn();}
						if(key == KeyEvent.VK_UP){
							collision_up=false;
							for(int i =0 ; i < enemy.size(); i++){
										if(enemy.get(i).getID() == ID.TreeSummer){
												if(player.getOffsetBoundsUp().intersects(enemy.get(i).getBounds()) ){ collision_up=true; }
									 }
							 }
							 if(!collision_up){  player.moveY(-10); }
						}
						if(key == KeyEvent.VK_DOWN) {
							collision_down=false;
							for(int i =0 ; i < enemy.size(); i++){
										if(enemy.get(i).getID() == ID.TreeSummer){
											 if(player.getOffsetBoundsDown().intersects(enemy.get(i).getBounds()) ){collision_down=true;}
									 }
							 }
							 if(!collision_down){  player.moveY(10); }
						 }
						if(key == KeyEvent.VK_LEFT) {
							collision_left=false;
							for(int i =0 ; i < enemy.size(); i++){
										if(enemy.get(i).getID() == ID.TreeSummer){
											 if(player.getOffsetBoundsLeft().intersects(enemy.get(i).getBounds())){collision_left=true;}
									 }
							 }
							 if(!collision_left){ player.moveX(-10); }
						}
						if(key == KeyEvent.VK_RIGHT) {
							collision_right=false;
							for(int i =0 ; i < enemy.size(); i++){
										if(enemy.get(i).getID() == ID.TreeSummer){
											 if( player.getOffsetBoundsRight().intersects(enemy.get(i).getBounds())){collision_right=true;}
									 }
							 }
							 if(!collision_right){ player.moveX(10); }
						 }
			}
			if(key == KeyEvent.VK_P) { if(pause==false){ pause=true; }else{ pause=false; } }
		}


		public void keyReleased(KeyEvent e){}



    public void clickMouse(MouseEvent e) {}
    public void menu(){}
		public void help(){}
    public void load(){}
    public void winter(){}
    public void spring(){}
    public void summer(){}
    public void autumn(){c.setState(c.getAutumnState());}
		public void lose(){c.setState(c.getLoseState());}
    public void win(){c.setState(c.getWinState());}
    public void end(){}
    public int getVelX(){ return velX; }
		public int getVelY(){ return velY; }
    public void setContext(GameContext cont){ this.c = cont;}
		public void setPlayer(Player p){this.player=p;}
		public void tick(Camera camera){camera.tick(player);}
		public void setX(Camera camera){}
		public void setY(Camera camera){}
		public void closeMidi(){}
		public void loadLevel(BufferedImage image){
				int w = image.getWidth();
				int h = image.getHeight();
				for(int xx = 0; xx < w; xx++){
						for(int yy = 0; yy < h; yy++){
								int pixel = image.getRGB(xx, yy);
								int red = (pixel >> 16) & 0xff;
								int green = (pixel >> 8) & 0xff;
								int blue = (pixel) & 0xff;

								if(green == 255 && red == 255 && blue == 255){}
								else if(red == 255 && blue == 255){}
								else if(green == 255 && blue == 255){}
								else if(green == 255 && red == 255){ goal = new Goal(xx*32, yy*32, ID.Goal); }
								else if(green == 255){ enemy.add(new Enemy(xx*32, yy*32, ID.Fuegito)); }
								else if(red == 255){	enemy.add(new Enemy(xx*32, yy*32, ID.TreeSummer)); }
							}
					}
			}


			private void win_lose(){
				t++;
				if(t>100){
				 for(int i =0 ; i < enemy.size(); i++){
						 if(enemy.get(i).getID() == ID.Fuegito && player.getBounds().intersects(enemy.get(i).getBounds())){
								 player.setScore(0);
								lose();
							}
						 if(goal.getID() == ID.Goal && player.getBounds().intersects(goal.getBounds())){ win(); }
				 }
			 }
	 		}

}
