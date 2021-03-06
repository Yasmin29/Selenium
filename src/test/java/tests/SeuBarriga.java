package tests;

import core.BaseTeste;
import org.junit.Assert;
import org.junit.Test;
import pages.ContaPage;
import pages.MenuPage;
import pages.MovimentacaoPage;
import pages.ResumoMensalPage;
import utils.DataUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SeuBarriga extends BaseTeste {
    MenuPage menuPage = new MenuPage();
    ContaPage contaPage = new ContaPage();
    MovimentacaoPage movimentacaoPage = new MovimentacaoPage();
    ResumoMensalPage resumoMensalPage = new ResumoMensalPage();
    
    @Test
    public void quandoInsiroUmaNovaContaEntaoRetornaMensagemAmigavel(){
    menuPage.acessarTelaAdicionarConta();
    contaPage.setNome("Nova conta");
    contaPage.botaoSalvar();
    Assert.assertEquals("Conta adicionada com sucesso!", contaPage.obterMensagemDeSucesso());
    }

    //VOLTAR AQUI, AULA 78
    /*@Test
    public void quandoAlteroONomeDeUmaContaEntaoRetornaMensagemAmigavel(){
         menuPage.acessarListasDeContas();
         listarPage.botaoEditar();
         adicionarContaPage.setNome("NovoNome");
         adicionarContaPage.botaoSalvar();
    }*/

    @Test
    public void quandoInsiroUmaContaComOMesmoNomeEntaoDeveRetornarMensagemDeErro(){
        menuPage.acessarTelaAdicionarConta();
        contaPage.setNome("Yasmin");
        contaPage.botaoSalvar();

        Assert.assertEquals("J√° existe uma conta com esse nome!", contaPage.obterMensagemDeErro());
    }

    @Test
    public void quandoCrioUmaMovimenta√ß√£oEntaoRetornaMensagemDeSucesso(){
        menuPage.acessarTelaCriarMovimentacao();
        movimentacaoPage.setTipoDaMovimentacao("Receita");
        movimentacaoPage.setDataDaMovimentacao(DataUtils.obterDataFormatada(new Date()));
        movimentacaoPage.setDataDoPagamento(DataUtils.obterDataFormatada(new Date()));
        movimentacaoPage.setDescricao("Emprestimo para nova casa");
        movimentacaoPage.setInteressado("Alexa");
        movimentacaoPage.setValor("500");
        movimentacaoPage.setConta("Yasmin");
        movimentacaoPage.setSituacaoPago();
        movimentacaoPage.botaoSalvar();

        Assert.assertEquals("Movimenta√ß√£o adicionada com sucesso!", movimentacaoPage.obterMensagemDeSucesso());
    }

    @Test
    public void quandoNaoInsiroCampoSObrigatoriosEntaoRetornaMensagensDeAviso(){
        menuPage.acessarTelaCriarMovimentacao();
        movimentacaoPage.botaoSalvar();
        List<String> erros = movimentacaoPage.obterMensagemDeErros();

        Assert.assertTrue(erros.containsAll(Arrays.asList(
                "Data da Movimenta√ß√£o √© obrigat√≥rio",
                "Data do pagamento √© obrigat√≥rio",
                "Descri√ß√£o √© obrigat√≥rio",
                "Interessado √© obrigat√≥rio",
                "Valor √© obrigat√≥rio",
                "Valor deve ser um n√ļmero"
        )));
       Assert.assertEquals(6, erros.size());

    }

    @Test
    public void quandoADataDaMovimentacaoEFuturoEntaoDeveRetornarMensagemDeErro(){
        Date dataFutura = DataUtils.obterDataComDiferencaDias(1);
        menuPage.acessarTelaCriarMovimentacao();
        movimentacaoPage.setTipoDaMovimentacao("Receita");
        movimentacaoPage.setDataDaMovimentacao(DataUtils.obterDataFormatada(dataFutura));
        movimentacaoPage.setDataDoPagamento(DataUtils.obterDataFormatada(dataFutura));
        movimentacaoPage.setDescricao("Emprestimo para nova casa");
        movimentacaoPage.setInteressado("Alexa");
        movimentacaoPage.setValor("500");
        movimentacaoPage.setConta("Yasmin");
        movimentacaoPage.setSituacaoPago();
        movimentacaoPage.botaoSalvar();

        List<String> erro = movimentacaoPage.obterMensagemDeErros();
        Assert.assertTrue(erro.contains("Data da Movimenta√ß√£o deve ser menor ou igual √† data atual"));
    }

    //VOLTAR AQUI AULA 84
    @Test
    public void quandoRemovoUmacontaComMovimentacaoEntaoRetornaMensagemDeErro(){
        menuPage.acessarListasDeContas();
        contaPage.botaoExcluirConta("Yasmin");

        Assert.assertEquals("Conta em uso na movimenta√ß√Ķes", contaPage.obterMensagemDeErro());
    }

    @Test
    public void quandoRemovoUmaMovimentacaoEntaoRetornaMensagemAmigavel(){
        menuPage.acessarTelaDeResumoMensal();
        resumoMensalPage.botaoExcluir();

        Assert.assertEquals("Movimenta√ß√£o removida com sucesso!", resumoMensalPage.obterMensagemDeSucesso());
    }

    @Test
    public void quandoNaoTenhoResumosMensaisEntaoAListaDeveRetornarVazia(){
        menuPage.acessarTelaDeResumoMensal();

    }

}
