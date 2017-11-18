package View;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;


/**
 * 
 * @author wwj
 * @category 照片墙
 *
 */
public class photoWall extends JPanel{

	private static final int INFO_H = 600;
	private static final int INFO_W = 800;
	private static final String IMAGE_DIR = "img/";
	private ArrayList<ImageIcon> images;
	private static int index = 0;
	private mainFrame mf;
	private Timer timer;
	private studentWindow sw;

	public photoWall() {
		// TODO Auto-generated constructor stub
		super();
		
		//随机选图片构成图片地址的数组，然后循环放映
		images = randImageIcons();
		this.addMouseListener(new myclickListener());
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				photoWall.this.repaint();
				index++;
				if (index >= images.size()) {
					index = 0;
				}
			}
		}, 1000, 1000);
	}

	/**
	 * @param Graphics g
	 * @see repaint
	 */
	public void paint(Graphics g) {
		super.paintComponent(g);
		g.drawImage(images.get(index).getImage(), 0, 0, INFO_W, INFO_H,
				images.get(index).getImageObserver());
	}

	/**
	 * @see 随机选择图片
	 * @return ArrayList<ImageIcon>
	 */
	private ArrayList<ImageIcon> randImageIcons() {
		Random rand = new Random();
		int randNum = 0;
		ArrayList<ImageIcon> selected_pictures = new ArrayList<>();

		List<String> dir_names = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			for(int j = 0; j < 2; j++) {
				randNum = rand.nextInt(10) + 1;
			dir_names.add(IMAGE_DIR + "/" + i + "/" + randNum + ".jpg");
			}
			
		}

		Collections.sort(dir_names, Collator.getInstance(java.util.Locale.CHINA));
		for (String dir_name : dir_names) {
			selected_pictures.add(new ImageIcon(dir_name));
		}
		return selected_pictures;
	}
	
	public void setMainFrame(mainFrame mf) {
		this.mf = mf;
	}
	
	/**
	 * 
	 * @author wwj
	 * @see 鼠标响应
	 *
	 */
	private class myclickListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			//System.out.println("1");
			mf.getContentPane().removeAll();
			mf.getContentPane().add(mf.getSW());
			mf.setVisible(true);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

}
