package prototype.shencopy;

import java.util.ArrayList;
import java.util.List;

public class WorkExper implements Cloneable{

	private String timeArea;
	private String company;
	
	//设置工作经历
	public void setWork(String timeArea,String company){
		this.timeArea = timeArea;
		this.company = company;
	}
	
	public String getTimeArea() {
		return timeArea;
	}

	public void setTimeArea(String timeArea) {
		this.timeArea = timeArea;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	protected WorkExper clone() throws CloneNotSupportedException {
		return (WorkExper) super.clone();
	}

}
