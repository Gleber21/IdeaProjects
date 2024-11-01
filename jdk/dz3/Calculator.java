/* Задание 1. Написать класс Калькулятор (необобщенный), который содержит
обобщенные статические методы: sum(), multiply(), divide(), subtract().
Параметры этих методов – два числа разного типа, над которыми должна быть
произведена операция. Методы должны возвращать результат своей работы.
 */
public class Calculator {
    public static <T extends Number> double sum(T num1, T num2) {
        return num1.doubleValue() + num2.doubleValue();
    }

    public static <T extends Number> double substract(T num1, T num2) {
        return num1.doubleValue() - num2.doubleValue();
    }

    public static <T extends Number> double multiply(T num1, T num2) {
        return num1.doubleValue() * num2.doubleValue();
    }

    public static <T extends Number> double divide(T num1, T num2) {
        try {
            if (num2.doubleValue() == 0) {
                throw new ArithmeticException("Нельзя делить на zero!");
            }
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        return num1.doubleValue() / num2.doubleValue();
    }
}
