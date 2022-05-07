import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Protocolo {
    private int id_action;
    private String dados;
    private String response;
    private int status;

    public Protocolo(String dados) {
        this.setDados(dados);
    }

    public Protocolo(byte[] dados) {
        this.setDados(dados);
    }

    public String getDados() {
        return this.dados;
    }

    public Protocolo processarDados() {
        // Verificando ação que deve ser realizado
        if(Pattern.matches("SOMA[0-9\s\n\\+]+", this.getDados())) this.id_action = 1;
        else if (Pattern.matches("DATA\n", this.getDados())) this.id_action = 2;
        else if (Pattern.matches("BYE\n", this.getDados())) this.id_action = 3;
        else if (Pattern.matches("(AJUDA|HELP)\n", this.getDados())) this.id_action = 4;
        else if (Pattern.matches("(DESLIGAR)(\n?)", this.getDados())) this.id_action = 5;

        this.status = 200;
        switch(this.id_action) {
            case 1:
                this.somar();
                break;
            case 2:
                this.response = "DATA = " + this.getData();
                break;
            case 3:
                this.status = 100;
                this.response = "Servidor será desligado. Bye!";
                break;
            case 4:
                this.response = "\n========= HELPE ======== \n";
                this.response += "Para somar você pode digitar soma N1 + N2 + N3 + ... + Nn\n";
                this.response += "Para mostrar data, basta digitar \"data\"\nPara finalizar, digite \"bye\".\n";
                this.response += "=========================\n";
                break;
            case 5:
                this.status = 101;
                this.response = "SERVIDOR SENDO DESLIGADO!";
                break;
            default:
                this.status = 404; // Not Found "Não encontrado"
        }

        return this;
    }

    public int statusCode() {
        return this.status;
    }

    public String getResponse() {
        return this.response;
    }

    private void somar() {
        // Montando expressão regular para pegar os numero
        Pattern patternNum = Pattern.compile("[0-9]+");
        Matcher m = patternNum.matcher(this.getDados().toUpperCase(Locale.ROOT));

        // Realizando a soma
        int soma = 0;
        while(m.find()) {
            soma += Integer.parseInt(m.group());
        }

        this.response = "SOMA = " + String.valueOf(soma);
    }

    /* Metodo acessor e modificador */
    public void setDados(String dados) {
        this.dados = dados.toUpperCase(Locale.ROOT);
    }

    public void setDados(byte [] dados) {
        // Retirar a parte bínaria da string
        int i = 0;
        for(i = 0; i < dados.length && dados[i] != 0; i++);

        this.setDados(new String(dados, 0, i, StandardCharsets.UTF_8));
    }

    // Retorna a data atual do sistema
    private String getData() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime agora = LocalDateTime.now();
        return dtf.format(agora);
    }
}
