package com.example.haberler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<News>
    lateinit var  imageId:Array<Int>
    lateinit var heading:Array<String>
    lateinit var news:Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId= arrayOf(
            R.drawable.ahbap,
            R.drawable.bbaskan,
            R.drawable.camoluk,
            R.drawable.deprem,
            R.drawable.haland,
            R.drawable.oguzhan,
            R.drawable.sedat,
            R.drawable.silahli,
            R.drawable.kaza,
            R.drawable.multeci,
            R.drawable.kilicdar,
            R.drawable.pskolog,

        )

        heading = arrayOf(
            "Haluk Levent, \"Ahbap'lar eğlencede\" diyerek yayınlanan videoya isyan etti: Uğraşmayın, bırakın çalışsınlar”,",
            "Deprem soruşturmasında Belediye Başkanı tutuklandı.",
            "50 milyar TL bağışlayan oto galerici konuştu:Aslında 50 bin TL demek istedim, telefonlarım susmuyor.",
            "Deprem bölgesinden 6 yaralı ambulans uçakla İstanbul'a getirildi.",
            "İnanması zor istatistik! Fenerbahçeli Valencia, Haaland'ı geride bıraktı",
            "“YouTuber Oğuzhan Uğur, Ankara'da gözaltına alındığını bildirerek, \"Çayımızı içtik çıktım, iyiyim teşekkürler\" dedi.”",
            "“Sedat Peker bağış yaptı.”",
            "“Zeytinburnu’nda aralarında husumet bulunan gruplar arasında çıkan silahlı çatışmada 4 kişi yaralandı.”",
            "Avcılar'da kazada 'aşırı hız' iddiası",
            "Tunus'ta düzensiz göçmenlerle dayanışma için \"ırkçılık karşıtı\" eylem yapıldı",
            "Kılıçdaroğlu: \"Çocuklarımızı Depremin Yarattığı Ağır Travmalardan Korumak Zorundayız.",
            "Deprem bölgesinde 637 bin 488 kişiye psikososyal destek sağlandı"

        )
        news = arrayOf(
            getString(R.string.ahbap),
            getString(R.string.bbaskan),
            getString(R.string.camoluk),
            getString(R.string.deprem),
            getString(R.string.haland),
            getString(R.string.kaza),
            getString(R.string.kilicdar),
            getString(R.string.multeci),
            getString(R.string.oguzgan),
            getString(R.string.pskolog),
            getString(R.string.sedat),
            getString(R.string.silahli),


        )

        newRecyclerView=findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager=LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList= arrayListOf<News>()
        getUserdata()
    }

    private fun getUserdata() {
        for (i in imageId.indices){
            val news = News(imageId[i],heading[i])
            newArrayList.add(news)
        }
        var adapter = NewAdapter(newArrayList)
        newRecyclerView.adapter=adapter
        adapter.setOnItemClickListener(object :NewAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {


                val intent=Intent(this@MainActivity,NewsActivity::class.java)
                intent.putExtra("heading",newArrayList[position].heading)
                intent.putExtra("imageId",newArrayList[position].titleImage)
                intent.putExtra("news",news[position])
                startActivity(intent)

            }
        })
    }
}