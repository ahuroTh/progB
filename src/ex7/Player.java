package ex7;
/*
 * 課題の目的：
 * 抽象クラス，ポリモルフィズム
 */

// 課題：下記プログラム中の...（1箇所）を埋めてプログラムを完成させよ。
// 実行すると下記が出力される：
// play-text How are you?
// play-audio Good morning.
// play-audio Good evening.

abstract class Player {
	public abstract void play();

	public void loop(int n) {
		for (int i = 0; i < n; i++) {
			play();
		}
	}
}

class TextPlayer extends Player {
	String text;

	public TextPlayer(String text) {
		this.text = text;
	}

	@Override
	public void play() {
		System.out.println("play-text " + text);
	}

	@Override
	public String toString() {
		return "play-text " + text;
	}

}

class AudioPlayer extends Player {
	String audio;
	// (1) ...
	public AudioPlayer(String audio) {
		this.audio = audio;
	}
	@Override
	public void play() {
		System.out.println("play-audio " +audio);
	}
	@Override
	public String toString() {
		return "play-audio " + audio;
		}
	}





class PlayerTest {
	public static void main(String[] args) {
		// ポリモルフィズム
		Player[] player = new Player[3];
		player[0] = new TextPlayer("How are you?");
		player[1] = new AudioPlayer("Good morning.");
		player[2] = new AudioPlayer("Good evening.");
		for (int i = 0; i < player.length; i++) {
			player[i].play();
			switch (i) {
			case 0:
				assert player[i].toString().equals("play-text How are you?");
				break;
			case 1:
				assert player[i].toString().equals("play-audio Good morning.");
				break;
			case 2:
				assert player[i].toString().equals("play-audio Good evening.");
				break;
			}
		}
	}

}
