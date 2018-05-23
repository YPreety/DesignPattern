package CreationalDesignPattern;


/*Factory Method Pattern
A Factory Pattern or Factory Method Pattern says that just define an interface or abstract class for creating an object but let the subclasses decide 
which class to instantiate. In other words, subclasses are responsible to create the instance of the class.

The Factory Method Pattern is also known as Virtual Constructor.
*/

abstract class Animal1 {
	public abstract String makeSound();
}

class Dog1 extends Animal1 {

	@Override
	public String makeSound() {
		return "Woof";
	}

}

class Cat1 extends Animal1 {

	@Override
	public String makeSound() {
		return "Meow";
	}

}

class AnimalFactory {

	public Animal1 getAnimal(String type) {
		if ("canine".equals(type)) {
			return new Dog1();
		} else {
			return new Cat1();
		}
	}

}

public class FactoryMethodPattern {

	public static void main(String[] args) {
		AnimalFactory animalFactory = new AnimalFactory();

		Animal1 a1 = animalFactory.getAnimal("feline");
		System.out.println("a1 sound: " + a1.makeSound());

		Animal1 a2 = animalFactory.getAnimal("canine");
		System.out.println("a2 sound: " + a2.makeSound());
	}

}
