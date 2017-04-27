package future;

/*
 * 有一客户端
 */
public class FutureClient {

	public Data request(final String queryStr) {
		// 真实对象的一个代理对象，先返回给发送请求的客户端，让它知道请求已经收到了，可以去做其他的事情了
		final FutureData futureData = new FutureData();
		// 启动一个线程，偷偷的去加载真实数据，传递给代理对象
		new Thread(new Runnable() {
			@Override
			public void run() {
				RealData realData = new RealData(queryStr);
				futureData.setRealData(realData);
			}
		}).start();
		return futureData;
	}

}
