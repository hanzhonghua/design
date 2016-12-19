
package decorate.test2;

import decorate.test2.impl.LeatherShoes;
import decorate.test2.impl.Necktie;
import decorate.test2.impl.Pants;
import decorate.test2.impl.Shoes;
import decorate.test2.impl.Suit;
import decorate.test2.impl.TShirts;

/*
	相对于test1有了一些简单的改善，但是还有很多不足，只是用到了继承，
 	还有穿西装、打领带、穿鞋子都是一个一个打印出来的，就好比光着屁股一件一件的穿，
 	并且还是公开的；
 	穿衣服的顺序不一样职位就不一样，比如：先穿裤子再穿内裤就是超人，先穿内裤在穿裤子
 	就是普通人了。
 	我们需要把这几个功能按照正确的顺序串联起来进行控制，可以使用装饰模式，见test3
 	装饰模式(Decorate)：动态的给对象添加一些额外的职责，就增加功能来说，比增加子类更加灵活
 	见demo
 */
public class Test {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setName("小韩");
		p1.show();
		TShirts t = new TShirts();
		Pants p = new Pants();
		Shoes s = new Shoes();
		s.cross();
		p.cross();
		t.cross();
		System.out.println();
		Person p2 = new Person();
		p2.setName("老韩");
		p2.show();
		Suit suit = new Suit();
		suit.cross();
		Necktie n = new Necktie();
		n.cross();
		LeatherShoes l = new LeatherShoes();
		l.cross();
	}
}
