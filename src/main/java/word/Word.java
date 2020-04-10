package word;

import org.apache.log4j.Logger;
import text.Text;

public class Word {
    public static final Logger LOG = Logger.getLogger(Text.class.getName());

    private String word = "";
    private String punctuationAfterWorld = "";
    private boolean isPunctuationAfterWorld = false;

    public Word(String word){
        if(word == null){
            LOG.warn("word is null");
            throw new NullPointerException("word is null");
        }
        isAfterWorldStayPunctuation(word);
    }

    public Word(){

    }

    public boolean isPunctuationAfterWorld() {
        return isPunctuationAfterWorld;
    }

    public String getPunctuationAfterWorld() {
        return punctuationAfterWorld;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        if(word == null){
            LOG.info("word is null");
            throw new NullPointerException("word is null");
        }
        this.word = word;
    }

    public void isAfterWorldStayPunctuation(String word){
        char[] wordInSymbols = word.toCharArray();
        if(Character.isLetter(wordInSymbols[wordInSymbols.length-1])== true || Character.isDigit(wordInSymbols[wordInSymbols.length-1])== true){
            this.word = word;
            return;
        }
        this.isPunctuationAfterWorld = true;
        int i = 0;
        StringBuilder str = new StringBuilder();
        while (Character.isLetter(wordInSymbols[i])== true|| Character.isDigit(wordInSymbols[wordInSymbols.length-1])== true){
            str.append(wordInSymbols[i]);
            i++;
        }
        this.word = str.toString();
        str.delete(0,str.length());
        while (i < wordInSymbols.length){
            str.append(wordInSymbols[i]);
            i++;
        }
        this.punctuationAfterWorld = str.toString();
    }

    @Override
    public String toString() {
        return word + punctuationAfterWorld + " ";
    }
}
