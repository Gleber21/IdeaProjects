package dz6;

import java.util.HashMap;
import java.util.Random;

public class Main {
    static final int numberOfIterations = 1000;
    static final int doorsNumber = 3;
    static HashMap<Integer, Boolean> resultsWithSameDoor;
    static HashMap<Integer, Boolean> resultsWithOtherDoor;
    public static void main(String[] args) {
        Game game = new Game(doorsNumber);
        resultsWithSameDoor = game.start(false);
        resultsWithOtherDoor = game.start(true);
        System.out.println("Статистика при отказе от изменения двери:");
        System.out.println("Доля выигрыша: " + game.calcTruePercent(resultsWithSameDoor) + "%");
        System.out.println("Статистика при изменении двери:");
        System.out.println("Доля выигрыша: " + game.calcTruePercent(resultsWithOtherDoor) + "%");
    }
}

class Game {
    Random random;
    int doorsNumber;

    public Game(int doorsNumber) {
        this.random = new Random();
        this.doorsNumber = doorsNumber;
    }

    /* Метод start() принимает выбор игрока либо всегда открывать первоначальную дверь,
    либо всегда открывать дверь предложенную ведущим. Дальше, на основе большого
    количества попыток (numberOfIterations) накапливвается статистика побед и поражений,
    которая возвращается в виде HashMap<Integer, Boolean>
     */
    HashMap<Integer, Boolean> start(boolean changeDoor) {
        HashMap<Integer, Boolean> result = new HashMap<>();
        for (int i = 0; i < Main.numberOfIterations; i++) {
            int win = random.nextInt(this.doorsNumber);
            int playerFirstChoice = random.nextInt(this.doorsNumber);
            if (!changeDoor) result.put(i, playerFirstChoice == win);
            else result.put(i, win != playerFirstChoice);
        }
        return result;
    }

    Integer calcTruePercent(HashMap<Integer, Boolean> resultMap) {
        int winStat = 0;
        for (HashMap.Entry<Integer, Boolean> entry : resultMap.entrySet()) {
            if (entry.getValue()) {
                winStat++;
            }
        }
        return winStat * 100 / resultMap.size();
    }
}
