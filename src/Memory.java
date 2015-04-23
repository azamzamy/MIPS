
public class Memory {
	Register [] memory;
	int size;
	static int counter = 0;
	Register readData = new Register(32);
	Register address = new Register(32); 
	Register writeData = new Register(32);
	char memwrite;
	char memread;
	public Memory(int size){
		memory = new Register [size];
		memwrite = '0';
		memread = '0';
	}
	public static int getCounter() {
		return counter;
	}
	public static void setCounter(int counter) {
		Memory.counter = counter;
	}
	public Register getReadData() {
		return readData;
	}
	public void setReadData(Register readData) {
		this.readData = readData;
	}
	public Register getAddress() {
		return address;
	}
	public void setAddress(Register address) {
		this.address = address;
	}
	public char getMemwrite() {
		return memwrite;
	}
	public void setMemwrite(char memwrite) {
		this.memwrite = memwrite;
	}
	public char getMemread() {
		return memread;
	}
	public void setMemread(char memread) {
		this.memread = memread;
	}
	public void add(Register register)
	{
		memory[counter] = new Register(32);
		memory[counter].setValue(register.getValue());
		counter++;
	}
	public void execute()
	{
	//	System.out.println(address.toInt() + " " + memread + " " + memwrite);
		if(memwrite == '1')
		{
			if(memory[address.toInt()] == null)
			{
				memory[address.toInt()] = new Register(32);
			}
			memory[address.toInt()].setValue(writeData.getValue());
		}
		if(memread == '1')
		{
			readData.setValue(memory[address.toInt()].getValue());
		}
			
			
	}
	public Register getWriteData() {
		return writeData;
	}
	public void setWriteData(Register writeData) {
		this.writeData = writeData;
	}
}
