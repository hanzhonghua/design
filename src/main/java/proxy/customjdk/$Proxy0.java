package proxy.customjdk;

import java.lang.reflect.Method;
import proxy.customjdk.MyInvocationHandler;

public class $Proxy0 implements proxy.customjdk.UserService {
	private MyInvocationHandler h;

	public $Proxy0(MyInvocationHandler h) {
		this.h = h;
	}

	@Override
	public void add() {
		try {
			Method md = proxy.customjdk.UserService.class.getMethod("add");
			h.invoke(this, md);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete() {
		try {
			Method md = proxy.customjdk.UserService.class.getMethod("delete");
			h.invoke(this, md);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}