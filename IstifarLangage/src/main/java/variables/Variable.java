package variables;

public class Variable {
        
        protected String nom;
        protected String type;
        
        public Variable(String nom, String type) {
            this.nom = nom;
            this.type = type;
        }
        
        public String getNom() {
            return nom;
        }
        
        public String getType() {
            return type;
        }
        
        public void setNom(String nom) {
            this.nom = nom;
        }

        
        public String toString() {
            return "Variable " + this.nom + " de type " + this.type;
        }
}
