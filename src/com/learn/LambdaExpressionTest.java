package com.learn;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/*
 * This class demonstrate use of functional interface and lambda expression.
 */
/**
 * @author atagrawal
 *
 */
public class LambdaExpressionTest {
	public static void main(String args[]) {
		print("Atul", (p) -> System.out.println("Hello " + p));

		check(100, (p) -> p >= 100);
		check(50, (p) -> p >= 100);

		System.out.println(square(100, t -> {
			return t * t;
		}));

	}

	public static void print(String val, Consumer<String> consumer) {
		consumer.accept(val);
	}

	public static void check(Integer val, Predicate<Integer> predicate) {
		System.out.println(predicate.test(val));
	}

	public static Integer square(Integer val,
			Function<Integer, Integer> function) {
		return function.apply(val);
	}
}
