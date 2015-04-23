public class RegisterFile {

	int SIZE = 32;
	Register[] registers;
	MapToRegister map;
	Register ReadData1;
	Register ReadData2;
	Register ReadReg1; 
	Register ReadReg2;
	Register WriteReg; 
	Register WriteData; 
	Datapath datapath;
	char RegWrite;
	
	public RegisterFile() {
		registers = new Register[SIZE];
		ReadReg1 = new Register(32);
		ReadReg2 = new Register(32);
		WriteData = new Register(32);
		WriteReg = new Register(32);
		ReadData1 = new Register(32);
		ReadData2 = new Register(32);
		RegWrite = '0';
		map = new MapToRegister();
		for(int i = 0 ; i < 32 ;i++)
			registers[i] = new Register(32);
	
	}
	public void execute ()
	{
		//System.out.println(ReadReg1.toInt() + " " + ReadData2.toInt() + " SADSSAS");
		ReadData1 = registers[ReadReg1.toInt()];
		ReadData2 = registers[ReadReg2.toInt()];
				
	}
	public void write()
	{
		if(RegWrite=='1')
		{
			registers [WriteReg.toInt()].setValue(WriteData.getValue());
		}

	}
	public int getSIZE() {
		return SIZE;
	}
	public void setSIZE(int sIZE) {
		SIZE = sIZE;
	}
	public Register[] getRegisters() {
		return registers;
	}
	public void setRegisters(Register[] registers) {
		this.registers = registers;
	}
	public MapToRegister getMap() {
		return map;
	}
	public void setMap(MapToRegister map) {
		this.map = map;
	}
	public Register getReadData1() {
		return ReadData1;
	}
	public void setReadData1(Register readData1) {
		ReadData1 = readData1;
	}
	public Register getReadData2() {
		return ReadData2;
	}
	public void setReadData2(Register readData2) {
		ReadData2 = readData2;
	}
	public Datapath getDatapath() {
		return datapath;
	}
	public void setDatapath(Datapath datapath) {
		this.datapath = datapath;
	}
	public Register getReadReg1() {
		return ReadReg1;
	}
	public void setReadReg1(Register readReg1) {
		ReadReg1 = readReg1;
	}
	public Register getReadReg2() {
		return ReadReg2;
	}
	public void setReadReg2(Register readReg2) {
		ReadReg2 = readReg2;
	}
	public Register getWriteReg() {
		return WriteReg;
	}
	public void setWriteReg(Register writeReg) {
		WriteReg = writeReg;
	}
	public Register getWriteData() {
		return WriteData;
	}
	public void setWriteData(Register writeData) {
		WriteData = writeData;
	}
	public char getRegWrite() {
		return RegWrite;
	}
	public void setRegWrite(char regWrite) {
		RegWrite = regWrite;
	}
	public RegisterFile(Register[] registers) {
		map = new MapToRegister();
		registers = new Register[SIZE];
		this.registers = registers;
	}

	public Register getRegister(String regName) {
		int pos = map.get(regName);
		return registers[pos];
	}

}
