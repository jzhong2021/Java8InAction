package lambdasinaction.chap3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import lambdasinaction.chap3.Lambdas.Apple;

public class LambdasJZ {

	public static void main(String... args) {
		// TODO Auto-generated method stub
		List<String> listStr = Arrays.asList("applx", "water melon", "banada", "F1", "F12");

		filterJZ(listStr, x -> x.length() < 5);
		filterJZ(listStr, x -> x.length() == 5);
		filterJZ(listStr, x -> x.length() > 5);
		
		// No Generics
		filterJZNoGeneric(listStr, x -> x.length() < 5);
		filterJZNoGeneric(listStr, x -> x.length() == 5);
		filterJZNoGeneric(listStr, x -> x.length() > 5);
	}

	static void filterJZ(List<String> listStr, JZPredicate<String> p) {
		for (String str : listStr) {
			if (p.test(str))
				System.out.print(str + "; ");
		}
		System.out.println("");
	}

	static void filterJZNoGeneric(List<String> listStr, JZPredicateNoGenerics p) {
		for (String str : listStr) {
			if (p.test(str))
				System.out.print(str + "; ");
		}
		System.out.println("");
	}
	
	interface JZPredicate<T>{
		public boolean test(T t);
	}

	interface JZPredicatex<Tx>{
		public boolean test(Tx tx);
	}

	/* Warning: The type parameter String is hiding the type String
	 * A1: https://stackoverflow.com/questions/10178377/java-generics-the-type-parameter-string-is-hiding-the-type-string
	 * 		It thinks you're trying to create a type parameter -- a variable -- whose name is String. 
	 * 		In any event, if T is a type parameter of your interface -- which it probably should be
	 * A2:	https://zhidao.baidu.com/question/1888320960825028548.html
	 * 		你这里的String并不代表java.lang.String这个类，而是一个泛型名称，它代表传入这个方法的任何类型 
	 * 
	 * https://blog.csdn.net/cnds123/article/details/130605741
	 * Java中的泛型介绍
	 */
	interface JZPredicate2<String>{	
		public boolean test(String str);
	}
	
	interface JZPredicateNoGenerics{
		public boolean test(String t);
	}
	
}
