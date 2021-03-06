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

import java.util.ArrayList;

public class Customlistview extends ArrayAdapter<Album> {
    private Context context;
    private int resource;
    TextView liststt;
    TextView listma;
    TextView listten;
    ArrayList<Album> albumArrayList;
    public Customlistview(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        Log.d("khoi tao:","khoi tao custom list view");
    }
    public void setdata(ArrayList<Album> albumArrayList){
        this.albumArrayList = albumArrayList;
        Log.d("khoi tao: ","set Array list vao CustomListView");
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Log.d("----Chay vo getView:", "Chay vo getView");
        convertView = LayoutInflater.from(context).inflate(resource,parent,false);
        liststt = (TextView) convertView.findViewById(R.id.liststt);
        listma = (TextView) convertView.findViewById(R.id.listmaalbum);
        listten = (TextView) convertView.findViewById(R.id.listtenalbum);
        Album c = albumArrayList.get(position);
        liststt.setText(String.valueOf(c.getStt()));
        listma.setText(c.getMaalbum());
        listten.setText(c.getTenalbum());

        return convertView;
    }
}
