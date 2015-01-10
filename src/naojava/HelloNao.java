package naojava;

import com.aldebaran.qimessaging.Application;
import com.aldebaran.qimessaging.Future;
import com.aldebaran.qimessaging.Session;

public class HelloNao {
	public static void main(String[] args) throws Exception {
		Application app = new Application(args);
		Session session = new Session();
		Future<Void> fut = session.connect("tcp://ned.local:9559");
		fut.get();

		com.aldebaran.qimessaging.Object tts = null;
		tts = session.service("ALTextToSpeech");


		boolean ping = tts.<Boolean>call("ping").get();
		if (!ping) {
			System.out.println("Could not ping TTS");
		} else {
			System.out.println("Ping ok");
		}

		System.out.println("Calling say");
		tts.call("say", "Bonjour tout le monde");
	}
}

