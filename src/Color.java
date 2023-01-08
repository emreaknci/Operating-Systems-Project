import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Color {//Çıktıyı renkli göstermek için oluşturduğumuz renk sınıfı
	Color() {
		//Kurucu fonksiyonda renk listesi oluşturulur ve renk kodları bu listeye eklenir
		colors = new ArrayList<>();
		colors.add("\u001B[35m");
		colors.add("\u001B[30m");
		colors.add("\u001B[31m");
		colors.add("\u001B[32m");
		colors.add("\u001B[33m");
		colors.add("\u001B[34m");
		colors.add("\u001B[35m");
		colors.add("\u001B[36m");
		colors.add("\u001B[37m");
	}

	private List<String> colors;

	public String GetRandomColor() {//Oluşturduğumuz renk listesinden rastgele bir renk getirir
        Random rnd = new Random();
        String color = colors.get(rnd.nextInt(colors.size() - 1));
		return color;
	}
}
