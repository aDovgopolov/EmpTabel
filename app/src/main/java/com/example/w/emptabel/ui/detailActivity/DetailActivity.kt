package com.example.w.emptabel.ui.detailActivity

import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.support.v7.widget.Toolbar
import com.example.w.emptabel.R
import com.example.w.emptabel.ui.ToolbarManager
import org.jetbrains.anko.find
import android.graphics.Color
import android.support.v7.widget.ButtonBarLayout
import com.example.w.emptabel.App
import com.example.w.emptabel.domain.RandomUsersApi
import com.example.w.emptabel.height
import kotlinx.android.synthetic.main.activity_main.*
import com.example.w.emptabel.ui.CustomView
import javax.inject.Inject

//inject retrofit and support +
// create data class for person ++
// add realm ++
//use login activity to create person(name and sername) and push into realm
// in future got local server
// detailActivity use Presenter -> Presenter get data from Realm  and update UI

class DetailActivity : AppCompatActivity(), ToolbarManager  {

    @Inject
    lateinit var randomUsersApi: RandomUsersApi

    @Inject
    lateinit var presenter: DetailActivityPresenter

    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    companion object {
        val ID = "DetailActivity:id"
        val CITY_NAME = "DetailActivity:cityName"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        initComponent()

        initToolbar()
        initCustomView()
        initSecondPandel()
        initRecycleView()
        initButtonQR()
        presenter.populateUsers()
    }

    private fun initComponent() {
        val detailActivityComponent = App.instance.provideMainComponent().createDetailActivityComponent()
        detailActivityComponent.injectMainActivity(this)
        presenter.attachView(this)
        //randomUsersApi = detailActivityComponent.getRandomUsersApi()
    }

    fun initSecondPandel(){
        work_time.layoutParams.height = this.height
        second_part.layoutParams.height = this.height
    }

    fun initRecycleView(){
        //need to change
        calendar_part.layoutParams.height = this.height * 5 + this.height / 2 + this.height / 4 + (this.height * 0.25).toInt()
    }

    fun initButtonQR(){
        btn_qr.layoutParams.height = (this.height * 0.75).toInt()
        btn_qr.setTextColor(Color.WHITE)
    }

    fun initCustomView(){
        val customView: CustomView = findViewById(R.id.firstCustom)
        customView.bindView("Начало", "--:--")
        val customView1: CustomView = findViewById(R.id.second_custom)
        customView1.bindView("На работе", "--:--")
        val customView2: CustomView = findViewById(R.id.third_custom)
        customView2.bindView("Конец", "--:--")
    }

    fun toast(message: String){
        //this.toast(message)
            Toast.makeText(this, message,Toast.LENGTH_LONG).show()
    }

    fun getRandomUserService(): RandomUsersApi {
        return randomUsersApi//retrofit.create(RandomUsersApi.class);
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView();
    }

    fun DetailActivity.toast(message: CharSequence){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun faceClick(v: ButtonBarLayout){ toast( "tools")}

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        //super.onCreateOptionsMenu(menu)
//
//        Log.d("MENU", "MENU")
//        menuInflater.inflate(R.menu.menu, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//        //super.onOptionsItemSelected(item)
//        val i = item?.getItemId()
//        if (i == R.id.action_beidg) {
//            val intent = Intent(this, PassingActivity::class.java)
//            startActivity(intent)
//        }
//        return true
//    }
}
