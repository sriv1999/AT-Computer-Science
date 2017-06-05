package wordamounts;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordAmounts {
    public static void ReadFile()
    {
        String phrase;
        int count = 0;
        int numWords = 0;
        String word = "";
        ArrayList<String> words = new ArrayList<String>();
        ArrayList<WordTally> freq = new ArrayList<WordTally>();
        File file = new File("H:/Files-AT/dream.txt");
        
        try {
            Scanner inFile = new Scanner(file);
            while (inFile.hasNextLine())
            {        
                phrase = inFile.nextLine();
                if (phrase.length() > 0){
                    String[] splitArray = phrase.replaceAll("[^a-zA-Z ]", "").toLowerCase().trim().split("\\s+");
                    for (int x = 0; x < splitArray.length; x++){
                        words.add(splitArray[x]);
                    }
                }

            }
        } catch (FileNotFoundException e) {  
            System.out.println("File not Found");    
            e.printStackTrace();
        }
        
        for (int x = 0; x < words.size(); x++){
            if (originalWords(words.get(x) , words, x)){
                count++;
                word = words.get(x);
                numWords = 0;
                for(int y = 0; y < words.size(); y++){
                    if (words.get(y).equals(word)){
                        numWords++;
                    }
                }
                freq.add(new WordTally(word , numWords));
            }
           
        }
       
        System.out.println("Number of Unique Words: "+count);
        System.out.println("Total number words: "+words.size());
        System.out.println("\tWord\tFrequency");
        for(int x = 0; x < 30; x++){
            int pos = getMax(freq);
            System.out.println(x+1+")\t"+freq.get(pos).getWord()+"\t"+freq.get(pos).getFrequency());
            freq.remove(pos);
        }
       
    }
    public static boolean originalWords(String word, ArrayList<String> a, int index){
            for (int x = 0; x < index; x++){
                if (a.get(x).equalsIgnoreCase(word))
                    return false;
            }
            return true;
    }
   
    public static int getMax(ArrayList<WordTally> a){
        int max = a.get(0).getFrequency();
        int maxPos = 0;
        for (int x = 0; x < a.size(); x++){
            if ( a.get(x).getFrequency()> max){
                max = a.get(x).getFrequency();
                maxPos = x;
            }
        }
        return maxPos;
    }

    public static void main(String[] args) {
        ReadFile();

    }

}