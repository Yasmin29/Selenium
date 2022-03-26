package pages;

import core.BasePage;
import core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MovimentacaoPage extends BasePage {
    public void setTipoDaMovimentacao(String texto){
        selecionarCombo("//select[@id=\"tipo\"]", texto);
    }

    public void setDataDaMovimentacao(String texto){
        escreve("//input[@id=\"data_transacao\"]", texto);
    }

    public void setDataDoPagamento(String texto){
        escreve("//input[@id=\"data_pagamento\"]", texto);
    }

    public void setDescricao(String texto) {
        escreve("//input[@id=\"descricao\"]", texto);
    }

    public void setInteressado(String texto){
        escreve("//input[@id=\"interessado\"]", texto);
    }

    public void setValor(String texto) {
        escreve("//input[@id=\"valor\"]", texto);
    }

    public void setConta(String texto){
        selecionarCombo("//select[@id=\"conta\"]", texto);
    }

    public void setSituacaoPago(){
        clicar("//input[@id=\"status_pago\"]");
    }

    public void setSituacaoPendente(){
        clicar("//input[@id=\"status_pendente\"]");
    }

    public void botaoSalvar(){
        clicar("//button[@type=\"submit\"]");
    }

    public String obterMensagemDeSucesso(){
        return vereficarTexto("//div[@class=\"alert alert-success\"]");
    }

    public List<String> obterMensagemDeErros(){
        List<WebElement> erros = DriverFactory.getDriver().findElements(By.xpath("//div[@class=\"alert alert-danger\"]//li"));
        List<String> retorno = new ArrayList<String>();
        for(WebElement erro: erros) {
            retorno.add(erro.getText());
        }
        return retorno;
    }
}
