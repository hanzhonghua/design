package factorymethod.iterator;

public class ArrayList {
	private int index = 0;
	Object[] obj = new Object[10];
	public void add(Object o){
		index+=1;
		if(index == obj.length){
			Object[] newObj = new Object[obj.length * 2];
			System.arraycopy(obj, 0, newObj, 0, obj.length);
			obj = newObj;
		}
		obj[index] = o;
	}
	
	public int size(){
		return index;
	}
}
