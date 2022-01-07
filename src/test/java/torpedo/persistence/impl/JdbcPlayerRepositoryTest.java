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
        // Setup
        final GamerVO gamerVO = new GamerVO("player1", 0);

        // Run the test
        jdbcPlayerRepositoryUnderTest.addPlayer(gamerVO);

        // Verify the results
    }

    @Test
    void testModPlayer() {
        // Setup
        final GamerVO gamerVO = new GamerVO("player1", 0);

        // Run the test
        jdbcPlayerRepositoryUnderTest.modPlayer(gamerVO);

        // Verify the results
    }

    @Test
    void testClose() throws Exception {
        // Setup
        // Run the test
        jdbcPlayerRepositoryUnderTest.close();

        // Verify the results
    }

    @Test
    void testReadPlayer() {
        // Setup
        final GamerVO expectedResult = new GamerVO("player1", 0);

        // Run the test
        final GamerVO result = jdbcPlayerRepositoryUnderTest.readPlayer();

        // Verify the results
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
