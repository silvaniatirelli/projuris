package br.com.projuris;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/MyFindArray")
@RestController
public class MyFindArray implements FindArray {

	@RequestMapping(value = "/", method = RequestMethod.POST)
	Integer main(@RequestBody MyFindArrayRestParams filtro)  {
		return findArray(filtro.getArray1(), filtro.getArray2());
	}

	@Override
	public int findArray(int[] array, int[] subArray) {
		List<Integer> base = Arrays.stream(array).boxed().collect(Collectors.toList());
		List<Integer> sub = Arrays.stream(subArray).boxed().collect(Collectors.toList());
		for (int a : array) {
			if (sub.contains(a)) {
				return base.lastIndexOf(a);
			}
		}
		return -1;
	}

}
