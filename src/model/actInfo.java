package Model;

import java.util.ArrayList;

/**
 * 
 * @author wwj
 * @category 活动类
 *
 */
public class actInfo {

	private String name;//活动名称
	private String time;//活动时间
	private String location;//活动地点
	private ArrayList<String> host = new ArrayList<String>();//主办社团（可能多个）
	private String intro = "";//活动备注
	private String slogan;//宣传标语
	
	public actInfo(String name,String time,String location,ArrayList<String> host,String slogan,
			String intro){
		setName(name);
		setTime(time);
		setLocation(location);
		setHost(host);
		setSlogan(slogan);
		this.intro = intro;

	}
	
	/*构造方法的重写*/
	public actInfo(String in) {
		String[] data = in.split(",");
		
		this.name = data[0];
		this.time = data[1];
		this.location = data[2];
		String[] tNames = data[3].split("、");
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
	
	/*方法*/
	/**
	 * 
	 * @return String
	 */
	/*输出格式*/
	public String output() {
		String output = "活动名称：" + name + "\n" + "活动时间："  + time + "\n" + "活动地点：" 
						+ location + "\n" + "主办社团：";
		
		for(int i = 0; i < host.size()-1; i++) {
			output += (host.get(i) + "、");
		}
		output += (host.get(host.size()-1) + "\n" + "宣传标语：");
		
		output = output + slogan + "\n" +  "备注：" + intro + "\n" ;
		
		return output;
	}

	/**
	 * 
	 * @return String
	 */
	/*修改文件格式*/
	public String writeOut() {
		String writeOut = name + "," + time + "," + location + ",";
		
		for(int i = 0; i < host.size()-1; i++) {
			writeOut += (host.get(i) + "、");
		}
		
		writeOut += host.get(host.size()-1) + ",";
		
		writeOut += slogan + "," + intro + ",";
		
		return writeOut;
	}
}
