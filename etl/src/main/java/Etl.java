import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Etl {
   public Map<String, Integer> transform(Map<Integer, List<String>> old) {
	   Map<String, Integer> result = new HashMap<String, Integer>();
	   for (int points : old.keySet()) {
		   for (String letter : old.get(points)) {
			   result.put(letter.toLowerCase(), points);
		   }
	   }
	   return result;
   }
}
