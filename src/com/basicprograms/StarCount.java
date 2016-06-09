import java.util.Scanner;
/**
 * Write a description of class StarCount here.
 *
 * @author Damon
 * @version (a version number or a date)
 */
public class StarCount {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int starCount = 0;
        String input = keyboard.nextLine();
        while(!input.equals("#")){

            for(starCount=0; starCount<=input.length(); starCount++){
                if (input.charAt(starCount)== '*'){
                    System.out.println(starCount);
                }//if
            }//for

        }//while

    } //main

} // class StarCount