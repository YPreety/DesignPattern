package BehavioralDesignPattern;

/*The template method pattern is a behavioral class pattern. A behavioral class pattern uses inheritance for distribution of behavior.
In the template method pattern, a method (the 'template method') defines the steps of an algorithm. The implementation of these steps (ie, methods) 
can be deferred to subclasses. Thus, a particular algorithm is defined in the template method, but the exact steps of this algorithm can be defined in 
subclasses. The template method is implemented in an abstract class. The steps (methods) of the algorithm are declared in the abstract class, and the 
methods whose implementations are to be delegated to subclasses are declared abstract.
*/

abstract class Meal {

	// template method
	public final void doMeal() {
		prepareIngredients();
		cook();
		eat();
		cleanUp();
	}

	public abstract void prepareIngredients();

	public abstract void cook();

	public void eat() {
		System.out.println("Mmm, that's good");
	}

	public abstract void cleanUp();

}

class HamburgerMeal extends Meal {

	@Override
	public void prepareIngredients() {
		System.out.println("Getting burgers, buns, and french fries");
	}

	@Override
	public void cook() {
		System.out.println("Cooking burgers on grill and fries in oven");
	}

	@Override
	public void cleanUp() {
		System.out.println("Throwing away paper plates");
	}

}

class TacoMeal extends Meal {

	@Override
	public void prepareIngredients() {
		System.out.println("Getting ground beef and shells");
	}

	@Override
	public void cook() {
		System.out.println("Cooking ground beef in pan");
	}

	@Override
	public void eat() {
		System.out.println("The tacos are tasty");
	}

	@Override
	public void cleanUp() {
		System.out.println("Doing the dishes");
	}

}

public class TemplateMethodPattern {

	public static void main(String[] args) {
		Meal meal1 = new HamburgerMeal();
		meal1.doMeal();

		System.out.println();

		Meal meal2 = new TacoMeal();
		meal2.doMeal();

	}

}
