package design.stragety.test4.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//区间注解，可以给策略添加价格区间，在各个具体策略类上加上注解，需要在策略工厂中处理注解
@Target(ElementType.TYPE) //表示只能给类添加注解
@Retention(RetentionPolicy.RUNTIME) //必须要将注解保留到运行时
public @interface PriceAnnotation {

	//我们只取整数
	int max() default Integer.MAX_VALUE;
	int min() default Integer.MIN_VALUE;
}
