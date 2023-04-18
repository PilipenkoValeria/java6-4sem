package ru.omsu;

import java.util.*;

public class ListDemo {
    //2)Напишите метода класса ListDemo, который получает на вход список объектов типа Human
    //и еще один объект типа Human. Результат — список однофамильцев заданного человека
    //среди людей из входного списка.
    public static ArrayList<Human> listOfNamesakes(ArrayList<Human> listOfPeople, Human people) {
        ArrayList<Human> listOfNamesakes = new ArrayList<>();
        for (Human human : listOfPeople) {
            if (human.getSurname().equals(people.getSurname())) {
                listOfNamesakes.add(human);
            }
        }
        return listOfNamesakes;
    }

    //3)Вход: список объектов типа Human и еще один объект типа Human. Выход — копия
    //входного списка, не содержащая выделенного человека. При изменении элементов
    //входного списка элементы выходного изменяться не должны.
    public static ArrayList<Human> listWithoutAPeople(ArrayList<Human> listOfPeople, Human people) {
        ArrayList<Human> listWithoutAPeople = new ArrayList<>(listOfPeople);
        for (Human human : listOfPeople) {
            if (human.equals(people)) {
                listWithoutAPeople.remove(human);
            }
        }
        return listWithoutAPeople;
    }

    //4)Вход: список множеств целых чисел и еще одно множество. Выход: список всех множеств
    //входного списка, которые не пересекаются с заданным множеством.
    public static ArrayList<Set<Integer>> disjointSets(ArrayList<Set<Integer>> listOfSets, Set<Integer> set) {
        ArrayList<Set<Integer>> disjointSets = new ArrayList<>(listOfSets);
        for (Set<Integer> i : listOfSets) {
            if (i.removeAll(set)) {
                disjointSets.remove(i);
            }
        }
        return disjointSets;
    }

    //5)Напишите метод класса ListDemo, который получает на вход список, состоящий из
    //объектов типа Human и его производных классов. Результат — множество людей из
    //входного списка с максимальным возрастом.
    public static Set<Human> listMaxAge(ArrayList<Human> list) {
        int maxAge = 0;
        Set<Human> setMaxAge = new HashSet<Human>();
        for (Human human : list) {
            if (human.getAge() > maxAge) {
                maxAge = human.getAge();
            }
        }
        for (Human human : list) {
            if (human.getAge() == maxAge) {
                setMaxAge.add(human);
            }
        }
        return setMaxAge;
    }

    //7)Имеется набор людей, каждому человеку задан уникальный целочисленный
    //идентификатор. Напишите метод, который получает на вход отображение (Map)
    //целочисленных идентификаторов в объекты типа Human и множество целых чисел.
    //Результат — множество людей, идентификаторы которых содержатся во входном
    //множестве.
    public static Set<Human> listIdPeople(Map<Integer, Human> idPeople, Set<Integer> id) {
        Set<Human> peopleId = new HashSet<>();
        for (Integer key : id) {
            if (idPeople.containsKey(key)) {
                peopleId.add(idPeople.get(key));
            }
        }
        return peopleId;
    }

    //8)Для отображения из задачи 7 постройте список идентификаторов людей, чей возраст не
    //менее 18 лет.
    public static ArrayList<Integer> listOfAdults(Map<Integer, Human> idPeople) {
        ArrayList<Integer> id = new ArrayList<>();
        Set<Integer> key = idPeople.keySet();
        for (Integer k : key) {
            if (idPeople.get(k).getAge() >= 18) {
                id.add(k);
            }
        }
        return id;
    }

    //9)Для отображения из задачи 7 постройте новое отображение, которое идентификатору
    //сопоставляет возраст человека.
    public static Map<Integer, Integer> listIdAge(Map<Integer, Human> idPeople) {
        Map<Integer, Integer> idAge = new HashMap<>();
        Set<Integer> keys = idPeople.keySet();
        for (Integer id : keys) {
            idAge.put(id, idPeople.get(id).getAge());
        }
        return idAge;
    }

    //10)По множеству объектов типа Human постройте отображение, которое целому числу
    //(возраст человека) сопоставляет список всех людей данного возраста из входного
    //множества.
    public static Map<Integer, ArrayList<Human>> listAgeHuman(Set<Human> humans) {
        Map<Integer, ArrayList<Human>> ageHuman = new HashMap<>();
        for (Human human : humans) {
            ArrayList<Human> people = new ArrayList<>();
            if (ageHuman.containsKey(human.getAge())) {
                people = ageHuman.get(human.getAge());
            }
            people.add(human);
            ageHuman.put(human.getAge(), people);

        }
        return ageHuman;
    }

    /*//11)постройте отображение,которое возрасту сопоставляет новое отображение, которое букве алфавита сопоставляет
    //список всех людей из входного множества, имеющих данный возраст, и фамилия которых
    //начинается на эту букву. Т.е.(возраст ->(буква -> <список людей данного возраста с фамилией на эту букву>))
    //Списки внутри должны быть отсортированы по ФИО по убыванию.
    public static Map<Integer, Map<Character, ArrayList<Human>>> listAgeCharHuman(Set<Human> humans) {
        Map<Integer, ArrayList<Human>> mapAgeListHuman = listAgeHuman(humans);
        Map<Integer, Map<Character, ArrayList<Human>>> result = new HashMap<>();
        for (int age : mapAgeListHuman.keySet()) {
            Map<Character, ArrayList<Human>> mapCharListHuman = new HashMap<>();
            for (Human human : mapAgeListHuman.get(age)) {
                ArrayList<Human> humanList = new ArrayList<>();
                char firstLetter = human.getSurname().charAt(0);
                if (mapCharListHuman.containsKey(firstLetter)) {
                    humanList = mapCharListHuman.get(firstLetter);
                }
                humanList.add(human);
                mapCharListHuman.put(firstLetter, humanList);
                result.put(human.getAge(), mapCharListHuman);
            }
        }
        return result;
    }*/
}
