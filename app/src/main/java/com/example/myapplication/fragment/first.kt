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
import com.example.myapplication.exdata
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass.
 */
class first : Fragment() {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        val bundle = bundleOf("message" to "i'm from first fragment!")

        //data 생성 및 삽입
        var data1 = exdata()
        data1.name = "huiung"
        data1.phone = "000-0000-0000"
        data1.email = "aaa@aaaaaa.caa"
//
//        RealmManager.create(data1)


        //동일 Name의 data 제거
       RealmManager.deleteByName("huiung")


        // 동일 Name의 data 업데이트
//        data1.phone = "change"
//        data1.email = "change"

//        RealmManager.update("huiung", data1)


        //해당 name의 data find
        val viewdata = RealmManager.find("huiung")

        textview2.text = viewdata.toString()

        textview.setOnClickListener {
            navController.navigate(R.id.action_first2_to_second2, bundle)
        }
    }
}
