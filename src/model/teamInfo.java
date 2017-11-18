package Model;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author wwj
 * @category 社团类
 *
 */
public class teamInfo {

	private String name;//社团名
	private String time;//成立时间
	private String person;//负责人
	private String tel;//电话号码
	private String email;//邮箱
	private String intro;//简介
	private String[] photo = new String[10];//照片
	private String[] personList;//社团成员（多个）
	private ArrayList<String> actList = new ArrayList<String>();//社团活动（可能多个）
	
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
	
	//构造方法的重写
	public teamInfo(String in) {
		
		String[] data = in.split(",");
		
		this.name = data[0];
		this.time = data[1];
		
		//负责人与personInfo类相关，需要特殊方法,data[2]
		this.person = data[2];
		
		this.tel = data[3];
		this.email = data[4];
		//社团成员是一个字符串数组
		//将所有社团成员所在的截出的数组存储起来
		String s = data[5];
		//将数组分开存储到personList相对应的位置
		personList = s.split("、");
		
		//将所有社团成员所在的截出的数组存储起来
		String[] aNames = data[6].split("、");
		//将数组分开存储到personList相对应的位置
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
	
	/*方法*/
	/**
	 * 
	 * @return String
	 */
	/*输出格式*/
	public String output() {
		String output = "姓名：" + name + "\n" + "成立时间：" + time + "\n" + "负责人：" + person + "\n" 
						+ "手机号码：" + tel + "\n" + "邮箱：" + email + "\n" + "成员列表：";
		
		for(int i = 0; i < personList.length-1; i++) {
			output += personList[i] + "、";
		}
		output += personList[personList.length-1] + "\n" + "活动列表：";
		
		for(int i = 0; i < actList.size()-1; i++) {
			output += actList.get(i) + "、";
		}
		output += actList.get(actList.size()-1) + "\n";
		
		output += "简介：" + intro + "\n";
		
		return output;
	}

	/**
	 * 
	 * @return String 
	 */
	/*随机选出两张照片*/
	public String choosePhoto() {
		int i,j;
		
		i = new Random().nextInt(10) +1;
		j = new Random().nextInt(10) +1;
		
		String s = i + "/" + j;
		
		return s;
	}
}
