# Android-Flag-Kit

Free Resource from https://dribbble.com/shots/2828120-All-Flags-Freebie-Flag-Kit

####  Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

```groovy
	allprojects {
		repositories {
			...
			mavenCentral()
		}
	}
```

#### Step 2. Add the dependency

```groovy
	dependencies {
    	implementation 'io.github.xiaoyuecai:flag-kit:1.0.0'
	}
```

#### Step 3. Using

in XML

```xml
<io.github.android.flagkit.FlagImageView
    android:id="@+id/flagView"
    android:layout_width="70dp"
    android:layout_height="wrap_content"
    app:countryCode="US"
    tools:src="@drawable/flag_us" />
```

in Java Code

```java
FlagImageView flagImageView = findViewById(R.id.flagView);

flagImageView.setCountryCode("US"); // with text code

flagImageView.setCountryCode(Locale.CANADA); //  with Locale

flagImageView.defaultLocal(); // Show current device

int resId = FlagUtils.getFlagResIdByCountryCode(this, "US"); // get flag resId with country code

```

