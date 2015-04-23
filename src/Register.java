public class Register {
	int size;
	String value = "";

	public Register(int size) {
		this.size = size;
		for (int i = 0; i < size; i++)
			value += '0';
		
	}
	public Register(String val , int x)
	{
		value = val;
		size = x;
		while(value.length() < size)
			value = '0' + value;
	}
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getValue() {
		
		return value;
	}

	public void setValue(String value) {
		this.value = value;
		while(this.value.length() < size)
			this.value = '0' + this.value;
	}

	public void setValue(int start, int end, Register two) {
		String out = "";
		
		if(start > 0)
		out = value.substring(0, start);
		
		out = out + two.getValue();
		if(end + 1 < size)
			out = out + value.substring(end + 1);
		value = new String(out);
	}

	public int toInt() {
		int multiplier = 1;
		int out = 0;
		for(int i = value.length() - 1 ; i>= 0 ; i--)
		{
			if(value.charAt(i) == '1')
				out += multiplier;
			multiplier *= 2;
		}
		return out;
	}

	public  String toBinary(int val) {
		String output = Integer.toBinaryString(val);
		while(output.length() < this.size)
			output = '0' + output;
		return output;
	}

	public Register(String val) {
		this.value = val;
	}
	public Register getValue(int start, int end){
		String out = this.value.substring(start, end + 1);
		return new Register(out, out.length());
		
	}

}
