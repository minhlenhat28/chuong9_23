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
        Log.d("KIem tra 3","qua tao intent albumlist");
        listView = (ListView) findViewById(R.id.lv);
        customlistview = new Customlistview(AlbumList.this,R.layout.albumlist);
        lvalbum = (ArrayList<Album>) intent.getSerializableExtra("List");
        customlistview.setdata(lvalbum);
        listView.setAdapter(customlistview);
        Log.d("KIem tra 4","qua lay lv album intent albumlist");
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
        getDatafromMain();
    }

    public void getDatafromMain(){
        intent.putExtra("list",lvalbum);
        Log.d("KIem tra 10","qua tao getdatafrommain");
        setResult(115,intent);
        Log.d("KIem tra 1","qua tao setresult");
    }
}
