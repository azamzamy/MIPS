public class Datapath {
	Register PC = new Register(32);
	Memory instmem;
	Memory datamem;
	Adder PCAdder;
	Adder BranchAdder;
	Mux PcMux;
	Mux AluSrcMux;
	Mux RegDstMux;
	Mux memtoreg;
	RegisterFile regfile;
	ALUControl AluControl;
	ALU Alu;
	ShiftLeft shiftleft;
	SignExtend signextend;
	Control control;
	Register IF_ID = new Register(64);
	Register ID_EX = new Register(147);
	Register EX_MEM = new Register(107);
	Register MEM_WB = new Register(71);
	And branch;
	
	
	
	public Datapath() {
		branch = new And();
		PCAdder = new Adder();
		PCAdder.setIn2(new Register("1", 32));
		BranchAdder = new Adder();
		PC.setValue("0");
		PcMux = new Mux();
		PcMux.setOne(PC);
		PcMux.setTwo(new Register("0", 32));

		AluSrcMux = new Mux();
		RegDstMux = new Mux();
		memtoreg = new Mux();

		instmem = new Memory(1000);
		instmem.setMemread('1');
		datamem = new Memory(32);

		AluControl = new ALUControl();
		Alu = new ALU();

		shiftleft = new ShiftLeft();

		signextend = new SignExtend();

		control = new Control();
		regfile = new RegisterFile();
		//fetch();
	}

	public void fetch() {
		PcMux.muxOutput();
		PC.setValue(PcMux.getOutput().getValue());
		instmem.setAddress(PC);
		instmem.execute();
		if(instmem.getReadData() == null)
			return;
		IF_ID.setValue(32, 63, instmem.getReadData());
		PCAdder.setIn(PC);
		PCAdder.add();
		IF_ID.setValue(0, 31, PCAdder.getOut());		
		PcMux.setOne(PCAdder.getOut());
		

		decode();
		//fetch();
		
	}

	public void decode() {
		Register instruction = IF_ID.getValue(32, 63);
		control.setControls(instruction.getValue(0, 5));
		regfile.setReadReg1(instruction.getValue(6, 10));
		regfile.setReadReg2(instruction.getValue(11, 15));
		signextend.setIn(instruction.getValue(16, 31));
		ID_EX.setValue(0, 8, control.getControls());
		regfile.execute();
		signextend.extend();
		ID_EX.setValue(9, 40, IF_ID.getValue(0, 31));
		ID_EX.setValue(41, 72, regfile.getReadData1());
		ID_EX.setValue(73, 104, regfile.getReadData2());
		ID_EX.setValue(105, 136, signextend.getOut());
		ID_EX.setValue(137, 141, instruction.getValue(11, 15));
		ID_EX.setValue(142, 146, instruction.getValue(16, 20));
		
		execute();
		//decode();
	}

	public void execute() {
		EX_MEM.setValue(0, 1, ID_EX.getValue(0, 1));
		EX_MEM.setValue(2, 4, ID_EX.getValue(2, 4));
		shiftleft.setIn(ID_EX.getValue(104, 135));
		BranchAdder.setIn(ID_EX.getValue(9, 40));
		BranchAdder.setIn2(shiftleft.getOut());
		EX_MEM.setValue(5, 36, BranchAdder.getOut());
		AluSrcMux.setS(ID_EX.getValue(8, 8).getValue().charAt(0));
		AluSrcMux.setOne(ID_EX.getValue(73, 104));
		AluSrcMux.setTwo(ID_EX.getValue(105, 136));
		AluSrcMux.muxOutput();
		
		//System.out.println(AluSrcMux.getOutput().getValue()+"############");
		Alu.setIn(ID_EX.getValue(41, 72));
		Alu.setIn2(AluSrcMux.getOutput());
		
		AluControl.setFunctionCode(ID_EX.getValue(131, 136));
		AluControl.setOp(ID_EX.getValue(6, 7).getValue());
		Alu.setOp(AluControl.outputSignal());
		Alu.outputRegister();
		Register Zero = new Register(Alu.ZERO + "", 1);
		EX_MEM.setValue(37, 37, Zero);
		EX_MEM.setValue(38, 69, Alu.getOutput());
		RegDstMux.setOne(ID_EX.getValue(137, 141));
		RegDstMux.setTwo(ID_EX.getValue(142, 146));
		RegDstMux.setS(ID_EX.getValue(5, 5).getValue().charAt(0));
		RegDstMux.muxOutput();
		EX_MEM.setValue(70, 101, ID_EX.getValue(73, 104));
		EX_MEM.setValue(102, 106, RegDstMux.getOutput());
		memory();
		//decode();
	}
	public void memory(){
		MEM_WB.setValue(0, 1, EX_MEM.getValue(0, 1));
		branch.setIn(EX_MEM.getValue(2, 2));
		branch.setIn2(EX_MEM.getValue(37, 37));
		branch.execute();
		PcMux.setTwo(EX_MEM.getValue(5, 36));
		PcMux.setS(branch.getOut().getValue().charAt(0));
		datamem.setAddress(EX_MEM.getValue(38, 69));
		datamem.setWriteData(EX_MEM.getValue(73, 104));
		datamem.setMemread(EX_MEM.getValue(3, 3).getValue().charAt(0));
		datamem.setMemwrite(EX_MEM.getValue(4, 4).getValue().charAt(0));
		datamem.execute();
		MEM_WB.setValue(2, 33, datamem.getReadData());
		MEM_WB.setValue(34, 65, EX_MEM.getValue(38, 69));
		MEM_WB.setValue(66, 71, EX_MEM.getValue(102, 106));
		writeBack();
		//execute();
		
	}
	public void writeBack(){
		regfile.setRegWrite(MEM_WB.getValue(0,0).getValue().charAt(0));
		memtoreg.setS(MEM_WB.getValue(1,1).getValue().charAt(0));
		memtoreg.setTwo(MEM_WB.getValue(2, 33));
		memtoreg.setOne(MEM_WB.getValue(34, 65));
		memtoreg.muxOutput();
		regfile.setWriteReg(MEM_WB.getValue(66, 70));
		regfile.setWriteData(memtoreg.getOutput());
		System.out.println("Write Register: "+ regfile.getWriteReg().getValue()+" Write Data: "+regfile.getWriteData().getValue());
		regfile.write();
		//memory();
		//fetch();
		
	}
	public static void main(String[] args) {
		Datapath x = new Datapath();
		Register r1 = new Register("100", 32);
		Register r2 = new Register("111", 32);
		x.regfile.registers[9] = r1;
		x.regfile.registers[10] = r2;
		Register test = new Register("00000001001010100100100000000010",32);
		Register test2 = new Register("00000001001010100100100000000010",32);
		x.instmem.add(test);
		x.instmem.add(test2);
		x.fetch();
		System.out.println(x.regfile.registers[9].toInt());
	}
}
