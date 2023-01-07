import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dosya {
	
	 public List<Process> oku(String dosyaYolu) {
	        List<Process> processList = new ArrayList<>();
	        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaYolu))) {
	            String satir;
	            Color color=new Color();
	            int i = 0;
	            while ((satir = reader.readLine()) != null) {
	                String[] values = satir.split(",");
	                int arriveTime = Integer.parseInt(values[0].trim());
	                int priority = Integer.parseInt(values[1].trim());
	                int processTime = Integer.parseInt(values[2].trim());
	                String renk = color.GetRandomColor();

	                Process data = new Process(i, arriveTime, priority, processTime, renk);

	                i++;
	                processList.add(data);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return processList;
	    }
}
