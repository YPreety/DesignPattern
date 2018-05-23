package BehavioralDesignPattern;

/*The state pattern is a behavioral object design pattern. The idea behind the state pattern is for an object to change its behavior depending on its state. 
In the state pattern, we have a Context class, and this class has a State reference to a Concrete State instance. The State interface declares particular 
methods that represent the behaviors of a particular state. Concrete States implement these behaviors. By changing a Context's Concrete State, we change 
its behavior. In essence, in the state pattern, a class (the Context) is supposed to behave like different classes depending on its state. 
The state pattern avoids the use of switch and if statements to change behavior.
*/

interface EmotionalState {

	public String sayHello();

	public String sayGoodbye();

}

class HappyState implements EmotionalState {

	@Override
	public String sayGoodbye() {
		return "Bye, friend!";
	}

	@Override
	public String sayHello() {
		return "Hello, friend!";
	}

}

class SadState implements EmotionalState {

	@Override
	public String sayGoodbye() {
		return "Bye. Sniff, sniff.";
	}

	@Override
	public String sayHello() {
		return "Hello. Sniff, sniff.";
	}

}

class Person implements EmotionalState {

	EmotionalState emotionalState;

	public Person(EmotionalState emotionalState) {
		this.emotionalState = emotionalState;
	}

	public void setEmotionalState(EmotionalState emotionalState) {
		this.emotionalState = emotionalState;
	}

	@Override
	public String sayGoodbye() {
		return emotionalState.sayGoodbye();
	}

	@Override
	public String sayHello() {
		return emotionalState.sayHello();
	}

}

public class StatePattern {

	public static void main(String[] args) {
		Person person = new Person(new HappyState());
		System.out.println("Hello in happy state: " + person.sayHello());
		System.out.println("Goodbye in happy state: " + person.sayGoodbye());

		person.setEmotionalState(new SadState());
		System.out.println("Hello in sad state: " + person.sayHello());
		System.out.println("Goodbye in sad state: " + person.sayGoodbye());

	}

}
