package autres;

public class Main {
    public static void main(String[] args) {
        Interpreteur i = new Interpreteur();
        Lecteur l = new Lecteur("example.istifar", i);
        l.lireFichier(i.getRoot());
        i.executerInterpreteur();
    }
}
