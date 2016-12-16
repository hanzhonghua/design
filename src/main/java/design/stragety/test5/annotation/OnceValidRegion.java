package design.stragety.test5.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//总金额有效的区间注解，可以个策略添加有效的区间设置
@Target(ElementType.TYPE) //表示只能给类添加注解
@Retention(RetentionPolicy.RUNTIME) //必须要将注解保留到运行时
public @interface OnceValidRegion {

	//需要引用的有效区间注解
	ValidRegion value() default @ValidRegion;
}
