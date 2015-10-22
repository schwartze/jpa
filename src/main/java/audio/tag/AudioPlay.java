package audio.tag;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioPlay {
	public static void main ( String[] args ) throws FileNotFoundException {
		//Sound sound = new Sound( "/Users/Alchemist/Desktop/finished.wav", false );
		Sound sound = new Sound( "/Users/Alchemist/Desktop/a.mp3", false );
		sound.play();
	}
	public static synchronized void playSound(final String url) {
		new Thread( new Runnable() {
			public void run() {
				try {
					System.out.println( "/Users/Alchemist/Desktop/" + url );
					Clip clip = AudioSystem.getClip();
					FileInputStream fis = new FileInputStream( "/Users/Alchemist/Desktop/" + url );
					System.out.println( "/Users/Alchemist/Desktop/" + url );
					AudioInputStream inputStream = AudioSystem.getAudioInputStream( fis );
					clip.open( inputStream );
					clip.start(); 
				} catch ( Exception e ) {
					System.err.println( e.getMessage() );
				}
			}
		} ).start();
	}
}
