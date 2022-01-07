package torpedo.persistence.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import torpedo.model.GamerVO;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JdbcPlayerRepositoryTest {

    private JdbcPlayerRepository jdbcPlayerRepositoryUnderTest;
    private Connection connection;

    @BeforeEach
    void setUp() throws Exception {
        jdbcPlayerRepositoryUnderTest = new JdbcPlayerRepository(new GamerVO("player1", 0));
        connection = Mockito.mock(Connection.class);
    }

    @Test
    void testAddPlayer() {
        // Given
        final GamerVO gamerVO = new GamerVO("player1", 0);

        // When
        jdbcPlayerRepositoryUnderTest.addPlayer(gamerVO);
    }

    @Test
    void testModPlayer() {
        // Given
        final GamerVO gamerVO = new GamerVO("player1", 0);

        // When
        jdbcPlayerRepositoryUnderTest.modPlayer(gamerVO);
    }

    @Test
    void testClose() throws Exception {
        // When
        jdbcPlayerRepositoryUnderTest.close();
    }

    @Test
    void testReadPlayer() {
        // Given
        final GamerVO expectedResult = new GamerVO("player1", 0);

        // When
        final GamerVO result = jdbcPlayerRepositoryUnderTest.readPlayer();

        // Then
        assertEquals(expectedResult, result);
    }

    @Test
    public void testCloseShouldCloseConnection() throws Exception {
        // When
        connection.close();

        // Then
        Mockito.verify(connection).close();
        Mockito.verifyNoMoreInteractions(connection);
    }
}
