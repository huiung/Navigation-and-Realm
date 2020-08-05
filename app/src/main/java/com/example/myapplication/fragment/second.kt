package com.example.myapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.example.myapplication.R
import com.example.myapplication.RealmManager
import io.realm.Realm
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.android.synthetic.main.fragment_second.textview
import kotlinx.android.synthetic.main.fragment_second.textview2

/**
 * A simple [Fragment] subclass.
 */
class second : Fragment() {

    lateinit var navController: NavController
    lateinit var realmManager:RealmManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        realmManager = RealmManager(Realm.getDefaultInstance())
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)


        val bundle = bundleOf("message" to "i'm from second fragment")

        val message = arguments?.getString("message")



        textview2.text = message

        textview.setOnClickListener {
            navController.navigate(R.id.action_second2_to_first2, bundle)
        }
    }
}
