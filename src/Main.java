import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Main {
    HashMap<String, Integer> wordMap=new HashMap<String,Integer>();

    public void readFile(String file){
        String word="";
        Scanner sc;
        try {
            sc=new Scanner(new File("/home/milan/IdeaProjects/data.txt"));
            sc.useDelimiter(" ");
            while (sc.hasNext()){
                word=sc.next();
                word=word.toLowerCase();
                word=word.replaceAll("[,;]","");
                if (!word.equals("")){
                    if(wordMap.containsKey(word))
                        wordMap.put(word,wordMap.get(word)+1);
                    else
                        wordMap.put(word,1);
                }
            }
            sc.close();
        } catch (FileNotFoundException e){
            System.out.println("File does not exist"+e);
        }
    }
    public void printWordFreq(){
        for (String word: wordMap.keySet()){
            int count=wordMap.get(word);
            System.out.println("{"+word+"},"+count+"}"+"\n");
        }
    }

    public static void main(String[] args) {
        Main unigram =new Main();
        unigram.readFile("Data/data.txt");
        unigram.printWordFreq();
    }
}