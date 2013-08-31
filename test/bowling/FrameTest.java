package bowling;

import junit.framework.TestCase;

public class FrameTest extends TestCase {
	public void testAddScoreToFrame() throws Exception {
		Frame frame = new Frame();
		frame.getScores().add(10);
		frame.getScores().add(9);
		assertEquals(10, (int)frame.getScores().get(0));
		assertEquals(9, (int)frame.getScores().get(1));
	}
}
