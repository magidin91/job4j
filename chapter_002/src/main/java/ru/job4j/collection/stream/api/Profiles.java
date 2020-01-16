package ru.job4j.collection.stream.api;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    List<Address> collect(List<Profile> profiles) {
        List<Address> all = profiles.stream().map(Profile::getAddress).collect(Collectors.toList());
        //Для этого чтобы обеспечить уникальность элементов,// используем метод Stream#distinct();
        List<Address> unique = all.stream().distinct().sorted(new Comparator<Address>() {
            @Override
            public int compare(Address o1, Address o2) {
                return o1.getCity().compareTo(o2.getCity());
            }
        }).collect(Collectors.toList());

        return  unique;
    }
}
