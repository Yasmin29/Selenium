package pages;

import core.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    public String obterSaldoConta(String nomeConta){
        return obterCelula("Conta", nomeConta, "Saldo", "tabelaSaldo")
                .getText();

    }
}
