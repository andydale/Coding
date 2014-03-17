import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Linkedin 
// Remember this :  (25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.
// L1

public class ipAddressRegex {
	public static void main(String args[]){
		String ip="256.0.0.1";
		String regx="(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\."+"(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\."+"(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\."+"(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
		Pattern p=Pattern.compile(regx);
		Matcher m=p.matcher(ip);
		if(m.matches()){
			System.out.println(ip);
		}
	}
}
