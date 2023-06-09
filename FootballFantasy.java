import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class FootballFantasy
{
    public FootballFantasy()
    {
        File fileName = new File("Fantasy Football.txt");
        int sum = 0;
        try
        {
            BufferedReader input = new BufferedReader(new FileReader(fileName));
            String text = input.readLine();
            int num = 1;
            ArrayList<Player> players = new ArrayList<Player>();

            while((text = input.readLine()) != null)
            {
                try
                {
                    String[] pieces = text.split(";");
                    double pick = Double.parseDouble(pieces[0]);
                    double overall = Double.parseDouble(pieces[5]);
                    players.add(new Player(pick, pieces[1], pieces[2], pieces[3], Integer.parseInt(pieces[4]), overall, Double.parseDouble(pieces[6]), Double.parseDouble(pieces[7]), Double.parseDouble(pieces[8]), Integer.parseInt(pieces[9])));
                }catch(NumberFormatException nfe)
                {

                }
            }

            Collections.sort(players);

            for(Player a: players)
                System.out.println(a);

        }catch(IOException e)
        {
            System.out.println("File not found.");
        }
    }

    public static void main(String[] args)
    {
        FootballFantasy app = new FootballFantasy();
    }
}