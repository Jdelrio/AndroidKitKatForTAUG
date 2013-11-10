package com.juliendelrio.kitkat4taug;

import android.content.Context;
import android.util.DisplayMetrics;

public final class UITools {

	private UITools() {
	}

	public static int dpToPx(Context context, int dp) {
		DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
		int px = (int) (dp * displayMetrics.density + 0.5f);
		return px;
	}

	public static int pxToDp(Context context, int px) {
		DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
		int dp = (int) (px / displayMetrics.density + 0.5f);
		return dp;
	}
}
