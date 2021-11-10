package io.github.android.flagkit.example;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import io.github.android.flagkit.FlagImageView;

public class MainActivity extends AppCompatActivity {

  FlagImageView flagImageView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    flagImageView = findViewById(R.id.flagView);
  }

  public void currentFlag(View v) {
    flagImageView.defaultLocal();
  }
}
