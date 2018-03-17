package letters_dictionary;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Test;

import letters_dictionary.index_strategy.CaseInsensitiveIndexStrategy;
import letters_dictionary.index_strategy.CaseSensitiveIndexStrategy;
import letters_dictionary.index_strategy.IndexStrategy;

public class LetterDictionaryPerformanceTest {

    @Test
    public void TenThousandLoremIpsumPerformanceTest() throws IOException, URISyntaxException {
        performanceTestFor("10KloremIpsum.txt", new CaseInsensitiveIndexStrategy());
        performanceTestFor("10KloremIpsum.txt", new CaseSensitiveIndexStrategy());
    }

    @Test
    public void OneMillionLoremIpsumPerformanceTest() throws IOException, URISyntaxException {
        performanceTestFor("1MloremIpsum.txt", new CaseInsensitiveIndexStrategy());
        performanceTestFor("1MloremIpsum.txt", new CaseSensitiveIndexStrategy());
    }

    @Test
    public void AllDistinctEnglishWordsPerformanceTest() throws IOException, URISyntaxException {
        //https://github.com/dwyl/english-words
        performanceTestFor("allEnglishWords.txt", new CaseInsensitiveIndexStrategy());
        performanceTestFor("allEnglishWords.txt", new CaseSensitiveIndexStrategy());
    }

    private void performanceTestFor(String s, IndexStrategy indexStrategy) throws IOException, URISyntaxException {
        String input = new String(Files.readAllBytes(Paths.get(ClassLoader.getSystemResource(s).toURI())), Charset.forName("UTF-8"));
        long start = System.currentTimeMillis();
        LettersMap lettersMap = new LetterDictionary().indexLettersPerWords(input, indexStrategy);
        String results = lettersMap.getResults();
        saveAndPrintResults(results, indexStrategy);
        long end = System.currentTimeMillis() - start;
        System.out.println("Performance test took: " + end + " miliseconds");
    }

    private void saveAndPrintResults(String results, IndexStrategy indexStrategy) throws IOException {
        Files.write(Paths.get(indexStrategy.getClass().getSimpleName() + "_performance_results.txt"), results.getBytes(), StandardOpenOption.CREATE);
//        System.out.println(results); //uncomment to see test results
    }
}