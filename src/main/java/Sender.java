import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;


public class Sender {
    private static String account = "/*insert account here*/";
    private static String auth = "/*insert token here*/";
    
    //Sends message to number.
    public static void send(String number, String message) {
    	if (!number.startsWith("+1")) {
    		System.err.println("Make sure your number starts with +1 (only US numbers)");
    		return;
    	}
    	
    	if (number.length() > 12) {
    		System.err.println("You inputted the number with incorrect formatting or a non US number");
    		return;
    	}
    	
    	Twilio.init(account, auth);
    	
    	Message msg = Message.creator(new com.twilio.type.PhoneNumber(number),
    			new com.twilio.type.PhoneNumber("+18569972465"), message).create();
    	
    	System.out.println("Message returned id " + msg.getSid());
		
	}
}
