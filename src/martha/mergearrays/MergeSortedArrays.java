package martha.mergearrays;

public class MergeSortedArrays {

	private static long[] parseLongs(String string) {
		String[] longStrings = string.split(",");
		// Long.valueOf("123");
		long[] longVals = new long[longStrings.length];

		for (int i = 0; i < longStrings.length; i++) {
			longVals[i] = Long.valueOf(longStrings[i]);
		}
		
		return longVals;
	}
	
	private static long[] mergeArrays(long[] a, long[] b) {
		long[] marray = new long[a.length + b.length];
		int ctra = 0;
		int ctrb = 0;
		
		while (ctra < a.length || ctrb < b.length) {
			if (ctra < a.length && ctrb < b.length) {
				if (a[ctra] <= b[ctrb]) {
					marray[ctra + ctrb] = a[ctra];
					ctra++;
				} else {
					marray[ctra + ctrb] = b[ctrb];
					ctrb++;
				}
			} else if (ctra == a.length) {
				marray[ctra + ctrb] = b[ctrb];
				ctrb++;
			} else {
				marray[ctra + ctrb] = a[ctra];
				ctra++;
			}
		}
		
		return marray;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		assert (args.length == 2);
		String firstString = args[0];
		String secondString = args[1];
		
		long[] firstLongs = parseLongs(firstString);
		long[] secondLongs = parseLongs(secondString);
		
		long[] srtArray = mergeArrays(firstLongs,secondLongs);
		
		for (int i = 0; i < srtArray.length; i++) {
			System.out.println(srtArray[i]);
		}

	}

}
