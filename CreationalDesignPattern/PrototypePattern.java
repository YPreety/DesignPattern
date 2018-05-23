package CreationalDesignPattern;

/*Prototype Design Pattern
Prototype Pattern says that cloning of an existing object instead of creating new one and can also be customized as per the requirement.

This pattern should be followed, if the cost of creating a new object is expensive and resource intensive.
*/
interface Prototype {

	public Prototype doClone();

}

class Person implements Prototype {

	String name;

	public Person(String name) {
		this.name = name;
	}

	@Override
	public Prototype doClone() {
		return new Person(name);
	}

	public String toString() {
		return "This person is named " + name;
	}
}

class Dog2 implements Prototype {

	String sound;

	public Dog2(String sound) {
		this.sound = sound;
	}

	@Override
	public Prototype doClone() {
		return new Dog2(sound);
	}

	public String toString() {
		return "This dog says " + sound;
	}
}

public class PrototypePattern {

	public static void main(String[] args) {
		Person person1 = new Person("Fred");
		System.out.println("person 1:" + person1);
		Person person2 = (Person) person1.doClone();
		System.out.println("person 2:" + person2);

		Dog2 dog1 = new Dog2("Wooof!");
		System.out.println("dog 1:" + dog1);
		Dog2 dog2 = (Dog2) dog1.doClone();
		System.out.println("dog 2:" + dog2);

	}

}
