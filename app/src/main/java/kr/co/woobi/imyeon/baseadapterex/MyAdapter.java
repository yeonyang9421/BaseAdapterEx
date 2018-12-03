package kr.co.woobi.imyeon.baseadapterex;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private List<CoffeeModel> mData;
    public MyAdapter(Context context, List<CoffeeModel> data){
        mContext=context;
        mData=data;

    }
    @Override
    public int getCount() {   //아이템 개수
        return  mData.size();
    }

    @Override
    public Object getItem(int position) {  //position 번째 아이템
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) { //position번째 레이아웃
        //convertView 는 화면상에 보이는 뷰들이 바뀔때 리스트 자리를 재사용하는 것
        ViewHolder viewHolder;
        if(convertView==null){
            //뷰를 새로 만들 때
            convertView=LayoutInflater.from(mContext).inflate(R.layout.item_cafe,parent,false);
            viewHolder=new ViewHolder();
            //레이아웃 들고 오기
            ImageView imageView=(ImageView)convertView.findViewById(R.id.image_coffee);
            TextView textVieMenu=(TextView)convertView.findViewById(R.id.text_Menu);
            TextView textViewPrice=(TextView)convertView.findViewById(R.id.text_price);
            //뷰 홀더에 넣는다.
            viewHolder.imageView=imageView;
            viewHolder.textViewMenu=textVieMenu;
            viewHolder.textViewPrice=textViewPrice;

            convertView.setTag(viewHolder);
        }else {
            //재사용할때
            viewHolder=(ViewHolder)convertView.getTag();
        }

//        Log.d(TAG, "getView"+position);



        //데이터
        CoffeeModel coffeeModel=mData.get(position);
        //화면에 뿌리기
        viewHolder.imageView.setImageResource(coffeeModel.getImageRes());
        viewHolder.textViewMenu.setText(coffeeModel.getMenu());
        viewHolder.textViewPrice.setText(coffeeModel.getPrice());

        if(position %2 ==1) {
            convertView.setBackgroundColor(Color.GREEN);
        }else{
            convertView.setBackgroundColor(Color.WHITE);
        }
        if(mSelelctedPostion==position){
            convertView.setBackgroundColor(Color.YELLOW);
        }

        return convertView;
    }
    //-1이면 선택된게 없다.
    private int mSelelctedPostion=-1;
    public  void setSelect(int position){
        mSelelctedPostion=position;

    }

    private static class ViewHolder{
        ImageView imageView;
        TextView textViewMenu;
        TextView textViewPrice;
    }
}
