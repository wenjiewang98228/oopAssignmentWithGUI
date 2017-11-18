package Model;

import java.util.ArrayList;

/**
 * 
 * @author wwj
 * @category ���
 *
 */
public class actInfo {

	private String name;//�����
	private String time;//�ʱ��
	private String location;//��ص�
	private ArrayList<String> host = new ArrayList<String>();//�������ţ����ܶ����
	private String intro = "";//���ע
	private String slogan;//��������
	
	public actInfo(String name,String time,String location,ArrayList<String> host,String slogan,
			String intro){
		setName(name);
		setTime(time);
		setLocation(location);
		setHost(host);
		setSlogan(slogan);
		this.intro = intro;

	}
	
	/*���췽������д*/
	public actInfo(String in) {
		String[] data = in.split(",");
		
		this.name = data[0];
		this.time = data[1];
		this.location = data[2];
		String[] tNames = data[3].split("��");
		for(String t : tNames) {
			host.add(t);
		}

		this.slogan = data[4];
		this.intro = data[5];
	}
	
	/*getters*/
	public String getName() {
		return name;
	}
	
	public String getTime() {
		return time;
	}
	
	public String getLocation() {
		return location;
	}
	
	public ArrayList<String> getHost() {
		return host;
	}
	
	public String getIntro() {
		return intro;
	}

	
	public String getSlogan() {
		return slogan;
	}
	
	/*setters*/
	public void setName(String aName) {
		this.name = aName;
	}
	
	public void setTime(String aTime) {
		this.time = aTime;
	}
	
	public void setLocation(String aLocation) {
		this.location = aLocation;
	}
	
	public void setHost(ArrayList<String> aHost) {
		this.host = aHost;
	}
	
	public void setIntro(String aIntro) {
		this.intro = aIntro;
	}

	public void setSlogan(String aSlogan) {
		this.slogan = aSlogan;
	}
	
	/*����*/
	/**
	 * 
	 * @return String
	 */
	/*�����ʽ*/
	public String output() {
		String output = "����ƣ�" + name + "\n" + "�ʱ�䣺"  + time + "\n" + "��ص㣺" 
						+ location + "\n" + "�������ţ�";
		
		for(int i = 0; i < host.size()-1; i++) {
			output += (host.get(i) + "��");
		}
		output += (host.get(host.size()-1) + "\n" + "�������");
		
		output = output + slogan + "\n" +  "��ע��" + intro + "\n" ;
		
		return output;
	}

	/**
	 * 
	 * @return String
	 */
	/*�޸��ļ���ʽ*/
	public String writeOut() {
		String writeOut = name + "," + time + "," + location + ",";
		
		for(int i = 0; i < host.size()-1; i++) {
			writeOut += (host.get(i) + "��");
		}
		
		writeOut += host.get(host.size()-1) + ",";
		
		writeOut += slogan + "," + intro + ",";
		
		return writeOut;
	}
}
