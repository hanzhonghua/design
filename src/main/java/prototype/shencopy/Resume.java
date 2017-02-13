package prototype.shencopy;

//Java提供的clone复制是浅复制，只复制引用，引用的对象不复制
//我们把工作经历抽取为一个类
public class Resume implements Cloneable{

	private String name;
	private String sex;
	private String age;
	private WorkExper work;
	
	public Resume(String name) {
		this.name = name;
		work = new WorkExper();
	}
	
	//设置个人信息
	public void setPersonInfo(String sex,String age){
		this.sex = sex;
		this.age = age;
	}
	
	//设置工作经历
	public void setWork(String timeArea,String company){
		work.setTimeArea(timeArea);
		work.setCompany(company);
	}
	
	public void disPlay(){
		System.out.println(name +" "+ sex +" "+ age);
		System.out.println("工作经历："+work.getTimeArea() + " "+work.getCompany());
	}
	
	@Override
	protected Resume clone() throws CloneNotSupportedException {
		Object o = null;
		o = super.clone();
		((Resume)o).work = this.work.clone();
		return (Resume)o;
		
	}
	public static void main(String[] args) throws Exception {
		//测试时候设置三个不同的工作经历，结果查看结果三个经历都跟最后一个一样
		//clone对应引用类型，只是复制了引用，对引用的对象还是指向了原有对象
		//如何实现深复制呢，让工作经历类也实现Cloneable接口并实现clone方法
		Resume r1 = new Resume("小菜");
		r1.setPersonInfo("男", "18");
		r1.setWork("2014-2017", "XXX公司");
		
		//对以上代码改进，克隆Clone代码
		Resume r2 = (Resume) r1.clone();
		r2.setWork("2015-2017", "某互联网公司");
		
		Resume r3 = (Resume) r1.clone();
		r3.setWork("2016-2017", "某传统公司");
		r1.disPlay();
		r2.disPlay();
		r3.disPlay();
		
	}
}
