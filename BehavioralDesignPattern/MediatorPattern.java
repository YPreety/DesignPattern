package BehavioralDesignPattern;

/*The mediator pattern is a behavioral object design pattern. The mediator pattern centralizes communication between objects into a mediator object. 
This centralization is useful since it localizes in one place the interactions between objects, which can increase code maintainability, especially 
as the number of classes in an application increases. Since communication occurs with the mediator rather than directly with other objects, the mediator 
pattern results in a loose coupling of objects.
*/

class Mediator {

	Buyer swedishBuyer;
	Buyer frenchBuyer;
	AmericanSeller americanSeller;
	DollarConverter dollarConverter;

	public Mediator() {
	}

	public void registerSwedishBuyer(SwedishBuyer swedishBuyer) {
		this.swedishBuyer = swedishBuyer;
	}

	public void registerFrenchBuyer(FrenchBuyer frenchBuyer) {
		this.frenchBuyer = frenchBuyer;
	}

	public void registerAmericanSeller(AmericanSeller americanSeller) {
		this.americanSeller = americanSeller;
	}

	public void registerDollarConverter(DollarConverter dollarConverter) {
		this.dollarConverter = dollarConverter;
	}

	public boolean placeBid(float bid, String unitOfCurrency) {
		float dollarAmount = dollarConverter.convertCurrencyToDollars(bid, unitOfCurrency);
		return americanSeller.isBidAccepted(dollarAmount);
	}
}

class Buyer {

	Mediator mediator;
	String unitOfCurrency;

	public Buyer(Mediator mediator, String unitOfCurrency) {
		this.mediator = mediator;
		this.unitOfCurrency = unitOfCurrency;
	}

	public boolean attemptToPurchase(float bid) {
		System.out.println("Buyer attempting a bid of " + bid + " " + unitOfCurrency);
		return mediator.placeBid(bid, unitOfCurrency);
	}
}

class SwedishBuyer extends Buyer {

	public SwedishBuyer(Mediator mediator) {
		super(mediator, "krona");
		this.mediator.registerSwedishBuyer(this);
	}
}

class FrenchBuyer extends Buyer {

	public FrenchBuyer(Mediator mediator) {
		super(mediator, "euro");
		this.mediator.registerFrenchBuyer(this);
	}
}

class AmericanSeller {

	Mediator mediator;
	float priceInDollars;

	public AmericanSeller(Mediator mediator, float priceInDollars) {
		this.mediator = mediator;
		this.priceInDollars = priceInDollars;
		this.mediator.registerAmericanSeller(this);
	}

	public boolean isBidAccepted(float bidInDollars) {
		if (bidInDollars >= priceInDollars) {
			System.out.println("Seller accepts the bid of " + bidInDollars + " dollars\n");
			return true;
		} else {
			System.out.println("Seller rejects the bid of " + bidInDollars + " dollars\n");
			return false;
		}
	}

}

class DollarConverter {

	Mediator mediator;

	public static final float DOLLAR_UNIT = 1.0f;
	public static final float EURO_UNIT = 0.7f;
	public static final float KRONA_UNIT = 8.0f;

	public DollarConverter(Mediator mediator) {
		this.mediator = mediator;
		mediator.registerDollarConverter(this);
	}

	private float convertEurosToDollars(float euros) {
		float dollars = euros * (DOLLAR_UNIT / EURO_UNIT);
		System.out.println("Converting " + euros + " euros to " + dollars + " dollars");
		return dollars;
	}

	private float convertKronorToDollars(float kronor) {
		float dollars = kronor * (DOLLAR_UNIT / KRONA_UNIT);
		System.out.println("Converting " + kronor + " kronor to " + dollars + " dollars");
		return dollars;
	}

	public float convertCurrencyToDollars(float amount, String unitOfCurrency) {
		if ("krona".equalsIgnoreCase(unitOfCurrency)) {
			return convertKronorToDollars(amount);
		} else {
			return convertEurosToDollars(amount);
		}
	}
}

public class MediatorPattern {

	public static void main(String[] args) {
		Mediator mediator = new Mediator();

		Buyer swedishBuyer = new SwedishBuyer(mediator);
		Buyer frenchBuyer = new FrenchBuyer(mediator);
		float sellingPriceInDollars = 10.0f;
		AmericanSeller americanSeller = new AmericanSeller(mediator, sellingPriceInDollars);
		DollarConverter dollarConverter = new DollarConverter(mediator);

		float swedishBidInKronor = 55.0f;
		while (!swedishBuyer.attemptToPurchase(swedishBidInKronor)) {
			swedishBidInKronor += 15.0f;
		}

		float frenchBidInEuros = 3.0f;
		while (!frenchBuyer.attemptToPurchase(frenchBidInEuros)) {
			frenchBidInEuros += 1.5f;
		}

	}

}
