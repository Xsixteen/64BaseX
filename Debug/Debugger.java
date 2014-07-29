package Debug;

public class Debugger {
		private static boolean enabled = true;
	    public static boolean isEnabled(){
	        return enabled;
	    }

	    public static void log(Object o){
	        System.out.println(o.toString());
	    }
}
