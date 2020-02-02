package ru.job4j.stream.api;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(Profile::getAddress).distinct().sorted((o1, o2) -> o1.getCity().compareTo(o2.getCity())).collect(Collectors.toList());
    }
}
