package bowling;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private static final String scoreBoard = " 1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |  10  ";
	private static final String NEW_LINE = System.getProperty("line.separator");
	private List<Player> players = new ArrayList<Player>();
	
	public Board(int numOfPlayers) {
		for (int i = 0; i < numOfPlayers; i++) {
			players.add(new Player());
		}
	}

	public int getNumOfPlayers() {
		return players.size();
	}

	public List<Player> getPlayers() {
		return players;
	}
	
	public void calculTotalFrameScore(Player player) {
		List<Frame> frames = player.getFrames();
		Frame frame;
		int curScore;
		for (int i = 0; i < frames.size(); i++) {
			frame = frames.get(i);
			List<Integer> scores = frame.getScores();
			// strike
			if (scores.size() == 1 && frame.getFrameScore() == 10) {
				if (i+1 < frames.size()) {
					Frame nextFrame = frames.get(i+1);
					// not consecutive strike
					if (nextFrame.getScores().size() == 2) {
//						frame.addBonusScoreToFrame(nextFrame.getFrameScore());
						player.setCalculatedFrameScores(frame.getFrameScore() + nextFrame.getFrameScore());
					} 
					// consecutive strike
					else if (nextFrame.getScores().size() == 1 && nextFrame.getFrameScore() == 10) {
						if (i+2 < frames.size()) {
							Frame dNextFrame = frames.get(i+2);
							player.setCalculatedFrameScores(frame.getFrameScore() + nextFrame.getFrameScore() + dNextFrame.getScores().get(0));
						}
					}
				}
			}
			// spare
			else if (scores.size() == 2 && frame.getFrameScore() == 10) {
				if (i+1 < frames.size()) {
					Frame nextFrame = frames.get(i+1);
					player.setCalculatedFrameScores(frame.getFrameScore() + nextFrame.getScores().get(0));
				}
			}
			// normal
			else if (scores.size() == 2) {
				player.setCalculatedFrameScores(frame.getFrameScore());
			}
		}
	}

	public String showScoreOf(Player player) {
		this.calculTotalFrameScore(player);
		String temp = scoreBoard + NEW_LINE;
		for (Frame frame : player.getFrames()) {
			for (Integer score : frame.getScores()) {
				temp += Integer.toString(score) + '|' +' ';
				if (frame.getScores().size() == 1 && frame.getScores().get(0) == 10) {
					temp += "| ";
				}
			}
		}
		temp += NEW_LINE;
		for (Integer frameScore : player.getCalculatedFrameScores()) {
			if (frameScore/100 == 0) temp += ' ' + Integer.toString(frameScore) + " | ";
			else temp += Integer.toString(frameScore) + " | ";
		}
		return temp;
	}
}
