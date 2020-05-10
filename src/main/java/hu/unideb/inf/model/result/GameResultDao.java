package hu.unideb.inf.model.result;

import hu.unideb.inf.jpa.GenericJpaDao;

import javax.persistence.Persistence;
import java.util.List;

/**
 * DAO class for the {@link GameResult} entity.
 */
public class GameResultDao extends GenericJpaDao<GameResult> {

    private static GameResultDao instance;

    private GameResultDao() {
        super(GameResult.class);
    }

    public static GameResultDao getInstance() {
        if (instance == null) {
            instance = new GameResultDao();
            instance.setEntityManager(Persistence.createEntityManagerFactory("persistance-1").createEntityManager());
        }
        return instance;
    }

    /**
     * Returns the list of {@code n} best results with respect to the number
     * of wins.
     *
     * @param n the maximum number of results to be returned
     * @return the list of {@code n} best results with respect to the number of wins
     * 
     */
    public List<GameResult> findBest(int n) {
        return entityManager.createQuery("SELECT r FROM GameResult r WHERE r.win = true and r.winCount > 0 ORDER BY r.winCount DESC",GameResult.class)
                .setMaxResults(n)
                .getResultList();
    }

}
