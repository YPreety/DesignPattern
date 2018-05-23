package StructuralDesignPattern;

import java.util.HashMap;
import java.util.Map;

/*The flyweight pattern is a structural design pattern. In the flyweight pattern, instead of creating large numbers of similar objects, objects are reused. 
This can be used to reduce memory requirements and instantiation time and related costs. Similarities between objects are stored inside of the objects, 
and differences are moved outside of the objects and placed in client code. These differences are passed in to the objects when needed via method calls 
on the objects. A Flyweight interface declares these methods. A Concrete Flyweight class implements the Flyweight interface which is used to perform 
operations based on external state and it also stores common state. A Flyweight Factory is used create and return Flyweight objects.
*/

interface Flyweight {

	public void doMath(int a, int b);

}

class FlyweightAdder implements Flyweight {

	String operation;

	public FlyweightAdder() {
		operation = "adding";
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doMath(int a, int b) {
		System.out.println(operation + " " + a + " and " + b + ": " + (a + b));
	}

}

class FlyweightMultiplier implements Flyweight {

	String operation;

	public FlyweightMultiplier() {
		operation = "multiplying";
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doMath(int a, int b) {
		System.out.println(operation + " " + a + " and " + b + ": " + (a * b));
	}

}

class FlyweightFactory {

	private static FlyweightFactory flyweightFactory;

	private Map<String, Flyweight> flyweightPool;

	private FlyweightFactory() {
		flyweightPool = new HashMap<String, Flyweight>();
	}

	public static FlyweightFactory getInstance() {
		if (flyweightFactory == null) {
			flyweightFactory = new FlyweightFactory();
		}
		return flyweightFactory;
	}

	public Flyweight getFlyweight(String key) {
		if (flyweightPool.containsKey(key)) {
			return flyweightPool.get(key);
		} else {
			Flyweight flyweight;
			if ("add".equals(key)) {
				flyweight = new FlyweightAdder();
			} else {
				flyweight = new FlyweightMultiplier();
			}
			flyweightPool.put(key, flyweight);
			return flyweight;
		}
	}

}

public class flyweightPattern {

	public static void main(String[] args) {
		FlyweightFactory flyweightFactory = FlyweightFactory.getInstance();

		for (int i = 0; i < 5; i++) {
			Flyweight flyweightAdder = flyweightFactory.getFlyweight("add");
			flyweightAdder.doMath(i, i);

			Flyweight flyweightMultiplier = flyweightFactory.getFlyweight("multiply");
			flyweightMultiplier.doMath(i, i);
		}

	}

}
