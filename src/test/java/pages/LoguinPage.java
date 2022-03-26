package pages;

import core.BasePage;

public class LoguinPage extends BasePage {

    public void setEmail(String email){
        escreve("//input[@type=\"email\"]", email);
    }

    public void setSenha(String senha){
        escreve("//input[@type=\"password\"]", senha);
    }

    public void botaoEntrar(){
        clicar("//button[@type=\"submit\"]");
    }

}
