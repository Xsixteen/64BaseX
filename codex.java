import Debug.Debugger;


public class codex {
	private Byte[] eightBits = new Byte[3];
	private String message = "";
	private String codex = "ABCDEFGHIJLKMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
	
	public void encodeMessage() {
		int work = 0;
		
		//Bits 0-5
		work |= getBit(eightBits[0],7);
		work <<= 1;
		work |= getBit(eightBits[0],6);
		work <<= 1;
		work |= getBit(eightBits[0],5);
		work <<= 1;
		work |= getBit(eightBits[0],4);
		work <<= 1;
		work |= getBit(eightBits[0],3);
		work <<= 1;
		work |= getBit(eightBits[0],2);
		
		message = "" + (encodeBlock(work));
		
		
		if (Debugger.isEnabled())
		    Debugger.log("Bits 0 -5: " + (int) work + " Char Returned: " + encodeBlock(work));
		//Bits 6 - 11
		work = 0;	
		work |= getBit(eightBits[0],1);
		work <<= 1;
		work |= getBit(eightBits[0],0);
		work <<= 1;
		work |= getBit(eightBits[1],7);
		work <<= 1;
		work |= getBit(eightBits[1],6);
		work <<= 1;
		work |= getBit(eightBits[1],5);
		work <<= 1;
		work |= getBit(eightBits[1],4);
		message = message + (encodeBlock(work));
		if (Debugger.isEnabled())
		    Debugger.log("Bits 6 - 11: " + (int) work + " Char Returned: " + encodeBlock(work));
		
		
		if(eightBits[1] == 0){
			message = message + "==";
		} else {
			//Bits 12 - 17
			work = 0;	
			work <<= 6;
			work |= getBit(eightBits[1],3);
			work <<= 1;
			work |= getBit(eightBits[1],2);
			work <<= 1;
			work |= getBit(eightBits[1],1);
			work <<= 1;
			work |= getBit(eightBits[1],0);
			work <<= 1;
			work |= getBit(eightBits[2],7);
			work <<= 1;
			work |= getBit(eightBits[2],6);
			message = message + (encodeBlock(work));
			if (Debugger.isEnabled())
			    Debugger.log("Bits 12 - 17: " + (int) work + " Char Returned: " + encodeBlock(work));	
		}
		
		if(eightBits[2] == 0){
			message = message + "=";
		} else {
			//Bits 18 - 23
			work = 0;	
			work <<= 6;
			work |= getBit(eightBits[2],5);
			work <<= 1;
			work |= getBit(eightBits[2],4);
			work <<= 1;
			work |= getBit(eightBits[2],3);
			work <<= 1;
			work |= getBit(eightBits[2],2);
			work <<= 1;
			work |= getBit(eightBits[2],1);
			work <<= 1;
			work |= getBit(eightBits[2],0);
			message = message + (encodeBlock(work));
			if (Debugger.isEnabled())
			    Debugger.log("Bits 18 - 23: " + (int) work + " Char Returned: " + encodeBlock(work));
		}
	
		
	}
	
	public void decodeMessage() {
		
	}
	
	
	
	public void setMessage(Byte b1, Byte b2, Byte b3) {
		setBlock(0, b1);
		setBlock(1, b2);
		setBlock(2, b3);
	}
	
	public String getMessage() {
		return message;
	}
	
	private char encodeBlock(int index) {
		return codex.charAt(index);
	}
	
	private void setBlock(int bNum, Byte b) {
		if(bNum < 3) {
			eightBits[bNum] = b;
		}
	}
	
	private Byte getBlock(int bNum) {
		if(bNum < 3) {
			return eightBits[bNum];
		} else {
			return (byte) -1;
		}
	}
	
	public int getBit(Byte b, int position)
	{
	   return ((b >> position) & 1);
	}
	

}
