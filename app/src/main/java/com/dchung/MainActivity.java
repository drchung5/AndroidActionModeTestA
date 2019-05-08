package com.dchung;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

  private ActionMode mActionMode = null;

  private static String TAG = "MainActivity";

  @Override
  public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
    Log.wtf(TAG,"onWindowStartingActionMode");

    return super.onWindowStartingActionMode(callback);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    WebView webView = findViewById(R.id.webview);
    webView.setWebViewClient(new WebViewClient());

    runOnUiThread(()->webView.loadUrl("https://www.abikelife.com"));
  }

  @Override
  public void onActionModeStarted(ActionMode mode) {
    if (mActionMode == null) {

      Log.wtf(TAG,mode.toString());

      mActionMode = mode;
      Menu menu = mode.getMenu();
      // Remove the default menu items (select all, copy, paste, search)
      menu.clear();

      // If you want to keep any of the defaults,
      // remove the items you don't want individually:
      // menu.removeItem(android.R.id.[id_of_item_to_remove])

      // Inflate your own menu items
      mode.getMenuInflater().inflate(R.menu.select_menu, menu);

      // remove an item
      menu.removeItem(R.id.autostudy);

      menu.findItem(R.id.copy)
            .setOnMenuItemClickListener(
                  menuItem -> {
                    Log.wtf(TAG,"COPY");
                    return true;
                  }
            );


//      View menuView = mode.getCustomView();


    }

    super.onActionModeStarted(mode);
  }

  // This method is what you should set as your item's onClick
// <item android:onClick="onContextualMenuItemClicked" />
  public void onContextualMenuItemClicked(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.copy:
        Log.wtf(TAG,"Copy");
        break;
      case R.id.share:
        Log.wtf(TAG,"Share");
        break;
      case R.id.dictionary:
        Log.wtf(TAG,"Dictionary");
        break;
      case R.id.web_search:
        Log.wtf(TAG,"Web Search");
        break;
      case R.id.autostudy:
        Log.wtf(TAG,"Auto Study");
        break;
      default:
        // ...
        break;
    }

    // This will likely always be true, but check it anyway, just in case
    if (mActionMode != null) {
      mActionMode.finish();
    }
  }

  @Override
  public void onActionModeFinished(ActionMode mode) {
    mActionMode = null;
    super.onActionModeFinished(mode);
  }
}
