// ClosestWordsOptimized
/* Labb 2 i DD2350 Algoritmer, datastrukturer och komplexitet    */
/* Följ instruktionerna i kursrummet i Canvas                    */
/* Ursprunglig författare: Viggo Kann KTH viggo@nada.kth.se      */
import java.util.LinkedList;
import java.util.List;

/*Hitta ord med det minsta avståndet till ett givet ord */
/*Avståndet mellan strängar refrerar till antal operationer, ersätt, tabort och lägg till */
/*Känt som levenshtein-avståndet */
public class ClosestWords {
    //lista som ska innehålla ordet närmast ett givet ord 
  LinkedList<String> closestWords = null;
  //intierar till det minsta antaö operationer som krävs för att omvandla ett ord
  int closestDistance = -1;

  // Beräknar partiell distans mellan två strängar
  /*Beräkning av en del av levenshtein algoritm mellan två stärngar mw1 och w2
  med hjälp av dynamsik programeringsmatris "dynMatrix" */
  int[][] partDist(String w1, String w2, int w1len, int w2len, StringBuilder prevWord, int[][] dynMatrix) {
    if (w1len == 0 || w2len == 0) {
/*Om ngn av strängar är tom, intialiseras matrisen */
      return dynMatrix = initMatrix();
    }

    // Hitta index där strängarna börjar skilja sig
    int matchingIndex = 0;
    while (matchingIndex < prevWord.length() && matchingIndex < w2.length() && prevWord.charAt(matchingIndex) == w2.charAt(matchingIndex)) {
      matchingIndex++;
    }

    // Justera startindex för bearbetning
    //sätter start index till ett steg efter där strängarna börjar skilja sig 
    int startIdx = matchingIndex + 1;
 
    //dubbel loop för att gå genom varje bokstab i både orden och jämföra dem
    for (int i = 1; i <= w1len; i++) {
      for (int j = startIdx; j <= w2len; j++) {
    //kontroller bokstäver vid givna positioner om de är lika eller olika, matrisen uppdatera
        int replaceCost = ((w1.charAt(i - 1) == w2.charAt(j - 1)) ? 0 : 1) + dynMatrix[i - 1][j - 1];
    // kostnaden för att sätt in en bokstav i w1 för att matcha v2
        int insertCost = 1 + dynMatrix[i - 1][j];
    //ta bort en boktav från w1 för att matcha v2
        int deleteCost = 1 + dynMatrix[i][j - 1];
//uppdatera till den mista kostnaden 
        dynMatrix[i][j] = Math.min(replaceCost, Math.min(insertCost, deleteCost));
      }
    }

    return dynMatrix;
  }

  // Beräknar distansen mellan två strängar
  int[][] distance(String w1, String w2, StringBuilder prevWord, int[][] dynMatrix) {
    return partDist(w1, w2, w1.length(), w2.length(), prevWord, dynMatrix);
  }

//beräkna avståndet mellan w och varje ord i  listan och 
//lagrar den märmaste orden och deras avstånd
  public ClosestWords(String w, List<String> wordList) {
    //spara den senaste behandlade ord(upp till 40 tecken)
//ett sätt att optimera prestandan genom att minimera antalet omallokeringar som kan behövas under programmets körning.
    StringBuilder prevWord = new StringBuilder(40);
    //initialisera dynMatrix till en två dimensionell array 
    int[][] dynMatrix = initMatrix();

//loopa genom varje ord i listan 
    for (String currentWord : wordList) {
        //beräkna distance från w till varje ord 
      dynMatrix = distance(w, currentWord, prevWord, dynMatrix);
      //dist håller koll på avståndet mellan w och den aktuella ordet
      int dist = dynMatrix[w.length()][currentWord.length()];

      if (dist < closestDistance || closestDistance == -1) {
    /*om if uppfylls uppdateras closest distance och listan
    initieras med den aktuella ordet */
        closestDistance = dist;
        closestWords = new LinkedList<String>();
        closestWords.add(currentWord);
        //annars läggs den aktuella ordet i listan
  
  
      } else if (dist == closestDistance) {
        closestWords.add(currentWord);
      }

    /*efter varje intiering rensas prevWord och uppdateras med
    aktuella ordet i nästa i nästa iteration, detta gör att vi kan optimera beräkning */
// undvika onödiga beräkningar för inledande tecken som är gemensamma mellan sekventiella ord i listan.
      prevWord.delete(0, prevWord.length());
      prevWord.append(currentWord);
    }
  }

  // Initialiserar dynamisk matris
  int[][] initMatrix() {
    int[][] dynMatrix = new int[41][41];
    for (int j = 0; j <= 40; j++) {
      dynMatrix[0][j] = j;
    }
    for (int i = 1; i <= 40; i++) {
      dynMatrix[i][0] = i;
    }
    return dynMatrix;
  }

  // Returnerar minsta avståndet
  int getMinDistance() {
    return closestDistance;
  }

  // Returnerar lista med närmaste ord
  List<String> getClosestWords() {
    return closestWords;
  }
}
