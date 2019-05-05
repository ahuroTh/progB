package ex7;

/*
 * 課題の目的：
 * インターフェース
 */

// 課題：下記プログラム中の...の部分（3箇所）を埋めてプログラムを完成させよ。
// 出力は下記となる：
// Play-text How are you?
// Send-text How are you?
// play-audio Good morning.
// Send-audio Good morning.
// play-audio Good evening.
// Send-audio Good evening.

interface PlayerI {
	public void play();
}

interface SenderI {
	public void send();

	public void play();
}

class TextPlayer2 implements PlayerI, SenderI {
	String text;

	public TextPlayer2(String text) {
		this.text = text;
	}

	@Override
	public void play() {
		System.out.println("Play-text " + text);
	}

	@Override
	public void send() {
		System.out.println("Send-text " + text);
	}
}

class AudioPlayer2 implements PlayerI, SenderI {
	String audio;

	public AudioPlayer2(String audio) {
		this.audio = audio;
	}

	// (1) ...
	@Override
	public void play() {
		System.out.println("Play-audio " + audio);
	}

	@Override
	public void send() {
		System.out.println("Send-audio " + audio);
	}

}

class PlayerTest2 {
	public static void main(String[] args) {
		PlayerI[] player = new PlayerI[3];
		// (2) ...
		SenderI[] sender = new SenderI[3];

		for (int i = 0; i < player.length; i++) {
			// (3) ...
			player[0] = new TextPlayer2("How are you?");
			player[1] = new AudioPlayer2("Good morning.");
			player[2] = new AudioPlayer2("Good evening.");
			sender[0] = new TextPlayer2("How are you?");
			sender[1] = new AudioPlayer2("Good morning.");
			sender[2] = new AudioPlayer2("Good evening.");

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
			sender[i].send();
			switch (i) {
			case 0:
				assert sender[i].toString().equals("send-text How are you?");
				break;
			case 1:
				assert sender[i].toString().equals("send-audio Good morning.");
				break;
			case 2:
				assert sender[i].toString().equals("send-audio Good evening.");
				break;
			}

		}
	}
}
