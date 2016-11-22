package dk.itu.chomsky.configurator.util;

import java.util.Scanner;

public class Utils {
	
	public static String getResource(Object obj, String fileName) {

		StringBuilder result = new StringBuilder();

		//Get file from resources folder
		ClassLoader classLoader = obj.getClass().getClassLoader();

		Scanner scanner = new Scanner(classLoader.getResourceAsStream(fileName));
		try {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				result.append(line).append("\n");
			}

		} finally {
			scanner.close();
		}

		return result.toString();

	 }

}
