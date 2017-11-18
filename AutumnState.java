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
	int i;


	  public AutumnState(){}

		public AutumnState(GameContext c){
			this.c = c;
		}

		public void draw(Graphics g){
			i++;
			color=new Color(53, 171, 255);
			font=new Font("Verdana", Font.BOLD, 18);
			g.setFont(font);
			g.setColor(color);
			g.drawImage(ImageLoader.getImageLoader().getImage("autumn"),0,0,null);


			loadLevel(ImageLoader.getImageLoader().getImage("level1"));

			player.render(g);

		}

		public void processKey(KeyEvent e){
			int keyCode = e.getKeyCode();
			if(keyCode == KeyEvent.VK_SPACE){winter();}
      if(keyCode == KeyEvent.VK_UP   ) { player.moveY(-10);}
      if(keyCode == KeyEvent.VK_DOWN ) { player.moveY(10); }
      if(keyCode == KeyEvent.VK_LEFT ) { player.moveX(-10); }
      if(keyCode == KeyEvent.VK_RIGHT) { player.moveX(10); }

		}
		
	public void loadLevel(BufferedImage image){
        int w = image.getWidth();
        int h = image.getHeight();
        for(int xx = 0; xx < w; xx++){
            for(int yy = 0; yy < h; yy++){
                int pixel = image.getRGB(xx, yy);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;
                //System.out.println("X:" + xx + "Y: " + yy);
                if(green == 255 && red == 255 && blue == 255){ //white
                    handler.addObject(new Enemy(xx*32, yy*32, ID.Hielito));
                }else if(red == 255 && blue == 255){ //purple
                	handler.addObject(new Enemy(xx*32,yy*32, ID.Espinita));
                }else if(green == 255 && blue == 255){ //cyan
                    handler.addObject(new Enemy(xx*32, yy*32, ID.Hierbita));
                }else if(green == 255 && red == 255){ //yellow
                    handler.addObject(new BasicMeta(xx*32, yy*32, ID.BasicMeta));
                }else if(green == 255){ //green
                    handler.addObject(new Enemy(xx*32, yy*32, ID.Fuegito));
                }else if(red == 255){ //red
                   handler.addObject(new Enemy(xx*32, yy*32, ID.Enemy));
                }else if(blue == 255){ //blue
                   //handler.addObject(new Player(xx*32, yy*32, ID.Player, handler));
                }
            }
        }
    }

		public void keyReleased(KeyEvent e){	int key = e.getKeyCode(); }

    public void clickMouse(MouseEvent e) {}
    public void menu(){}
    public void help(){}
		public void load(){}
    public void winter(){c.setState(c.getWinterState());}
    public void spring(){}
    public void summer(){}
    public void autumn(){}
    public void lose(){}
    public void win(){}
    public void end(){}
    public void setContext(GameContext cont){ this.c = cont;}
		public void setPlayer(Player p){this.player=p;}
		public void tick(Camera camera){camera.tick(player);}

}
