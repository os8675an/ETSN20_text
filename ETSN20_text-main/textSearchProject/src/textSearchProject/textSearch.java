package textSearchProject;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

public class textSearch {

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		String inputString = "";
		String testString = "search bee bee.txt";
//		while (!legitInput(inputString)) {
//			System.out.println("Enter a search query in the form: search pattern file");
//			inputString = scanner.nextLine();
//		}
		String inputString = testString;
		
		ArrayList<String> foundEntries = searchAlgorithm(inputString);
		reportFoundEntries(foundEntries);
	}


	private static boolean legitInput(String input) {
		String[] arr = input.split(" ");
		boolean isCorrectLength = arr.length == 3;
		if (isCorrectLength) {
			boolean isSearch = arr[0].equals("search");
			if (isSearch) {
				boolean isFile = arr[2].endsWith(".txt");
				if (isFile) {
					return true;
				}
			}
		}
		return false;

	}
	
	private static ArrayList<String> searchAlgorithm(String input) {
		String[] query = input.split(" ");
		
		File textFile = new File("src/textSearchProject/" + query[2]);
		System.out.println(textFile.getAbsolutePath());
		System.out.println(textFile.exists());
		ArrayList<String> searchList = new ArrayList<String>();
		Scanner scanText;
		if (textFile.exists()) {
			try {
				scanText = new Scanner(textFile);
				while (scanText.hasNextLine()) {
					String nextLine = scanText.nextLine();
					if (nextLine.contains(query[1])) {
						searchList.add(nextLine);
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		else {
			System.out.println("The file does not exist.");
		}
		return searchList;

	}
	private static void reportFoundEntries(ArrayList<String> foundEntries) {
		int i = 1; 
		for (String str : foundEntries) {
			System.out.println(i + " found line =         " + str);
			i++;
		}
	}



}
