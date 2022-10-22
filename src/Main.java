import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int qntTemperatura, cont = 1;
        String tempInicial, tempFinal;
        double valorTemp, valorConvertido, mediaTempInicial=0.0, mediaTempTransformada=0.0;

        System.out.printf("\nDigite o número de conversões desejadas:\n");
        qntTemperatura = scan.nextInt();

        System.out.printf("Escolha a temperatura inicial, digite:" +
                "\nC para Celsius" +
                "\nK para Kelvin" +
                "\nF para Fahrenheit\n");
        tempInicial = scan.next();

        System.out.printf("Escolha para qual temperatura deseja converter, digite:" +
                "\nC para Celsius" +
                "\nK para Kelvin" +
                "\nF para Fahrenheit\n");
        tempFinal = scan.next();

        while (cont<=qntTemperatura){
            System.out.printf("\nDigite a temperatura %s:\n", cont);
            valorTemp = scan.nextInt();
            valorConvertido=conversorTemp(cont, tempInicial, tempFinal, valorTemp);
            if (valorConvertido==0.0){
                System.out.printf("\nErro em seleção de Temperatura!\n");
                break;
            }
            mediaTempInicial=(mediaTempInicial+valorTemp)/qntTemperatura;
            mediaTempTransformada=(mediaTempTransformada+valorConvertido)/qntTemperatura;
            cont++;
        }

        if (mediaTempInicial!=0.0 && mediaTempTransformada!=0.0){
            System.out.printf("\nMédia das temperaturas iniciais: %s%s", mediaTempInicial,tempInicial);
            System.out.printf("\nMédia das temperaturas convertidas: %s%s", mediaTempTransformada,tempFinal);
        }
    }

    private static double conversorTemp(int cont, String tempInicial, String tempFinal, double valorTemp) {
        double conversor;
        switch (tempInicial) {
            case "C":
                if (tempFinal.equals("F")) {
                    conversor = (valorTemp * (9.0 / 5.0)) + 32.0;
                    System.out.printf("\nConversao %s: %sºC = %sºF\n", cont, valorTemp, conversor);
                    return conversor;
                } else if (tempFinal.equals("K")){
                    conversor = (valorTemp + 273.15);
                    System.out.printf("\nConversao %s: %sºC = %sK\n", cont, valorTemp, conversor);
                    return conversor;
                }else {
                    System.out.printf("\nTemperatura selecionada é inválido!\n");
                    return 0.0;
                }
            case "F":
                if (tempFinal.equals("C")) {
                    conversor =(valorTemp -32.0)*(5.0/9.0);
                    System.out.printf("\nConversao %s: %sºF = %sºC\n", cont, valorTemp, conversor);
                    return conversor;
                } else if (tempFinal.equals("K")){
                    conversor = (valorTemp -32.0)*(5.0/9.0)+273.15;
                    System.out.printf("\nConversao %s: %sºF = %sK\n", cont, valorTemp, conversor);
                    return conversor;
                }else {
                    System.out.printf("\nTemperatura selecionada é inválido!\n");
                    return 0.0;
                }
            case "K":
                if (tempFinal.equals("F")) {
                    conversor = ((valorTemp -273.15) * (9.0 / 5.0)) + 32.0;
                    System.out.printf("\nConversao %s: %sK = %sºF\n", cont, valorTemp, conversor);
                    return conversor;
                } else if (tempFinal.equals("C")){
                    conversor = (valorTemp - 273.15);
                    System.out.printf("\nConversao %s: %sK = %sºC\n", cont, valorTemp, conversor);
                    return conversor;
                }else {
                    System.out.printf("\nTemperatura selecionada é inválido!\n");
                    return 0.0;
                }
            default:
                System.out.printf("\nTemperatura selecionada é inválido!\n"); return 0.0;
        }
    }
}