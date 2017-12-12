package br.com.fiap.pizzaria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import br.com.fiap.pizzaria.model.Pedido;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.cbBacon)
    CheckBox cbBacon;

    @BindView(R.id.cbAtum)
    CheckBox cbAtum;

    @BindView(R.id.rgTamanho)
    CheckBox cbTamanho;

    @BindView(R.id.spPagamentos)
    CheckBox spPagamentos;

    TextView tvCliente;

    private String nomeusuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        if(getIntent() != null) {
            nomeusuario = getIntent().getStringExtra("USUARIO");
        }
        tvCliente.setText(nomeusuario);

        cbAtum.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                }
            }
        });
    }

    @OnClick(R.id.btFecharPedido)
    public void fecharPedido(){

        Pedido pedido = new Pedido();
        pedido.setCliente(tvCliente.getText().toString());

    }
}
