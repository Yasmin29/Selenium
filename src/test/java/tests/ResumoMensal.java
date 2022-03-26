package tests;

import core.BaseTeste;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import core.DriverFactory;
import pages.MenuPage;

import java.util.List;

import static core.DriverFactory.getDriver;
public class ResumoMensal extends BaseTeste {
    MenuPage menuPage = new MenuPage();

    @Test
    public void quandoEstouNaPaginaDeResumoEntaoOTituloDaPaginaDeveSerExtrato(){
        menuPage.acessarTelaDeResumoMensal();

        Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());

        List<WebElement> listaDoResumoMensal = DriverFactory.getDriver().findElements(By.xpath("//*[@id=\"tabelaExtrato\"]/tbody/tr"));
        Assert.assertEquals(0, listaDoResumoMensal);
    }
}
