package bowling;

import junit.framework.TestCase;

public class PlayerTest extends TestCase {
	Player player;

	@Override
	protected void setUp() throws Exception {
		player = new Player();
	}
	
	public void testSetScoreWhenStrike() throws Exception {
		player.roll(10);
		assertEquals(1, player.getCurrentFrame());
		player.roll(10);
		assertEquals(2, player.getCurrentFrame());
		assertEquals(10, (int)player.getFrames().get(player.getCurrentFrame()-1).getScores().get(0));
		assertEquals(10, (int)player.getFrames().get(player.getCurrentFrame()-1).getScores().get(0));
	}
	
	public void testSetScoreWheneverRoll() throws Exception {
		player.roll(9);
		assertEquals(1, player.getCurrentFrame());
		player.roll(1);
		assertEquals(1, player.getCurrentFrame());
		assertEquals(9, (int)player.getFrames().get(player.getCurrentFrame()-1).getScores().get(0));
		assertEquals(1, (int)player.getFrames().get(player.getCurrentFrame()-1).getScores().get(1));
		player.roll(2);
		assertEquals(2, player.getCurrentFrame());
		assertEquals(2, (int)player.getFrames().get(player.getCurrentFrame()-1).getScores().get(0));
	}
}
