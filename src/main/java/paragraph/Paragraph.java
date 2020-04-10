package paragraph;

import org.apache.log4j.Logger;
import sentence.Sentence;
import text.Text;

import java.util.ArrayList;
import java.util.List;

public class Paragraph {
    public static final Logger LOG = Logger.getLogger(Text.class.getName());

    private List<Sentence> sentences = new ArrayList<Sentence>();

    public Paragraph(String paragraph) throws Exception {
        if(paragraph == null){
            LOG.info("Paragraph is null");
            throw new NullPointerException("Paragraph is null");
        }
        StringBuilder str = new StringBuilder();
        char[] paragraphInSymbols = paragraph.toCharArray();
        for(int i = 0; i < paragraphInSymbols.length; i++){
            str.append(paragraphInSymbols[i]);
            if(paragraphInSymbols[i] == '!' || paragraphInSymbols[i] == '?' || paragraphInSymbols[i] == '.'){
                Sentence sentence = new Sentence(str.toString());
                sentences.add(sentence);
                str.delete(0,str.length());
            }
        }
    }

    public Paragraph(){

    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        if(sentences == null){
            LOG.info("sentences is null");
            throw new NullPointerException("sentences is null");
        }
        this.sentences = sentences;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Sentence sentence : sentences) {
            str.append(sentence.toString());
        }
        return str.toString();
    }
}
