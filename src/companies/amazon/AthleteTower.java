/* * <b>Coding exercise:</b>
 * Every athlete is characterized by his mass 'm' (in kg) and strength 's' (in kg). You are to find the maximum number
 * of athletes that can form a tower standing one upon another. An athlete can hold a tower of athletes with total mass
 * equal to his strength or less than his strength. Input contains the number of athletes n and their parameters. These
 * inputs can be assumed to be passed as arguments (Integer n and List<Pair<Integer, Integer>> parameterList) appropriate
 * for your language of choice.
 * 
 * @Solution: Sort the athletes by increasing order of their masses. 
 * 			Then iterate over athletes and keep checking strength condition everytime.
 * 
 * 
 */

package companies.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AthleteTower {

	class Athlete implements Comparable<Athlete> {
		private int mass;
		private int strength;

		public Athlete(int mass, int strength) {
			this.mass = mass;
			this.strength = strength;
		}

		public int getMass() {
			return mass;
		}

		public void setMass(int mass) {
			this.mass = mass;
		}

		public int getStrength() {
			return strength;
		}

		public void setStrength(int strength) {
			this.strength = strength;
		}

		@Override
		public String toString() {
			return "Athlete [mass=" + mass + ", strength=" + strength + "]";
		}

		@Override
		public int compareTo(Athlete o) {
			return this.mass - o.mass;
		}

	}

	public static void main(String[] args) {
		ArrayList<Athlete> list = new ArrayList<Athlete>();
		AthleteTower s = new AthleteTower();
		list.add(s.new Athlete(3, 4));
		list.add(s.new Athlete(2, 2));
		list.add(s.new Athlete(7, 7));
		list.add(s.new Athlete(4, 5));
		for (Athlete athlete : list) {
			System.out.println(athlete);
		}
		Collections.sort(list);
		System.out.println();
		for (Athlete athlete : list) {
			System.out.println(athlete);
		}

		int totalweight = 0;
		ArrayList<Athlete> ans = new ArrayList<AthleteTower.Athlete>();
		for (Athlete athlete : list) {
			if (athlete.strength > totalweight) {
				ans.add(athlete);
				totalweight += athlete.getMass();
			}
		}
		System.out.println(ans);
		System.out.println(ans.size());
	}
}
