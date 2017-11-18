package View;

import java.awt.Container;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JFrame;

import Model.actInfo;

/**
 * 
 * @author wwj
 * @category 图形界面框架
 *
 */
public class mainFrame extends JFrame{

	private studentWindow sw;

	private photoWall pw;
	
	public mainFrame(studentWindow sw,photoWall pw){
		super("社团招新");
		this.sw = sw;
		this.pw = pw;
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		//sw.initTeamPanel();
		//sw.initActPanel();
		this.getContentPane().add(pw);
		//this.getContentPane().add(sw);
		this.setResizable(false);
		this.setVisible(true);

	}
	
	/*public mainFrame(studentWindow sw){
		super("社团招新");
		this.sw = sw;
		//this.pw = pw;
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		sw.initTeamPanel();
		sw.initActPanel();
		//this.getContentPane().add(pw);
		this.getContentPane().add(sw);
		this.setResizable(false);
		this.setVisible(true);

	}*/

	public studentWindow getSW() {
		return sw;
	}

	public void setSW(studentWindow sw) {
		this.sw = sw;
	}

	public photoWall getPW() {
		return pw;
	}

	public void setPW(photoWall pw) {
		this.pw = pw;
	}
}
