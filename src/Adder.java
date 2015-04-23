public class Adder {
	Register in = new Register(32);
	Register in2 = new Register(32);
	Register out = new Register(32);
	
	public Register getIn() {
		return in;
	}

	public void setIn(Register in) {
		this.in = in;
	}

	public Register getIn2() {
		return in2;
	}

	

	public Register getOut() {
		return out;
	}

	public void setOut(Register out) {
		this.out = out;
	}

	public void add() {

		int result = in.toInt() + in2.toInt();
		out.setValue(in.toBinary(result));
	}

	public void setIn2(Register in2) {
		// TODO Auto-generated method stub
		this.in2 = in2;
	}

}
