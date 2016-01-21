package generateISBN;

import java.util.Scanner;

/*
 * Question 1
 */
public class ISBN {
	
	public static void main(String[] args) {
		System.out.println("Please enter a Product ID");
		String product_id;
		Scanner sc = new Scanner(System.in);
		try{
			product_id = sc.nextLine();
			System.out.println("The ISBN number is: "+ generateISBN(product_id));
			
		} catch(Exception e){
			System.out.println("Please enter a valid Product ID");
			
		} finally{
			sc.close();
		}
	}
	/*
	 * Since a valid ISBN is checked by multiplying each digit by a constant(from the appendix)
	 * constant starting from 10 to 1 (left to right)(from the appendix)
	 * our last missing digit can be obtained by taking the sum of first 9 digits which are
	 *  multiplied by their respective constants.
	 *  This sum + last digit(can be 0-9) * (1) modulo 11 if gives 0 we got the last digit 
	 *  else the digit is 10 append 'x' as the last digit
	 */
	private static String generateISBN(String product_id){
		//remove the first three digit from product_id
		StringBuilder sb = new StringBuilder(product_id.substring(3));
		int ISBN = Integer.parseInt(product_id.substring(3));
		int sum = 0;
		int constant = 1;
		while (ISBN > 0){
			sum += (ISBN % 10) * ++constant;
			ISBN = ISBN / 10;
		}
		
		for(int last_digit = 0; last_digit <= 9; last_digit++){
			
			if( (sum + last_digit) % 11 == 0){
			
				return sb.append(last_digit).toString();
			}
		}

		return sb.append('x').toString();
	}

}
