package firstproject.leminh.chuong9_bai23;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AlbumList extends AppCompatActivity {

    ListView listView;
    Customlistview customlistview;
    ArrayList<Album> lvalbum;
    Intent intent=null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.albumlist);
        addControls();
        addEvent();
    }
    public void addControls(){
        intent = getIntent();
        lvalbum = new ArrayList<>();
        Bundle bundle = intent.getBundleExtra("mybundle");
        Log.d("KIem tra 3","qua tao intent albumlist");
        listView = (ListView) findViewById(R.id.lvmodule);                                  //anh xa listview
        //customlistview = new Customlistview(AlbumList.this,R.layout.itemlistview);

        lvalbum.add(new Album(1,"ma1","Minh"));
        lvalbum.add(new Album(1,"ma1","Minh"));
        lvalbum.add(new Album(1,"ma1","Minh"));
        lvalbum.add(new Album(1,"ma1","Minh"));
        lvalbum.add(new Album(1,"ma1","Minh"));
        AlbumAdapter albumAdapter = new AlbumAdapter(this,R.layout.itemlistview,lvalbum);
        //lvalbum = (ArrayList<Album>) bundle.getSerializable("List");
        //customlistview.setdata(lvalbum);
        albumAdapter.setdata(lvalbum);
        listView.setAdapter(albumAdapter);
        Log.d("KIem tra 4","qua lay lv album intent albumlist");
        Log.d("Kiem tra listview",String.valueOf(lvalbum.size()));
       // Log.d("Kiem tra listview",lvalbum.get(0).getMaalbum());
       // Log.d("Kiem tra listview",lvalbum.get(0).getTenalbum());
    }
    public void addEvent(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("KIem tra 9","qua stop");
        getDataBackToMain();
    }

    public void getDataBackToMain(){
       //Bundle bundle = new Bundle();
        //bundle.putSerializable("list",lvalbum);
       // intent.putExtra("mybundle",bundle);
        Log.d("KIem tra 10","qua tao getdatafrommain");
      //  setResult(115,intent);
        Log.d("KIem tra 1","qua tao setresult");
    }
}
