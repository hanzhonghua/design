package stragety.sort;

public class CatSortByWeight implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		
		//既然知道比较的是猫，直接强转
		if(((Cat)o1).getWeight() > ((Cat)o2).getWeight()){
			return 1;
		}else if(((Cat)o1).getWeight() == ((Cat)o2).getWeight()){
			return 0;
		}
		return -1;
	}

}
