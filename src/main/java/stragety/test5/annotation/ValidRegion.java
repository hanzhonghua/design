package stragety.test5.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//嵌套注解
@Target(ElementType.ANNOTATION_TYPE) //表示只能给类添加注解
@Retention(RetentionPolicy.RUNTIME) //必须要将注解保留到运行时
public @interface ValidRegion {

	//我们只取整数
	int max() default Integer.MAX_VALUE;
	int min() default Integer.MIN_VALUE;
	
	//比如黄金会员花费2000，满减打折和先打折再满减花费是不一样的；我们必须支持这一个规则
	//默认0，为最优先
	int order() default 0;
}
