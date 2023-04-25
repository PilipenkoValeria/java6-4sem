package ru.omsu;

import java.util.ArrayList;
import java.util.List;

public class CollectionsDemo {
    //1)Вход: список строк и символ. Выход: количество строк входного списка, у которых первый
    //символ совпадает с заданным.
    public int numberRowsWithCharacter(List<String> list, char a){
        int sum = 0;
        for (String str: list){
            if(str.startsWith(String.valueOf(a))){
                sum++;
            }
        }
        return sum;
    }
}
