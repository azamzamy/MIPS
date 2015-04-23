public class ShiftLeft {
	Register in = new Register(32);
	Register out;

	public void Shift() {
		out = new Register(in.getSize());
		out.setValue(in.getValue().substring(2) + "00");
	}

	public Register getIn() {
		return in;
	}

	public void setIn(Register in) {
		this.in = in;
	}

	public Register getOut() {
		return out;
	}

	public void setOut(Register out) {
		this.out = out;
	}
}
