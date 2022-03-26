package pages;

import core.BasePage;

public class ResumoMensalPage extends BasePage {
    public void setMes(String mes){
        selecionarCombo("//select[@id=\"mes\"]", mes);
    }

    public void setAno(String ano){
        selecionarCombo("//select[@id=\"ano\"]", ano);
    }

    public void botaoBuscar(){
        clicar("//input[@type=\"submit\"]");
    }

    public void botaoExcluir(){
        clicar("//span[@class=\"glyphicon glyphicon-remove-circle\"]");
    }

    public String obterMensagemDeSucesso(){
        return vereficarTexto("//div[@class=\"alert alert-success\"]");
    }
}
