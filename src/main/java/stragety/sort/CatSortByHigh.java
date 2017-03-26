package stragety.sort;

import java.util.Collections;

/**
 *根据体中比较猫的大小，实现Comparator接口 
 * @Title: CatSortByHeight.java
 * @author Hanzhonghua
 * @date 2017年2月13日下午1:56:22
 */
public class CatSortByHigh implements Comparator {

	public int compare(Object o1, Object o2) {
		//既然知道比较的是猫，直接强转
		if(((Cat)o1).getHigh() > ((Cat)o2).getHigh()){
			return 1;
		}else if(((Cat)o1).getHigh() == ((Cat)o2).getHigh()){
			return 0;
		}
		return -1;
	}

}
