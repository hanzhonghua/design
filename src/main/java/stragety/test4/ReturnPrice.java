package stragety.test4;

//一个简单的例子：
//商场根据会员等级优惠不同，现在简单设计为消费1000以上的银牌会员，享受9折，2000以上的为金牌，享受8折，
//3000以上的为超级会员，享受7折
public interface ReturnPrice {

	//根据原价返回不用价格
	double getPrice(double price);
}
