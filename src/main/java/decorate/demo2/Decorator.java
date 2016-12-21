package decorate.demo2;

import decorate.demo2.Component;

public abstract class Decorator implements Component {

	protected Component compontent;
	
	public Decorator(Component compontent) {
		this.compontent = compontent;
	}

	@Override
	public void show() {
		if(compontent != null){
			compontent.show();
		}
	}

}
