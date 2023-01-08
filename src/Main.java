import java.util.List;

public class Main {

	public static void main(String[] args) {
		Dosya dosya = new Dosya();
        List<Process> list = dosya.oku("giris.txt");//Proses listesini okuyoruz

        Dispatcher dispatcher = new Dispatcher(list);//Dispatcher ile sırasıyla prosesleri çalıştırıyoruz
        dispatcher.run();
	
	}

}
