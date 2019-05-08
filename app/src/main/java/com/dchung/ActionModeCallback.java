package com.dchung;


import android.support.annotation.MenuRes;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

public class ActionModeCallback implements ActionMode.Callback {

  private static String TAG = "ActionModeCallback";

  @Override
  public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
    Log.wtf(TAG,"onCreateActionMode");
    return false;
  }

  @Override
  public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
    Log.wtf(TAG,"onPrepareActionMode");
    return false;
  }

  @Override
  public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
    Log.wtf(TAG,"onActionItemClicked");
    return false;
  }

  @Override
  public void onDestroyActionMode(ActionMode actionMode) {
    Log.wtf(TAG,"onDestroyActionMode");
  }
}