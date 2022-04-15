package autres;

import noeuds.Bloc;
import noeuds.Noeud;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Le but de cette classe est de lire un fichier et de convertir les ligne de ce fichier en noeuds dans l'interpreteur
 */
public class Lecteur {

    private String nomFichier;

    public static void main(String[] args) {
        Lecteur l = new Lecteur("example.istifar");
        l.lireFichier(new Bloc());
    }



    public Lecteur(String nomFichier){
        this.nomFichier = nomFichier;
    }

    public void lireFichier(Noeud noeudPrincipale){
        try{
            Scanner scan = new Scanner(new File(this.nomFichier));
            while(scan.hasNextLine()){
                String ligne = scan.nextLine();
                System.out.println(lireLigne(ligne));
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public String lireLigne(String ligne){
         String[] tab = ligne.replace('\t', ' ').split(" ");

        Pattern defPattern = Pattern.compile("[ \t]*def[ \t]+[a-z[A-Z]]+[ \t]*");
        Pattern affPattern = Pattern.compile("[ \t]*afficher(.)[ \t]*");
        Pattern ifPattern = Pattern.compile("[ \t]*if(.)[ \t]*");
        Pattern endPattern = Pattern.compile("[ \t]*end[ \t]*");

        Matcher m = defPattern.matcher(ligne);
        if(m.find()){
            return "bloc";
        }

        m = affPattern.matcher(ligne);
        if(m.find()){
            return "afficher";
        }

        m = endPattern.matcher(ligne);
        if(m.find()){
            return "end";
        }
        
        m = ifPattern.matcher(ligne);
        if(m.find()){
            return "if";
        }

        return "o";
    }



}
