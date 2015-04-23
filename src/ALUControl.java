public class ALUControl {
	MapToFunction map;
	Register functionCode;
	String op;

	public ALUControl() {
		map = new MapToFunction();
		functionCode = new Register(6);
	}

	public MapToFunction getMap() {
		return map;
	}

	public void setMap(MapToFunction map) {
		this.map = map;
	}

	public Register getFunctionCode() {
		return functionCode;
	}

	public void setFunctionCode(Register functionCode) {
		this.functionCode = functionCode;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public String outputSignal() {
		if (op.equals("00"))
			return "ADD";
		else if (op.equals("01"))
			return "SUB";
		else if (op.equals("10"))
			return map.get(functionCode.getValue());
		return "";

	}
}
