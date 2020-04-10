package sentence;

import org.apache.log4j.Logger;
import text.Text;
import word.Word;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    public static final Logger LOG = Logger.getLogger(Text.class.getName());

    private List<Word> words = new ArrayList<Word>();

    public Sentence(String sentence) throws Exception {
        if(sentence == null){
            LOG.info("sentence is null");
            throw new NullPointerException("sentence is null");
        }
        StringBuilder str = new StringBuilder();
        char[] sentenceInSymbols = sentence.toCharArray();
        for (int i = 0; i < sentenceInSymbols.length; i++){
            if(sentenceInSymbols[i] == sentenceInSymbols[sentenceInSymbols.length-1]){
                str.append(sentenceInSymbols[i]);
                Word word = new Word(str.toString());
                words.add(word);
                str.delete(0,str.length());
            }
            if(sentenceInSymbols[i] == ' ' || sentenceInSymbols[i] == '\t'){
                if(str.length() != 0){
                    Word word = new Word(str.toString());
                    words.add(word);
                    str.delete(0,str.length());
                }
                while (sentenceInSymbols[i] == ' '){
                    i++;
                }
            }
            str.append(sentenceInSymbols[i]);
        }
    }

    public Sentence(){

    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        if(words == null){
            LOG.info("words is null");
            throw new NullPointerException("words is null");
        }
        this.words = words;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Word word : words) {
            str.append(word.toString());
        }
        return str.toString();
    }
}
