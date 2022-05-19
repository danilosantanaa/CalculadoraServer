import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Locale;

public class Client {
    public static void main(String[] args) 	{
        System.out.println("CLIENTE EXECUTANDO...");
        try {
            Socket s = null;
            InputStream i = null;
            OutputStream o = null;
            String str = "";
            do {
                byte[] line = new byte[30000];
                System.out.print("Digite o que deseja fazer: ");
                System.in.read(line);

                // Mudar a porta do servidor de acordo com o tipo de servidor que ira operar
                Protocolo protocoloClient = new Protocolo(line);
                protocoloClient.processarDados();

                // Se estiver na faixa de 5 até 7 o servidor B realizar a operação de RAIZ, Potencia, e Porcentagem
                int porta = 9999; // Padrão será servidor A
                if(protocoloClient.getID() >= 5 && protocoloClient.getID() <= 7){
                    porta = 9998; // Servidor B
                }

                s = new Socket("127.0.0.1", porta);
                i  = s.getInputStream();
                o = s.getOutputStream();

                o.write(line);
                i.read(line);
                str = new String(line);

                if (!str.trim().equals("100"))
                    System.out.println(str.trim());
                else
                    System.out.println("<<< CONEXAO COM O SERVIDOR FINALIZADA >>>");

            } while (!str.trim().equals("100")) ;

            str = "";
            s.close();
        }
        catch (Exception err) {
            System.err.println(err);
        }
    }
}
