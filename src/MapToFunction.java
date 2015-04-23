import java.util.Hashtable;

public class MapToFunction {
	static Hashtable<String, String> map;

	public MapToFunction() {
		map = new Hashtable<String, String>();

		map.put("000000", "AND");
		map.put("000001", "OR");
		map.put("000010", "ADD");
		map.put("000110", "SUB");
		map.put("000111", "SLT");
		map.put("001100", "NOR");

	}
	public String get(String value){
		return map.get(value);
	}
}
