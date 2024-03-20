package com.example.practica_m07_uf1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import kotlinx.coroutines.NonDisposableHandle.parent

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [DetallesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetallesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var transaction: Transaction? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            transaction = it.getSerializable(ARG_PARAM1) as Transaction?
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalles, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val displayName = view.findViewById<TextView>(R.id.textView)
        val displayAmount = view.findViewById<TextView>(R.id.textView2)

        val displayDate = view.findViewById<TextView>(R.id.textViewDateDisplay)

        val displayType = view.findViewById<TextView>(R.id.textViewTypeDisplay)



        if (transaction != null) {
            displayName?.text = transaction?.name
            displayAmount?.text = "${transaction?.amount}€"
            displayType?.text = transaction?.type
            displayDate?.text = transaction?.date
        }


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @return A new instance of fragment DetallesFragmetn.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Transaction?) =
            DetallesFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, param1)
                }
            }
    }
}