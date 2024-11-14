package info.fahri.aplikasicurhat;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class CurhatAdapter extends FirestoreRecyclerAdapter<Curhat, CurhatAdapter.ViewHolder> {

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public CurhatAdapter(@NonNull FirestoreRecyclerOptions<Curhat> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull CurhatAdapter.ViewHolder holder, int position, @NonNull Curhat model) {
        holder.txtCurhat.setText(model.konten);
        holder.txtNama.setText(model.email);

        String uid = getSnapshots().getSnapshot(position).getId();
        model.uid = uid;

        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = holder.itemLayout.getContext();
                Intent intent = new Intent(context, DetailCurhatActivity.class);
                intent.putExtra("current_curhat", model);
                context.startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public CurhatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.curhat_item, parent, false));
        return holder;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtCurhat, txtNama;
        public ConstraintLayout itemLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtCurhat = itemView.findViewById(R.id.txtItemKonten);
            txtNama = itemView.findViewById(R.id.txtItemNama);
            itemLayout = itemView.findViewById(R.id.item_layout);
        }
    }
}
