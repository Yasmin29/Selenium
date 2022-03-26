package pages;

import core.BasePage;

public class MenuPage extends BasePage {

    public void acessarTelaAdicionarConta(){
        clicarEmLink("Contas");
        clicarEmLink("Adicionar");
    }

    public void acessarListasDeContas(){
        clicarEmLink("Contas");
        clicarEmLink("Listar");
    }

    public void acessarTelaCriarMovimentacao(){
        clicarEmLink("Criar Movimentação");
    }

    public void acessarTelaDeResumoMensal(){
        clicarEmLink("Resumo Mensal");
    }

}
