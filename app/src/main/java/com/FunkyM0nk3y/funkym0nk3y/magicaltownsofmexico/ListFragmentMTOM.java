package com.FunkyM0nk3y.funkym0nk3y.magicaltownsofmexico;

import android.app.AlertDialog;
import android.app.ListFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by FunkyM0nk3y on 8/29/15.
 */
public class ListFragmentMTOM extends ListFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        LoadAsyncTask mt = new LoadAsyncTask(getActivity(), this);
        mt.execute("https://www.googleapis.com/fusiontables/v1/query?sql=SELECT*FROM%2011GTk-iKcdvPSNTvKcxf1anMs1s_9DcI1uYGMu7c%20ORDER%20BY%20Ciudad&key=AIzaSyALk5qQAiXa8o6kH5bACKM9Ms7bqIRdk_s");
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub

        super.onListItemClick(l, v, position, id);
        MagicalTown r = (MagicalTown) getListAdapter().getItem(position);

        Intent intent = new Intent("com.FunkyM0nk3y.funkym0nk3y.MAPS_ACTIVITY");
        intent.putExtra("magicaltown", r.getMagicaltown());
        intent.putExtra("state", r.getState());
        intent.putExtra("latitudemt", r.getLatitudeMT());
        intent.putExtra("longitudemt", r.getLongitudeMT());

        startActivity(intent);
    }
}
