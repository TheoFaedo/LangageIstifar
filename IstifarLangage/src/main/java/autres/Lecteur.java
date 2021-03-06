package autres;

import instructions.AfficherInstruction;
import instructions.Condition;
import noeuds.Bloc;
import noeuds.Noeud;
import variables.*;
import variables.operations.OperationComparaison;
import variables.operations.OperationEntier;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Le but de cette classe est de lire un fichier et de convertir les ligne de ce fichier en noeuds dans l'interpreteur
 */
public class Lecteur {

    private String nomFichier;
    private Interpreteur interpreteur;



    public Lecteur(String nomFichier, Interpreteur interpreteur){
        this.nomFichier = nomFichier;
        this.interpreteur = interpreteur;
    }

    public void lireFichier(Noeud noeudPrincipale){
        Stack pileNoeud = new Stack();

        pileNoeud.add(noeudPrincipale); //On définit le noeud principale comme noeud courant

        try{
            Scanner scan = new Scanner(new File(this.nomFichier));
            while(scan.hasNextLine()){
                String ligne = scan.nextLine();

                Noeud temp1 = null;
                Noeud temp2 = null;

                Variable vTemp = null;

                Matcher m;
                System.out.println(trouverInstruction(ligne));
                switch (trouverInstruction(ligne)){

                    case "si":
                        m = Pattern.compile("\\((.*)\\)").matcher(ligne); //On récupère le contenu de la paranthese
                        if(m.find()) {
                            vTemp = lireValeur(m.group(1));
                            if (vTemp.getType().equals("booleen")) {
                                temp2 = new Bloc();
                                temp1 = new Condition((Booleen) vTemp, (Bloc) temp2);

                                ((Bloc)pileNoeud.peek()).ajouter(temp1); //On ajoute le nouveau noeud au noeud courant
                                pileNoeud.add(temp1); //On ajoute ce bloc à la liste des bloc courant
                                pileNoeud.add(temp2); //On ajoute ce bloc à la liste des bloc courant
                            }

                        }
                        break;

                    case "def":
                        temp1 = new Bloc(); //On créé un nouveau bloc

                        ((Bloc)pileNoeud.peek()).ajouter(temp1); //On ajoute le nouveau noeud au noeud courant

                        pileNoeud.add(temp1); //On ajoute ce bloc à la liste des bloc courant
                        break;

                    case "afficher":
                        m = Pattern.compile("\\((.*)\\)").matcher(ligne); //On récupère ce qu'il y a entre la paranthèse

                        if(m.find()){
                            Variable v = lireValeur(m.group(1));
                            temp1 = new AfficherInstruction(lireValeur(m.group(1)));
                            ((Bloc)pileNoeud.peek()).ajouter(temp1); //On ajoute le nouveau noeud au noeud courant
                        }
                        break;

                    case "fin":
                        pileNoeud.pop();
                        break;

                    case "finsi":
                        pileNoeud.pop();
                        pileNoeud.pop();
                        break;
                    default:
                        break;
                }

            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * Méthode qui permet de trouver l'instruction que demande une ligne
     * @param ligne : ligne qu'on souhaite analyser
     * @return l'identifiant de l'instruction demandée
     */
    public String trouverInstruction(String ligne){
         String[] tab = ligne.replace('\t', ' ').split(" ");


        Pattern pattern = Pattern.compile("[ \t]*def[ \t]+[a-z[A-Z]]+[ \t]*");
        Matcher m = pattern.matcher(ligne);
        if(m.find()){
            return "bloc";
        }

        pattern = Pattern.compile("[ \t]*afficher(.)[ \t]*");
        m = pattern.matcher(ligne);
        if(m.find()){
            return "afficher";
        }

        pattern = Pattern.compile("[ \t]*si(.)[ \t]*");
        m = pattern.matcher(ligne);
        if(m.find()){
            return "si";
        }

        pattern = Pattern.compile("[ \t]*fin[ \t]*");
        m = pattern.matcher(ligne);
        if(m.find()){
            return "fin";
        }

        pattern = Pattern.compile("[ \t]*finsi[ \t]*");
        m = pattern.matcher(ligne);
        if(m.find()){
            return "finsi";
        }

        pattern = Pattern.compile("[ \t]*.+[ \t]=[ \t].+[ \t]*");
        m = pattern.matcher(ligne);
        if(m.find()){
            return "assign";
        }

        return "o";
    }

    /**
     * Permet de lire une valeur contenue dans une expression
     * @param chaineALire : chaine dont on souhaite connaitre la valeur
     * @return la Valeur donnée
     */
    public Variable lireValeur(String chaineALire){
        Matcher m;

        //Syntaxe PlusGrandQue
        m = Pattern.compile("(.*)\\>(.*)").matcher(chaineALire);
        if(m.find()){

            Entier e1 = null;
            Entier e2 = null;

            Variable vTemp = lireValeur(m.group(1));
            if(vTemp.getType().equals("entier")){
                e1 = (Entier)vTemp;
            }

            vTemp = lireValeur(m.group(2));
            if(vTemp.getType().equals("entier")){
                e2 = (Entier)vTemp;
            }

            return new OperationComparaison("default", e1, e2, '>');
        }
        //Syntaxe PlusPetitQue
        m = Pattern.compile("(.*)\\<(.*)").matcher(chaineALire);
        if(m.find()){

            Entier e1 = null;
            Entier e2 = null;

            Variable vTemp = lireValeur(m.group(1));
            if(vTemp.getType().equals("entier")){
                e1 = (Entier)vTemp;
            }

            vTemp = lireValeur(m.group(2));
            if(vTemp.getType().equals("entier")){
                e2 = (Entier)vTemp;
            }

            return new OperationComparaison("default", e1, e2, '<');
        }



        //Syntaxe Addition
        m = Pattern.compile("(.*)\\+(.*)").matcher(chaineALire);
        if(m.find()){

            Entier e1 = null;
            Entier e2 = null;

            Variable vTemp = lireValeur(m.group(1));
            if(vTemp.getType().equals("entier")){
                e1 = (Entier)vTemp;
            }

            vTemp = lireValeur(m.group(2));
            if(vTemp.getType().equals("entier")){
                e2 = (Entier)vTemp;
            }

            return new OperationEntier("default", e1, e2, '+');
        }

        //Syntaxe Soustraction
        m = Pattern.compile("(.*)\\-(.*)").matcher(chaineALire);
        if(m.find()){

            Entier e1 = null;
            Entier e2 = null;

            Variable vTemp = lireValeur(m.group(1));
            if(vTemp.getType().equals("entier")){
                e1 = (Entier)vTemp;
            }

            vTemp = lireValeur(m.group(2));
            if(vTemp.getType().equals("entier")){
                e2 = (Entier)vTemp;
            }

            return new OperationEntier("default", e1, e2, '-');
        }

        //Syntaxe chaine de caractere
        m = Pattern.compile("\"(.*)\"").matcher(chaineALire);
        if(m.find()){
            return new Chaine("default", m.group(1));
        }

        //Syntaxe caractere
        m = Pattern.compile("\'(.)\'").matcher(chaineALire);
        if(m.find()){
            return new Caractere("default", m.group(1).charAt(0));
        }

        //Syntaxe booleen
        m = Pattern.compile("(False|True)").matcher(chaineALire);
        if(m.find()){
            if(m.group(1).equals("True")){
                return new Booleen("default", true);
            }else if(m.group(1).equals("False"))
                return new Booleen("default", false);
        }

        //Syntaxe entier
        m = Pattern.compile("([-]?[0-9]+)").matcher(chaineALire);
        if(m.find()){
           return new Entier("default", Integer.parseInt(m.group(1)));
        }


        return new Variable("entier", "entier");
    }



}
