package Model;

/**
 * 
 * @author wwj
 * @category �û���
 *
 */
public class personInfo {

	private String name;//����
	private String department;//ѧԺ
	private String classrm;//�༶
	
	public personInfo(String name,String department,String classrm){
		setName(name);
		setDepartment(department);
		setClassrm(classrm);
	}
	
	//��д�Ĺ��췽��
	public personInfo(String in) {
		String[] data = in.split(",");
		
		this.name = data[0];
		this.department = data[1];
		this.classrm = data[2];
	}
	
	/*getters*/
	public String getName() {
		return name;
	}
	
	public String getDepartment( ) {
		return department;
	}
	
	public String getClassrm() {
		return classrm;
	}
	
	/*setters*/
	public void setName(String aName) {
		this.name = aName;
	}
	
	public void setDepartment(String aDepartment) {
		this.department = aDepartment;
	}
	
	public void setClassrm(String aClassrm) {
		this.classrm = aClassrm;
	}
	
	/**
	 * 
	 * @return String
	 */
	//ת��Ϊ�ַ����������
	public String output() {
		String s = "������" + name + "\n" + "Ժϵ��" + department + "\n" + "�༶��" + classrm + "\n";
		
		return s;
	}
}
