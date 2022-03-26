package core;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import pages.LoguinPage;

import java.io.IOException;

public class BaseTeste {
    private LoguinPage loguinPage = new LoguinPage();

    @Rule
    public TestName testeNome = new TestName();

    @Before
    public void login(){
        DriverFactory.getDriver().get("https://seubarriga.wcaquino.me/login");
        loguinPage.setEmail("yasmin@email.com");
        loguinPage.setSenha("senha");
        loguinPage.botaoEntrar();
    }
    @After
    public void finaliza() throws IOException {

        /*TakesScreenshot screenshot = (TakesScreenshot) getDriver();
        File arquivo = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" +
                File.separator + testeNome.getMethodName() + ".jpg"));*/

        DriverFactory.killDriver();

        /*if (Propriedades.FEHCHAR_BROWSER) {
            killDriver();
        }*/
    }
}
