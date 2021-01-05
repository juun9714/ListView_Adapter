package com.example.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class UserAdapter (val context: Context, val UserList: ArrayList<User>) : BaseAdapter()
/*
val UserList: ArrayList<User>
: 우리가 만든 데이터 model인 User을 요소로 갖는 배열을 인자로 받겠다는 이야기


 ~~ : BaseAdapter() 
 : 우리가 만든 UserAdapter가 안드로이드에서 기본으로 제공하는 BaseAdapter라는 
 : 클래스로부터 상속을 받겠다는 의미
 --> 그렇기 때문에 UserAdpater에서 Implement members를 선택하면 BaseAdapter의 함수들을 사용할 수 있음
*/

{
    override fun getCount(): Int {
        //리스트뷰의 항목 개수를 반환
        return UserList.size
    }

    override fun getItem(position: Int): Any {
        //어떤 아이템을 끌고 올거냐
        return UserList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0 //사용 안함
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.list_item_user,null)
        //view를 붙였다. 우리가 만들어놓은 view(list_item_user.xml,항목 - 좌우로 긴 직사각형)를 view라는 변수에 담아서 사용할 것이다.
        val profile = view.findViewById<ImageView>(R.id.iv_profile)
        //우리가 만든 view 안의 ImageView 태그 중 id가 iv_profile 항목을 profile 이라는 변수에 저장
        val name = view.findViewById<TextView>(R.id.tv_name)
        //우리가 만든 view 안의 TextView 태그 중 id가 name 항목을 name 이라는 변수에 저장
        val greet = view.findViewById<TextView>(R.id.tv_greet)
        val age = view.findViewById<TextView>(R.id.tv_age)

        //메인 액티비티에서 어댑터를 생성하고 실제 데이터들이 들어있는 배열을 인자로 전달해줄 것임
        val user = UserList[position]
        //UserAdpater 클래스가 UserList라는 인자로 전달받은 User라는 배열(실제 데이터들의 배열)의 각 항목을 user라는 변수에 저장
        profile.setImageResource(user.profile)
        //우리가 만든 view의 profile의 imageresource를 변경해준다. 실제 데이터를 받아서 저장하고 있는 user.profile로
        //user.profile의 실제 데이터는 profile 이미지의 경로다.
        name.text=user.name
        age.text=user.age
        greet.text=user.greet

        return view
    }

}