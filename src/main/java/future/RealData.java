package future;

public class RealData implements Data {

	private String result;
	
	public RealData(String queryStr) {
		System.out.println("根据：" + queryStr + "查询，这是一个很耗时的操作");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("操作完毕，得到结果");
		result = "this is result";
	}

	@Override
	public String getRequest() {
		return result;
	}

}
