package words;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UniqueWords {
	public static void main(String[] args) {
		if (args.length != 2) {
	        System.out.println("Usage : java UniqueWords filename topNumberOccurences");
	        System.exit(1);
        }
		try {
			String fileContent = new String(Files.readAllBytes(Paths.get(args[0])), StandardCharsets.UTF_8);
			Map<String, Integer> words = new HashMap<String, Integer>();
			for (String word:  fileContent.trim().split(" ")) {
				System.out.println(word.length());
				words.put(word, words.containsKey(word) ? words.get(word) + 1 : 1);
			}
			words.entrySet()
				.stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.limit(Integer.parseInt(args[1]))
				.forEach(System.out::println);
		} catch (IOException e) {
			System.out.println("Couldn't find or open file " + args[0]);
		}
	}
}
