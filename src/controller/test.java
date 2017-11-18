package Controller;

import java.io.File;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JFrame;

import Model.actInfo;
import Model.fileOperation;
import Model.personInfo;
import Model.teamInfo;
import View.mainFrame;
import View.photoWall;
import View.studentWindow;

public class test {

	public static String s = "";
	
	/**
	 * 用于测试各部分功能的test类
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		List<personInfo> persons = readInPersonList();
		
		List<actInfo> acts = readInActList();
		
	    List<teamInfo> teams = readInTeamList();
	    	    
	    //测试照片轮播
	    printPhoto(teams);
	    //测试输出社团列表
	    printTeamNameList(teams);
	    System.out.println("");
	    
	    //测试打印活动列表
	    printActNameList(acts);
	    System.out.println("");
	    
	    //搜索社团详细信息
	    System.out.println("搜索结果：");
	    printTeamInfo(teams,persons,"文学社",s);
	    System.out.println("搜索结果：");
	    printTeamInfo(teams,persons,"动漫社",s);
	    
	    //搜索活动详细信息
	    System.out.println("搜索结果：");
	    printActInfo(acts,"星座书上",s);
	    System.out.println("搜索结果：");
	    printActInfo(acts,"街头篮球表演",s);
	    
	    //搜索某时间之前的活动
	    System.out.println("2016.1.1前的活动有：");
	    searchBeforeTime(acts,"2016.1.1",s);
	    
	    //搜索某时间之后的活动
	    System.out.println("2016.5.1后的活动有：");
	    searchAfterTime(acts,"2016.5.1",s);
	    
	    //根据社团筛选活动
	    System.out.println("街舞社参与主办的活动有：");
	    searchActByTeam(acts,"街舞社",s);
	    System.out.println("\n");
	    System.out.println("音乐协会参与主办的活动有：");
	    searchActByTeam(acts,"音乐协会",s);
	    System.out.println("\n");
	    
	    //根据开展活动次数对社团进行排序
	    sortByTimes(teams,s);
	    System.out.println("\n");
	    
	    //根据活动规模（人数）对社团进行排序
	    sortByPersons(teams,s);
	    System.out.println("\n");
	    
	    //信息汇总（编辑）,文件修改之后保存为txt格式，已放在文件夹中
	    editInfo(acts, "鬼步教学","教师：陈玉，Linda",s);
	    editInfo(acts,"街头篮球表演","表演队：校篮球表演队",s);
	    
	    //图形界面，仅完成了照片轮播和单击图片后输出社团列表以及活动列表这一种交互
	    studentWindow sw = new studentWindow(teams, acts,s);
	    photoWall pw = new photoWall();
		mainFrame mf = new mainFrame(sw,pw);
		
		pw.setMainFrame(mf);
		sw.setMainFrame(mf);
	}
	
	public static List<personInfo> readInPersonList() {
		List<personInfo> persons = new ArrayList<personInfo>();
		
		/*读入数据，并分类存储*/
		/*用户表的读入，将记录分条存储，并将各属性赋值*/
		List<String> personList = fileOperation.importCsv(new File("用户表.csv"));
		for(int i = 2; i < personList.size(); i++) {
			persons.add(new personInfo(personList.get(i)));
		}
		
		return persons;
			
	}
	
	public static List<teamInfo> readInTeamList() {
	    List<teamInfo> teams = new ArrayList<teamInfo>();
		
		/*读入数据，并分类存储*/
		/*社团表的读入，将记录分条存储，并将各属性赋值*/
		List<String> teamList = fileOperation.importCsv(new File("社团表.csv"));
		for(int i = 2; i < teamList.size(); i++) {
			teams.add(new teamInfo(teamList.get(i)));
		}
			
		return teams;
	}
	
	public static List<actInfo> readInActList() {
		List<actInfo> acts = new ArrayList<actInfo>();
		
		/*读入数据，并分类存储*/
		/*活动表的读入，将记录分条存储，并将各属性赋值*/
		List<String> actList = fileOperation.importCsv(new File("活动表.csv"));
		for(int i = 0; i < actList.size(); i++) {
			acts.add(new actInfo(actList.get(i)));
		}
			
		return acts;
	}
	
	/*照片轮播*/
	public static void printPhoto(List<teamInfo> teams) throws InterruptedException {
		String[] photoList;
		
		Comparator<Object> com=Collator.getInstance(java.util.Locale.CHINA);
		
		String[] names = new String[10];
		
		for(int i = 0; i < teams.size(); i++) {
			names[i] = teams.get(i).getName();
		}
		
		List<String> list = Arrays.asList(names);  
        Collections.sort(list, com); 
        
        for(int i = 0; i < list.size(); i++) {
        	System.out.println(list.get(i));
        	for(int j = 0; j < teams.size(); j++) {
        		if(teams.get(j).getName().equals(list.get(i))) {
        			String photo = teams.get(j).choosePhoto();
        			String[] photos = photo.split("/");
        			for(int k = 0; k < photos.length;k++) {
        				System.out.print("照片" + photos[k] + "  ");
        			}
        			System.out.println("");
        		}
        	}
        }
        System.out.println("");
	}
	
	/*显示社团列表*/
	public static void printTeamNameList(List<teamInfo> teams) {
		System.out.println("社团列表如下：");
		for(int i = 0; i < teams.size(); i++) {
			System.out.print(teams.get(i).getName() + "  ");
		}
		System.out.println("");
	}
	
	/*显示活动列表*/
	public static void printActNameList(List<actInfo> acts) {
		System.out.println("活动列表如下：");
		for(int i = 0; i < acts.size(); i++) {
			System.out.print(acts.get(i).getName() + "  ");
		}
		System.out.println("");
	}
	
	/*搜索社团详细信息，包括社团信息、负责人信息以及举办过的活动列表*/
	public static void printTeamInfo(List<teamInfo> teams,List<personInfo> persons,String key,String s) {
		for(int i = 0; i < teams.size(); i++) {
			if(teams.get(i).getName().equals(key)) {
				System.out.println(teams.get(i).output());
				s += teams.get(i).output() + "\n";
				System.out.println("负责人信息如下：");
				for(int j = 0; j < persons.size(); j++) {
					if(persons.get(j).getName().equals(teams.get(i).getPerson())) {
						System.out.println(persons.get(j).output());
						s += persons.get(j).output() + "\n";
						break;
					}
				}
				System.out.println("相关活动列表：");
				for(String t : teams.get(i).getActList()) {
					s += teams.get(i).getActList() + "\n";
					System.out.print(t + "  ");
				}
			}
		}
	}
	
	/*搜索活动详细信息*/
	public static void printActInfo(List<actInfo> acts,String key,String s) {
		for(int i = 0; i < acts.size(); i++) {
			if(acts.get(i).getName().equals(key)) {
				s += acts.get(i).output()+"\n";
				System.out.println(acts.get(i).output());
			}
		}
	}
	
	/*按照时间搜索——之前*/
	public static void searchBeforeTime(List<actInfo> acts,String key,String s) {
		for(int i = 0; i < acts.size(); i++) {
			if(acts.get(i).getTime().compareTo(key) == -1) {
				s += acts.get(i).output() + "\n";
				System.out.println(acts.get(i).output());
			}
		}
	}
	
	/*按照时间搜索——之后前*/
	public static void searchAfterTime(List<actInfo> acts,String key,String s) {
		for(int i = 0; i < acts.size(); i++) {
			if(acts.get(i).getTime().compareTo(key) == 1) {
				s += acts.get(i).output()+"\n";
				System.out.println(acts.get(i).output());
			}
		}
	}
	
	/*按照社团筛选活动*/
	public static void searchActByTeam(List<actInfo> acts,String key,String s) {
		for(int i = 0; i < acts.size(); i++) {
			for(int j = 0; j < acts.get(i).getHost().size(); j++)
			if(acts.get(i).getHost().get(j).equals(key)) {
				s += acts.get(i).getName() + "  ";
				System.out.print(acts.get(i).getName() + "  ");
			}
		}
		s += "\n";
	}
	
	/*根据开展活动次数对社团进行排序*/
	public static void sortByTimes(List<teamInfo> teams,String s) {
		String t[] = new String[10];
		int i,j;
		for(i = 0; i < teams.size(); i++) {
			t[i] = teams.get(i).getName();
		}
		String tmp = "";
		for(i = 1; i < teams.size(); i++) {
			tmp = t[i];
			for(j  = i; j>0 && (teams.get(j-1).getActList().size() <= teams.get(i).getActList().size());j--) {
				t[j] = t[j-1];
			}
			t[j] = tmp;
		}
		System.out.println("排序后的社团列表为：");
		for(i = 0; i < t.length; i++) {
			System.out.print(t[i] + "  ");
			s += t[i] + "  ";
		}
		s += "\n";
	}
	
	/*根据活动规模（人数）进行排序*/
	public static void sortByPersons(List<teamInfo> teams,String s) {
		String t[] = new String[10];
		int i,j;
		for(i = 0; i < teams.size(); i++) {
			t[i] = teams.get(i).getName();
		}
		String tmp = "";
		for(i = 1; i < teams.size(); i++) {
			tmp = t[i];
			for(j  = i; j>0 && (teams.get(j-1).getPersonList().length <= teams.get(i).getPersonList().length);j--) {
				t[j] = t[j-1];
			}
			t[j] = tmp;
		}
		System.out.println("排序后的社团列表为：");
		for(i = 0; i < t.length; i++) {
			System.out.print(t[i] + "  ");
			s += t[i] + "  ";
		}
		s += "\n";
		
	}
	
	/*信息汇总*/
	public static void editInfo(List<actInfo> acts,String actName,String addInfo,String s) {
		for(int i = 0; i < acts.size(); i++) {
			if(acts.get(i).getName().equals(actName)) {
				acts.get(i).setIntro(addInfo);
				System.out.println(acts.get(i).output() + "\n");
				s += acts.get(i).output() + "\n";
			}
		}
		File  f = new File("活动表.csv");
		List<String> t = new ArrayList<String>();
		for(int i = 0; i < acts.size(); i++) {
			t.add(acts.get(i).writeOut());
		}
		fileOperation.exportCsv(f, t);
		s += "\n";
	}
}
