package io.github.android.flagkit;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import java.util.Locale;

public class FlagUtils {
  private static final String TAG = FlagUtils.class.getSimpleName();

  private FlagUtils() {
    throw new UnsupportedOperationException("u can't instantiate it.");
  }

  public static @DrawableRes int getFlagResIdByCountryCode(
      @NonNull Context context, @NonNull String countryCode) {
    if (TextUtils.isEmpty(countryCode)) {
      return 0;
    } else {
      Resources resources = context.getResources();
      final String resName = "flag_" + countryCode.toLowerCase(Locale.ENGLISH);
      final int resourceId = resources.getIdentifier(resName, "drawable", context.getPackageName());
      if (resourceId == 0) {
        Log.w(TAG, String.format("CountryCode `%s` is wrong!", countryCode));
      }
      return resourceId; // resourceId = 0 is not found
    }
  }
}
