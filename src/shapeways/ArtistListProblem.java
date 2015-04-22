package shapeways;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;

public class ArtistListProblem {
	public static void main(String[] args) {
		String fileName = "src/shapeways/Artist_lists_small.txt";

		try {
			FileReader fin = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fin);
			String line;
			HashMap<String, Integer> h = new HashMap<String, Integer>();
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				String[] artists = line.split(",");
				for (String artist : artists) {
					if (h.get(artist) == null) {
						h.put(artist, 1);
					} else {
						h.put(artist, (int) h.get(artist) + 1);
					}
				}
			}
			for (Iterator<String, Integer> iterator : h.entrySet().iterator()) {
				
			}

			br.close();
			fin.close();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}
}
