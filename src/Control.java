public class Control {
	char RegDst = '0';
	char Branch = '0';
	char MemRead = '0';
	char MemtoReg = '0';
	char MemWrite = '0';
	char AluSrc = '0';
	char RegWrite = '0';
	String AluOp = "00";

	public void setControls(Register opcode) {
		if (opcode.getValue().equals("000000")) {
			RegWrite = RegDst = '1';
			Branch = MemWrite = MemRead = MemtoReg = AluSrc = '0';
			AluOp = "10";
		}
		if (opcode.getValue().equals("100011")) {
			RegDst = MemWrite = Branch = '0';
			AluSrc = MemtoReg = RegWrite = MemRead = '1';
			AluOp = "00";
		}
		if (opcode.getValue().equals("101011")) {
			AluSrc = MemWrite = '1';
			RegWrite = MemRead = Branch = MemtoReg = RegDst = '0';
			AluOp = "00";
		}
		if (opcode.getValue().equals("000100")) {
			AluSrc = RegWrite = MemRead = MemWrite = '0';
			Branch = '1';
			AluOp = "01";
		}
	}
	public Register getControls()
	{
		Register out = new Register(9);
		out.setValue(""+RegWrite + MemtoReg + Branch + MemRead + MemWrite + RegDst + AluOp + AluSrc);
		return out;
	}
}
