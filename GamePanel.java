
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class GamePanel extends JPanel implements Runnable {

	public static final int PWIDTH = 640;
	public static final int PHEIGHT = PWIDTH/ 12 * 9; //tamaño del panel

	private Thread animator; //controla la animación
	private volatile boolean end = false;
	private String s;
	private GameContext game;
	private Camera camera;


	public GamePanel(){
		setBackground(Color.black);
		setPreferredSize(new Dimension(PWIDTH,PHEIGHT));
		/*setMaximumSize( new Dimension(width, height));
		setMinimumSize( new Dimension(width, height));*/
		setFocusable(true);
		requestFocus();
		readyForTermination();

		game = new GameContext();
		camera = new Camera(0,0, PWIDTH, PHEIGHT);

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

	/*public void run(){
		while(end==false){
			gameUpdate();
			gameRender();
			paintScreen();

			try{
				Thread.sleep(125);
			}
			catch(InterruptedException ex){}
		}
		System.exit(0);
	}
*/
	//Taked from somebody esle, notch code, DONT touch
public  void run(){
	 this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;

		while(end==false){

			 long now = System.nanoTime();
				delta += (now - lastTime) / ns;
				lastTime = now;

				while(delta >= 1){
				/*	for(int i = 0; i < handler.object.size(); i++){
							if(handler.object.get(i).getID() == ID.Player){
									camera.tick(handler.object.get(i));
							}
					}*/
					game.tick(camera);
					delta--;
				}

					gameUpdate();
					gameRender();
					paintScreen();
					frames++;


				if(System.currentTimeMillis() - timer > 1000){
						timer += 1000;
					 System.out.println("FPS: "+ frames);
						frames = 0;
				}
		}
	//	stop();
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
      dbg.setColor(Color.black);
      dbg.fillRect(0,0,PWIDTH,PHEIGHT);
      //game.draw(dbg);


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
		dbg.setColor(Color.black);
		dbg.fillRect(0,0,PWIDTH,PHEIGHT);
		Graphics2D g2d = (Graphics2D) dbg;
		g2d.translate(-camera.getX(), -camera.getY());

		game.draw(dbg);

		g2d.translate(camera.getX(), camera.getY());

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

			public void keyReleased(KeyEvent e){
				int keyCode = e.getKeyCode();
				game.keyReleased(e);
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
		 app.setLocationRelativeTo(null);
     app.pack();
     app.setResizable(false);
     app.setVisible(true);
	}
}
