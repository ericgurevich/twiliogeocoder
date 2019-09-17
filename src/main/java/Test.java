
/*Tester class for both apis
 */

public class Test {

	public static void main(String[] args) {
		
		//Test for text message sender. Number should be in format "+1XXXXXXXXXX"
		Sender.send("+1/*insert phone number here*/","Hello. This is a test.");

		//Test for returning latitude and longitude based on search query. 
		System.out.println(GeoCoder.getLatLong("1208 Frankford Ave, Philadelphia, PA 19125"));
	}

}
