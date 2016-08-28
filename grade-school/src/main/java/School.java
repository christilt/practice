import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* Is this immutable (in the way described in the README)?  
 * Any feedback would be greatly appreciated.
 */

public final class School {

	private Map<Integer, List<String>> db;

	public School() {
		this.db = new TreeMap<>();
	}

	public Map<Integer, List<String>> db() {
		return Collections.unmodifiableMap(db);
	}

	public void add(final String studentName, final int grade) {
		if (db.get(grade) == null)
			db.put(grade, new ArrayList<>());
		db.get(grade).add(studentName);
	}

	public List<String> grade(int grade) {
		if (!db.containsKey(grade)) {
			return Collections.emptyList();
		} else {
			return Collections.unmodifiableList(db.get(grade));
		}
	}

	public Map<Integer, List<String>> sort() {
		Map<Integer, List<String>> result = new TreeMap<>(db);
		for (List<String> students : result.values()) {
			Collections.sort(students);
		}
		return Collections.unmodifiableMap(result);
	}

}
