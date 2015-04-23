public class ALU {
	
	char ZERO = '0';
	Register output = new Register(32);
	Register in; 
	Register in2; 
	String op;
	public ALU() {
		output = new Register(32);
		in = new Register(32);
		in2 = new Register(32);
		
	}

	public void outputRegister() {
	//	System.out.println(in.getValue() + " " + in2.getValue() + " " + op);
		int Reg1 = in.toInt();
		int Reg2 = in2.toInt();
		if (op.equals("AND")) {
			String register = in.toBinary((Reg1 & Reg2));
			output.setValue(register);
		}else if(op.equals("ADD"))
		{
			String register = in.toBinary((Reg1 + Reg2));
			output.setValue(register);
			System.out.println(output.getValue()+ " RESULT");
		}else if(op.equals("SUB"))
		{
			String register = in.toBinary((Reg1 - Reg2));
			ZERO = (Reg1 == Reg2)? '1' : '0';
			output.setValue(register);
		}else if(op.equals("SLT"))
		{
			String register = "";
			if(Reg1 < Reg2)
			{
				 register = in.toBinary((1));
					
			}else
			{
				 register = in.toBinary(0);
				
			}
			output.setValue(register);
		}else if(op.equals("NOR"))
		{
			String register = in.toBinary(~(Reg1 | Reg2));
			output.setValue(register);
		}else if(op.equals("OR"))
		{
			String register = in.toBinary((Reg1 | Reg2));
			output.setValue(register);
		}
		
	}
	public char getZERO() {
		return ZERO;
	}

	public void setZERO(char zERO) {
		ZERO = zERO;
	}

	public Register getOutput() {
		return output;
	}

	public void setOutput(Register output) {
		this.output = output;
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

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

}
