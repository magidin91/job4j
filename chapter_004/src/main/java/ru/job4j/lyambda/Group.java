package ru.job4j.lyambda;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Group {

    public static Map<String, Set<String>> sections(List<Student> students) {
        // преобразуем поток Student-ов в поток Holder-ов
        return students.stream().flatMap(student -> student.getUnits().stream().map(unit -> new Holder(unit, student.getName()))
        ).collect(// собираем карту
                Collectors.groupingBy(holder -> holder.key, // в качестве ключей используем назв-ия секций
                        Collector.of(//определяем коллектор для value в виде HashSet имен учеников
                                HashSet::new, // функция создания объекта для хранения элемента
                                (set, el) -> set.add(el.value), // функция добавления элемента в набор
                                (left, right) -> {
                                    left.addAll(right);
                                    return left;  // функции агрегации наборов;
                                }
                        )
                )
        );

    }
}