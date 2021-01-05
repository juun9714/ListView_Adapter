package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var UserList = arrayListOf<User>(
        //val profile : Int, val name : String, val age : String, val greet : String 모델의 User를 정의한 순서대로 데이터를 넣어주기
        User(R.drawable.profile,"June","25","Hell this world"),
        User(R.drawable.profile,"Harry","37","이해리 입니다"),
        User(R.drawable.profile,"Mingki","32","강민경 입니다"),
        User(R.drawable.profile,"V","27","My name is V of Victory"),
        User(R.drawable.profile,"RM","28","Rap Monster")

    )
    override fun onCreate(savedInstanceState: Bundle?) {
        //액티비티의 실행시작지점
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        /*
        //기본으로 안드로이드에서 제공하는 Adapter를 사용해서 listview를 구현
        //다양한 형태를 구현하려면 custom된 방법을 사용해야 함

        val item = arrayOf("사과","배","포도","체리","오렌지")
        //string 형태의 배열을 생성한 것임
        binding.listView.adapter=ArrayAdapter(this, android.R.layout.simple_list_item_1,item)

        list는 어댑터가 연결되어있어야만 데이터들을 넣어줄 수 있다.
        안드로이드에서 기본저긍로 제공하는 arrayadapter

        첫번째 인자 - context란
        : 한 액티비티의 모든 정보를 담고 있는 것
        : this -> 이 액티비티를 대상으로 arrayadapter를 연결해주기 위해 대상 액티비티 지정
        
        두번째 인자
        : 레이아웃 형태- ctrl 누른 채로 클릭하면 볼 수 있음
        
        세번째 인자 
        : 전달해줄 실제 데이터
        */


        /*
        모델 객체라는 것을 만들어야 함
        list에 뿌려줄 데이터들을 어떤 것ㅇ들을 사용할 것인지 지정해 주는 것
        */

        val Adapter=UserAdapter(this,UserList)
        //우리가 커스텀해서 만든 UserAdapter
        binding.listView.adapter=Adapter
        //xml의 listView라는 id를 갖는 listview에 adapter에 우리가 만든 UserAdapter를 연결!
        //사실 listview는 끝 !

        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectItem = parent.getItemAtPosition(position) as User
            //User라는 모델 단위로 position번째 item을 가져와
            Toast.makeText(this,selectItem.name,Toast.LENGTH_SHORT).show()
        }
    }
}