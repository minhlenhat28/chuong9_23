package firstproject.leminh.chuong9_bai23;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AlbumAdapter extends ArrayAdapter {
    private Context context;
    private int resource;
    TextView liststt;
    TextView listma;
    TextView listten;
    ArrayList<Album> albumArrayList;
    public AlbumAdapter(@NonNull Context context, int resource, ArrayList<Album> albumArrayAdapter) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.albumArrayList = albumArrayAdapter;
    }
    public void setdata(ArrayList<Album> albumArrayList){
        this.albumArrayList = albumArrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Log.d("----Chay vo getView:", "Chay vo getView");
        convertView = LayoutInflater.from(context).inflate(resource,parent,false);
        liststt = convertView.findViewById(R.id.liststt);
        listma  = convertView.findViewById(R.id.listmaalbum);
        listten = convertView.findViewById(R.id.listtenalbum);
        Album c = albumArrayList.get(position);
        liststt.setText(String.valueOf(c.getStt()));
        listma.setText(c.getMaalbum());
        listten.setText(c.getTenalbum());

        return convertView;
    }
}
