package org.systemimc.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.systemimc.Model.Pessoa;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    public TextField txtNome;
    @FXML
    public TextField txtAltura;
    @FXML
    public TextField txtPeso;
    @FXML
    public Label lbIMC;
    @FXML
    public Label lbClassificacao;
    //************************************
    @FXML
    TableView<Pessoa> tbPessoas;
    @FXML
    TableColumn<Pessoa, Integer> colId;
    @FXML
    TableColumn<Pessoa, String> colNome;
    @FXML
    TableColumn<Pessoa, Float> colPeso;
    @FXML
    TableColumn<Pessoa, Float> colAltura;
    @FXML
    TableColumn<Pessoa, Float> colIMC;

    Pessoa pessoa;
    List<Pessoa> listaPessoas;
    ObservableList<Pessoa> observableListPessoas;

//**************************************************

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.pessoa = new Pessoa();
        this.listaPessoas = new ArrayList<>();
        this.observableListPessoas = FXCollections.observableArrayList();
        iniciarGUI();
    }

    public void iniciarGUI(){
        // VINCULAR AS CADA CELULA DA LINHA DA TABELA COM O ATRIBUTO DO OBJETO PESSOA
        this.colId.setCellValueFactory( new PropertyValueFactory<>("id"));
        this.colNome.setCellValueFactory( new PropertyValueFactory<>("nome"));
        this.colPeso.setCellValueFactory( new PropertyValueFactory<>("peso"));
        this.colAltura.setCellValueFactory( new PropertyValueFactory<>("altura"));
        this.colIMC.setCellValueFactory( new PropertyValueFactory<>("imc"));
    }


    //******************************************************
    @FXML
    public void onCalcularIMCClick() {
        lerformulario();
        this.pessoa.calcularIMC();
        this.pessoa.classificacaoIMC();
        exibirClassificacaoIMC();
        System.out.println(this.pessoa.toString());

    }

    @FXML
    public void onClickSalvarIMC() {
        try {
            lerformulario();
            this.pessoa.calcularIMC();
            this.pessoa.classificacaoIMC();
            this.listaPessoas.add(this.pessoa);
            atualizarTableView();

            // Limpar campos para melhor feedback visual
            this.txtNome.clear();
            this.txtPeso.clear();
            this.txtAltura.clear();
            this.lbIMC.setText("");
            this.lbClassificacao.setText("");

            // Nova pessoa para próximo cadastro
            this.pessoa = new Pessoa();
        } catch (Exception e) {
            System.err.println("Erro ao salvar: " + e.getMessage());
        }
    }

    @FXML
    public void onClickNovo(){
        this.pessoa = new Pessoa();
        this.txtNome.setText("");
        this.txtAltura.setText("");
        this.txtPeso.setText("");
    }


    //*************************************************************

    private void lerformulario(){
        this.pessoa.setNome(this.txtNome.getText()) ;
        this.pessoa.setAltura( Float.parseFloat(txtAltura.getText()));
        this.pessoa.setPeso( Float.parseFloat(txtPeso.getText()));
    }

    public void exibirClassificacaoIMC(){
        DecimalFormat df = new DecimalFormat("#0.00");
        lbIMC.setText(df.format(this.pessoa.getImc()));
        lbClassificacao.setText(this.pessoa.getClassificacao());
    }

    public void atualizarTableView() {
        try {
            // Usar setAll é mais eficiente que recriar a lista
            observableListPessoas.setAll(listaPessoas);
            tbPessoas.setItems(observableListPessoas);

            // Log para depuração
            System.out.println("Adicionado " + listaPessoas.size() + " pessoas à tabela");

            // Forçar atualização da tabela
            tbPessoas.refresh();
        } catch (Exception e) {
            System.err.println("Erro ao atualizar tabela: " + e.getMessage());
        }
    }


}
