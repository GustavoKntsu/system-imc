package org.systemimc.Model;

public class Pessoa {
    private static int id = 0;
    private String nome;
    private Float altura;
    private Float peso;
    private Float imc;
    private String classificacao;
    //********************************************************************
    public Pessoa() {
        this.id = ++this.id;
    }

    public Pessoa(int id, String nome, Float altura, Float peso, Float imc, String classificacao) {
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.imc = imc;
        this.classificacao = classificacao;
    }

    //***************************************************************
    //Get & Set
    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Pessoa.id = id;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public void setImc(Float imc) {
        this.imc = imc;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    //********************************************************************


    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", altura=" + altura +
                ", peso=" + peso +
                ", imc=" + imc +
                ", classificacao='" + classificacao + '\'' +
                '}';
    }
    //********************************************************************
    //Calculo IMC
    public Float calcularIMC() {
        this.imc = this.peso / (this.altura * this.altura);
        return this.imc;
    }
    //********************************************************************

    public String classificacaoIMC() {
        String classificacao;
        if(this.imc < 18.5)
            this.classificacao = "Abaixo do peso";
        else if(this.imc >= 18.5 && this.imc < 24.9)
            this.classificacao = "Peso normal";
        else if(this.imc >= 25 && this.imc < 29.9)
            this.classificacao = "Sobrepeso";
        else if(this.imc >= 30 && this.imc < 34.9)
            this.classificacao = "Obesidade grau 1";
        else if(this.imc >= 35 && this.imc < 39.9)
            this.classificacao = "Obesidade grau 2";
        else
            return "Obesidade grau 3";

        return this.classificacao;
    }
}
