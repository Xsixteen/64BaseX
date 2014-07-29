
public class BaseX {
	private String output = "";
	
	public BaseX(String message) {
		//TODO: Break into 3 word Chunks for entire message
		//	chunk("Man");
		for(int i=0; i < message.length(); i=i+3) {
			if(i >= message.length()) {
				
			}
			else if(i+1 >= message.length()) {
				output = output + chunk(""+message.charAt(i));
			} else if(i + 2 >= message.length() ) {
				output = output + chunk((""+message.charAt(i)+message.charAt(i+1)));
			} else {
				output = output + chunk((""+message.charAt(i)+message.charAt(i+1)+message.charAt(i+2)));
			}
		}
		if (Debugger.isEnabled())
		    Debugger.log(output);
	}
	
	public String message() {
		return output;
	}
	
	public String chunk(String content) {
		codex test = new codex();
		
		if(content.length() == 1) {
			test.setMessage((byte)content.charAt(0), (byte) 0, (byte) 0);
			test.encodeMessage();
			if (Debugger.isEnabled())
			    Debugger.log("Base64 Response: " + test.getMessage());
		} else if (content.length() == 2) {
			test.setMessage((byte)content.charAt(0), (byte)content.charAt(1), (byte)0);
			test.encodeMessage();
			if (Debugger.isEnabled())
			    Debugger.log("Base64 Response: " + test.getMessage());
		} else if (content.length() <= 3) { 
			test.setMessage((byte)content.charAt(0), (byte)content.charAt(1), (byte)content.charAt(2));
			test.encodeMessage();
			if (Debugger.isEnabled())
			    Debugger.log("Base64 Response: " + test.getMessage());
		} else {
			return "error";
		}
		return test.getMessage();
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseX obj = new BaseX("leasure.");
		
	}

}
