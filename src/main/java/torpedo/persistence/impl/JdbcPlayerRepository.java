package torpedo.persistence.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import torpedo.model.GamerVO;
import torpedo.persistence.PlayerRepository;

/**
 * This Class implements the database of the game.
 *
 * @author István Szabó
 */
public class JdbcPlayerRepository implements PlayerRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcPlayerRepository.class);

    static final String INSERT_STATEMENT = "INSERT INTO GAME_POINTLIST (NAME, POINT) VALUES (?, ?);";
    static final String SELECT_STATEMENT = "SELECT * FROM GAME_POINTLIST WHERE 1 ORDER BY POINT *DESC;";
    static final String UPDATE_STATEMENT = "UPDATE GAME_POINTLIST SET POINT = ? WHERE NAME = ?;";

    Connection connection = DriverManager.getConnection("jdbc:h2:./db./torpedo", "sz", "i");

    private GamerVO gamerVO;

    public JdbcPlayerRepository(GamerVO gamerVO) throws SQLException {
        this.gamerVO = gamerVO;
    }

    @Override
    public void addPlayer(GamerVO gamerVO, int Point) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STATEMENT)) {
            preparedStatement.setString(1, gamerVO.getName());
            preparedStatement.setString(2, String.valueOf(gamerVO.getPoint()));
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            LOGGER.debug(String.valueOf(throwables));
        }
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }

    @Override
    public void modPlayer(GamerVO gamerVO, int Point) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STATEMENT)) {
                preparedStatement.setString(1, gamerVO.getName());
                preparedStatement.setString(2, String.valueOf(gamerVO.getPoint()));
                preparedStatement.executeUpdate();

            } catch (SQLException throwables) {
                LOGGER.debug(String.valueOf(throwables));
            }
    }

    @Override
    public GamerVO readPlayer() {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STATEMENT)) {
            preparedStatement.setString(1, gamerVO.getName());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                gamerVO.setPoint(resultSet.getInt("Started"));
            }
        } catch (SQLException throwables) {
            LOGGER.debug(String.valueOf(throwables));
        }
        return gamerVO;
    }
}
