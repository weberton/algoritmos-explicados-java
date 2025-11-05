package br.com.aartedeprogramar.aula2;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== Aula 2.2 — Big O na Prática =====");
        AnaliseBigOPratica.medirTempo(1);
        AnaliseBigOPratica.medirTempo(10);
        AnaliseBigOPratica.medirTempo(1000);
        AnaliseBigOPratica.medirTempo(100000);
        AnaliseBigOPratica.medirTempo(500000);
        AnaliseBigOPratica.medirTempo(1000000);
    }
}
