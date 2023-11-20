package lambdasinaction.chap1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FilterJZ {

	public static void main(String... args) {
		// TODO Auto-generated method stub
		List<String> listStr = Arrays.asList("apple", "water melon", "banada", "F1", "F12");

		filterJZ(listStr, x -> x.length() < 5);
		filterJZ(listStr, x -> x.length() == 5);
		filterJZ(listStr, x -> x.length() > 5);
	}

	static void filterJZ(List<String> listStr, Predicate<String> p) {
		for (String str : listStr) {
			if (p.test(str))
				System.out.print(str + "; ");
		}
		System.out.println("");
	}

}
