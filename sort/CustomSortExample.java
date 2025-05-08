package sort;

import java.util.*;

public class CustomSortExample {

    /**
     * 객체 리스트를 커스텀 정렬하는 예제
     */
    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "(" + name + ", " + age + ")";
        }
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 25));
        people.add(new Person("Bob", 20));
        people.add(new Person("Charlie", 23));
        people.add(new Person("David", 20));

        // 나이 오름차순 정렬
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                if (p1.age == p2.age) {
                    return p1.name.compareTo(p2.name); // 나이가 같으면 이름순
                }
                return p1.age - p2.age; // 나이 오름차순
            }
        });

        System.out.println(people);

        // 람다식으로 더 간단하게
        Collections.sort(people, (p1, p2) -> {
            if (p1.age == p2.age) {
                return p1.name.compareTo(p2.name);
            }
            return p1.age - p2.age;
        });

        System.out.println(people);
    }
}
