public class ChiffreRomain {

    public static final String[] chiffresRomains= {"I","V","X","L","C","D","M"};

    static String puissance10ArabeToRomain (int valeur, int puissance10) {
        switch (valeur) {
                case 1:return chiffresRomains[puissance10*2];
                case 2:return chiffresRomains[puissance10*2]
                             +chiffresRomains[puissance10*2];
                case 3:return chiffresRomains[puissance10*2]
                             +chiffresRomains[puissance10*2]
                             +chiffresRomains[puissance10*2];
                case 4:return chiffresRomains[puissance10*2]
                             +chiffresRomains[puissance10*2+1];
                case 5:return chiffresRomains[puissance10*2+1];
                case 6:return chiffresRomains[puissance10*2+1]
                             +chiffresRomains[puissance10*2];
                case 7:return chiffresRomains[puissance10*2+1]
                             +chiffresRomains[puissance10*2]
                             +chiffresRomains[puissance10*2];
                case 8:return chiffresRomains[puissance10*2+1]
                             +chiffresRomains[puissance10*2]
                             +chiffresRomains[puissance10*2]
                             +chiffresRomains[puissance10*2];
                case 9:return chiffresRomains[puissance10*2]
                             +chiffresRomains[puissance10*2+2];
                default: return "";
        }
    }
    
   static int valeurChiffreRomain(String s) {
   int i=0;
   int valeur=0;
   //on parcourt le tableau à la recherche du chiffre romain
   while (i<chiffresRomains.length && !s.equals(chiffresRomains[i])) i++;
   if (i==chiffresRomains.length) return 0; //on n'a pas trouvé
   else {valeur=(int)(Math.pow(10,(i/2)));
         if  ((i%2)==1) valeur=valeur*5;
         return valeur;
        }
   }
   
    private String chiffresR;  //Attribut dans lequel on stocke un nombre romain
    private int valeur;
    
    ChiffreRomain(int nombre) {  //constructeur
        valeur=nombre;
        chiffresR="";
        int puissance10=0;  //on mémorise la puissance de 10 car
        while (nombre>0) { //à chaque étape, on va diviser par 10  
            chiffresR=puissance10ArabeToRomain(nombre % 10,puissance10)+chiffresR;
            puissance10=puissance10+1;         // %10 = reste de la division par 10
            nombre = nombre / 10; //division entière par 10
         }
    }
    
    ChiffreRomain(String chaine) {
      chiffresR=chaine;
      valeur=0;
      int i=0;
      while (i<chaine.length()) {
         int v1=valeurChiffreRomain(chaine.substring(i, i+1));
         if (i<chaine.length()-1) {
            int v2=valeurChiffreRomain(chaine.substring(i+1, i+2));
            if (v1<v2) 
               {valeur=valeur+v2-v1;
                i=i+1;}
            else valeur=valeur+v1;}
         else valeur=valeur+v1;
         i=i+1;
      }
    }
                
    public int toInt() {return valeur;}
    
    public String toString() {return chiffresR;}
    
    public static void main (String args[]) {
        System.out.println(new ChiffreRomain(1987)); //900
        ChiffreRomain c=new ChiffreRomain("MCMXCVIII");
        System.out.println(c.toString()+" = "+c.toInt());
        ChiffreRomain d=new ChiffreRomain("MMMDCCCXLIX");
        System.out.println(d.toString()+" = "+d.toInt());
    }
}
