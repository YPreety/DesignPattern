package BehavioralDesignPattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*The iterator pattern is a behavioral object design pattern. The iterator pattern allows for the traversal through the elements in a grouping of objects 
via a standardized interface. An Iterator interface defines the actions that can be performed. These actions include being able to traverse the objects 
and also obtain the objects.JavaSW features the widely used java.util.Iterator interface which is used to iterate through things such as Java collections. 
We can write our own iterator by implementing java.util.Iterator. This interface features the hasNext(), next(), and remove() methods. When writing an 
iterator for a class, it is very common for the iterator class to be an inner class of the class that we'd like to iterate through.
*/

class Item {

	String name;
	float price;

	public Item(String name, float price) {
		this.name = name;
		this.price = price;
	}

	public String toString() {
		return name + ": $" + price;
	}
}

class Menu {

	List<Item> menuItems;

	public Menu() {
		menuItems = new ArrayList<Item>();
	}

	public void addItem(Item item) {
		menuItems.add(item);
	}

	public Iterator<Item> iterator() {
		return new MenuIterator();
	}

	class MenuIterator implements Iterator<Item> {
		int currentIndex = 0;

		@Override
		public boolean hasNext() {
			if (currentIndex >= menuItems.size()) {
				return false;
			} else {
				return true;
			}
		}

		@Override
		public Item next() {
			return menuItems.get(currentIndex++);
		}

		@Override
		public void remove() {
			menuItems.remove(--currentIndex);
		}

	}

}

public class IteratorPattern {

	public static void main(String[] args) {
		Item i1 = new Item("spaghetti", 7.50f);
		Item i2 = new Item("hamburger", 6.00f);
		Item i3 = new Item("chicken sandwich", 6.50f);

		Menu menu = new Menu();
		menu.addItem(i1);
		menu.addItem(i2);
		menu.addItem(i3);

		System.out.println("Displaying Menu:");
		Iterator<Item> iterator = menu.iterator();
		while (iterator.hasNext()) {
			Item item = iterator.next();
			System.out.println(item);
		}

		System.out.println("\nRemoving last item returned");
		iterator.remove();

		System.out.println("\nDisplaying Menu:");
		iterator = menu.iterator();
		while (iterator.hasNext()) {
			Item item = iterator.next();
			System.out.println(item);
		}

	}

}
