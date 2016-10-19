public class SoundEx {
	public static final char[] MAP = {
        //A  B   C   D   E   F   G   H   I   J   K   L   M
        '0','1','2','3','0','1','2','0','0','2','2','4','5',
        //N  O   P   W   R   S   T   U   V   W   X   Y   Z
        '5','0','1','2','6','2','3','0','1','0','2','0','2'
    };

    public static String soundEx(String s) {
    	String t= s.toUpperCase();

    	StringBuffer res = new StringBuffer();

    	char c, prev = '?', prevOutput = '?';

    	// Main action, find up to 4 char that map
    	for (int i = 0; i<t.length() && res.length() < 4 && (c = t.charAt(i)) != ','; i++) {
    		// Check to see if character under consideration is alphabetic and not a double letter
    		if (c > 'A'&& c < 'Z' && c != prev) {
    			System.out.println("Awesome Char!");
    		}

    	}
    	return "foo";
    }
}