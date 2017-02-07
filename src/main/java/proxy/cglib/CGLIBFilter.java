package proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.CallbackFilter;

public class CGLIBFilter implements CallbackFilter {

	@Override
	public int accept(Method arg0) {
		if("addCar".equalsIgnoreCase(arg0.getName())){
			return 0;
		}
		return 1;
	}

}
