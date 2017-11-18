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

public class AutumnState implements GameState {
	private Scanner scan = new Scanner(System.in); // for user input
	private Color color;
	private Font font;
	GameContext c;
	Player player;
			int velX;
	int velY;
	private boolean[] keyDown=new boolean[4];
	LinkedList<Enemy> enemy = new LinkedList<>();
	Goal goal;
	private int dx=1;
	private int dy=1;
	private volatile boolean pause = false;





	  	public AutumnState(){
	  		loadLevel(ImageLoader.getImageLoader().getImage("level1"));
	  	}

		public AutumnState(GameContext c){
			this.c = c;
			loadLevel(ImageLoader.getImageLoader().getImage("level1"));}

		public void loadLevel(BufferedImage image){
        int w = image.getWidth();
        int h = image.getHeight();
        for(int xx = 0; xx < w; xx++){
            for(int yy = 0; yy < h; yy++){
                int pixel = image.getRGB(xx, yy);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;

                if(green == 0 && red == 0 && blue ==0){
                	//floor.add(new Floor(xx*120, yy*120, ID.Autumn));
                }else if(green == 255 && red == 255 && blue == 255){ //white
                    //enemy.add(new Enemy(xx*32, yy*32, ID.Hielito));
                }else if(red == 255 && blue == 255){ //purple
                    enemy.add(new Enemy(xx*32, yy*32, ID.Espinita));
                }else if(green == 255 && blue == 255){ //cyan
                    //enemy.add(new Enemy(xx*32, yy*32, ID.Hierbita));
                }else if(green == 255 && red == 255){ //yellow
                    goal = new Goal(xx*32, yy*32, ID.Goal);
                }else if(green == 255){ //green
                    //enemy.add(new Enemy(xx*32, yy*32, ID.Fuegito));
                }else if(red == 255){ //red
                    enemy.add(new Enemy(xx*32, yy*32, ID.TreeAutumn));
                }else if(blue == 255){ //blue
                    //handler.addObject(new Player(xx*32, yy*32, ID.Player, handler));
                }
                
            	}
        	}
    	}


    	 private void collision(){
        for(int i =0 ; i < enemy.size(); i++){
            if(enemy.get(i).getID() == ID.Fuegito || enemy.get(i).getID() == ID.Hielito || enemy.get(i).getID() == ID.Espinita || enemy.get(i).getID() == ID.Hierbita){
                //collision with Basic enemy.get(i)
                if(player.getBounds().intersects(enemy.get(i).getBounds())){
                    HUD.HEALTH-=2;
                }
            }
             if(enemy.get(i).getID() == ID.Goal){
                //collision with Basic enemy.get(i)
                if(player.getBounds().intersects(enemy.get(i).getBounds())){
                    HUD.level++;
                }
                
            }
             
             if(enemy.get(i).getID() == ID.TreeAutumn || enemy.get(i).getID() == ID.TreeSpring || enemy.get(i).getID() == ID.TreeWinter || enemy.get(i).getID() == ID.TreeSummer){
                //collision with Basic enemy.get(i)
                 if(player.getOffsetBoundsUp().intersects(enemy.get(i).getBounds()) || player.getOffsetBoundsDown().intersects(enemy.get(i).getBounds())  || player.getOffsetBoundsLeft().intersects(enemy.get(i).getBounds()) || player.getOffsetBoundsRight().intersects(enemy.get(i).getBounds())){
                        player.moveX(player.getVelX()* -1);
                        player.moveY(player.getVelY()* -1);
                    }
            }

            if(goal.getID() == ID.Goal){
            	if(player.getBounds().intersects(goal.getBounds())){win();}
        	}
             
        }
    }

		public void draw(Graphics g){
			//color=new Color(53, 171, 255);
			//font=new Font("Verdana", Font.BOLD, 18);
			//g.setFont(font);
			//g.setColor(color);
			g.drawImage(ImageLoader.getImageLoader().getImage("autumn"),0,0,null);
			player.render(g);
			player.tick();
        	for(int i = 0; i  < enemy.size(); i++){
        		enemy.get(i).render(g);
        	}
        	goal.render(g);
        	collision();

		}

public void processKey(KeyEvent e){
			int key = e.getKeyCode();
			if(pause==false){
			if(key == KeyEvent.VK_SPACE){winter();}
            if(key == KeyEvent.VK_UP){player.setVely(-dy); keyDown[0] = true;}
            if(key == KeyEvent.VK_DOWN) {player.setVely(dy); keyDown[1] = true;}
            if(key == KeyEvent.VK_LEFT) {player.setVelX(-dx); keyDown[2] = true;}
            if(key == KeyEvent.VK_RIGHT) {player.setVelX(dx); keyDown[3] = true;}
        	}
        	if(key == KeyEvent.VK_P) { if(pause==false){pause=true;}else{pause=false;} }
		}

		public void keyReleased(KeyEvent e){
			int key = e.getKeyCode();

			    if(key == KeyEvent.VK_UP){ keyDown[0] = false;}
                if(key == KeyEvent.VK_DOWN) {keyDown[1] = false;}
                if(key == KeyEvent.VK_LEFT) {keyDown[2] = false;}
                if(key == KeyEvent.VK_RIGHT) {keyDown[3] = false;}

                if(!keyDown[0] && !keyDown[1]){
                    player.setVely(0);
                }
                if(!keyDown[2] && !keyDown[3]){
                    player.setVelX(0);
                }

		}

    public void clickMouse(MouseEvent e) {}
    public void menu(){}
    public void help(){}
		public void load(){}
    public void winter(){c.setState(c.getWinterState());}
    public void spring(){}
    public void summer(){}
    public void autumn(){}
    public void lose(){}
    public void win(){c.setState(c.getWinState());}
    public void end(){}
            public int getVelX(){ return velX; }
		public int getVelY(){ return velY; }
    public void setContext(GameContext cont){ this.c = cont;}
		public void setPlayer(Player p){this.player=p;}
		public void tick(Camera camera){camera.tick(player);}

}
