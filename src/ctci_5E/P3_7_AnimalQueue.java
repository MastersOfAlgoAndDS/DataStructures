package ctci_5E;

import java.util.LinkedList;

/**
 * @Problem: An animal shelter holds only dogs and cats, and operates on a
 *           strictly "first in, first
 *           out" basis. People must adopt either the "oldest" (based on arrival
 *           time) of all animals at the shelter, or they can select whether
 *           they would prefer a dog or a cat (and will receive the oldest
 *           animal of that type). They cannot select which specific animal they
 *           would like. Create the data structures to maintain this system and
 *           implement operations such as enqueue, dequeueAny, dequeueDog and
 *           dequeueCat. You may use the built-in L inkedL ist data structure.
 *
 * @Solution: We peek at both cat and dog queues and compare the head of both
 *            and return the oldest animal
 * 
 * @author Milind
 *
 */
public class P3_7_AnimalQueue {
	private LinkedList<Dog> dogQueue;
	private LinkedList<Cat> catQueue;
	private int seqNumber;

	public P3_7_AnimalQueue() {
		dogQueue = new LinkedList<Dog>();
		catQueue = new LinkedList<Cat>();
		seqNumber = 0;
	}

	public void enqueue(Animal animal) {
		animal.setAnimNum(seqNumber++);
		if (animal instanceof Dog) {
			dogQueue.add((Dog) animal);
		} else if (animal instanceof Cat) {
			catQueue.add((Cat) animal);
		}
	}

	public Dog dequeueDog() throws Exception {
		return dogQueue.pollFirst();
	}

	public Cat dequeueCat() throws Exception {
		return catQueue.pollFirst();
	}

	public Animal dequeueAny() throws Exception {
		Dog dog = dogQueue.peek();
		Cat cat = catQueue.peek();
		if (dog == null && cat == null)
			throw new Exception("No animals found!!!");
		else {
			if (dog == null)
				return dequeueCat();
			else if (cat == null) {
				return dequeueDog();
			} else if (dog.isOlderThan(cat)) {
				return dequeueDog();
			} else {
				return dequeueCat();
			}
		}
	}

	abstract class Animal {
		private int animNumber;
		protected String name;

		public Animal(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Animal [animNumber=" + animNumber + ", name=" + name + "]";
		}

		public int getAnimNum() {
			return animNumber;
		}

		public void setAnimNum(int animNum) {
			this.animNumber = animNum;
		}

		public boolean isOlderThan(Animal a) {
			return this.getAnimNum() < a.getAnimNum();
		}
	}

	class Dog extends Animal {

		public Dog(String name) {
			super(name);
		}
	}

	class Cat extends Animal {

		public Cat(String name) {
			super(name);
		}
	}

	public static void main(String[] args) {
		P3_7_AnimalQueue animQueue = new P3_7_AnimalQueue();
		animQueue.enqueue(animQueue.new Cat("Benny"));
		animQueue.enqueue(animQueue.new Dog("Labbu"));
		animQueue.enqueue(animQueue.new Cat("Tom"));
		animQueue.enqueue(animQueue.new Dog("Maxx"));

		try {
			System.out.println(animQueue.dequeueAny());
			System.out.println(animQueue.dequeueAny());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
