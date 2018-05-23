package BehavioralDesignPattern;

/*The memento pattern is a behavioral design pattern. The memento pattern is used to store an object's state so that this state can be restored at a later 
point. The saved state data in the memento object is not accessible outside of the object to be saved and restored. This protects the integrity of the 
saved state data.

In this pattern, an Originator class represents the object whose state we would like to save. A Memento class represents an object to store the state of 
the Originator. The Memento class is typically a private inner class of the Originator. As a result, the Originator has access to the fields of the memento,
but outside classes do not have access to these fields. This means that state information can be transferred between the Memento and the Originator within 
the Originator class, but outside classes do not have access to the state data stored in the Memento.
*/

class DietInfo {

	String personName;
	int dayNumber;
	int weight;

	public DietInfo(String personName, int dayNumber, int weight) {
		this.personName = personName;
		this.dayNumber = dayNumber;
		this.weight = weight;
	}

	public String toString() {
		return "Name: " + personName + ", day number: " + dayNumber + ", weight: " + weight;
	}

	public void setDayNumberAndWeight(int dayNumber, int weight) {
		this.dayNumber = dayNumber;
		this.weight = weight;
	}

	public Memento save() {
		return new Memento(personName, dayNumber, weight);
	}

	public void restore(Object objMemento) {
		Memento memento = (Memento) objMemento;
		personName = memento.mementoPersonName;
		dayNumber = memento.mementoDayNumber;
		weight = memento.mementoWeight;
	}

	// memento - object that stores the saved state of the originator
	private class Memento {
		String mementoPersonName;
		int mementoDayNumber;
		int mementoWeight;

		public Memento(String personName, int dayNumber, int weight) {
			mementoPersonName = personName;
			mementoDayNumber = dayNumber;
			mementoWeight = weight;
		}
	}
}

class DietInfoCaretaker {

	Object objMemento;

	public void saveState(DietInfo dietInfo) {
		objMemento = dietInfo.save();
	}

	public void restoreState(DietInfo dietInfo) {
		dietInfo.restore(objMemento);
	}

}

public class MementoPattern {

	public static void main(String[] args) {
		// caretaker
		DietInfoCaretaker dietInfoCaretaker = new DietInfoCaretaker();

		// originator
		DietInfo dietInfo = new DietInfo("Fred", 1, 100);
		System.out.println(dietInfo);

		dietInfo.setDayNumberAndWeight(2, 99);
		System.out.println(dietInfo);

		System.out.println("Saving state.");
		dietInfoCaretaker.saveState(dietInfo);

		dietInfo.setDayNumberAndWeight(3, 98);
		System.out.println(dietInfo);

		dietInfo.setDayNumberAndWeight(4, 97);
		System.out.println(dietInfo);

		System.out.println("Restoring saved state.");
		dietInfoCaretaker.restoreState(dietInfo);
		System.out.println(dietInfo);

	}

}
