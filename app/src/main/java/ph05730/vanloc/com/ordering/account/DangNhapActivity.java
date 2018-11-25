package ph05730.vanloc.com.ordering.account;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import ph05730.vanloc.com.ordering.R;
import ph05730.vanloc.com.ordering.dao.NhanVienDAO;
import ph05730.vanloc.com.ordering.database.DBManager;
import ph05730.vanloc.com.ordering.manchinh.ManChinhActivity;

public class DangNhapActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView imgngonngu;
    private ImageView imglogo;
    private EditText edttaikhoan;
    private EditText edtmatkhau;
    private Button btndangnhap;
    private Button btnthemtaikhoan;
    private TextView tvquenmatkhau;

    NhanVienDAO nhanVienDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        anhxa();

        imgngonngu.setOnClickListener(this);
        btndangnhap.setOnClickListener(this);
        btnthemtaikhoan.setOnClickListener(this);
        tvquenmatkhau.setOnClickListener(this);
        nhanVienDAO = new NhanVienDAO(new DBManager(this));

    }

    private void anhxa() {
        imgngonngu = findViewById(R.id.imgngonngu);
        edttaikhoan = findViewById(R.id.edttaikhoan);
        edtmatkhau = findViewById(R.id.edtmatkhau);
        btndangnhap = findViewById(R.id.btndangnhap);
        btnthemtaikhoan = findViewById(R.id.btnthemtaikhoan);
        tvquenmatkhau = findViewById(R.id.tvquenmatkhau);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgngonngu:
                startActivity(new Intent(DangNhapActivity.this, NgonNguActivity.class));
                break;

            case R.id.btndangnhap:
                xulydangnhap();
                break;

            case R.id.btnthemtaikhoan:
                startActivity(new Intent(DangNhapActivity.this, DangKiActivity.class));
                break;

            case R.id.tvquenmatkhau:
                startActivity(new Intent(DangNhapActivity.this, QuenMatKhauActivity.class));
                break;
        }
    }

    public void xulydangnhap() {

        String tendangnhap = edttaikhoan.getText().toString().trim();
        String matkhau = edtmatkhau.getText().toString().trim();

        int kiemtra = nhanVienDAO.KiemTraDangNhap(tendangnhap, matkhau);

        if (kiemtra != 0) {

            Intent intent = new Intent(DangNhapActivity.this, ManChinhActivity.class);
            intent.putExtra("tendn", tendangnhap);
            startActivity(intent);
            edttaikhoan.setText("");
            edtmatkhau.setText("");

        } else {
            Toast.makeText(DangNhapActivity.this, R.string.loithatbai, Toast.LENGTH_SHORT).show();
        }

    }
}
