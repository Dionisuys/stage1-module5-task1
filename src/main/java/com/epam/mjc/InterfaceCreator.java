package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> x.stream().allMatch(s -> Character.isUpperCase(s.charAt(0)));
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> evenValue = x.stream()
                    .filter(n -> n % 2 == 0)
                    .collect(Collectors.toList());
            x.addAll(evenValue);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            return  values.stream()
                    .filter(s -> Character.isUpperCase(s.charAt(0)))
                    .filter(s -> s.endsWith("."))
                    .filter(s -> s.split(" ").length > 3)
                    .collect(Collectors.toList());
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            return x.stream()
                    .collect(Collectors.toMap(String::toString, String::length));
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> result = new ArrayList<>();
            result.addAll(list1);
            result.addAll(list2);
            return result;
        };
    }
}
