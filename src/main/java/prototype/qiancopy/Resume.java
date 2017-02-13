package prototype.qiancopy;

//写一份简历，必须有姓名，可以设置性别、姓名以及工作经历，然后最终写三份简历
//引出原型模式
public class Resume implements Cloneable{

	private String name;
	private String sex;
	private String age;
	private String timeArea;
	private String company;
	
	public Resume(String name) {
		super();
		this.name = name;
	}
	
	//设置个人信息
	public void setPersonInfo(String sex,String age){
		this.sex = sex;
		this.age = age;
	}
	
	//设置工作经历
	public void setWork(String timeArea,String company){
		this.timeArea = timeArea;
		this.company = company;
	}
	
	public void disPlay(){
		System.out.println(name +" "+ sex +" "+ age);
		System.out.println("工作经历："+timeArea + " "+company);
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public static void main(String[] args) throws Exception {
		//这样写不好，因为简历都是相同的，万一某一个属性写错了，假如写很多份呢，修改
		Resume r1 = new Resume("小菜");
		r1.setPersonInfo("男", "18");
		r1.setWork("2014-2017", "XXX公司");
		
		/*Resume r2 = new Resume("小菜");
		r2.setPersonInfo("男", "18");
		r2.setWork("2014-2017", "XXX公司");
		
		Resume r3 = new Resume("小菜");
		r3.setPersonInfo("男", "18");
		r3.setWork("2014-2017", "XXX公司");*/
		
		//对以上代码改进，克隆Clone代码
		Resume r2 = (Resume) r1.clone();
		Resume r3 = (Resume) r1.clone();
		
		r1.disPlay();
		r2.disPlay();
		r3.disPlay();
	}
}
