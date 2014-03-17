import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class PriortiyQueues {
	
	
	@SuppressWarnings("unchecked")
	public static void main(String args[]){
		List<String> temp=Arrays.asList("23","35","36","234");	
//		temp.add("908");
//		temp.add(0, "99999");
		
		Collections.sort(temp, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.parseInt(o1) > Integer.parseInt(o2) ? 1 : 0;
			}
		});
	
	for(String s:temp){
		System.out.println(s);
	}
	
	HashMap<String,String> hmap=new HashMap<String,String>();
	
	List<Map.Entry<String, String>> list =
         new LinkedList<Map.Entry<String, String>>( hmap.entrySet() );
	
	Collections.sort(list,new Comparator(){
//		public int compare(Entry<String,String> o1,Entry<String,String> o2){
//		}
		@Override
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			return 0;
		}
	});
	}
}
