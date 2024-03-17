import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practica_m07_uf1.APIService
import com.example.practica_m07_uf1.Adapter
import com.example.practica_m07_uf1.AppDatabase
import com.example.practica_m07_uf1.R
import com.example.practica_m07_uf1.Transaction
import com.example.practica_m07_uf1.Transactiondb
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var db: AppDatabase // lateinit sirve para que no falle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        GlobalScope.launch {
            db = AppDatabase.getInstance(applicationContext)!!

            val transactions = db.TransactionDAO().loadAll()

            if (transactions.isEmpty()) {
                val remoteTransactions = getRetrofit()
                withContext(Dispatchers.Main) {
                    val adapter = Adapter(remoteTransactions)
                    recyclerView.adapter = adapter
                }
            } else {
                val transactionList = convertToTransactions(transactions)
                withContext(Dispatchers.Main) {
                    val adapter = Adapter(transactionList)
                    recyclerView.adapter = adapter
                }
            }
        }
    }

    private suspend fun getRetrofit(): List<Transaction> {
        return withContext(Dispatchers.IO) {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://my-json-server.typicode.com/mateojubells/transaction/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service = retrofit.create(APIService::class.java)
            val response = service.getTransactions().execute()

            val transactions = response.body() ?: emptyList()

            // Insertar cada transacción en la base de datos
            transactions.forEach { transaction ->
                val transactiondb = Transactiondb(
                    uId = null,
                    name = transaction.name,
                    amount = transaction.amount,
                    date = transaction.date,
                    type = transaction.type
                )
                db.TransactionDAO().insert(transactiondb)
            }

            return@withContext transactions
        }
    }
    private fun convertToTransactions(transactiondbs: List<Transactiondb>): List<Transaction> {
        val transactions = mutableListOf<Transaction>()
        transactiondbs.forEach { transactiondb ->
            val transaction = Transaction(
                name = transactiondb.name ?: "",
                amount = transactiondb.amount,
                date = transactiondb.date ?: "",
                type = transactiondb.type ?: ""
            )
            transactions.add(transaction)
        }
        return transactions
    }

}
