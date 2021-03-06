
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class GamePanel extends JPanel implements Runnable {

	private static final int PWIDTH = 500;
	private static final int PHEIGHT = 400; //tamaño del panel

	private Thread animator; //controla la animación
	private volatile boolean end = false;
	private String s;
	private GameContext game;


	public GamePanel(){
		setBackground(Color.white);
		setPreferredSize(new Dimension(PWIDTH,PHEIGHT));
		setFocusable(true);
		requestFocus();
		readyForTermination();

		game = new GameContext();

		addMouseListener( new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				game.clickMouse(e);
			}
		});
	} //GamePanel()

	public void addNotify(){
		super.addNotify();
		startGame();
	}

	private void startGame(){
		if(animator == null ){
			animator = new Thread(this);
			animator.start();
		}
	}

	public void run(){
		while(end==false){
			gameUpdate();
			gameRender();
			paintScreen();

			try{
				Thread.sleep(20);
			}
			catch(InterruptedException ex){}
		}
		System.exit(0);
	}

	private void gameUpdate(){
        if(dbImage == null){
            dbImage = createImage(PWIDTH,PHEIGHT);
            if(dbImage == null){
                System.out.println("dbImage is null");
                return;
            }else{
                dbg = dbImage.getGraphics();
            }
        }
      dbg.setColor(Color.white);
      dbg.fillRect(0,0,PWIDTH,PHEIGHT);
      game.draw(dbg);


}

	private Graphics 	dbg;
	private Image 		dbImage = null;

	private void gameRender(){
		if(dbImage == null){
			dbImage = createImage(PWIDTH,PHEIGHT);
			if(dbImage == null){
				System.out.println("dbImage is null");
				return;
			}else{
				dbg = dbImage.getGraphics();
			}
		}
		dbg.setColor(Color.white);
		dbg.fillRect(0,0,PWIDTH,PHEIGHT);
		dbg.setColor(Color.black);

		game.draw(dbg);
	}

	private void gameOverMessage(){
		Graphics g;
		g=this.getGraphics();
		g.drawString("GameOver",10,10);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(dbImage != null)
			g.drawImage(dbImage, 0, 0, null);
	}

	private void readyForTermination() {

		addKeyListener( new KeyAdapter() { // listen for esc, q, end, ctrl-c
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				game.processKey(e);
				if ((keyCode == KeyEvent.VK_ESCAPE) || (keyCode == KeyEvent.VK_END) || ((keyCode == KeyEvent.VK_C) && e.isControlDown()) ) {
					end = true;
				}
			}
		});
	}

	private void paintScreen(){
		Graphics g;
		try{
			g = this.getGraphics();
			if((g != null) && (dbImage != null))
				g.drawImage(dbImage,0,0,null);
			Toolkit.getDefaultToolkit().sync();
			g.dispose();

		}
		catch(Exception e){
			System.out.println("Graphics context error: "+e);
		}
	}

	public static void main(String args[]){
	 JFrame app = new JFrame("Season Jumper");
     app.getContentPane().add(new GamePanel(), BorderLayout.CENTER);
     app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     app.pack();
     app.setResizable(false);
     app.setVisible(true);
	}
}
