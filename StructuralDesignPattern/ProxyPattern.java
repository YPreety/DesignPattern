package StructuralDesignPattern;

import java.util.Date;

/*The proxy pattern is a structural design pattern. In the proxy pattern, a proxy class is used to control access to another class. 
The reasons for this control can vary. As one example, a proxy may avoid instantiation of an object until the object is needed. This can be useful if 
the object requires a lot of time or resources to create. Another reason to use a proxy is to control access rights to an object. A client request 
may require certain credentials in order to access the object.
*/

abstract class Thing {

	public void sayHello() {
		System.out.println(this.getClass().getSimpleName() + " says howdy at " + new Date());
	}

}

class FastThing extends Thing {

	public FastThing() {
	}

}

class SlowThing extends Thing {

	public SlowThing() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class Proxy {

	SlowThing slowThing;

	public Proxy() {
		System.out.println("Creating proxy at " + new Date());
	}

	public void sayHello() {
		if (slowThing == null) {
			slowThing = new SlowThing();
		}
		slowThing.sayHello();
	}

}

public class ProxyPattern {

	public static void main(String[] args) {
		Proxy proxy = new Proxy();

		FastThing fastThing = new FastThing();
		fastThing.sayHello();

		proxy.sayHello();

	}

}
