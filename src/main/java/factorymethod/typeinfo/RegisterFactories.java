package factorymethod.typeinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//工厂方法，创建对象

class Part{
	public String toString(){
		return getClass().getSimpleName();
	}
	static List<Factory<? extends Part>> partFactories = new ArrayList<Factory<? extends Part>>();
	//静态代码块
	static{
		partFactories.add(new FuelFilter.Factory());
		partFactories.add(new AirFileter.Factory());
		partFactories.add(new CabinAirFileter.Factory());
		partFactories.add(new OilFileter.Factory());
		partFactories.add(new FanBelt.Factory());
		partFactories.add(new GeneratorBelt.Factory());
		partFactories.add(new PowerSteeringBelt.Factory());
	}
	private static Random rand = new Random(47);
	public static Part createRandom(){
		int n = rand.nextInt(partFactories.size());
		return partFactories.get(n).create();
	}
}

class Filter extends Part{}

class FuelFilter extends Filter{
	//这里Factory接口必须加上包名，如果直接写的话会被认为是定义的静态内部类本身
	public static class Factory implements factorymethod.typeinfo.Factory<FuelFilter>{
		@Override
		public FuelFilter create() {
			return new FuelFilter();
		}
	}
}

class AirFileter extends Filter{
	public static class Factory implements factorymethod.typeinfo.Factory<AirFileter>{
		@Override
		public AirFileter create() {
			return new AirFileter();
		}
	}
}

class CabinAirFileter extends Filter{
	public static class Factory implements factorymethod.typeinfo.Factory<CabinAirFileter>{
		@Override
		public CabinAirFileter create() {
			return new CabinAirFileter();
		}
	}
}

class OilFileter extends Filter{
	public static class Factory implements factorymethod.typeinfo.Factory<OilFileter>{
		@Override
		public OilFileter create() {
			return new OilFileter();
		}
	}
}

class Belt extends Part{}

class FanBelt extends Belt{
	public static class Factory implements factorymethod.typeinfo.Factory<FanBelt>{
		@Override
		public FanBelt create() {
			return new FanBelt();
		}
	}
}

class GeneratorBelt extends Belt{
	public static class Factory implements factorymethod.typeinfo.Factory<GeneratorBelt>{
		@Override
		public GeneratorBelt create() {
			return new GeneratorBelt();
		}
	}
}

class PowerSteeringBelt extends Belt{
	public static class Factory implements factorymethod.typeinfo.Factory<PowerSteeringBelt>{
		@Override
		public PowerSteeringBelt create() {
			return new PowerSteeringBelt();
		}
	}
}

public class RegisterFactories {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(Part.createRandom());
		}
	}
}
