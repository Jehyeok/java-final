package bowling;
import junit.framework.TestCase;

public class BoardTest extends TestCase {
	Board board;
	
	@Override
	protected void setUp() throws Exception {
		board = new Board(3); // 3은 플레이어 수
	}
	
	public void testInitBoard() throws Exception {
		assertEquals(3, board.getNumOfPlayers());
	}
	
	public void testCalculateFrameScore() throws Exception {
		Player player = board.getPlayers().get(0);
		player.roll(8);
		player.roll(1);
		board.calculTotalFrameScore(player);
		assertEquals(9, (int)player.getCalculatedFrameScores().get(0));
	}
	
	public void testCalculateFrameScoreWhenStrike() throws Exception {
		Player player = board.getPlayers().get(0);
		player.roll(10);
		player.roll(10);
		player.roll(1);
		player.roll(2);
		board.calculTotalFrameScore(player);
		assertEquals(21, (int)player.getCalculatedFrameScores().get(0));
	}
	
	public void testCalculateFrameScoreWhenSpare() throws Exception {
		Player player = board.getPlayers().get(0);
		player.roll(9);
		player.roll(1);
		player.roll(1);
		player.roll(2);
		board.calculTotalFrameScore(player);
		assertEquals(11, (int)player.getCalculatedFrameScores().get(0));
	}
	
	public void testShowScoreBoard() throws Exception {
		Player player = board.getPlayers().get(0);
		player.roll(9);
		player.roll(1);
		player.roll(8);
		player.roll(0);
		player.roll(10);
		player.roll(10);
		player.roll(8);
		player.roll(0);
		player.roll(10);
		player.roll(8);
		player.roll(1);
		player.roll(9);
		player.roll(1);
		player.roll(8);
		player.roll(1);
		player.roll(10);
		player.roll(9);
		player.roll(1);
		System.out.println(board.showScoreOf(player));
	}
}