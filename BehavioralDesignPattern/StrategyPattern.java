package BehavioralDesignPattern;

/*The strategy pattern is a behavioral object design pattern. In the strategy pattern, different algorithms are represented as Concrete Strategy classes, 
and they share a common Strategy interface. A Context object contains a reference to a Strategy. By changing the Context's Strategy, different behaviors 
can be obtained. Although these behaviors are different, the different strategies all operate on data from the Context.
*/

interface Strategy {

	boolean checkTemperature(int temperatureInF);

}

class HikeStrategy implements Strategy {

	@Override
	public boolean checkTemperature(int temperatureInF) {
		if ((temperatureInF >= 50) && (temperatureInF <= 90)) {
			return true;
		} else {
			return false;
		}
	}

}

class SkiStrategy implements Strategy {

	@Override
	public boolean checkTemperature(int temperatureInF) {
		if (temperatureInF <= 32) {
			return true;
		} else {
			return false;
		}
	}

}

class Context {

	int temperatureInF;
	Strategy strategy;

	public Context(int temperatureInF, Strategy strategy) {
		this.temperatureInF = temperatureInF;
		this.strategy = strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public int getTemperatureInF() {
		return temperatureInF;
	}

	public boolean getResult() {
		return strategy.checkTemperature(temperatureInF);
	}

}

public class StrategyPattern {

	public static void main(String[] args) {
		int temperatureInF = 60;

		Strategy skiStrategy = new SkiStrategy();
		Context context = new Context(temperatureInF, skiStrategy);

		System.out.println(
				"Is the temperature (" + context.getTemperatureInF() + "F) good for skiing? " + context.getResult());

		Strategy hikeStrategy = new HikeStrategy();
		context.setStrategy(hikeStrategy);

		System.out.println(
				"Is the temperature (" + context.getTemperatureInF() + "F) good for hiking? " + context.getResult());

	}

}
