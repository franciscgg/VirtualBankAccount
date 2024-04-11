import java.util.Scanner;

public class ContaBancaria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nomeCliente = "Francisco Hélio";
        String tipoDeConta = "Corrente";
        double saldoInicial = 777.00;

        String dadosCliente = """
                ************************************************
                Dados inicias do cliente:
                
                        Nome:              %s
                        Tipo de conta:     %s
                        Saldo inicial:     R$%.2f
                ************************************************
                """.formatted(nomeCliente, tipoDeConta, saldoInicial);
        System.out.println(dadosCliente);

        int opcao;
        do {
            String operacao = """
                
                Operações
                
                1- Consultar saldo
                2- Receber valor
                3- Transferir valor
                4- Sair
                
                Digite a opção desejada:
                """;
            System.out.println(operacao);
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println(String.format("O saldo atual é R$%.2f",saldoInicial));
                    break;

                case 2:
                    System.out.println("Digite o valor a receber:");
                    double valorRecebido = scanner.nextDouble();
                    if (valorRecebido > 0){
                        double saldoAtualizado = valorRecebido + saldoInicial;
                        saldoInicial += valorRecebido;
                        System.out.println(String.format("Transferência recebida \nSeu saldo atual R$%.2f",saldoAtualizado));
                    }else{
                        System.out.println("Transferência mal sucedida,digite um valor válido");
                    }
                    break;

                case 3:
                    System.out.println("Digite o valor que deseja transferir:");
                    double valorTranferir = scanner.nextDouble();
                    if (saldoInicial >= valorTranferir){
                        double saldoAtualizado = saldoInicial - valorTranferir;
                        saldoInicial -= valorTranferir;
                        System.out.println(String.format("O valor de R$%.2f foi transferido com sucesso \nSeu saldo atual R$%.2f",valorTranferir,saldoInicial));
                    } else{
                        System.out.println("Seu saldo é insuficiente para essa transferência, tente novamente");
                    }
                    break;

                case 4:
                    System.out.println("Encerrando programa...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente");
                    break;
            }
        }
            while (opcao != 4) ;
            scanner.close();

    }
}


