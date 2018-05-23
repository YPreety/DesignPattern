package BehavioralDesignPattern;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*The observer pattern is a behavioral object design pattern. In the observer pattern, an object called the subject maintains a collection of objects 
called observers. When the subject changes, it notifies the observers. Observers can be added or removed from the collection of observers in the subject. 
The changes in state of the subject can be passed to the observers so that the observers can change their own state to reflect this change.
*/

interface WeatherSubject {

	public void addObserver(WeatherObserver weatherObserver);

	public void removeObserver(WeatherObserver weatherObserver);

	public void doNotify();

}

interface WeatherObserver {

	public void doUpdate(int temperature);

}

class WeatherStation implements WeatherSubject {

	Set<WeatherObserver> weatherObservers;
	int temperature;

	public WeatherStation(int temperature) {
		weatherObservers = new HashSet<WeatherObserver>();
		this.temperature = temperature;
	}

	@Override
	public void addObserver(WeatherObserver weatherObserver) {
		weatherObservers.add(weatherObserver);
	}

	@Override
	public void removeObserver(WeatherObserver weatherObserver) {
		weatherObservers.remove(weatherObserver);
	}

	@Override
	public void doNotify() {
		Iterator<WeatherObserver> it = weatherObservers.iterator();
		while (it.hasNext()) {
			WeatherObserver weatherObserver = it.next();
			weatherObserver.doUpdate(temperature);
		}
	}

	public void setTemperature(int newTemperature) {
		System.out.println("\nWeather station setting temperature to " + newTemperature);
		temperature = newTemperature;
		doNotify();
	}

}

class WeatherCustomer1 implements WeatherObserver {

	@Override
	public void doUpdate(int temperature) {
		System.out.println("Weather customer 1 just found out the temperature is:" + temperature);
	}

}

class WeatherCustomer2 implements WeatherObserver {

	@Override
	public void doUpdate(int temperature) {
		System.out.println("Weather customer 2 just found out the temperature is:" + temperature);
	}

}

public class ObserverPattern {

	public static void main(String[] args) {
		WeatherStation weatherStation = new WeatherStation(33);

		WeatherCustomer1 wc1 = new WeatherCustomer1();
		WeatherCustomer2 wc2 = new WeatherCustomer2();
		weatherStation.addObserver(wc1);
		weatherStation.addObserver(wc2);

		weatherStation.setTemperature(34);

		weatherStation.removeObserver(wc1);

		weatherStation.setTemperature(35);

	}

}
