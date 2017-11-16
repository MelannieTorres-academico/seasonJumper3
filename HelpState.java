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

public class HelpState implements GameState {
	  GameContext c;
		Font font;
		Font font2;
		Font font3;


    public HelpState(){}

		public HelpState(GameContext c){
			this.c = c;
		}

		public void draw(Graphics g){

				font  = new Font("arial", 1, 50);
				font2 = new Font("arial", 1, 30);
				font3 = new Font("arial", 1, 20);
				g.setColor(Color.white);

				g.setFont(font);
				g.drawString("HELP", 240, 70);


				g.setFont(font3);
				g.drawString("Use the arrows keys to get to the yellow,", 100, 200);
				g.drawString("beware of the monsters along the way!", 100, 225);

				g.setFont(font2);
				g.drawRect(210, 350, 200, 64);
				g.drawString("Back", 270, 390);

		}

		  public void processKey(KeyEvent e){}
		  public void clickMouse(MouseEvent e) {
				int mx = e.getX();
				int my = e.getY();
				if(mouseOver(mx, my, 210, 350, 200, 64)){ menu(); }
			}


      public void menu(){c.setState(c.getMenuState());}
      public void help(){}
      public void load(){}
      public void winter(){}
      public void spring(){}
      public void summer(){}
      public void autumn(){}
      public void lose(){}
      public void win(){}
      public void end(){}
      public void setContext(GameContext cont){ this.c = cont;}

			private boolean mouseOver(int mx, int my,int x, int y, int width, int heigth){
				if (mx > x && mx < x + width){
						return (my >  y  && my < y + heigth);
				}else{
						return false;
				}
			}


}
