package engineer.jsp.g711a;

public class G711a {

	static {
		System.loadLibrary("G711a");
	}

	/**
	 * PCM data encode to G711A
	 * 
	 * @param pcmDataArr
	 *            PCM source array
	 * @param result
	 *            call {@link engineer.jsp.g711a.G711a.Result} getDataArr method
	 */
	public static native void G711aEncode(byte[] pcmDataArr, Result result);

	/**
	 * G711A data decode to PCM
	 * 
	 * @param g711DataArr
	 *            G711A source array
	 * @param result
	 *            call {@link engineer.jsp.g711a.G711a.Result} getDataArr method
	 */
	public static native void G711aDecode(byte[] g711DataArr, Result result);

	public static class Result {

		private byte[] dataArr;

		/**
		 * set [B
		 * 
		 * @param dataArr
		 */
		public void setDataArr(byte[] dataArr) {
			this.dataArr = dataArr;
		}

		/**
		 * get [B
		 * 
		 * @return
		 */
		public byte[] getDataArr() {
			return dataArr;
		}
	}

}