package com.cs442.smahade4.assignment2;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetailListFragment extends Fragment implements Button.OnClickListener {
    String text="";
    TextView price;
    CM c;
    TextView name;
    TextView description;
    EditText  quantity;
    int position;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub

       View view = inflater.inflate(R.layout.secondactivityfragment, container, false);
        // Exception at this line

        name = (TextView)view.findViewById(R.id.menuname);

        price = (TextView)view.findViewById(R.id.Price);
        quantity = (EditText) view.findViewById(R.id.Quantity);

        Button btnQuantity= (Button)view.findViewById(R.id.buttonQuantity);

        btnQuantity.setOnClickListener(this);

        System.out.print("ok");
        return view;
    }

    public void getData(int i,int p,int q,String n,String d)
    {
       // quantity.setText(String.valueOf(q));
        price.setText(String.valueOf(p));
        name.setText(n);
        position=i;
    }
    @Override
    public void onAttach(Activity activity) {
        // TODO Auto-generated method stub
        super.onAttach(activity);
    }

    @Override
    public void onClick( View v)
    {

        c.respond2(position,Integer.parseInt(quantity.getText().toString()));
        //   getActivity().getIntent().putExtra("quantity",Integer.parseInt(quantity.getText().toString()));
       // getActivity().getIntent().putExtra("position",position);
       // getActivity().setResult(Activity.RESULT_OK,getActivity().getIntent());
    }

    public void setC(CM c)
    {
        this.c=c;
    }
    public interface CM
    {
        public void respond2(int i,int quantity);

    }


}