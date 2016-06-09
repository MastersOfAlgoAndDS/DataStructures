/**
 * 
 * Check if a given sequence of moves for a robot is circular or not
 * Given a sequence of moves for a robot, check if the sequence is circular or not. A sequence of moves is circular if first and last positions of robot are same. A move can be on of the following.
 * 
 *   G - Go one unit
 *   L - Turn left
 *   R - Turn right 
 * 
 * Examples:
 * 
 * Input: path[] = "GLGLGLG"
 * Output: Given sequence of moves is circular 
 * 
 * Input: path[] = "GLLG"
 * Output: Given sequence of moves is circular 
 *  
 * 
 * */

package companies.VMware;

public class RobotCircular {
	public static enum Direction {
		EAST, WEST, NORTH, SOUTH;

		public Direction turnRight(Direction currDirection) {
			Direction newDirection = null;
			switch (currDirection) {
			case EAST:
				newDirection = SOUTH;
				break;
			case WEST:
				newDirection = NORTH;
				break;
			case NORTH:
				newDirection = EAST;
				break;
			case SOUTH:
				newDirection = WEST;
				break;
			}
			return newDirection;
		}

		public Direction turnLeft(Direction currDirection) {
			Direction newDirection = null;
			switch (currDirection) {
			case EAST:
				newDirection = NORTH;
				break;
			case WEST:
				newDirection = SOUTH;
				break;
			case NORTH:
				newDirection = WEST;
				break;
			case SOUTH:
				newDirection = EAST;
				break;
			}
			return newDirection;
		}
	}

	public static void main(String[] args) {
		String path = "LRGLRGLRGLLGGG";
		System.out.println(isCircular(path));
	}

	private static boolean isCircular(String path) {
		char[] charPath = path.toCharArray();
		int x = 0, y = 0;
		Direction currDirection = Direction.NORTH;
		for (char currMove : charPath) {
			switch (currMove) {
			case 'R':
				currDirection = currDirection.turnRight(currDirection);
				break;
			case 'L':
				currDirection = currDirection.turnLeft(currDirection);
				break;
			default:
				switch (currDirection) {
				case NORTH:
					y++;
					break;
				case SOUTH:
					y--;
					break;
				case WEST:
					x--;
					break;
				case EAST:
					x++;
					break;
				}
				break;
			}
		}

		return (x == 0 && y == 0);
	}
}
