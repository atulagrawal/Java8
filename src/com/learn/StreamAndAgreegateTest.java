package com.learn;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * This class demonstrate the use of stream and aggregates
 * @author atagrawal
 *
 */
public class StreamAndAgreegateTest {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(2000);
		list.add(15);
		list.add(124);
		list.add(2);
		list.add(214);
		list.add(1241241);
		list.add(123);
		

		list.stream().filter(p->p>100).map(p->p*100).forEach(p-> System.out.println(p));
		
		//break down of above statement
		
		//create stream
		Stream<Integer> stream = list.stream();
		
		Predicate<Integer> predicate = p-> p>100;
		//apply predicate
		stream = stream.filter(predicate);
		
		Function<Integer,Integer> function = p-> p*100;
		//do the mapping
		stream = stream.map(function);
		
		Consumer consumer = p-> System.out.println(p);
		//consume
		stream.forEach(consumer);
		
		System.out.println("Custom Stream");
		CustomStream<Integer> customStream = new CustomStream(list);
		customStream.filter(p->p>100).map(p->p*100).forEach(p->System.out.println(p));
		
	}

}


/**
 * This is a customized stream class.
 * @author atagrawal
 *
 * @param <T>
 */
class CustomStream<T> {
	List<T> list;
	public CustomStream(List<T> list) {
		this.list = list;
	}
	
	public CustomStream<T> filter(Predicate<T> predicate) {
		List<T> internalList = new ArrayList<T>();
		for (T t : list) {
			if(predicate.test(t)) {
				internalList.add(t);
			}
		}
		
		return new CustomStream(internalList);
	}
	
	public CustomStream<T> map(Function<T,T> function) {
		List<T> internalList = new ArrayList<T>();
		for (T t : list) {
			internalList.add(function.apply(t));
		}
		
		return new CustomStream(internalList);
	}
	
	public void forEach(Consumer<T> consumer) {
		for (T t : list) {
			consumer.accept(t);
		}
	}
	
	
}
