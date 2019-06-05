package mx.edu.ittepic.u5_lista_sensores;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context mCtx;
    private List<DataProvider> productList;

    public ProductAdapter(Context mCtx, List<DataProvider> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.card_layout,null);

        ProductViewHolder holder = new ProductViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        DataProvider product = productList.get(position);
        holder.txtNombre.setText(product.getNombre());
        holder.txtFabricante.setText(product.getFabricante());
        holder.txtVersion.setText(product.getVersion());
        holder.txtRangoMaximo.setText(product.getRango_max());
        holder.txtRetrasoMinimo.setText(product.getRetraso_min());
        holder.txtPotencia.setText(product.getPotencia());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{

        TextView txtNombre,txtFabricante,txtVersion,txtRangoMaximo,txtRetrasoMinimo,txtPotencia;

        CardView cv;
        ConstraintLayout constraint;

        public ProductViewHolder(View itemView) {
            super(itemView);

            cv = itemView.findViewById(R.id.card_view);
            constraint = itemView.findViewById(R.id.constraint);
            txtNombre = itemView.findViewById(R.id.textView1);
            txtFabricante = itemView.findViewById(R.id.textView2);
            txtVersion = itemView.findViewById(R.id.textView);
            txtRangoMaximo = itemView.findViewById(R.id.textView3);
            txtRetrasoMinimo = itemView.findViewById(R.id.textView6);
            txtPotencia = itemView.findViewById(R.id.textView7);


        }
    }


}
