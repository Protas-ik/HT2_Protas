package services;

import org.apache.log4j.Logger;
import paragraph.Paragraph;
import sentence.Sentence;
import text.Text;
import word.Word;

import java.util.List;

public class Services {
    public static final Logger LOG = Logger.getLogger(Services.class.getName());

    public void changeFirstAndLastWordInSentence(Text text){
        if(text == null){
            LOG.warn("Text is null");
            throw new NullPointerException("Text is null");
        }
        for (Paragraph paragraph : text.getParagraphs()) {
            List<Sentence> sentences = paragraph.getSentences();
            for( Sentence sentence : sentences){
                List<Word> words = sentence.getWords();
                String helpWorld = words.get(0).getWord();
                words.get(0).setWord(words.get(words.size()-1).getWord());
                words.get(words.size()-1).setWord(helpWorld);
            }
        }
    }


}
