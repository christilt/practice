
public class BeerSong {
	
	public static String verse(int bottles) {
		return new LineOne(bottles--).getLine() + new LineTwo(bottles).getLine();
	}
	
	public static String sing(int firstVerse, int lastVerse) {
		StringBuilder builder = new StringBuilder();
		for (int bottles = firstVerse; bottles >= lastVerse; bottles--) {
			builder.append(verse(bottles));
		}
		return builder.toString();
	}

	public static String singSong() {
		return sing(99, 0);
	}
	
	public static class LineOne {
		
		String line;
		
		public LineOne (int bottles) {
			if (bottles > 1) {
				this.line = bottles + " bottles of beer on the wall, " + bottles + " bottles of beer.\n";
			} else if (bottles == 1) {
				this.line = "1 bottle of beer on the wall, 1 bottle of beer.\n";
			} else {
				this.line = "No more bottles of beer on the wall, no more bottles of beer.\n";
			}
		}
		
		public String getLine() {
			return this.line;
		}
		
	}
	
	public static class LineTwo {
		
		String line;
		
		public LineTwo (int bottles) {
			if (bottles > 1) {
				this.line = "Take one down and pass it around, " + bottles + " bottles of beer on the wall.\n\n";
			} else if (bottles == 1) {
				this.line = "Take one down and pass it around, 1 bottle of beer on the wall.\n\n";
			} else if (bottles == 0) {
				this.line = "Take it down and pass it around, no more bottles of beer on the wall.\n\n";
			} else {
				this.line = "Go to the store and buy some more, 99 bottles of beer on the wall.\n\n";
			}
		}
		
		public String getLine() {
			return this.line;
		}
		
	}
	
}