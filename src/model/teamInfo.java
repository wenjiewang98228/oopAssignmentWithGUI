package Model;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author wwj
 * @category ������
 *
 */
public class teamInfo {

	private String name;//������
	private String time;//����ʱ��
	private String person;//������
	private String tel;//�绰����
	private String email;//����
	private String intro;//���
	private String[] photo = new String[10];//��Ƭ
	private String[] personList;//���ų�Ա�������
	private ArrayList<String> actList = new ArrayList<String>();//���Ż�����ܶ����
	
	public teamInfo(String name,String time,String person,String tel,String email,
					String intro,String photo[],String[] personList,
					ArrayList<String> actList){
		setName(name);
		setTime(time);
		setPerson(person);
		setTel(tel);
		setEmail(email);
		setIntro(intro);
		setPhoto(photo);
		setPersonList(personList);
		setActList(actList);
	}
	
	//���췽������д
	public teamInfo(String in) {
		
		String[] data = in.split(",");
		
		this.name = data[0];
		this.time = data[1];
		
		//��������personInfo����أ���Ҫ���ⷽ��,data[2]
		this.person = data[2];
		
		this.tel = data[3];
		this.email = data[4];
		//���ų�Ա��һ���ַ�������
		//���������ų�Ա���ڵĽس�������洢����
		String s = data[5];
		//������ֿ��洢��personList���Ӧ��λ��
		personList = s.split("��");
		
		//���������ų�Ա���ڵĽس�������洢����
		String[] aNames = data[6].split("��");
		//������ֿ��洢��personList���Ӧ��λ��
		for(String a : aNames) {
			actList.add(a);
			}
				
		this.intro = data[7];
		
	}
	
	/*getters*/
	public String getName() {
		return name;
	}
	
	public String getTime() {
		return time;
	}
	
	public String getPerson() {
		return person;
	}
	
	public String getTel() {
		return tel;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getIntro() {
		return intro;
	}
	
	public String[] getPhoto(){
		return photo;
	}
	
	public String[] getPersonList(){
		return personList;
	}
	
	public ArrayList<String> getActList(){
		return actList;
	}
	
	/*setters*/
	public void setName(String aName) {
		this.name = aName;
	}
	
	public void setTime(String aTime) {
		this.time = aTime;
	}
	
	public void setPerson(String aPerson) {
		this.person = aPerson;
	}
	
	public void setTel(String aTel) {
		this.tel = aTel;
	}
	
	public void setEmail(String aEmail) {
		this.email = aEmail;
	}
	
	public void setIntro(String aIntro) {
		this.intro = aIntro;
	}
	
	public void setPhoto(String[] photo) {
		this.photo = photo;
	}
	
	public void  setPersonList(String[] personList) {
		this.personList = personList;
	}
	
	public void setActList(ArrayList<String> actList) {
		this.actList = actList;
	}
	
	/*����*/
	/**
	 * 
	 * @return String
	 */
	/*�����ʽ*/
	public String output() {
		String output = "������" + name + "\n" + "����ʱ�䣺" + time + "\n" + "�����ˣ�" + person + "\n" 
						+ "�ֻ����룺" + tel + "\n" + "���䣺" + email + "\n" + "��Ա�б�";
		
		for(int i = 0; i < personList.length-1; i++) {
			output += personList[i] + "��";
		}
		output += personList[personList.length-1] + "\n" + "��б�";
		
		for(int i = 0; i < actList.size()-1; i++) {
			output += actList.get(i) + "��";
		}
		output += actList.get(actList.size()-1) + "\n";
		
		output += "��飺" + intro + "\n";
		
		return output;
	}

	/**
	 * 
	 * @return String 
	 */
	/*���ѡ��������Ƭ*/
	public String choosePhoto() {
		int i,j;
		
		i = new Random().nextInt(10) +1;
		j = new Random().nextInt(10) +1;
		
		String s = i + "/" + j;
		
		return s;
	}
}
