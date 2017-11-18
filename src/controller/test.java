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
	 * ���ڲ��Ը����ֹ��ܵ�test��
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		List<personInfo> persons = readInPersonList();
		
		List<actInfo> acts = readInActList();
		
	    List<teamInfo> teams = readInTeamList();
	    	    
	    //������Ƭ�ֲ�
	    printPhoto(teams);
	    //������������б�
	    printTeamNameList(teams);
	    System.out.println("");
	    
	    //���Դ�ӡ��б�
	    printActNameList(acts);
	    System.out.println("");
	    
	    //����������ϸ��Ϣ
	    System.out.println("���������");
	    printTeamInfo(teams,persons,"��ѧ��",s);
	    System.out.println("���������");
	    printTeamInfo(teams,persons,"������",s);
	    
	    //�������ϸ��Ϣ
	    System.out.println("���������");
	    printActInfo(acts,"��������",s);
	    System.out.println("���������");
	    printActInfo(acts,"��ͷ�������",s);
	    
	    //����ĳʱ��֮ǰ�Ļ
	    System.out.println("2016.1.1ǰ�Ļ�У�");
	    searchBeforeTime(acts,"2016.1.1",s);
	    
	    //����ĳʱ��֮��Ļ
	    System.out.println("2016.5.1��Ļ�У�");
	    searchAfterTime(acts,"2016.5.1",s);
	    
	    //��������ɸѡ�
	    System.out.println("�������������Ļ�У�");
	    searchActByTeam(acts,"������",s);
	    System.out.println("\n");
	    System.out.println("����Э���������Ļ�У�");
	    searchActByTeam(acts,"����Э��",s);
	    System.out.println("\n");
	    
	    //���ݿ�չ����������Ž�������
	    sortByTimes(teams,s);
	    System.out.println("\n");
	    
	    //���ݻ��ģ�������������Ž�������
	    sortByPersons(teams,s);
	    System.out.println("\n");
	    
	    //��Ϣ���ܣ��༭��,�ļ��޸�֮�󱣴�Ϊtxt��ʽ���ѷ����ļ�����
	    editInfo(acts, "����ѧ","��ʦ������Linda",s);
	    editInfo(acts,"��ͷ�������","���ݶӣ�У������ݶ�",s);
	    
	    //ͼ�ν��棬���������Ƭ�ֲ��͵���ͼƬ����������б��Լ���б���һ�ֽ���
	    studentWindow sw = new studentWindow(teams, acts,s);
	    photoWall pw = new photoWall();
		mainFrame mf = new mainFrame(sw,pw);
		
		pw.setMainFrame(mf);
		sw.setMainFrame(mf);
	}
	
	public static List<personInfo> readInPersonList() {
		List<personInfo> persons = new ArrayList<personInfo>();
		
		/*�������ݣ�������洢*/
		/*�û���Ķ��룬����¼�����洢�����������Ը�ֵ*/
		List<String> personList = fileOperation.importCsv(new File("�û���.csv"));
		for(int i = 2; i < personList.size(); i++) {
			persons.add(new personInfo(personList.get(i)));
		}
		
		return persons;
			
	}
	
	public static List<teamInfo> readInTeamList() {
	    List<teamInfo> teams = new ArrayList<teamInfo>();
		
		/*�������ݣ�������洢*/
		/*���ű�Ķ��룬����¼�����洢�����������Ը�ֵ*/
		List<String> teamList = fileOperation.importCsv(new File("���ű�.csv"));
		for(int i = 2; i < teamList.size(); i++) {
			teams.add(new teamInfo(teamList.get(i)));
		}
			
		return teams;
	}
	
	public static List<actInfo> readInActList() {
		List<actInfo> acts = new ArrayList<actInfo>();
		
		/*�������ݣ�������洢*/
		/*���Ķ��룬����¼�����洢�����������Ը�ֵ*/
		List<String> actList = fileOperation.importCsv(new File("���.csv"));
		for(int i = 0; i < actList.size(); i++) {
			acts.add(new actInfo(actList.get(i)));
		}
			
		return acts;
	}
	
	/*��Ƭ�ֲ�*/
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
        				System.out.print("��Ƭ" + photos[k] + "  ");
        			}
        			System.out.println("");
        		}
        	}
        }
        System.out.println("");
	}
	
	/*��ʾ�����б�*/
	public static void printTeamNameList(List<teamInfo> teams) {
		System.out.println("�����б����£�");
		for(int i = 0; i < teams.size(); i++) {
			System.out.print(teams.get(i).getName() + "  ");
		}
		System.out.println("");
	}
	
	/*��ʾ��б�*/
	public static void printActNameList(List<actInfo> acts) {
		System.out.println("��б����£�");
		for(int i = 0; i < acts.size(); i++) {
			System.out.print(acts.get(i).getName() + "  ");
		}
		System.out.println("");
	}
	
	/*����������ϸ��Ϣ������������Ϣ����������Ϣ�Լ��ٰ���Ļ�б�*/
	public static void printTeamInfo(List<teamInfo> teams,List<personInfo> persons,String key,String s) {
		for(int i = 0; i < teams.size(); i++) {
			if(teams.get(i).getName().equals(key)) {
				System.out.println(teams.get(i).output());
				s += teams.get(i).output() + "\n";
				System.out.println("��������Ϣ���£�");
				for(int j = 0; j < persons.size(); j++) {
					if(persons.get(j).getName().equals(teams.get(i).getPerson())) {
						System.out.println(persons.get(j).output());
						s += persons.get(j).output() + "\n";
						break;
					}
				}
				System.out.println("��ػ�б�");
				for(String t : teams.get(i).getActList()) {
					s += teams.get(i).getActList() + "\n";
					System.out.print(t + "  ");
				}
			}
		}
	}
	
	/*�������ϸ��Ϣ*/
	public static void printActInfo(List<actInfo> acts,String key,String s) {
		for(int i = 0; i < acts.size(); i++) {
			if(acts.get(i).getName().equals(key)) {
				s += acts.get(i).output()+"\n";
				System.out.println(acts.get(i).output());
			}
		}
	}
	
	/*����ʱ����������֮ǰ*/
	public static void searchBeforeTime(List<actInfo> acts,String key,String s) {
		for(int i = 0; i < acts.size(); i++) {
			if(acts.get(i).getTime().compareTo(key) == -1) {
				s += acts.get(i).output() + "\n";
				System.out.println(acts.get(i).output());
			}
		}
	}
	
	/*����ʱ����������֮��ǰ*/
	public static void searchAfterTime(List<actInfo> acts,String key,String s) {
		for(int i = 0; i < acts.size(); i++) {
			if(acts.get(i).getTime().compareTo(key) == 1) {
				s += acts.get(i).output()+"\n";
				System.out.println(acts.get(i).output());
			}
		}
	}
	
	/*��������ɸѡ�*/
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
	
	/*���ݿ�չ����������Ž�������*/
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
		System.out.println("�����������б�Ϊ��");
		for(i = 0; i < t.length; i++) {
			System.out.print(t[i] + "  ");
			s += t[i] + "  ";
		}
		s += "\n";
	}
	
	/*���ݻ��ģ����������������*/
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
		System.out.println("�����������б�Ϊ��");
		for(i = 0; i < t.length; i++) {
			System.out.print(t[i] + "  ");
			s += t[i] + "  ";
		}
		s += "\n";
		
	}
	
	/*��Ϣ����*/
	public static void editInfo(List<actInfo> acts,String actName,String addInfo,String s) {
		for(int i = 0; i < acts.size(); i++) {
			if(acts.get(i).getName().equals(actName)) {
				acts.get(i).setIntro(addInfo);
				System.out.println(acts.get(i).output() + "\n");
				s += acts.get(i).output() + "\n";
			}
		}
		File  f = new File("���.csv");
		List<String> t = new ArrayList<String>();
		for(int i = 0; i < acts.size(); i++) {
			t.add(acts.get(i).writeOut());
		}
		fileOperation.exportCsv(f, t);
		s += "\n";
	}
}
