package MegaputerIntelligence;

import java.util.ArrayList;
import java.util.Random;

/**
 * Имеется массив из 1 млн вещественных чисел, расположенных по возрастанию. Целые части уникальны.
 * Одна из них равна номеру индекса на котором оно находится. Нужно найти его. Написать тесты к предлагаемому решению.
 */

public class NumSearch
{
    private ArrayList<Double> massive;
    public static final int N = 1_000_000;

    /**
     * Binary search of an element which index equals to the integer part of it's value
     * from sorted massive of real numbers generated due to the conditions of the task.
     * @param massive
     * @return index of the element in the massive
     */
    public int findNumber(ArrayList<Double> massive){
        int index = -1;
        if(massive.size() != 0){
            int low = 0;
            int high = massive.size();
            int middle;
            while(low < high){
                middle = (low + high)/2;
                int value = massive.get(middle).intValue();
                if(value == middle) {
                    index = middle;
                    break;
                } else {
                    if(middle < value)
                        high = middle;
                    else
                        low = middle + 1;
                }
            }
        }
        return index;
    }

    /**
     * Simple massive generator of real numbers where indexes of elements doesn't equal to the integer parts of their values.
     * Values starts with 'from' and increments while we get 'N' items.
     * 'from' can't be equal to 0 because indexes of elements shouldn't be equal to the integer parts of their values.
     * So, we get sorted massive of real numbers due to the task.
     * @param from - number from which the increase of values begins
     * @return sorted massive
     */
    public static ArrayList<Double> generateMassive(int from) {
        if(from != 0) {
            ArrayList<Double> mas = new ArrayList<>();
            Random r = new Random();
            int index = from;
            while (mas.size() != N) {
                Double val = index + r.nextDouble();
                mas.add(val);
                ++index;
            }
            return mas;
        } else throw new IllegalArgumentException("'from' can't be equal to 0");
    }

    public ArrayList<Double> getMassive() {
        return massive;
    }

    public void setMassive(ArrayList<Double> massive) {
        this.massive = massive;
    }
}
