package core;

import resources.ImageStore;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import objects.ThrowableObject;
import resources.Controller;


public class GameCanvas extends Canvas implements Runnable {
	
	private static final int WINDOW_WIDTH = 800;
	private static final int WINDOW_HEIGHT = 640;
	private boolean running;
	private Controller controller;
	// Font och deltafactor som sl��ar ner spelet p�� slutet
//	private Font messageFont;
//	private double deltaFactor = 1.0;
	
	ThrowableObject throwobj = new ThrowableObject();

	public GameCanvas() {
		setMinimumSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		setPreferredSize(getMinimumSize());
		setMaximumSize(getMinimumSize());
		
		controller = new Controller();
		addKeyListener(controller);
		addMouseListener(controller);
		addMouseMotionListener(controller);

	}

	public void start() {
		if (!running) {
			Thread t = new Thread(this);
			createBufferStrategy(3);
			running = true;
			t.start();
		}
	}

	public static void main(String[] args) {
		// TEMP
		JFrame window = new JFrame("Madness");
		GameCanvas game = new GameCanvas();
		window.add(game);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		game.start();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void run() {
		long last = System.currentTimeMillis();
		while (running) {
			long now = System.currentTimeMillis();
			long delta = now - last;
			update(delta);
			render();

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			last = now;
		}
	}

	private void render() {
		BufferStrategy strategy = getBufferStrategy();
		Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
		g.clearRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		
		ImageStore.BACKGROUND.draw(g, 0, 0, 0, 0, 0);
		throwobj.render(g);
		
		strategy.show();
	}

	private void update(float delta) {
		throwobj.update(delta);
	}

}