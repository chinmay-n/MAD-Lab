package com.example.student.q1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import static android.Manifest.permission.READ_CONTACTS;


public class MainActivity extends ListActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    // This is the Adapter being used to display the list's data
    SimpleCursorAdapter mAdapter;
    // These are the Contacts rows that we will retrieve
    static final String[] PROJECTION = new String[]{ContactsContract.Data._ID, ContactsContract.Data.DISPLAY_NAME,ContactsContract.Data.CONTACT_ID};
    // This is the select criteria
    static final String SELECTION = "((" + ContactsContract.Data.DISPLAY_NAME + " NOTNULL)AND (" + ContactsContract.Data.DISPLAY_NAME + " != '' ))";

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this, ContactsContract.Data.CONTENT_URI, PROJECTION, SELECTION, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        mAdapter.swapCursor(cursor);
    }

    @Override public void onListItemClick(ListView l, View v, int position, long id) {
        // Do something when a list item is clicked
        String s = l.getItemAtPosition(position).toString();
        Toast.makeText(this,s, Toast.LENGTH_SHORT).show();
        }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mAdapter.swapCursor(null);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a progress bar to display while the list loads
        ProgressBar progressBar = new ProgressBar(this);
        progressBar.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, Gravity.CENTER));
        progressBar.setIndeterminate(true); getListView().setEmptyView(progressBar);
        // Must add the progress bar to the root of the layout
        ViewGroup root = (ViewGroup) findViewById(android.R.id.content); root.addView(progressBar);
        // For the cursor adapter, specify which columns go into which views
        String[] fromColumns = {ContactsContract.Data.DISPLAY_NAME};
        int[] toViews = {android.R.id.text1};
        // The TextView in simple_list_item_1 // Create an empty adapter we will use to display the loaded data.
        // We pass null for the cursor, then update it in onLoadFinished()
        mAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, null, fromColumns, toViews, 0);
        setListAdapter(mAdapter);
        // Prepare the loader. Either re-connect with an existing one, // or start a new one.
        getLoaderManager().initLoader(0, null, this);
    }
}

