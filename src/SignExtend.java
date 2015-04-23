public class SignExtend {
	Register in = new Register(32);
	Register out = new Register(32);

	public void extend() {

		String value = in.getValue();
		for (int i = 0; i < 16; i++) {

			value = "0" + value;

		}

		out.setValue(value);
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
