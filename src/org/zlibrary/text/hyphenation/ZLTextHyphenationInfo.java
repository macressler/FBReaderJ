package org.zlibrary.text.hyphenation;

public class ZLTextHyphenationInfo {
	final boolean[] myMask;

	public ZLTextHyphenationInfo(int length) {
		myMask = new boolean[length - 1];
	}

	public boolean isHyphenationPossible(int position) {
		final boolean mask[] = myMask;
		return (position < mask.length && mask[position]);
	}
}
