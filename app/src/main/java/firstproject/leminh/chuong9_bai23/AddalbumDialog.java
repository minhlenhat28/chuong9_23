package firstproject.leminh.chuong9_bai23;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

public class AddalbumDialog extends Dialog {
    Activity context;
    EditText edtmaalbum;
    EditText edttenalbum;
    Button btnxoatrang;
    Button btnluualbum;
    onSaveAlbumListener onSaveAlbumListener;
    public void setOnSaveAlbumListener(onSaveAlbumListener onSaveAlbumListener){
        this.onSaveAlbumListener = onSaveAlbumListener;
    }
    public AddalbumDialog(@NonNull Activity context) {
        super(context);
        this.context = context;
        setContentView(R.layout.addalbumdialog);
        addControls();
        addEvent();

    }
    public void addControls(){
        edtmaalbum = (EditText) findViewById(R.id.edtmaalbum);
        edttenalbum = (EditText) findViewById(R.id.edttenalbum);
        btnluualbum = (Button) findViewById(R.id.btnluulbum);
        btnxoatrang = (Button) findViewById(R.id.btnxoatrang);
        setTitle("Them Album ");
    }
    public void addEvent(){
        btnxoatrang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtmaalbum.setText("");
                edttenalbum.setText("");
                edtmaalbum.requestFocus();

            }
        });
        btnluualbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSaveAlbumListener.onSave(edtmaalbum.getText().toString(),edttenalbum.getText().toString());
                dismiss();
            }
        });
    }
}
