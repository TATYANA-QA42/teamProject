package ru.netology;

import java.util.HashMap;
import java.util.Map;

public class Player {
    private String name;

    /**
     * информация о том, в какую игру сколько часов было сыграно
     * ключ - игра
     * значение - суммарное количество часов игры в эту игру
     */
    private Map<Game, Integer> playedTime = new HashMap<>();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * добавление игры игроку
     * если игра уже была, никаких изменений происходить не должно
     */
    public void installGame(Game game) {
        if (playedTime.containsKey(game)) {
            playedTime.put(game, playedTime.get(game));
        } else {
            playedTime.put(game, 0);
        }

        // проверить работоспособность тестом, возможно включить проверку на если игра уже есть
//        game.getStore().containsGame(game);
//        Player player = new Player(getName());
//        for (int i = 0; i < playedTime.size(); i++) {
//
//        } {
//
//        }
//        playedTime.containsKey(game);
//            if (playedTime.containsKey(player)){
//                return;
//            }else {
//                playedTime.put(game, 0);
//            }
    }
    //playedTime.put(game, 0);

    // return;


    /**
     * игрок играет в игру game на протяжении hours часов
     * об этом нужно сообщить объекту-каталогу игр, откуда была установлена игра
     * также надо обновить значения в мапе игрока, добавив проигранное количество часов
     * возвращает суммарное количество часов, проигранное в эту игру.
     * если игра не была установлена, то надо выкидывать RuntimeException
     */
    public int play(Game game, int hours) {// предупреждение, цикл для поиска игр, отображение информации о часах в HASH

        game.getStore().addPlayTime(name, hours);
        if (playedTime.containsKey(game)) {
            playedTime.put(game, playedTime.get(game) + hours);
        } else {
            throw new RuntimeException("Игра не установлена");
        }
        return playedTime.get(game);
    }

    /**
     * Метод принимает жанр игры (одно из полей объекта игры) и
     * суммирует время, проигранное во все игры этого жанра этим игроком
     */
    public int sumGenre(String genre) { // проверить тестом, возможно дописать цикл на первый взгляд метод написан верно поправить условие иначе!
        int sum = 0;
        for (Game game : playedTime.keySet()) {
            if (game.getGenre().equals(genre)) {
                sum += playedTime.get(game);
            } //else {
            // sum = playedTime.get(game);
            // }
        }
        return sum;
    }

    /**
     * Метод принимает жанр и возвращает игру этого жанра, в которую играли больше всего
     * Если в игры этого жанра не играли, возвращается null
     */
    public Game mostPlayerByGenre(String genre) { // цикл на проверку условия и вывод
        int mostTime = 0; //наибольшее время
        Game gameMostTime = null; //игра с наибольшим временем
        for (Game game : playedTime.keySet()) { //берем игру со списка и проверяем ее на уловия
            if (game.getGenre().equals(genre)) { //условие подходит жанр или нет
                int timePlay = playedTime.get(game);//если подходит то мы создаем перенную время игры и приравниваем ее к времени которое было сыграно в эту игру
                if (timePlay > mostTime) { //сравниваем время сыгранное с наибольшим  временем
                    mostTime = timePlay;//приравниваем наибольшее время к сыгранному
                    gameMostTime = game;//присваиваем игре с наибольшим временем название игры которое прошло все улосвия
                }
            }
        }
        return gameMostTime;//возвращаем название игры которое прошло все условия или null если непрошло
    }
}