package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> menu;
    Random random;
    int numberOfCombos;
    ArrayList<String> combos;

    DinnerConstructor() {
        menu = new HashMap<>();
        random = new Random();
    }

    public void addNewDish(String dishType, String dishName) {
        ArrayList<String> dishes = menu.get(dishType);
        if (dishes == null) {
            dishes = new ArrayList<>();
        }
        dishes.add(dishName);
        menu.put(dishType, dishes);
    }

    public void printCombo() {
        if (numberOfCombos == 0 || combos.isEmpty() ) {
            System.out.println("Не сформирован список для комбинаций");
            return;
        }

        for (int i = 0; i < numberOfCombos; i++) {
            System.out.println("Комбо " + (i + 1));
            //сделал final, но не понимаю смысл этого именно тут, буду благодарен, если объясните
            final ArrayList<String> comboPrint = new ArrayList<>();
            for (String dishType : combos) {
                ArrayList<String> dishes = menu.get(dishType);
                int randomIndex = random.nextInt(dishes.size());
                String dish = dishes.get(randomIndex);
                comboPrint.add(dish);
            }
            System.out.println(comboPrint);
        }
    }

    public void addComboDishType(String dishType) {
        ArrayList<String> dishes = menu.get(dishType);
        if (dishes == null) {
            System.out.println("Типа блюд " + dishType + " не существует");
            return;
        }
        combos.add(dishType);
    }

    public void setNumberOfCombos(int numberOfCombos) {
        this.numberOfCombos = numberOfCombos;
        combos = new ArrayList<>();
    }

    public boolean isEmptyMenu() {
        return menu.isEmpty();
    }
}
