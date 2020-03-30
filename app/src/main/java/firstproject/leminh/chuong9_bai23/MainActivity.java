package firstproject.leminh.chuong9_bai23;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnaddalbum;
    Button btnpreview;
    Button btnquanlybaihat;
    TextView thuma;
    TextView thuten;
    ArrayList<Album> albumList;
    Intent intent=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvent();
    }
    public void addControls(){
        btnaddalbum = (Button) findViewById(R.id.btnaddalbum);
        btnpreview = (Button) findViewById(R.id.btnpreview);
        btnquanlybaihat = (Button) findViewById(R.id.btnquanlybaihat);
        thuma = (TextView) findViewById(R.id.thuma);
        thuten = (TextView) findViewById(R.id.thuten);
        albumList = new ArrayList<>();

    }
    public void addEvent(){
        btnaddalbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddalbumDialog addalbumDialog = new AddalbumDialog(MainActivity.this);
                addalbumDialog.setOnSaveAlbumListener(new onSaveAlbumListener() {
                    @Override
                    public void onSave(String ma,String ten) {
                        thuma.setText(String.valueOf(albumList.size()));
                        thuten.setText(ten);
                        albumList.add(new Album(albumList.size()+1,ma,ten)); //lay du lieu tu customdialog
                    }
                });
                addalbumDialog.show();
            }
        });
        btnpreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDataforAlbumlist();
            }
        });
    }
    public void setDataforAlbumlist(){
        intent = new Intent(MainActivity.this,AlbumList.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("List",albumList);
        intent.putExtra("mybundle",bundle);
        startActivityForResult(intent,113);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 113 && resultCode == 115){
           // Bundle bundle = data.getBundleExtra("mybundle");
          //  albumList = (ArrayList<Album>) bundle.getSerializable("list");

        }
    }
}
