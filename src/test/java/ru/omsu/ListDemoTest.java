package ru.omsu;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.assertEquals;

public class ListDemoTest {
    private final ListDemo listDemo = new ListDemo();
    private final ArrayList<Human> listOfPeople = new ArrayList<>();
    private final Human human1 = new Human("Ivanov", "Alexandr", "Victorovich", 45);
    private final Human human2 = new Human("Shugaev", "Evgeny", "Igorevich", 35);
    private final Human human3 = new Human("Ivanov", "Oleg", "Alexandrovich", 27);
    private final Human human4 = new Human("Andreev", "Andrey", "Vladimirovich", 17);
    private final Human human5 = new Human("Andreev", "Ivan", "Olegovich", 35);
    private final Human human6 = new Human("Ivanov", "Victor", "Alexandrovich", 45);


    @Test
    public void listOfNamesakesTest() {//ex2
        ArrayList<Human> expected = new ArrayList<>();
        Collections.addAll(listOfPeople, human1, human2, human3, human4, human5, human6);
        Collections.addAll(expected, human1, human3, human6);
        assertEquals(expected, ListDemo.listOfNamesakes(listOfPeople, human1));
    }

    @Test
    public void listWithoutAPeopleTest() {//ex3
        ArrayList<Human> expected = new ArrayList<>();
        Collections.addAll(listOfPeople, human1, human2, human3, human4, human5, human6);
        Collections.addAll(expected, human2, human3, human4, human5, human6);
        assertEquals(expected, ListDemo.listWithoutAPeople(listOfPeople, human1));
    }

    @Test
    public void disjointSetsTest() {//ex4
        ArrayList<Set<Integer>> disjointSets = new ArrayList<>();
        ArrayList<Set<Integer>> expected = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();
        Set<Integer> set4 = new HashSet<>();
        Collections.addAll(set1, 1, 2, 3, 4, 5);
        Collections.addAll(set2, 2, 4, 6);
        Collections.addAll(set3, 1, 3, 5);
        Collections.addAll(set4, 7, 8, 9);
        Collections.addAll(disjointSets, set1, set2, set3);
        Collections.addAll(expected, set1, set2, set3);
        assertEquals(expected, ListDemo.disjointSets(disjointSets, set4));
    }

    @Test
    public void listMaxAgeTest() {//ex5
        Set<Human> expected = new HashSet<>();
        Collections.addAll(listOfPeople, human1, human2, human3, human4, human5, human6);
        Collections.addAll(expected, human1, human6);
        assertEquals(expected, ListDemo.listMaxAge(listOfPeople));
    }

    @Test
    public void listIdPeopleTest() {//ex6
        Map<Integer, Human> idPeople = new HashMap<>();
        Set<Integer> id = new HashSet<>();
        Set<Human> expected = new HashSet<>();
        Collections.addAll(id, 1, 2, 3);
        idPeople.put(1, human1);
        idPeople.put(2, human2);
        idPeople.put(3, human3);
        idPeople.put(4, human4);
        idPeople.put(5, human5);
        idPeople.put(6, human6);
        Collections.addAll(expected, human1, human2, human3);
        assertEquals(expected, ListDemo.listIdPeople(idPeople, id));
    }

    @Test
    public void listOfAdultsTest() {//ex8
        Map<Integer, Human> idPeople = new HashMap<>();
        ArrayList<Integer> expected = new ArrayList<>();
        idPeople.put(1, human1);
        idPeople.put(2, human2);
        idPeople.put(3, human3);
        idPeople.put(4, human4);
        idPeople.put(5, human5);
        idPeople.put(6, human6);
        Collections.addAll(expected, 1, 2, 3, 5, 6);
        assertEquals(expected, ListDemo.listOfAdults(idPeople));
    }

    @Test
    public void listIdAgeTest() {//ex9
        Map<Integer, Human> idPeople = new HashMap<>();
        Map<Integer, Integer> expected = new HashMap<>();
        idPeople.put(1, human1);
        idPeople.put(2, human2);
        idPeople.put(3, human3);
        idPeople.put(4, human4);
        idPeople.put(5, human5);
        idPeople.put(6, human6);
        expected.put(1, 45);
        expected.put(2, 35);
        expected.put(3, 27);
        expected.put(4, 17);
        expected.put(5, 35);
        expected.put(6, 45);
        assertEquals(expected, ListDemo.listIdAge(idPeople));

    }

    @Test
    public void testListAgeHuman() { //ex10
        Set<Human> humans = new HashSet<>();
        Map<Integer, ArrayList<Human>> expected = new HashMap<>();
        ArrayList<Human> list1 = new ArrayList<>();
        ArrayList<Human> list2 = new ArrayList<>();
        ArrayList<Human> list3 = new ArrayList<>();
        ArrayList<Human> list4 = new ArrayList<>();
        Collections.addAll(humans, human1, human2, human3, human4, human5, human6);
        Collections.addAll(list1, human1, human6);
        Collections.addAll(list2, human2, human5);
        Collections.addAll(list3, human3);
        Collections.addAll(list4,human4);
        expected.put(45, list1);
        expected.put(35, list2);
        expected.put(27, list3);
        expected.put(17,list4);
        assertEquals(expected, ListDemo.listAgeHuman(humans));
    }
}
