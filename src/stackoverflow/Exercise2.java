package stackoverflow;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise2 {
	public static void main(String[] args) {
		int i, j;

		Scanner keyboard = new Scanner(System.in);
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> result = new ArrayList<String>();

		System.out.println("Enter words on one line, end with -1:");
		String word = keyboard.next();

		while (!word.equals("-1"))

		{
			list1.add(word);
			word = keyboard.next();
		}

		for (i = 0; i < list1.size(); i++)

		{

			String item = list1.get(i);

			boolean repeat = false;

			j = 0;

			while (!repeat && j < result.size())

			{

				if (item.equals(result.get(j)))

					repeat = true;

				j++;

			}

			if (!repeat)
				result.add(item);

		}

		System.out.println("Array List with no duplicate: ");
		System.out.println(result);

	}
}