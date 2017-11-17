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

public class WinState implements GameState {
    private int i=0;
    private int player;
	  GameContext c;
    private Color color;
    private Font font;

    public WinState(){
    }
		public WinState(GameContext c){
			this.c = c;
		}

  		public void draw(Graphics g){
  			i++;
        color=new Color(122, 24, 232);
        font=new Font("Verdana", Font.BOLD, 18);
        g.setColor(color);
        g.setFont(font);
        //g.drawImage(ImageLoader.getImageLoader().getBackground(),0,0,null);
        //g.drawImage(ImageLoader.getImageLoader().getFireworks(),0,0,null);
  		  g.drawString("Ganaste",300, 20);
  			if (i>200){
  				end();
  			}
  		}

      public void processKey(KeyEvent e){}
      public void clickMouse(MouseEvent e) {}
      public void keyReleased(KeyEvent e){}
      public void menu(){}
      public void help(){}
      public void load(){}
      public void winter(){}
    	public void spring(){}
    	public void summer(){}
    	public void autumn(){}
      public void lose(){}
      public void win(){}
      public void end(){c.setState(c.getEndState());}
      public void setContext(GameContext cont){ this.c = cont;}
      public void setHandler(Handler h){}

}
