package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Plants;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		// NUMBER OF PLANTS
		System.out.println("How many plants would you like to insert?");
		int number = sc.nextInt();
		sc.nextLine();

		Plants[] plantsVect = new Plants[number];

		// INSERTION

		// COUNTER VARIABLES
		// Plant size counters
		int smallNumber = 0, mediumNumber = 0, largeNumber = 0;
		// total price counters
		double totalPrice = 0;
		// plant climate counters
		int tropicalCont = 0, subtropicalCont = 0, temperateCont = 0, coldCont = 0, dryCont = 0, unknownCont = 0;

		for (int i = 0; i < number; i++) {

			// NAME

			System.out.println("Type the name of the "+ (i+1) + "º plant");
			String plantName = sc.nextLine();

			// SIZE


			String size = null;

			do {
				System.out.println("Type the Size of the plant: S for Small, M for Medium, L for large");
				char sizeChar = sc.next().toUpperCase().charAt(0);
				sc.nextLine();

				switch (sizeChar) {
				case 'S':
					size = "Small";
					smallNumber++;
					break;
				case 'M':
					size = "Medium";
					mediumNumber++;
					break;
				case 'L':
					size = "Large";
					largeNumber++;
					break;
				default:
					System.out.println("Invalid option, please try again: ");
					break;
				}
			} while (size == null);

			// CLIMATE

			String climate = null;

			do {
				System.out.println("Type the ideal climate for this plant: TR for TROPICAL, SU for SUBTROPICAL,"
						+ " TE for TEMPERATE, CO for COLD CLIMATE, DR for DRY CLIMATE and X if you don't know:");
				String climateString = sc.nextLine().toUpperCase();

				switch (climateString) {

				case "TR":
					climate = "TROPICAL";
					tropicalCont++;
					break;
				case "SU":
					climate = "SUBTROPICAL";
					subtropicalCont++;
					break;
				case "TE":
					climate = "TEMPERATE";
					temperateCont++;
					break;
				case "CO":
					climate = "COLD";
					coldCont++;
					break;
				case "DR":
					climate = "DRY";
					dryCont++;
					break;
				case "X":
					climate = "UNKNOWN";
					unknownCont++;
					break;
				default:
					System.out.println("Invalid Option, please, try again.");
					break;

				}
			} while (climate == null);

			// PRICE

			System.out.println("How much does this plant cost?");
			double price = sc.nextDouble();
			sc.nextLine();

			totalPrice += price;

			// ESTANCIANDO:

			Plants thisPlant = new Plants(plantName, climate, size, price);
			plantsVect[i] = thisPlant;

		}

		// vetores secundarios de tamanho
		String[] nameSmallVect = new String[smallNumber];
		String[] nameMediumVect = new String[mediumNumber];
		String[] nameLargeVect = new String[largeNumber];

		// vetores secundarios de clima
		String[] nameTropicalVect = new String[tropicalCont];
		String[] nameSubtropicalVect = new String[subtropicalCont];
		String[] nameTemperateVect = new String[temperateCont];
		String[] nameDryVect = new String[dryCont];
		String[] nameColdVect = new String[coldCont];
		String[] nameUnknownVect = new String[unknownCont];

		// preenchendo os vetores

		int contsmall = 0, contmedium = 0, contlarge = 0;
		int contTro = 0, contSub = 0, contTemp = 0, contDry = 0, contCol = 0, contUnk = 0;
		for (int i = 0; i < number; i++) {
			switch (plantsVect[i].getSize()) {
			case "Small":
				nameSmallVect[contsmall++] = plantsVect[i].getPlantName();
				break;
			case "Medium":
				nameMediumVect[contmedium++] = plantsVect[i].getPlantName();
				break;
			case "Large":
				nameLargeVect[contlarge++] = plantsVect[i].getPlantName();
				break;
			}

			switch (plantsVect[i].getClimate()) {
			case "TROPICAL":
				nameTropicalVect[contTro++] = plantsVect[i].getPlantName();
				break;
			case "SUBTROPICAL":
				nameSubtropicalVect[contSub++] = plantsVect[i].getPlantName();
				break;
			case "TEMPERATE":
				nameTemperateVect[contTemp++] = plantsVect[i].getPlantName();
				break;
			case "DRY":
				nameDryVect[contDry++] = plantsVect[i].getPlantName();
				break;
			case "COLD":
				nameColdVect[contCol++] = plantsVect[i].getPlantName();
				break;
			case "UNKNOWN":
				nameUnknownVect[contUnk++] = plantsVect[i].getPlantName();
				;
			}
		}

		// IMPRIMINDO
		System.out.println("You have added " + plantsVect.length + " plants");

		printPrices(plantsVect, totalPrice);

		printCategorySize(nameSmallVect, nameMediumVect, nameLargeVect);

		printCategoryClimate(nameTropicalVect, nameSubtropicalVect, nameTemperateVect, nameDryVect, nameColdVect,
				nameUnknownVect);
		
		System.out.println();

		System.out.println("Thank you very much! :)");

		sc.close();

	}

	public static void printCategorySize(String[] smalll, String[] mediummm, String[] largeee) {
		System.out.println();
		System.out.println("PLANTS AND SIZES");
		System.out.println();
		if (smalll.length > 0) {
			printVectors(smalll, "Small Plants:");
		}
		if (mediummm.length > 0) {
			printVectors(mediummm, "Medium Plants");
		}
		if (largeee.length > 0) {
			printVectors(largeee, "Large Plants");
		}

	}

	public static void printCategoryClimate(String[] tropicalll, String[] subtropicalll, String[] temperateee,
			String[] dryyy, String[] colddd, String[] unknownnn) {
		System.out.println();
		System.out.println("PLANTS AND CLIMATES");
		System.out.println();

		if (tropicalll.length > 0) {
			printVectors(tropicalll, "Tropical Plants");
		}
		if (subtropicalll.length > 0) {
			printVectors(subtropicalll, "Subtropical Plants");
		}
		if (temperateee.length > 0) {
			printVectors(temperateee, "Temperate Climate Plants");
		}
		if (dryyy.length > 0) {
			printVectors(dryyy, "Dry Climate Plants");
		}
		if (colddd.length > 0) {
			printVectors(colddd, "Cold Climate Plants");
		}
		if (unknownnn.length > 0) {
			printVectors(unknownnn, "Unknown Climate Plants");
		}
	}

	public static void printVectors(String[] vect, String categoryName) {
		System.out.println("You have " + vect.length + " plants in the category: " + categoryName);
		for (int j = 0; j < vect.length; j++) {
			System.out.printf("%s", vect[j]);
			if (j < vect.length - 1) {
				System.out.print("-");
			}
		}
		System.out.println();

	}

	public static void printPrices(Plants[] vectorPlants, double finalprice) {
		for (int i = 0; i < vectorPlants.length; i++) {
			System.out.printf("%s costs: $ %.2f%n", vectorPlants[i].getPlantName(), vectorPlants[i].getPrice());
		}
		System.out.printf("%nTotal Price: $ %.2f %n%n.", finalprice);
		

	}

}
