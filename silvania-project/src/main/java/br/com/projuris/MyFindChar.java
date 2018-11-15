package br.com.projuris;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/MyFindChar")
@RestController
public class MyFindChar implements FindCharachter {

	@RequestMapping(value = "/", method = RequestMethod.POST)
	char main(@RequestBody MyFindCharRestParams filtro)  {
		return findChar(filtro.getWord());
	}

	@Override
	public char findChar(String word) {
		List<String> base = Arrays.stream(word.split("")).collect(Collectors.toList());
		for (char a : word.toCharArray()) {
			String str = String.valueOf(a);
			if (base.stream().filter(s -> s.equals(str)).count() == 1) {
				return a;
			}
		}
		return ' ';
	}
}
