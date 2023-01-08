import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dosya {
	//Dosya içerisinde yer alan proses bilgilerini satır satır ayrıştırmamıza yarayan oku fonksiyonu
	 public List<Process> oku(String dosyaYolu) {//Fonksiyonumuz bir proses listesi döndürür
	        List<Process> processList = new ArrayList<>();
	        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaYolu))) {
	            String satir;
	            Color color=new Color();//Renklendirme için yazdığımız sınıfı kullanıyoruz
	            int i = 0;
	            while ((satir = reader.readLine()) != null) {//Dosya sonuna gelene kadar satır satır okuma yapıyoruz
	                String[] values = satir.split(",");//Virgül ile değerleri ayırıyoruz
	                //Dökmanda belirtilen sırayla arriveTime,priority ve processTime bilgilerini alıyoruz
	                int arriveTime = Integer.parseInt(values[0].trim());
	                int priority = Integer.parseInt(values[1].trim());
	                int processTime = Integer.parseInt(values[2].trim());
	                String renk = color.GetRandomColor();

	                Process data = new Process(i, arriveTime, priority, processTime, renk);//Elde ettiğimiz bilgilerden bir proses nesnesi oluşturuyoruz

	                i++;
	                processList.add(data);//döndüreceğimiz listeye o anki prosesi ekliyoruz
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return processList;//prosesleri içeren proses listesini döndür
	    }
}
