package stackoverflow;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class systemfinal {
public static void main(String[] args) throws Exception {
	
  String order,again;
  int quantity, total = 0, loop1 = 0, quantity1, quantity2=0;
  int price1 = 0,price2 = 0;
  
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
  System.out.println(" ");
  System.out.println("\t\t   Welcome to Karenderya ni Ineng!\t\t");
  System.out.println(" ");
  System.out.println(" ");
  System.out.println("\t\t\t\tMENU\t\t\t\t");
  System.out.println(" ");
  System.out.println("   Order code\t\t Meal\t\t\t\t Price ");
  System.out.println(" ");
  System.out.println("      Meals: ");
  System.out.println("      (A1)   \t\t Sisig\t\t\t\t P50");
  System.out.println("      (A2)   \t\t Sisig at Lechon\t\t P60");
  System.out.println("      (A3)   \t\t Lechon\t\t\t\t P50");
  System.out.println("      (A4)   \t\t Pancit Canton\t\t\t P35");
  System.out.println("      (A5)   \t\t Adobong manok\t\t\t P40");
  System.out.println("      (A6)   \t\t Inihaw na Bangus\t\t P60");
  System.out.println("      (A7)   \t\t Sinigang na Bangus\t\t P60");
  System.out.println("      (A8)   \t\t Inihaw na Pusit\t\t P60");
  System.out.println("      (A9)   \t\t Chicken Inasal\t\t\t P60");
  System.out.println("      (A10)   \t\t Fried Chicken\t\t\t P50");
  System.out.println("      Rice: ");
  System.out.println("      (B1)   \t\t Plain Rice \t\t\t P10");
  System.out.println("      (B2)   \t\t Java Rice\t\t\t P10");
  System.out.println("      (B3)   \t\t Fried Rice\t\t\t P10");
  System.out.println("      Drinks: ");
  System.out.println("      (C1)   \t\t Iced tea\t\t\t P15");
  System.out.println("      (C2)   \t\t Softdrinks\t\t\t P25");
  System.out.println("      (C3)   \t\t Water\t\t\t\t P10");
  System.out.println("      (C4)   \t\t Juice\t\t\t\t P20");
  System.out.println("      Desserts: ");
  System.out.println("      (D1)   \t\t Halo-Halo\t\t\t P40");
  System.out.println("      (D2)   \t\t Buko Pie (per box)\t\t P150");
  System.out.println("      (D2)   \t\t Pitchi pitchi (per box)\t P100");
  System.out.println(" ");
  System.out.println(" ");
  
  do{
	  System.out.println("");
            System.out.print("Enter Code Order: ");
            order=br.readLine();
            if (order.equalsIgnoreCase("A1")) {
                price1=50;
                System.out.println("Order Description: Sisig ");
            } else if (order.equalsIgnoreCase("A2")) {
                price1=60;
                System.out.println("Order Description: Sisig at Lechon ");
            }   

            System.out.print("Enter Quantity: ");
            quantity1= Integer.parseInt(br.readLine());
            
			 total += price1 * quantity1;
			 
			 System.out.print("Another Order?  (Y/N) : ");
            again=br.readLine();
            if (again.equalsIgnoreCase("y")){
			loop1=loop1+1;}
            else { 
			loop1=loop1-100;
    } } while (loop1==1);    
	  
	  System.out.println(" ");
     System.out.println("Total Price: "+price2);   

}
}