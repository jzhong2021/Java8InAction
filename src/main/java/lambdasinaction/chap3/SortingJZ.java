package lambdasinaction.chap3;

import java.util.Arrays;
import java.util.List;

public class SortingJZ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> listStr = Arrays.asList("applx", "water melon", "banada", "f1", "f12");
		System.out.println(listStr);	// [applx, water melon, banada, f1, f12]
		
		listStr.sort( (x,y)-> x.compareTo(y));
		System.out.println(listStr);	// [applx, banada, f1, f12, water melon]

		listStr.sort( (x, y)-> Integer.valueOf(x.length()).compareTo(Integer.valueOf(y.length())) );
		System.out.println(listStr);	// [f1, f12, applx, banada, water melon]
	}

}
