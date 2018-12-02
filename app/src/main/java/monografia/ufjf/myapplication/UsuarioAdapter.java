package monografia.ufjf.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.ViewHolder>{

    private Cursor cursor;
    private OnUsuarioClickListener listener;
    private onUsuarioLongClickListener longListener;

    public interface OnUsuarioClickListener {
        void onUsuarioClick(View usuarioView, int itemId);
    }

    public interface onUsuarioLongClickListener {
        void onUsuarioLongClick(View usuarioView, int itemId);
    }

    public void setOnUsuarioClickListener(OnUsuarioClickListener listener){
        this.listener = listener;
    }

    public void setOnUsuarioLongClickListener(UsuarioAdapter.onUsuarioLongClickListener longListener){
        this.longListener = longListener;
    }

    public void setCursor(Cursor c)
    {
        cursor = c;
    }

    public UsuarioAdapter(Cursor c) {
        cursor = c;
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context ctx = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(ctx);

        View itemView = inflater.inflate(R.layout.item_usuario, viewGroup, false);
        ViewHolder vwHolder = new ViewHolder(itemView);
        return vwHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        int idxTitulo = cursor.getColumnIndexOrThrow(CadastroPessoalContract.CadastroPessoal.COLUMN_NAME_NOME);
        int idxId = cursor.getColumnIndexOrThrow(CadastroPessoalContract.CadastroPessoal._ID);
        cursor.moveToPosition(i);
        viewHolder.txtNomeUsuario.setText(cursor.getString(idxTitulo));

        final int id = cursor.getInt(idxId);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onUsuarioClick(v, id);
                }
            }
        });

        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (longListener != null) {
                    longListener.onUsuarioLongClick(v, id);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtNomeUsuario;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            txtNomeUsuario = (TextView)itemView.findViewById(R.id.txtNomeUsuarioMain);
        }
    }

}
