
public class And {

	Register in = new Register(32);
	Register in2 = new Register(32);
	Register out;

	public void execute(){
		int f = in.toInt();
		int t= in2.toInt();
		int res = (f & t);
		out=new Register(32);
		out.setValue(out.toBinary(res));
	}
	
	public Register getIn() {
		return in;
	}

	public void setIn(Register in) {
		this.in = in;
	}

	public Register getIn2() {
		return in2;
	}

	public void setIn2(Register in2) {
		this.in2 = in2;
	}

	public Register getOut() {
		return out;
	}

	public void setOut(Register out) {
		this.out = out;
	}

}
