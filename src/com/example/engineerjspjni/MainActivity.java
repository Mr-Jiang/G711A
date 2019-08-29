package com.example.engineerjspjni;

import android.os.Bundle;
import android.widget.TextView;
import engineer.jsp.g711a.G711a;
import engineer.jsp.g711a.G711a.Result;
import android.app.Activity;

public class MainActivity extends Activity {

	private static final byte[] pcmDataArr = { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09 };

	private TextView show_ndk_text;

	private Result result;

	private String ndkStr = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		result = new Result();

		show_ndk_text = (TextView) findViewById(R.id.show_ndk_text);

		G711a.G711aEncode(pcmDataArr, result);
		byte[] g711a = result.getDataArr();

		ndkStr += "\nEncode result : " + BytesToHexString(g711a);

		G711a.G711aDecode(g711a, result);
		byte[] pcm = result.getDataArr();

		ndkStr += "\nDecode result : " + BytesToHexString(pcm);

		show_ndk_text.setText(ndkStr);
	}

	/**
	 * [B to String
	 * 
	 * @param src
	 *            [B
	 * @return String
	 */
	private static String BytesToHexString(byte[] src) {

		if (src == null || src.length <= 0) {
			return null;
		}

		StringBuilder stringBuilder = new StringBuilder("{");

		for (int i = 0; i < src.length; i++) {
			stringBuilder.append("0x");
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			if (i == src.length - 1) {
				stringBuilder.append(hv + "}");
			} else {
				stringBuilder.append(hv + ",");
			}
		}

		return stringBuilder.toString();
	}

}