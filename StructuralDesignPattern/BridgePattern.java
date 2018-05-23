package StructuralDesignPattern;

/*The bridge pattern is a structural design pattern. In the bridge pattern, we separate an abstraction and its implementation and develop separate 
inheritance structures for both the abstraction and the implementor. The abstraction is an interface or abstract class, and the implementor is likewise 
an interface or abstract class. The abstraction contains a reference to the implementor. Children of the abstraction are referred to as refined abstractions,
and children of the implementor are concrete implementors. Since we can change the reference to the implementor in the abstraction, we are able to change
the abstraction's implementor at run-time. Changes to the implementor do not affect client code.
*/

abstract class Vehicle {

	Engine engine;
	int weightInKilos;

	public abstract void drive();

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public void reportOnSpeed(int horsepower) {
		int ratio = weightInKilos / horsepower;
		if (ratio < 3) {
			System.out.println("The vehicle is going at a fast speed.");
		} else if ((ratio >= 3) && (ratio < 8)) {
			System.out.println("The vehicle is going an average speed.");
		} else {
			System.out.println("The vehicle is going at a slow speed.");
		}
	}

}

class BigBus extends Vehicle {

	public BigBus(Engine engine) {
		this.weightInKilos = 3000;
		this.engine = engine;
	}

	@Override
	public void drive() {
		System.out.println("\nThe big bus is driving");
		int horsepower = engine.go();
		reportOnSpeed(horsepower);
	}

}

class SmallCar extends Vehicle {

	public SmallCar(Engine engine) {
		this.weightInKilos = 600;
		this.engine = engine;
	}

	@Override
	public void drive() {
		System.out.println("\nThe small car is driving");
		int horsepower = engine.go();
		reportOnSpeed(horsepower);
	}

}

interface Engine {

	public int go();

}

class BigEngine implements Engine {

	int horsepower;

	public BigEngine() {
		horsepower = 350;
	}

	@Override
	public int go() {
		System.out.println("The big engine is running");
		return horsepower;
	}

}

class SmallEngine implements Engine {

	int horsepower;

	public SmallEngine() {
		horsepower = 100;
	}

	@Override
	public int go() {
		System.out.println("The small engine is running");
		return horsepower;
	}

}

public class BridgePattern {

	public static void main(String[] args) {
		Vehicle vehicle = new BigBus(new SmallEngine());
		vehicle.drive();
		vehicle.setEngine(new BigEngine());
		vehicle.drive();

		vehicle = new SmallCar(new SmallEngine());
		vehicle.drive();
		vehicle.setEngine(new BigEngine());
		vehicle.drive();

	}

}
