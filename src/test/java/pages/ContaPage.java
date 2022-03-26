package pages;

import core.BasePage;
import org.openqa.selenium.By;

public class ContaPage extends BasePage {
    public void setNome(String texto){
        escreve("//input[@id=\"nome\"]", texto);
    }

    public void botaoSalvar(){
        clicar("//button[@type=\"submit\"]");
    }

    public void botaoEditar(){
        clicar("//span[@class=\"glyphicon glyphicon-edit\"]");
    }

    public String obterMensagemDeSucesso(){
        return vereficarTexto("//div[@class=\"alert alert-success\"]");
    }

    public String obterMensagemDeErro(){
        return vereficarTexto("//div[@class=\"alert alert-danger\"]");
    }

    public void botaoExcluirConta(String string){
        obterCelula("Conta", string, "Ações", "tabelaContas")
                .findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
    }



}
