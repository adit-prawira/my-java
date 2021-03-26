import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class WordCounts {
    public static void main(String[] args) throws IOException {
        AtomicInteger sum = new AtomicInteger();
        File file = new File("/Users/adityaaaap/Desktop/ProgExer/my-java/src/assignment.pdf");
        PDDocument document = PDDocument.load(file);

        PDFTextStripper pdfStripper = new PDFTextStripper();

        String text = pdfStripper.getText(document);
        String[] sentences = text.split("\n");
        Arrays.stream(sentences).
                filter(s -> {
                    return s.contains("currently")&& s.contains("(") && s.contains(")");
                }).forEach(s -> {
                    String[] words = s.split(" ");
                    for(String word: words){
                        try{
                            int count = Integer.parseInt(word);
                            sum.addAndGet(count);
                        }catch(NumberFormatException e){
                            System.out.println(word + ": " + "Is not a digit");
                        }
                    }
        });
        System.out.println("#############################################");
        System.out.println("Total word counts for this document: " + sum);
        System.out.println("#############################################");
        document.close();
    }
}

