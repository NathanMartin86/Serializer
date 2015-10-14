import jodd.json.JsonSerializer;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by macbookair on 10/14/15.
 */
public class Album {
    public static void main(String[] args) throws IOException {

        Albinfo album = null;
        Scanner scanner = new Scanner(System.in);
        File f = new File("inputs.txt");
        while (true) {
            System.out.println("Welcome to your music library! Would you like to make an addition? [y/n]");
            String start = scanner.nextLine().toLowerCase();
            if (start.equals("y")){
                System.out.println("Okay, what is the album title");
                String albumtitle = scanner.nextLine();

                System.out.println("What year did this album release?");
                String yearchoice = scanner.nextLine();

                System.out.println("Who is the artist?");
                String artistchoice = scanner.nextLine();

                System.out.println("What's the genre");
                String genrechoice = scanner.nextLine();

                System.out.println("Who produced it?");
                String producer = scanner.nextLine();


                album = new Albinfo(albumtitle, yearchoice, artistchoice, genrechoice, producer);

            }
            else if (start.equals("n")) {
                System.out.println("Alright. Your additions have been saved. See you next time!");
                JsonSerializer serializer = new JsonSerializer();
                String contentToSave = serializer.serialize(album);
                FileWriter fw = new FileWriter(f);
                fw.write(contentToSave);
                fw.close();
            }


        }

    }
}