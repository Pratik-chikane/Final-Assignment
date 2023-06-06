package assignment.FinalAssignment.CoreJava;

import java.util.List;
import java.util.stream.Collectors;

public class Q6 {
	public static void main(String[] args) {

		List<Integer> list1 = List.of(324,234,23,23,43,234,235,231,24,1,1,21,32,32,4,45,56,98);

		List<Integer> list2 = list1.stream().filter(l -> l % 2 == 0).sorted((i1, i2) -> i1.compareTo(i2))
				.collect(Collectors.toList());
		list2.forEach(i -> System.out.println(i));
	}
}