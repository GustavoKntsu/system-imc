package org.systemimc.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.systemimc.Model.Pessoa;

import java.text.DecimalFormat;

public class MainController {
    @FXML
    public TextField txtNome;
    @FXML
    public TextField txtAltura;
    @FXML
    public TextField txtPeso;
    @FXML
    public Label lblIMC;
    @FXML
    public Label lblClassificacao;

    Pessoa pessoa = new Pessoa();

    @FXML
    protected void onCalcularIMCClick() {
        DecimalFormat df = new DecimalFormat();
        this.pessoa.setNome(this.txtNome.getText()) ;
        this.pessoa.setAltura( Float.parseFloat(txtAltura.getText()));
        this.pessoa.setPeso( Float.parseFloat(txtPeso.getText()));


        df.applyPattern("#0.00");
        this.lblIMC.setText(df.format(this.pessoa.calcularIMC()));
        this.lblClassificacao.setText(this.pessoa.classificacaoIMC());

    }
}
