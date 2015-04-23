public class Mux {

	Register Output = new Register(32);
	Register One = new Register(32); 
	Register Two = new Register(32);
	char s;
	public Mux() {
		s = '0';
	}

	public void muxOutput() {
		if (s == '1')
			Output = Two;
		else
			Output = One;
	}

	public Register getOutput() {
		return Output;
	}

	public void setOutput(Register output) {
		Output = output;
	}

	public Register getOne() {
		return One;
	}

	public void setOne(Register one) {
		One = one;
	}

	public Register getTwo() {
		return Two;
	}

	public void setTwo(Register two) {
		Two = two;
	}

	public boolean isS() {
		return (s == '1');
	}

	public void setS(char s) {
		this.s = s;
	}

}
