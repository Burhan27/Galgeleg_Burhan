package com.example.burhanari.galgeleg_burhan;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

public class Highscore_Adapter  {

 /**
  extends RecyclerView.Adapter<Highscore_Adapter.MyViewHolder>
    private Context context;
    private String[] names;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public MyViewHolder(TextView v) {
            super(v);
            mTextView = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public Highscore_Adapter(Context context, String[] names) {
        this.context = context;
        this.names = names;
    }

    // Create new views (invoked by the layout manager)

    @Override
    public Highscore_Adapter.MyViewHolder onCreateViewHolder(ViewGroup vg ,int i){

    }
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(names[position]);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return names.length;
    }
**/
}
