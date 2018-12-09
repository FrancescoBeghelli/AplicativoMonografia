package monografia.ufjf.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AtividadeAdapter extends RecyclerView.Adapter<AtividadeAdapter.ViewHolder> {

    private Cursor cursor;
    private AtividadeAdapter.OnAtividadeClickListener listener;
    private AtividadeAdapter.onAtividadeLongClickListener longListener;

    public interface OnAtividadeClickListener {
        void onAtividadeClick(View usuarioView, int itemId);
    }

    public interface onAtividadeLongClickListener {
        void onAtividadeLongClick(View usuarioView, int itemId);
    }

    public void setOnAtividadeClickListener(AtividadeAdapter.OnAtividadeClickListener listener){
        this.listener = listener;
    }

    public void setOnAtividadeLongClickListener(AtividadeAdapter.onAtividadeLongClickListener longListener){
        this.longListener = longListener;
    }

    public void setCursor(Cursor c)
    {
        cursor = c;
    }

    public AtividadeAdapter(Cursor c) {
        cursor = c;
    }

    @NonNull
    public AtividadeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context ctx = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(ctx);

        View itemView = inflater.inflate(R.layout.item_atividade, viewGroup, false);
        AtividadeAdapter.ViewHolder vwHolder = new AtividadeAdapter.ViewHolder(itemView);
        return vwHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AtividadeAdapter.ViewHolder viewHolder, int i) {
        int idxTitulo = cursor.getColumnIndexOrThrow(AtividadeFisicaContract.Atividade.COLUMN_NAME_NOME);
        int idxPonto = cursor.getColumnIndexOrThrow(AtividadeFisicaContract.Atividade.COLUMN_NAME_PONTO);
        int idxId = cursor.getColumnIndexOrThrow(AtividadeFisicaContract.Atividade._ID);
        cursor.moveToPosition(i);
        viewHolder.txtNomeAtividadeMain.setText(cursor.getString(idxTitulo));
        viewHolder.txtPonto.setText(String.format("%.2f", cursor.getDouble(idxPonto)));
        final int id = cursor.getInt(idxId);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onAtividadeClick(v, id);
                }
            }
        });

        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (longListener != null) {
                    longListener.onAtividadeLongClick(v, id);
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

        public TextView txtNomeAtividadeMain;
        public TextView txtPonto;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            txtNomeAtividadeMain = (TextView)itemView.findViewById(R.id.txtNomeAtividadeMain);
            txtPonto = (TextView)itemView.findViewById(R.id.txtPontoAtividadeUsuario);
        }
    }


}
