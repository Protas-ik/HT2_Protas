package text;

import org.apache.log4j.Logger;
import paragraph.Paragraph;
import services.Services;

import java.util.ArrayList;
import java.util.List;

public class Text {
    public static final Logger LOG = Logger.getLogger(Text.class.getName());

    private List<Paragraph> paragraphs = new ArrayList<Paragraph>();

    public Text(String text) throws Exception {
        if(text == null){
            LOG.info("text is null");
            throw new NullPointerException("text is null");
        }
        StringBuilder str = new StringBuilder();
        char[] textInSymbols = text.toCharArray();
        for(int i = 0; i < textInSymbols.length; i++){
            if(textInSymbols[i] == '\n' || i + 1 == textInSymbols.length){
                while(textInSymbols[i] == '\n' && i + 1 != textInSymbols.length){
                    i++;
                }
                Paragraph paragraph = new Paragraph(str.toString());
                paragraphs.add(paragraph);
                str.delete(0,str.length());
            }
            str.append(textInSymbols[i]);
        }
    }

    public Text(){

    }

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(List<Paragraph> paragraphs) {
        if(paragraphs == null){
            LOG.info("Paragraphs is null");
            throw new NullPointerException("Paragraphs is null");
        }
        this.paragraphs = paragraphs;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Paragraph paragraph : paragraphs) {
            str.append(paragraph.toString());
            str.delete(str.length()-1,str.length());
            str.append("\n");
        }
        return str.toString();
    }
}
