package br.com.fiap.pizzaria.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.pizzaria.R;
import butterknife.OnClick;

/**
 * Created by logonrm on 11/12/2017.
 */

public class Pedido implements Parcelable{
    private String cliente;
    private List<String> sabores;
    private String tamanho;

    protected Pedido(Parcel in) {
        cliente = in.readString();
        sabores = in.createStringArrayList();
        tamanho = in.readString();
        formaPagamento = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cliente);
        dest.writeStringList(sabores);
        dest.writeString(tamanho);
        dest.writeString(formaPagamento);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Pedido> CREATOR = new Creator<Pedido>() {
        @Override
        public Pedido createFromParcel(Parcel in) {
            return new Pedido(in);
        }

        @Override
        public Pedido[] newArray(int size) {
            return new Pedido[size];
        }
    };

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setSabores(List<String> sabores) {
        this.sabores = sabores;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    private String formaPagamento;

    public String getCliente() {
        return cliente;
    }

    public List<String> getSabores() {
        return sabores;
    }

    public String getTamanho() {
        return tamanho;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    @OnClick(R.id.btFecharPedido)
    public void addSabor(String sabor){
        if(sabores ==null)
            sabores = new ArrayList<>();
        sabores.add(sabor);
    }

    public void removerSabor(String sabor){
        if(sabores !=null)
            sabores.remove(sabor);
    }
}
