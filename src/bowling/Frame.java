package bowling;

import java.util.ArrayList;
import java.util.List;

public class Frame {
	private List<Integer> scores = new ArrayList<Integer>();
	private int frameScore;
	
	public List<Integer> getScores() {
		return scores;
	}
	
	public void setFrameScore() {
		int total = 0;
		for (Integer score : scores) {
			total += score;
		}
		this.frameScore = total;
	}
	
	public int getFrameScore() {
		return this.frameScore;
	}

	public void addScore(int numOfTumbledPins) {
		this.scores.add(numOfTumbledPins);
	}
}
