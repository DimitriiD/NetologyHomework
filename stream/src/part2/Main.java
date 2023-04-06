package part2;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Collection<Person> persons = new ArrayList<>();
        generatePersonList(persons);
        System.out.println(persons.stream().filter(x -> x.getAge() < 18).count());
        List<String> secondNameArmy = persons.stream()
                .filter(x -> x.getAge() >= 18 && x.getAge() <= 27)
                .map(x -> x.getFamily())
                .collect(Collectors.toList());
        System.out.println(secondNameArmy.stream().limit(200).collect(Collectors.toList()));
        Collection<Person> personsWork = persons.stream().filter(x -> x.getEducation() == Education.HIGHER)
                .filter(x -> x.getAge() >= 18 && x.getAge() <= 65)
                .filter(x -> !(x.getSex() == Sex.WOMAN && x.getAge() > 60))
                .collect(Collectors.toList());
        personsWork.stream().limit(200).forEach(System.out::println);

    }

    /*Получить отсортированный по фамилии список потенциально работоспособных людей с высшим образованием в выборке (т.е. людей с высшим образованием от 18 до 60 лет для женщин и до 65 лет для мужчин).*/
    public static void generatePersonList(Collection<Person> persons) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
    }
}
