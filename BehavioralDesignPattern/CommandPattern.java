package BehavioralDesignPattern;

/*The command pattern is a behavioral object design pattern. In the command pattern, a Command interface declares a method for executing a particular action. 
Concrete Command classes implement the execute() method of the Command interface, and this execute() method invokes the appropriate action method of a 
Receiver class that the Concrete Command class contains. The Receiver class performs a particular action. A Client class is responsible for creating a 
Concrete Command and setting the Receiver of the Concrete Command. An Invoker class contains a reference to a Command and has a method to execute the Command.
*/

interface Command {

	public void execute();

}

class LunchCommand implements Command {

	Lunch lunch;

	public LunchCommand(Lunch lunch) {
		this.lunch = lunch;
	}

	@Override
	public void execute() {
		lunch.makeLunch();
	}

}

class DinnerCommand implements Command {

	Dinner dinner;

	public DinnerCommand(Dinner dinner) {
		this.dinner = dinner;
	}

	@Override
	public void execute() {
		dinner.makeDinner();
	}

}

class Lunch {

	public void makeLunch() {
		System.out.println("Lunch is being made");
	}

}

class Dinner {

	public void makeDinner() {
		System.out.println("Dinner is being made");
	}

}

class MealInvoker {

	Command command;

	public MealInvoker(Command command) {
		this.command = command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public void invoke() {
		command.execute();
	}

}

public class CommandPattern {

	public static void main(String[] args) {
		Lunch lunch = new Lunch(); // receiver
		Command lunchCommand = new LunchCommand(lunch); // concrete command

		Dinner dinner = new Dinner(); // receiver
		Command dinnerCommand = new DinnerCommand(dinner); // concrete command

		MealInvoker mealInvoker = new MealInvoker(lunchCommand); // invoker
		mealInvoker.invoke();

		mealInvoker.setCommand(dinnerCommand);
		mealInvoker.invoke();

	}

}
