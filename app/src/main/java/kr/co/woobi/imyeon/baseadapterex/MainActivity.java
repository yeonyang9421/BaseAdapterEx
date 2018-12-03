package kr.co.woobi.imyeon.baseadapterex;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {// 순서: 데이터 만들고 어댑터로 연결하고 리스트에 어댑터를 꽂는다
    private ListView mListView;
    private MyAdapter myAdapter;
    private List<CoffeeModel> coffeeModelList;
    private GridView mGridView;
    private Spinner mSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.listview);
        mGridView=findViewById(R.id.grid);
        mSpinner=findViewById(R.id.spinner);

        coffeeModelList = new ArrayList<>();
        coffeeModelList.add(new CoffeeModel(R.drawable.americano, "아메리카노", "3000"));
        coffeeModelList.add(new CoffeeModel(R.drawable.capuccino, "카푸치노", "4500"));
        coffeeModelList.add(new CoffeeModel(R.drawable.latte, "카페라떼", "40000"));
        coffeeModelList.add(new CoffeeModel(R.drawable.moca, "카페모카", "5000"));
        coffeeModelList.add(new CoffeeModel(R.drawable.americano, "아메리카노", "3000"));
        coffeeModelList.add(new CoffeeModel(R.drawable.capuccino, "카푸치노", "4500"));
        coffeeModelList.add(new CoffeeModel(R.drawable.latte, "카페라떼", "40000"));
        coffeeModelList.add(new CoffeeModel(R.drawable.moca, "카페모카", "5000"));

        //어댑터
        myAdapter = new MyAdapter(this, coffeeModelList);
        //어댑터를 뷰에 설정
        mListView.setAdapter(myAdapter);
        mGridView.setAdapter(myAdapter);
        mSpinner.setAdapter(myAdapter);
        //이벤트
        mListView.setOnItemClickListener(this);
        mListView.setOnItemLongClickListener(this);
        mGridView.setOnItemClickListener(this);
        mGridView.setOnItemLongClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        myAdapter.setSelect(position);
        coffeeModelList.add(new CoffeeModel(R.mipmap.ic_launcher_round, "집이다.", "졸리다"));
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        coffeeModelList.remove(position);
        myAdapter.notifyDataSetChanged();
        return true;
    }
}
