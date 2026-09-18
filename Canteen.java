import java.util.Scanner;

public class Canteen {
    static int total_items = 0;
	static double before_discount = 0;
	static double total_discount = 0;
	static double final_amount = 0;
	
	
	
	static void orderProcess(int orderNum, int quantity, char identity) {
	    double subtotal = 0;
		
		switch (orderNum){
		    case 1:
		        subtotal = 30 * quantity;
		        break;
		    case 2:
		        subtotal = 20 * quantity;
		        break;
		    case 3: 
		        subtotal = 50 * quantity;
		        break;
		    case 4:
		        subtotal = 20 * quantity;
		        break;
		    case 5:
		        subtotal = 15 * quantity;
		        break;
		}                
		System.out.print("\n ==============================================");
		System.out.printf("\n  Subtotal: $%.2f", subtotal);
		
		
		double discount = 0;
		
		if ((identity == 'Y'|| identity == 'y') && subtotal >= 500){
		    discount = subtotal * .15;
		} else if ( identity == 'Y'|| identity == 'y') {
		    discount = subtotal * .10;
		} else if (subtotal >= 500) {
		    discount = subtotal * .05;
		} else {
		    discount = 0;
		} 
		System.out.printf("\n  Discount: $%.2f", discount);
		
		double orderTotal = subtotal - discount;
	    System.out.printf("\n  Order Total: $%.2f", orderTotal);
	    
	    	
		total_items += quantity;
	    before_discount += subtotal;
    	total_discount += discount;
	    final_amount += orderTotal;
	}
	
	
	static class Summary{
		    void display() {     
		        System.out.print("\n ===============| ORDER SUMMARY |=============="+
		                         "\n  Total items: " + total_items);
		        System.out.printf("\n  Total before discount: $%.2f"+ 
		                          "\n  Total discount: $%.2f"+ 
		                          "\n  Final amount: $%.2f",
		                          before_discount,
		                          total_discount,
		                          final_amount);
		       System.out.print("\n ==============================================\n");
		       System.out.println("  Thank you for ordering!");
		    }
		}
		
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        
        System.out.println("\n ==========| CANTEEN ORDERING SYSTEM |=========");
		System.out.println(" ==================| MENU |====================");
		System.out.println("   1. Tuna Sandwich              - $30.00" + 
		                   "\n   2. Ham & cheese breadrolls    - $20.00" +
		                   "\n   3. Cinnamon Rolls             - $50.00" +
		                   "\n   4. Empanada                   - $20.00" +
		                   "\n   5. Cheesy donut               - $15.00" );
		
		int orderNum, quantity;
		char identity;
		
		
		System.out.print("\n  Enter order number: ");
		orderNum = input.nextInt();
		
		
		while (orderNum <= 0 || orderNum> 5){
		    System.out.print("  ''' Invalid order number!"+
		                     "\n   Enter order number again. '''\n");
		    System.out.print("\n  Enter order number: ");
		    orderNum = input.nextInt();
		}
		
		
		System.out.print("  Enter quantity: ");
		quantity = input.nextInt();
		
		while (quantity <= 0 || quantity > 10){
		    System.out.println("  ''' Invalid quantity!"+
		                       "\n   Quantity must not less than 1"+
		                       "\n   or must not exceed 10. '''\n");
		    System.out.print("\n  Enter quantity: ");
		    quantity = input.nextInt();
		}
		
		
		System.out.print("  Are you a student? (Y/N): ");
		identity = input.next().charAt(0);
		
		while (identity != 'Y' && identity !='y' && identity!= 'N' && identity != 'n'){
		    System.out.print("  ''' Invalid input! '''\n");
		    System.out.print("\n  Are you a student? (Y/N): ");
		    identity = input.next().charAt(0);
		}
		
		orderProcess(orderNum, quantity,identity);
		
		
		char orderAgain;
		
		System.out.print("\n ==============================================");
		System.out.print("\n  Do you want to order again? (Y/N): ");
		orderAgain = input.next().charAt(0);
		
		while (orderAgain != 'Y' && orderAgain !='y' && orderAgain!= 'N' && orderAgain != 'n'){
		    System.out.print("\n  ''' Invalid input! ''' \n"+ "\n   Choose 'Y' or 'N': ");
		    orderAgain = input.next().charAt(0);
		}   
		
        while (orderAgain == 'Y'|| orderAgain == 'y'){
		        System.out.print("\n  Enter order number: ");
		        orderNum = input.nextInt();
		        
		        if (orderNum <= 0 || orderNum> 5) {
		            System.out.print("\n  ''' Invalid order! Please try again. '''\n");
		            System.out.print("\n ==============================================");
		            System.out.print("\n  Do you want to order again? (Y/N): ");
		            orderAgain = input.next().charAt(0);
		            
		            while (orderAgain != 'Y' && orderAgain !='y' && orderAgain!= 'N' && orderAgain != 'n'){
		            System.out.print("\n  ''' Invalid input! '''\n" + "\n   Choose 'Y' or 'N': ");
		            orderAgain = input.next().charAt(0);
		            }
		            continue;
		        }   
		        
		        System.out.print("  Enter quantity: ");
		        quantity = input.nextInt();
		
	        	if (quantity <= 0 || quantity > 10){
	    	        System.out.println("\n  ''' Invalid quantity!"+
	    	                       "\n  Quantity must not less than 1"+
	    	                       "\n    or must not exceed 10. '''\n");
	    	        System.out.print("\n ==============================================");
	    	        System.out.print("\n  Do you want to order again? (Y/N): ");
		            orderAgain = input.next().charAt(0);
		            
		            while (orderAgain != 'Y' && orderAgain !='y' && orderAgain!= 'N' && orderAgain != 'n'){
		                System.out.print("\n  ''' Invalid input! '''\n" + "\n   Choose 'Y' or 'N': ");
		                orderAgain = input.next().charAt(0);
	            	}
	            	continue;
	        	}
	        	
	        	
		       System.out.print("  Are you a student? (Y/N): ");
		       identity = input.next().charAt(0);
		
		       if (identity != 'Y' && identity !='y' && identity!= 'N' && identity != 'n'){
		            System.out.print("\n  ''' Invalid input! '''\n ");
		            System.out.print("\n ==============================================");
		            System.out.print("\n  Do you want to order again? (Y/N): ");
		            orderAgain = input.next().charAt(0);
		            
		            while (orderAgain != 'Y' && orderAgain !='y' && orderAgain!= 'N' && orderAgain != 'n'){
		                System.out.print("\n  ''' Invalid input! ''' \n" + "\n  Choose 'Y' or 'N': ");
		                orderAgain = input.next().charAt(0);
	            	}
	            	continue;
		       }    
		       orderProcess(orderNum, quantity,identity);
		       
		       System.out.print("\n ==============================================");
		       System.out.print("\n  Do you want to order again? (Y/N): ");
		            orderAgain = input.next().charAt(0);
		            
		            while (orderAgain != 'Y' && orderAgain !='y' && orderAgain!= 'N' && orderAgain != 'n'){
		                System.out.print("\n  ''' Invalid input! ''' \n" + "\n  Choose 'Y' or 'N': ");
		                orderAgain = input.next().charAt(0);
		            }   
		 } 
		 Summary summary = new Summary();
		 summary.display();
		 input.close();
	}
}		

		