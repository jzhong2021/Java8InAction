package lambdasinaction.chap4;

import static java.util.Comparator.comparing;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamBasicJZ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dish.menu.stream()
		.filter(x -> x.isVegetarian())
		.sorted((x, y)-> Integer.valueOf(x.getCalories()).compareTo(Integer.valueOf(y.getCalories())))
		.map(x -> x.getName()+":"+x.getCalories())
		.forEach(System.out::println);

		System.out.println("");

		List<String> listNames =
		Dish.menu.stream()
		.filter(x -> !x.isVegetarian())
		.sorted(Comparator.comparing(Dish::getCalories))	//GOOD1
		.sorted(Comparator.comparing((Dish x)->x.getCalories()))	//GOOD2
		//.sorted( (Dish x)->x.getCalories() )
		.sorted(Comparator.comparing(x->x.getCalories()))	//GOOD3	Comparator.comparing(...) ---> compareTo(...)
		.map(x -> x.getName())
		.collect(Collectors.toList());

		listNames.forEach(System.out::println);
	}

}
