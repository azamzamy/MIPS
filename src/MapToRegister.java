import java.util.Hashtable;

public class MapToRegister {

	static Hashtable<String, Integer> map;

	public MapToRegister() {
		map = new Hashtable<String, Integer>();

		map.put("$0", 0);
		map.put("$v0", 2);
		map.put("$v1", 3);
		map.put("$a0", 4);
		map.put("$a1", 5);
		map.put("$a2", 6);
		map.put("$a3", 7);
		map.put("$t0", 8);
		map.put("$t1", 9);
		map.put("$t2", 10);
		map.put("$t3", 11);
		map.put("$t4", 12);
		map.put("$t5", 13);
		map.put("$t6", 14);
		map.put("$t7", 15);
		map.put("$s0", 16);
		map.put("$s1", 17);
		map.put("$s2", 18);
		map.put("$s3", 19);
		map.put("$s4", 20);
		map.put("$s5", 21);
		map.put("$s6", 22);
		map.put("$s7", 23);
		map.put("$t8", 24);
		map.put("$t9", 25);
		map.put("$gp", 28);
		map.put("$sp", 29);
		map.put("$fp", 30);
		map.put("$ra", 31);
	}

	public int get(String name) {
		return map.get(name);

	}

}
