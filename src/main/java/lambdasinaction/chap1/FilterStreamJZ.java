package lambdasinaction.chap1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FilterStreamJZ {

	public static void main(String... args) {
		// TODO Auto-generated method stub

		List<String> listStr = Arrays.asList("apple", "water melon", "banada");

		listStr.stream().filter(x -> x.length() == 5).forEach(x -> System.out.print(x + ", "));
		System.out.println("");
		listStr.stream().filter(x -> x.length() > 5).forEach(x -> System.out.print(x + ", "));

	}

}
