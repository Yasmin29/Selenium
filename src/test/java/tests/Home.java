package tests;

import org.junit.Assert;
import org.junit.Test;
import core.BaseTeste;
import pages.HomePage;

public class Home extends BaseTeste {
    HomePage homePage = new HomePage();
    @Test
    public void quandoTenhoUmaContaComSaldoEntaoDeveAparecerSaldoNaHome(){
        Assert.assertEquals(1000.00, homePage.obterSaldoConta("Yasmin"));
    }
}
