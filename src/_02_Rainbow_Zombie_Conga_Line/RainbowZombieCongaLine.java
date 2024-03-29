package _02_Rainbow_Zombie_Conga_Line;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class RainbowZombieCongaLine {

	/*
	 * You are hosting a rainbow zombie conga dance party! Zombies are not very
	 * smart(maybe that's why they crave brains) and need your help to direct them
	 * through the choreography.
	 * 
	 * Each method is a dance move you will need to implement.
	 * 
	 * When you think you've gotten your zombies trained well enough you can start
	 * the party by running the main method in RainbowZombieDanceParty and typing
	 * how many rounds you want in the console to see if they followed your
	 * choreography correctly.
	 * 
	 * Note: The party will always start with a rainbow brains and every 5 rounds
	 * the head and tail of the dance line will be removed.
	 */

	private LinkedList<Zombie> congaLine;
	private ZombieHatColor[] zombieHats;

	public RainbowZombieCongaLine() {

		congaLine = new LinkedList<Zombie>();
		zombieHats = ZombieHatColor.values();

	}

	// Make the passed in zombie the first Zombie in the conga line!
	public void engine(Zombie dancer) {
		Node<Zombie> current;
		current = congaLine.getHead();
		congaLine.setHead(new Node<Zombie>(dancer));
		congaLine.getHead().setNext(current);
	}

	// Make the passed in zombie the last Zombie in the conga line!
	public void caboose(Zombie dancer) {
		congaLine.add(dancer);
	}

	// Place the zombie at the designated position in the conga line!
	public void jumpInTheLine(Zombie dancer, int position) {
		int jumpCounter = 0;
		Node<Zombie> current;
		Node<Zombie> next;
		current = congaLine.getHead();
		next = current.getNext();
		while (jumpCounter < position - 1) {
			current = next;
			next = current.getNext();
			jumpCounter++;
		}
		current.setNext(new Node<Zombie>(dancer));
		current = current.getNext();
		current.setNext(next);
	}

	/*
	 * Remove all zombies with the same hat color as the passed in zombie from the
	 * conga line!
	 */
	public void everyoneOut(Zombie dancer) {
		Node<Zombie> current;
		Node<Zombie> next;
		current = congaLine.getHead();
		next = current.getNext();
		for (int i = 0; i < congaLine.size(); i++) {
			if (current.getValue().getZombieHatColor() == dancer.getZombieHatColor()) {
				if (next.getValue() != null) {
					current.setValue(next.getValue());
					next = next.getNext();
					current.setNext(next);
				} else {
					congaLine.remove(congaLine.size() - 1);
				}
			} else {
				current = next;
				if (current.getNext() != null) {
					next = current.getNext();
				}
			}
		}
	}

	/*
	 * Remove the first zombie with the same hat color as the passed in zombie from
	 * the conga line!
	 */
	public void youAreDone(Zombie dancer) {
		Node<Zombie> current;
		Node<Zombie> next;
		current = congaLine.getHead();
		next = current.getNext();
		while (current.getValue().getZombieHatColor() != dancer.getZombieHatColor()) {
			current = next;
			if (current.getNext() != null) {
				next = current.getNext();

			} else {
				break;
			}
		}
		if (current.getValue().getZombieHatColor() == dancer.getZombieHatColor()) {
			if (next.getValue() != null) {
				current.setValue(next.getValue());
				next = next.getNext();
				current.setNext(next);
			} else {
				congaLine.remove(congaLine.size() - 1);
			}
		}
	}

	/*
	 * Make two more zombies with the same hat color as the passed in zombie and add
	 * one to the front, one to the end and one in the middle.
	 */
	public void brains(Zombie dancer) {
		Node<Zombie> current;
		Node<Zombie> next;
		int position = congaLine.size() / 2;
		int jumpCounter = 0;
		current = congaLine.getHead();
		congaLine.setHead(new Node<Zombie>(dancer));
		congaLine.getHead().setNext(current);
		congaLine.add(dancer);

		current = congaLine.getHead();
		next = current.getNext();
		while (jumpCounter < position - 1) {
			current = next;
			next = current.getNext();
			jumpCounter++;
		}
		current.setNext(new Node<Zombie>(dancer));
		current = current.getNext();
		current.setNext(next);
	}

	/*
	 * Add the passed in zombie to the front and then add one zombie of each hat
	 * color to the end of the line.
	 */
	public void rainbowBrains(Zombie dancer) {
		congaLine.setHead(new Node<Zombie>(dancer));
		congaLine.add(new Zombie(ZombieHatColor.R));
		congaLine.add(new Zombie(ZombieHatColor.O));
		congaLine.add(new Zombie(ZombieHatColor.Y));
		congaLine.add(new Zombie(ZombieHatColor.G));
		congaLine.add(new Zombie(ZombieHatColor.B));
		congaLine.add(new Zombie(ZombieHatColor.I));
		congaLine.add(new Zombie(ZombieHatColor.V));
	}

	public LinkedList<Zombie> getCongaLine() {
		return congaLine;
	}
}
