package StructuralDesignPattern;

/*An Adapter Pattern says that just "converts the interface of a class into another interface that a client wants".

In other words, to provide the interface according to client requirement while using the services of a class with a different interface.

The Adapter Pattern is also known as Wrapper.
*/

class CelciusReporter {

	double temperatureInC;

	public CelciusReporter() {
	}

	public double getTemperature() {
		return temperatureInC;
	}

	public void setTemperature(double temperatureInC) {
		this.temperatureInC = temperatureInC;
	}

}

interface TemperatureInfo {

	public double getTemperatureInF();

	public void setTemperatureInF(double temperatureInF);

	public double getTemperatureInC();

	public void setTemperatureInC(double temperatureInC);

}

class TemperatureClassReporter extends CelciusReporter implements TemperatureInfo {

	@Override
	public double getTemperatureInC() {
		return temperatureInC;
	}

	@Override
	public double getTemperatureInF() {
		return cToF(temperatureInC);
	}

	@Override
	public void setTemperatureInC(double temperatureInC) {
		this.temperatureInC = temperatureInC;
	}

	@Override
	public void setTemperatureInF(double temperatureInF) {
		this.temperatureInC = fToC(temperatureInF);
	}

	private double fToC(double f) {
		return ((f - 32) * 5 / 9);
	}

	private double cToF(double c) {
		return ((c * 9 / 5) + 32);
	}

}

class TemperatureObjectReporter implements TemperatureInfo {

	CelciusReporter celciusReporter;

	public TemperatureObjectReporter() {
		celciusReporter = new CelciusReporter();
	}

	@Override
	public double getTemperatureInC() {
		return celciusReporter.getTemperature();
	}

	@Override
	public double getTemperatureInF() {
		return cToF(celciusReporter.getTemperature());
	}

	@Override
	public void setTemperatureInC(double temperatureInC) {
		celciusReporter.setTemperature(temperatureInC);
	}

	@Override
	public void setTemperatureInF(double temperatureInF) {
		celciusReporter.setTemperature(fToC(temperatureInF));
	}

	private double fToC(double f) {
		return ((f - 32) * 5 / 9);
	}

	private double cToF(double c) {
		return ((c * 9 / 5) + 32);
	}

}

public class AdapterPattern {

	public static void main(String[] args) {

		// class adapter
		System.out.println("class adapter test");
		TemperatureInfo tempInfo = new TemperatureClassReporter();
		testTempInfo(tempInfo);

		// object adapter
		System.out.println("\nobject adapter test");
		tempInfo = new TemperatureObjectReporter();
		testTempInfo(tempInfo);

	}

	public static void testTempInfo(TemperatureInfo tempInfo) {
		tempInfo.setTemperatureInC(0);
		System.out.println("temp in C:" + tempInfo.getTemperatureInC());
		System.out.println("temp in F:" + tempInfo.getTemperatureInF());

		tempInfo.setTemperatureInF(85);
		System.out.println("temp in C:" + tempInfo.getTemperatureInC());
		System.out.println("temp in F:" + tempInfo.getTemperatureInF());
	}

}
