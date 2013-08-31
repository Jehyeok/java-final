package bowling;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private int curFrame;
	private int rollNum;
	private List<Frame> frames = new ArrayList<Frame>();
	private List<Integer> frameScores = new ArrayList<Integer>();
	private int curScore;
	private int curCalculatedFrameScore;
	
	public void roll(int tumbledPins) {
		if (isEven() || curScore == 10) {
			curFrame++;
			this.frames.add(new Frame());
			rollNum = 0;
		}
		rollNum++;
		curScore = tumbledPins;
		this.frames.get(curFrame-1).addScore(curScore);
		this.frames.get(curFrame-1).setFrameScore();
	}

	private boolean isEven() {
		return this.rollNum % 2 == 0;
	}
	
	public int getCurrentFrame() {
		return curFrame;
	}
	
	private int getNumOfTumbledPins() {
		return 10;
	}

	public List<Frame> getFrames() {
		return frames;
	}

	public List<Integer> getCalculatedFrameScores() {
		return frameScores;
	}

	public int setCalculatedFrameScores(int score) {
		curCalculatedFrameScore += score;
		this.frameScores.add(this.curCalculatedFrameScore);
		return score;
	}
	
}
