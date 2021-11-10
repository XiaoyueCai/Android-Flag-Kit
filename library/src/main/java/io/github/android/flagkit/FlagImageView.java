package io.github.android.flagkit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import java.util.Locale;

@SuppressLint("AppCompatCustomView")
public class FlagImageView extends ImageView {

  private static final String TAG = FlagImageView.class.getCanonicalName();

  private String countryCode;

  public FlagImageView(Context context) {
    super(context);
    init(null);
  }

  public FlagImageView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(attrs);
  }

  public FlagImageView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(attrs);
  }

  private void init(AttributeSet attrs) {

    super.setScaleType(ScaleType.CENTER_CROP); // Scale to max width or height
    super.setAdjustViewBounds(true); // Definitely the right ratio

    if (isInEditMode()) return;

    if (attrs != null) {
      TypedArray typedArray =
          getContext().obtainStyledAttributes(attrs, R.styleable.FlagImageView, 0, 0);
      try {
        String countryCode = typedArray.getString(R.styleable.FlagImageView_countryCode);
        if (!TextUtils.isEmpty(countryCode)) setCountryCode(countryCode);
        else defaultLocal();
      } finally {
        typedArray.recycle();
      }
    }
  }

  @Deprecated
  @Override
  public void setScaleType(ScaleType scaleType) {
    // Remove
  }

  @Deprecated
  @Override
  public void setAdjustViewBounds(boolean adjustViewBounds) {
    // Remove
  }

  public void defaultLocal() {
    setCountryCode(Locale.getDefault().getCountry());
    Log.d(TAG, "defaultLocal " + Locale.getDefault().getCountry());
  }

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    countryCode = !TextUtils.isEmpty(countryCode) ? countryCode.toUpperCase(Locale.ENGLISH) : "";
    if (!TextUtils.equals(countryCode, this.countryCode)) {
      this.countryCode = countryCode;
      updateDrawableWithCountryCode();
    }
  }

  public void setCountryCode(Locale locale) {
    setCountryCode(locale.getCountry());
  }

  private void updateDrawableWithCountryCode() {
    setImageResource(FlagUtils.getFlagResIdByCountryCode(getContext(), this.countryCode));
  }
}
