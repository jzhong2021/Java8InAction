package lambdasinaction.chap5;

import static lambdasinaction.chap4.Dish.menu;

import java.util.Optional;

public class FindingJZ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menu.stream()
		.filter(x->x.isVegetarian())
		.findAny()
		.ifPresent(x->System.out.println(x));
		
		menu.stream()
		.limit(5)
		.filter(x->x.isVegetarian())
		.findAny()
		.ifPresent(x->System.out.println(x));
		
		menu.stream()
		//.limit(5)
		//.filter(x->x.isVegetarian())
		.map(x->x.getCalories())
		.forEach(x->System.out.print(x+";"));
		System.out.println("");	
		
		int reducedMax =
		menu.stream()
		//.filter(x->x.isVegetarian())
		.map(x->x.getCalories())
		//.reduce(0, Integer::max);	//Good1
		//.reduce(0, Math::max);	//Good2
		//.reduce(0, (a,b)->(a >= b) ? a : b);	//Good3
		.reduce(-1, (a,b)->(a >= b) ? a : b);	//Good3
		//.reduce(null, (a,b)->(a >= b) ? a : b);	//Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.lang.Integer.intValue()" because "a" is null
		System.out.println("reducedMax="+reducedMax);	//reducedMax=800
		
		int reduced =
		menu.stream()
		.limit(2)
		//.filter(x->x.isVegetarian())
		.map(x->x.getCalories())
		.reduce(0, (x,y)->x+y);		
		System.out.println("reduced="+reduced);	//reduced=1500
		
		Optional<Integer> optReduced =
		menu.stream()
		.limit(2)
		//.filter(x->x.isVegetarian())
		.map(x->x.getCalories())
		.reduce((x,y)->x+y);		
		System.out.println("optReduced="+optReduced);	//optReduced=Optional[1500]
		System.out.println("optReduced="+optReduced.get());	//optReduced=1500
	}

}
