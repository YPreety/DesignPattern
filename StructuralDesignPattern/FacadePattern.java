package StructuralDesignPattern;

/*The facade pattern is a structural design pattern. In the facade pattern, a facade classes is used to provide a single interface to set of classes. 
The facade simplifies a clients interaction with a complex system by localizing the interactions into a single interface. As a result, the client can 
interact with a single object rather than being required to interact directly in complicated ways with the objects that make up the subsystem.
*/

class Class1 {

	public int doSomethingComplicated(int x) {
		return x * x * x;
	}

}

class Class2 {

	public int doAnotherThing(Class1 class1, int x) {
		return 2 * class1.doSomethingComplicated(x);
	}
}

class Class3 {

	public int doMoreStuff(Class1 class1, Class2 class2, int x) {
		return class1.doSomethingComplicated(x) * class2.doAnotherThing(class1, x);
	}

}

class Facade {

	public int cubeX(int x) {
		Class1 class1 = new Class1();
		return class1.doSomethingComplicated(x);
	}

	public int cubeXTimes2(int x) {
		Class1 class1 = new Class1();
		Class2 class2 = new Class2();
		return class2.doAnotherThing(class1, x);
	}

	public int xToSixthPowerTimes2(int x) {
		Class1 class1 = new Class1();
		Class2 class2 = new Class2();
		Class3 class3 = new Class3();
		return class3.doMoreStuff(class1, class2, x);
	}

}

public class FacadePattern {

	public static void main(String[] args) {
		Facade facade = new Facade();

		int x = 3;
		System.out.println("Cube of " + x + ":" + facade.cubeX(3));
		System.out.println("Cube of " + x + " times 2:" + facade.cubeXTimes2(3));
		System.out.println(x + " to sixth power times 2:" + facade.xToSixthPowerTimes2(3));

	}

}
