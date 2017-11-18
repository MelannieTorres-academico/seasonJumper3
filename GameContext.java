/*
 * GameContext.java
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

public class GameContext {

	GameState menu;
	GameState help;
	GameState load;
	GameState winter;
	GameState spring;
	GameState summer;
	GameState autumn;
  GameState lose;
  GameState win;
	GameState end;
	GameState currentState;
	Handler 	handler;
	Player		player;



	public GameContext(){

		menu	  			= Factory.getInstance().createState("menu");
		help	  			= Factory.getInstance().createState("help");
		load  				= Factory.getInstance().createState("load");
		winter			  = Factory.getInstance().createState("winter");
		spring			  = Factory.getInstance().createState("spring");
		summer			  = Factory.getInstance().createState("summer");
		autumn			  = Factory.getInstance().createState("autumn");
    lose 					= Factory.getInstance().createState("lose");
    win 					= Factory.getInstance().createState("win");
		end 					= Factory.getInstance().createState("end");
		handler				= Factory.getInstance().createHandler();

		menu.setContext(this);
		help.setContext(this);
		load.setContext(this);
		winter.setContext(this);
		spring.setContext(this);
		summer.setContext(this);
		autumn.setContext(this);
    lose.setContext(this);
    win.setContext(this);
		end.setContext(this);



		player = new Player(150, 150, ID.Player);

		winter.setPlayer(player);
		spring.setPlayer(player);
		summer.setPlayer(player);
		autumn.setPlayer(player);

		currentState  = menu;

	}

	public GameState getMenuState(){return menu;}
	public GameState getHelpState(){return help;}
  public GameState getLoadState(){return load;}
	public GameState getWinterState(){return winter;}
	public GameState getSpringState(){return spring;}
	public GameState getSummerState(){return summer;}
	public GameState getAutumnState(){return autumn;}
  public GameState getLoseState(){return lose;}
  public GameState getWinState(){return win;}
  public GameState getEndState(){return end;}

	public void setState(GameState s){ this.currentState = s; }
	public void setContext(GameContext cont){}
	public void setPlayer(Player p){}//this.context = cont;}


	public void processKey(KeyEvent e){	currentState.processKey(e);	}
	public void keyReleased(KeyEvent e){currentState.keyReleased(e);}
	public void clickMouse(MouseEvent e) {	currentState.clickMouse(e); }
	public void draw(Graphics g){	currentState.draw(g);}

	public void menu(){currentState.menu(); }
	public void help(){currentState.help(); }
  public void load(){currentState.load(); }
	public void winter(){currentState.winter(); }
	public void spring(){currentState.spring(); }
	public void summer(){currentState.summer(); }
	public void autumn(){currentState.autumn(); }
  public void lose(){currentState.lose(); }
  public void win(){currentState.win(); }
  public void end(){currentState.end(); }


	public void tick(Camera camera){currentState.tick(camera);}
}
