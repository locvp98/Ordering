package ph05730.vanloc.com.ordering.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.List;

import ph05730.vanloc.com.ordering.R;
import ph05730.vanloc.com.ordering.adapter.BanAnAdapter;
import ph05730.vanloc.com.ordering.dao.BanAnDAO;
import ph05730.vanloc.com.ordering.database.DBManager;
import ph05730.vanloc.com.ordering.manchinh.ThemBanAnActivity;
import ph05730.vanloc.com.ordering.model.BanAn;

public class TrangChu_Far extends Fragment {

    public static int REQUEST_CODE_THEM=111;
    private GridView gvHienBanAn;
    private List<BanAn> banAnList;
    private BanAnDAO banAnDAO;
    private BanAnAdapter banAnAdapter;


    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_trangchu,container,false);
        setHasOptionsMenu(true);
        gvHienBanAn =  view.findViewById(R.id.gvHienBanAn);

        banAnDAO=new BanAnDAO(new DBManager(getActivity()));
        hienthi();

        return view;
    }


    private void hienthi() {

        banAnList=banAnDAO.laydsbanan();
        banAnAdapter=new BanAnAdapter(getActivity(),R.layout.custum_banan,banAnList);
        gvHienBanAn.setAdapter(banAnAdapter);
        banAnAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        MenuItem thembanan=menu.add(1,R.id.thembanan,1,R.string.thembanan);
        thembanan.setIcon(R.drawable.thembanan);
        thembanan.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()){
           case R.id.thembanan:
               Intent itthembanan=new Intent(getActivity(),ThemBanAnActivity.class);

               startActivityForResult(itthembanan,REQUEST_CODE_THEM);
               break;

       }
        return true;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_THEM){
            if(resultCode == Activity.RESULT_OK){
                Intent intent = data;
                boolean kiemtra = intent.getBooleanExtra("ketquathem",false);
                if(kiemtra){
                    hienthi();
                    Toast.makeText(getActivity(),getResources().getString(R.string.themthanhcong),Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(),getResources().getString(R.string.themthatbai),Toast.LENGTH_SHORT).show();
                }
            }


            }

        }

}
