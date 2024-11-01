public class Main {
    public static void main(String[] args) {

        System.out.println("Задание 1. Калькулятор");
        System.out.println("2 + 3 = " + Calculator.sum(2, 3));
        System.out.println("2 - 3 = " + Calculator.substract(2, 3));
        System.out.println("2 * 3 = " + Calculator.multiply(2, 3));
        System.out.println("2 / 3 = " + Calculator.divide(2, 3));
        System.out.println("2 / 0 = " + Calculator.divide(2, 0));
        System.out.println();

        System.out.println("Задание 2. Сравнение массивов");
        Integer[] intArray1 = {1, 2, 3, 4, 5};
        Integer[] intArray2 = {1, 2, 3, 4, 5};
        Integer[] intArray3 = {1, 2, 3, 4};
        String[] stringArray1 = {"Я", "есть", "Грут"};
        String[] stringArray2 = {"Hello", "World", "!"};
        System.out.println("Одинаковые массивы: " + compareArrays(intArray1, intArray2));
        System.out.println("Массивы разной длины: " + compareArrays(intArray1, intArray3));
        System.out.println("Массивы разного типа: " + compareArrays(intArray1, stringArray1));
        System.out.println("Массивы разных значений: " + compareArrays(stringArray1, stringArray2));
        System.out.println();

        System.out.println("Задание 3. Пара разного типа");
        Pair pair1 = new Pair<>(1, 5.0);
        System.out.println(pair1);
        Pair pair2 = new Pair<>('A', "Ага!");
        System.out.println(pair2);
    }

    /* Задание 2. Напишите обобщенный метод compareArrays(), который принимает
    два массива и возвращает true, если они одинаковые, и false в противном случае.
    Массивы могут быть любого типа данных, но должны иметь одинаковую длину
    и содержать элементы одного типа попарно по индексам.
     */
    public static <T> boolean compareArrays(T[] array1, T[] array2) {
        // сравнение массивов на длину
        if (array1.length != array2.length) {
            return false;
        }

        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].getClass().equals(array2[i].getClass())) {
                return false;
            }
        }
        return true;
    }
}