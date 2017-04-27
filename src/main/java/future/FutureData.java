package future;

public class FutureData implements Data {

	// 持有一真实对象的引用
	private RealData realData;
	private boolean isReady = false;

	public synchronized void setRealData(RealData realData) {
		if (isReady) {
			return;
		}
		this.realData = realData;
		isReady = true;
		notify();
	}

	@Override
	public synchronized String getRequest() {
		while (!isReady) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return this.realData.getRequest();
	}

}
