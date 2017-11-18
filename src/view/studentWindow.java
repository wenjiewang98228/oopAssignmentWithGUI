package View;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Timer;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controller.test;
import Model.actInfo;
import Model.teamInfo;

/**
 * 
 * @author wwj
 * @category 主界面
 *
 */
public class studentWindow extends JPanel{
	
	private JPanel teamPanel = new JPanel(); 
	private JPanel actPanel = new JPanel();
	private JPanel infoPanel = new JPanel();

    private JList<String> teamList = new JList<String>();
    private JList<String> actList = new JList<String>();
//  private JTextArea infoArea = new JTextArea();

    Vector<String> mStringVector = new Vector<String>(); 

    List<teamInfo> mTeamInfos;
    List<actInfo> acts;
	private mainFrame mf;

    public studentWindow(List<teamInfo> teams, List<actInfo> acts, String s) {
        this.mTeamInfos = teams;
        this.acts = acts;

        this.initTeamPanel();
        this.initActPanel();
    }

    /**
     * 
     * @see 初始化teamPanel
     */
    //将teamPanel添加到studentWindow这个JPanel上
    public void initTeamPanel() {
        //setBounds(0,0,200,400);
        setLeft(mTeamInfos, acts);//
        teamPanel.setBounds(0, 0, 200, 600);
        teamPanel.setFont(new Font("宋体",Font.BOLD,25));
        teamList.setVisible(true);
        teamPanel.setVisible(true);
        add(teamPanel); // add teamPanel to this panel
    }

    /**
     * 
     * @param teams
     * @param acts
     */
    //将JList添加到JPanel上
    private void setLeft(List<teamInfo> teams, List<actInfo> acts) {
        for (int i = 0; i < teams.size(); i++) {
            mStringVector.add(teams.get(i).getName()); 
        }
        teamList = new JList<>(mStringVector); 

        teamPanel.add(teamList); 

    }
    
    /**
     * 
     * @see 初始化actPanel
     */
  //将actPanel添加到studentWindow这个JPanel上
    public void initActPanel() {
        //setBounds(250,0,250,600);
        setRight(mTeamInfos, acts);
        actPanel.setBounds(200,0, 200, 600);
        actPanel.setFont(new Font("宋体",Font.BOLD,25));
        actList.setVisible(true);
        actPanel.setVisible(true);
        add(actPanel); 
    }

    /**
     * 
     * @param teams
     * @param acts
     */
    
  //将JList添加到JPanel上
    public void setRight(List<teamInfo> teams, List<actInfo> acts) {
    	for (int i = 0; i < acts.size(); i++) {
            mStringVector.add(acts.get(i).getName()); 
        }
        actList = new JList<>(mStringVector); 

        actPanel.add(actList); 
    }
    
    /*public void initInfoPanel() {
        //setBounds(500,0,200,400);
        
        infoPanel.setBounds(400,0, 200, 600);
        infoPanel.setFont(new Font("宋体",Font.BOLD,25));
        infoPanel.setVisible(true);
        add(infoPanel); // add teamPanel to this panel
    }

    public void setInfo() {
    	JTextArea infoArea = new JTextArea(test.s);
    	infoArea.setLineWrap(true);
        infoPanel.add(infoArea); 
    }*/
    
    public void setMainFrame(mainFrame mf) {
		this.mf = mf;
	}
}
