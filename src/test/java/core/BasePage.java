package core;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BasePage {

        public void procurarElemento(String xpath){
            DriverFactory.getDriver().findElement(By.xpath(xpath));
        }

        public void escreve(String xpath, String texto) {
            DriverFactory.getDriver().findElement(By.xpath(xpath)).sendKeys(texto);
        }

        public void clicar(String xpath){
            DriverFactory.getDriver().findElement(By.xpath(xpath)).click();
        }

        public void clicarEmLink(String elemento) {
            DriverFactory.getDriver().findElement(By.linkText(elemento)).click();
        }

        public void trocarParaAlert(){
            DriverFactory.getDriver().switchTo().alert();
        }

        public void aceitarAlerta(){
            DriverFactory.getDriver().switchTo().alert().accept();
        }

        public void recusarAlerta(){
            DriverFactory.getDriver().switchTo().alert().dismiss();
        }

        public String vereficaTextoDoAlerta(){
            Alert alert = DriverFactory.getDriver().switchTo().alert();
            return alert.getText();
        }

        public void escreveNoAlerta(String texto){
            DriverFactory.getDriver().switchTo().alert().sendKeys(texto);
        }

        public void selecionarCombo(String xpath, String texto){
            WebElement element = DriverFactory.getDriver().findElement(By.xpath(xpath));
            Select combo = new Select(element);
            combo.selectByVisibleText(texto);
        }

        public String vereficarSeComboFoiSelecionado(String xpath){
            WebElement element = DriverFactory.getDriver().findElement(By.xpath(xpath));
            Select combo = new Select(element);
            return combo.getFirstSelectedOption().getText();
        }

        public String vereficarAtributo(String xpath, String atributo){
            return DriverFactory.getDriver().findElement(By.xpath(xpath)).getAttribute(atributo);
        }

        public String vereficarTexto(String xpath){
            return DriverFactory.getDriver().findElement(By.xpath(xpath)).getText();
        }

        public boolean vereficarSeFoiSelecionado(String xpath){
            return DriverFactory.getDriver().findElement(By.xpath(xpath)).isSelected();
        }

        //************ JS *****************
        public Object comandoJS(String comando, Object... elemento){
            JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
            return js.executeScript(comando,elemento);
        }

        //*********Tabela**********

    public WebElement obterCelula(String colunaBusca, String valor, String colunaBotao, String idTabela) {
        //procurar coluna do registro
        WebElement tabela = DriverFactory.getDriver().findElement(By.xpath("//*[@id='"+idTabela+"']"));
        int idColuna = obterIndiceDaColuna(colunaBusca, tabela);

        //encontrar a linha do registro
        int idLinha = obterIndiceLinha(valor, tabela, idColuna);

        //procurar coluna do botao
        int idColunaBotao = obterIndiceDaColuna(colunaBotao, tabela);

        //clicar no botao da celula encontrada
        WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
        return celula;
    }

    public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela) {
            WebElement celula = obterCelula(colunaBusca,valor,colunaBotao,idTabela);
            celula.findElement(By.xpath(".//input")).click();
        }

        protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna){
            List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
            int idLinha = -1;
            for(int i = 0; i<linhas.size(); i++ ){
                if(linhas.get(i).getText().equals(valor)){
                    idLinha = i + 1;
                    break;
                }
            }
            return idLinha;

        }
        protected int obterIndiceDaColuna(String coluna, WebElement tabela){
            List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
            int idColuna = -1;
            for(int i = 0; i<colunas.size(); i++ ){
                if(colunas.get(i).getText().equals(coluna)){
                    idColuna = i + 1;
                    break;
                }
            }
            return idColuna;
        }
}

