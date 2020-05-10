package hu.unideb.inf.model.result;


import java.time.Duration;

public class GameResultExample {

    public static void main(String[] args) {
        GameResultDao gameResultDao = GameResultDao.getInstance();
        GameResult gameResult = GameResult.builder()
                .playerName("hassan")
                .win(true)
                .winCount(1)
                .build();
       // gameResultDao.persist(gameResult);
        System.out.println(gameResult);
        System.out.println(gameResultDao.findBest(5));
    }

}
