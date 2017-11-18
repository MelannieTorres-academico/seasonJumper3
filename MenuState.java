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
import java.awt.Font;
import java.io.*;
import java.util.*;

public class MenuState implements GameState {
	GameContext c;
	Font font;
	Font font2;
	Color color;
	private MidisLoader midisLoader;
	boolean volume;

	public MenuState(){
		font =new Font("arial", 1, 50);
		font2 =new Font("arial", 1, 30);
		midisLoader = new MidisLoader("midisInfo.txt");
		midisLoader.play("music", true);
		volume=true;


	}

	public MenuState(GameContext c){
		this.c = c;
		font =new Font("arial", 1, 50);
		font2 =new Font("arial", 1, 30);
	}

	public void draw(Graphics g){
		g.setColor(Color.white);

		g.setFont(font);
		g.drawImage(ImageLoader.getImageLoader().getImage("SeasonJumper"),200,20,null);

		g.setFont(font2);
		g.drawString("Play", 270, 190);
		g.drawString("Help", 270, 290);
		g.drawString("Quit", 270, 390);

		if(volume){ g.drawImage(ImageLoader.getImageLoader().getImage("volumeon"),580,10,null);}
		else{ g.drawImage(ImageLoader.getImageLoader().getImage("volumeoff"),580,10,null);}

		g.drawRect(210, 150, 200, 64);
		g.drawRect(210, 250, 200, 64);
		g.drawRect(210, 350, 200, 64);
	}


  public void processKey(KeyEvent e){}
	public void keyReleased(KeyEvent e){}

  public void clickMouse(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

		if (mouseOver(mx, my, 580, 10, 40, 40)){
			if(volume){
				volume=false;
				midisLoader.pause();
			}
			else{
				volume=true;
				midisLoader.resume();
			}
		}
		if (mouseOver(mx, my, 210, 150, 200, 64)){ load(); }
		if (mouseOver(mx, my, 210, 350, 200, 64)){ System.exit(0); }//quit button
		if (mouseOver(mx, my, 210, 250, 200, 64)){	help(); }
	}



  public void menu(){}
	public void help(){ c.setState(c.getHelpState()); }
  public void load(){	c.setState(c.getLoadState());}
	public void winter(){}
	public void spring(){}
	public void summer(){}
	public void autumn(){}
  public void lose(){}
  public void win(){}
  public void end(){}
  public void setContext(GameContext cont){ this.c = cont;}
	public void setPlayer(Player p){}

	private boolean mouseOver(int mx, int my,int x, int y, int width, int heigth){
		if (mx > x && mx < x + width){
				return (my >  y  && my < y + heigth);
		}else{
				return false;
		}
	}
	public void tick(Camera camera){}
		public void setX(Camera camera){}
		public void setY(Camera camera){}
}
