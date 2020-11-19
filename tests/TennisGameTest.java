import static org.junit.Assert.*;

import org.junit.Test;

public class TennisGameTest {
	
// Here is the format of the scores: "player1Score - player2Score"
// "love - love"
// "15 - 15"
// "30 - 30"
// "deuce"
// "15 - love", "love - 15"
// "30 - love", "love - 30"
// "40 - love", "love - 40"
// "30 - 15", "15 - 30"
// "40 - 15", "15 - 40"
// "player1 has advantage"
// "player2 has advantage"
// "player1 wins"
// "player2 wins"
	
	@Test
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore();
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		
	}
	
	@Test
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore();
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		// This statement should cause an exception
		game.player1Scored();			
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player2WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		// This statement should cause an exception
		game.player2Scored();			
	}
	
	// "15 - 15"
	@Test
	public void testTennisGame_1515() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player2Scored();
		
		String score = game.getScore();
		
		assertEquals("15 - 15 score incorrect", "15 - 15", score);
	}
		
	// "15 - love"
	@Test
	public void testTennisGame_15Love() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		
		String score = game.getScore();
		
		assertEquals("15 - love score incorrect", "15 - love", score);
	}
	
	// "love - 15"
	@Test
	public void testTennisGame_Love15() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		
		String score = game.getScore();
		
		assertEquals("love - 15 score incorrect", "love - 15", score);
	}
	
	// "30 - 15"
	@Test
	public void testTennisGame_3015() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		
		String score = game.getScore();
		
		assertEquals("30 - 15 score incorrect", "30 - 15", score);
	}
	
	// "15 - 30"
	@Test
	public void testTennisGame_1530() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		
		String score = game.getScore();
		
		assertEquals("15 - 30 score incorrect", "15 - 30", score);
	}
	
	// player1 has advantage
	@Test
	public void testTennisGame_Player1HasAdvantage() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		
		String score = game.getScore();
		
		assertEquals("Advantage score incorrect", "player1 has advantage", score);
	}
	
	// player2 has advantage
	@Test
	public void testTennisGame_Player2HasAdvantage() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		
		String score = game.getScore();
		
		assertEquals("Advantage score incorrect", "player2 has advantage", score);
	}
	
	// player1 wins
	@Test
	public void testTennisGame_Player1Wins() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		String score = game.getScore();
		
		assertEquals("Win score incorrect", "player1 wins", score);
	}
	
	// player2 wins
	@Test
	public void testTennisGame_Player2Wins() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		String score = game.getScore();
		
		assertEquals("Win score incorrect", "player2 wins", score);
	}
	
	// player1 has 4 points, but player2 has advantage
    @Test
    public void testTennisGame_Player1Has4PointsPlayer2HasAdvantage() throws TennisGameException {
        TennisGame game = new TennisGame();
        
        game.player1Scored();
        game.player2Scored();
        game.player1Scored();
        game.player2Scored();
        game.player1Scored();
        game.player2Scored();
        game.player1Scored();
        game.player2Scored();
        game.player2Scored();
        
        String score = game.getScore();
        
        assertEquals("Advantage score incorrect", "player2 has advantage", score);
    }
    
 // For mutation testing
    @Test
    public void mutationTesting1() throws TennisGameException {
        TennisGame game = new TennisGame();
        
        game.player1Scored();
        game.player1Scored();
        game.player1Scored();
        
        String score = game.getScore();
        
        assertEquals("40 - love score incorrect", "40 - love", score);
    }

    // For mutation testing
    @Test
    public void mutationTesting2() throws TennisGameException {
        TennisGame game = new TennisGame();
        
        game.player1Scored();
        game.player1Scored();
        game.player2Scored();
        game.player2Scored();
        game.player1Scored();
        game.player1Scored();
        
        
        String score = game.getScore();
        
        assertEquals("40 - 20 score incorrect", "player1 wins", score);
    }
    
    @Test
    public void mutationTesting3() throws TennisGameException {
        TennisGame game = new TennisGame();
        
        game.player2Scored();
        game.player2Scored();
        game.player1Scored();
        game.player1Scored();
        game.player2Scored();
        game.player2Scored();
        
        
        String score = game.getScore();
        
        assertEquals("20 - 40 score incorrect", "player2 wins", score);
    }



}
