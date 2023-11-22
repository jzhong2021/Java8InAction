package lambdasinaction.chap5;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MappingJZ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> words = Arrays.asList("hello", "world");

		words.stream()
		.map(s -> s.split("") )		// undefined: flatMap
		.forEach(s -> System.out.println(s));
		/* map
		 	[Ljava.lang.String;@6842775d
			[Ljava.lang.String;@5ecddf8f
		 */
		
		words.stream()
		.map(s -> Arrays.stream(s.split("")) )
		.forEach(s -> System.out.println(s));
		/*
		 	java.util.stream.ReferencePipeline$Head@59690aa4
			java.util.stream.ReferencePipeline$Head@6c629d6e
		 */

		words.stream()
		.flatMap(s -> Arrays.stream(s.split("")) )
		.distinct()
		.forEach(s -> System.out.print(s+" "));		//h e l o w r d
		System.out.println("");
		
		List<Integer> numbers1 = Arrays.asList(1,2,3);
		List<Integer> numbers2 = Arrays.asList(4,5);
		numbers1.stream()
		.flatMap(i -> numbers2.stream().map(j -> i*j))
		.forEach(x -> System.out.print(x+" "));		//4 5 8 10 12 15
		/* map
			java.util.stream.ReferencePipeline$3@768debd
			java.util.stream.ReferencePipeline$3@490d6c15
			java.util.stream.ReferencePipeline$3@7d4793a8		 
		 */
		
		List<Integer> numbers3 = Arrays.asList(1,4,2,5,3);
		Collections.sort(numbers3, (x,y)->Integer.compare(x, y));
		System.out.println("");
		numbers3.forEach(s -> System.out.print(s+"; "));
		System.out.println("");
		
	}

}
