import java.util.List;

public class Main {

	public static void main(String[] args) {
		Dosya dosya = new Dosya();
        List<Process> list = dosya.oku("giris.txt");

        Dispatcher dispatcher = new Dispatcher(list);
        dispatcher.run();
	
	}

}
