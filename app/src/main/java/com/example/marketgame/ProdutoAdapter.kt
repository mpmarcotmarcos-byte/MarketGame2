import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marketgame.R
import models.Produto

class ProdutoAdapter(private val lista: List<Produto>) :
    RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder>() {

    class ProdutoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nome = itemView.findViewById<TextView>(R.id.tvNome)
        val preco = itemView.findViewById<TextView>(R.id.tvPreco)
        val rating = itemView.findViewById<RatingBar>(R.id.ratingProduto)
        val imagem = itemView.findViewById<ImageView>(R.id.imgProduto01)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_item_produto, parent, false)
        return ProdutoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        val produto = lista[position]
        holder.nome.text = produto.nome
        holder.rating.rating = produto.avaliacao
        holder.preco.text = "R$ ${produto.preco}"
        holder.imagem.setImageResource(produto.imagem)
    }

    override fun getItemCount(): Int = lista.size
}