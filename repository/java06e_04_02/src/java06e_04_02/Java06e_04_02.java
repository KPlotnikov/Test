/* ################################################
Die mehrfach überschriebene Methode toString()
################################################# */
package java06e_04_02;

//die Basisklasse Baer
class Baer {
	int gewicht;
	int alter;

	//ein eigener Konstruktor
	Baer(int gewicht, int alter) {
		this.gewicht = gewicht;
		this.alter = alter;
	}

	//die Methode liefert das Gewicht
	int getGewicht() {
		return gewicht;
	}

	//die Methode liefert das Alter
	int getAlter() {
		return alter;
	}

	//die Methode zur Ausgabe der Werte
	void ausgeben() {
		System.out.println("Die Ausgabe erfolgt aus " + this.getClass());
		System.out.println("Der Bär ist " + alter + " Jahre alt und wiegt " + gewicht + " Kilo.");
	}

	//die überschriebene Methode toString() aus der Klasse Object
	@Override
	public String toString() {
		String ausgabe;
		ausgabe = "[" + this.getClass();
		ausgabe = ausgabe + " Alter: " + alter;
		ausgabe = ausgabe + " Gewicht: " + gewicht + "]";
		return ausgabe;
	}
}

//die Klasse ElternBaer erbt von der Klasse Baer
class ElternBaer extends Baer {
	int anzahlKinder;

	//ein eigener Konstruktor
	ElternBaer(int gewicht, int alter, int anzahlKinder) {
		//der Aufruf des Konstruktors der übergeordneten Klasse Baer
		//gewicht und alter werden "durchgereicht"
		super(gewicht, alter);
		this.anzahlKinder = anzahlKinder;
	}

	//die Methode liefert die Anzahl der Kinder
	int getAnzahlKinder() {
		return anzahlKinder;
	}

	//die Methode zur Ausgabe der Werte
	//Sie überschreibt die gleichnamige Methode der Basisklasse
	@Override
	void ausgeben() {
		System.out.println("Die Ausgabe erfolgt aus " + this.getClass());
		System.out.println("Der Bär ist " + alter + " Jahre alt,wiegt " + gewicht + " Kilo und hat " + anzahlKinder + " Kinder.");
	}

	//die überschriebene Methode toString() aus der Klasse Baer
	//die Methode ist in der Basisklasse selbst ebenfalls überschrieben
	@Override
	public String toString() {
		String ausgabe;
		//die Daten mit der Methode aus der übergeordneten Klasse beschaffen
		ausgabe = super.toString();
		ausgabe = ausgabe + " Kinder: " + anzahlKinder +"]";
		return ausgabe;
	}
}

public class Java06e_04_02 {
	public static void main(String[] args) {
		//einen Bären erzeugen
		Baer alterBaer = new Baer(200,3);
		//einen Papabären erzeugen
		ElternBaer papaBaer = new ElternBaer(500,5,20);

		//Werte über die Methoden ausgeben() anzeigen
		alterBaer.ausgeben();
		papaBaer.ausgeben();

		//und nun die kompakte Ausgabe über die überschriebene Methode toString()
		System.out.println(alterBaer.toString());
		System.out.println(papaBaer.toString());
	}
}
