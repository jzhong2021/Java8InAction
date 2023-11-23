package lambdasinaction.chap5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumericStreamsJZ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers1 = Arrays.asList(1,2,3);
		
		int iSum = numbers1.stream().mapToInt(x->x).sum();
		System.out.println(iSum);
		
		int iSum2 = numbers1.stream().mapToInt(x->1).sum();
		System.out.println(iSum2);
	}

}
