package torpedo.persistence;

import torpedo.model.GamerVO;

/**
 * This Interface stores the saves of the game.
 *
 * @author István Szabó
 */
public interface PlayerRepository {
    void addPlayer(GamerVO gamerVO, int point);

    void close() throws Exception;

    void modPlayer(GamerVO gamerVO, int point);

    GamerVO readPlayer();
}

