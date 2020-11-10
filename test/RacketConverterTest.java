import static org.junit.Assert.assertEquals;

import conversionCode.RacketConverter;
import conversionCode.dimacsCNFConverter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;

public class RacketConverterTest {
  private dimacsCNFConverter racketConvert;
  private File inputFile;
  private File outputFile;
  private File testingOutput;

  @Before
  public void setUp() {
    this.testingOutput = new File
        ("C:\\Users\\yousu\\IdeaProjects\\CS2800_Project1\\test\\testingFileOutputRacket.lisp");
    this.inputFile = new File
        ("C:\\Users\\yousu\\IdeaProjects\\CS2800_Project1\\src\\InputFiles\\test-factor-1.cnf");
    this.outputFile = new File
        ("C:\\Users\\yousu\\IdeaProjects\\CS2800_Project1\\src\\OutputFiles\\test-factor-1.lisp");
    this.racketConvert = new RacketConverter(this.inputFile, this.outputFile);
  }

  @Test
  public void testConversion() {
    this.racketConvert.getCNF();
    try {
      Scanner scan1 = new Scanner(this.testingOutput);
      Scanner scan2 = new Scanner(this.outputFile);

      while (scan1.hasNext() && scan2.hasNext()) {
        String str1 = scan1.next();
        String str2 = scan2.next();
        assertEquals(str1, str2);
      }

    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("Invalid file provided.");
    }

  }

}
