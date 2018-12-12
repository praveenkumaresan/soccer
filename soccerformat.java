import java.io.*;

public class Main {

    public static void main(String[] args) {

        String fileName = "soccer.txt";
        String line = null;
        File fout = new File("soccerout.txt");

        try {
            /**
             * file reader to read file name. Create a buffered object.
             * create file output stream
             */
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileOutputStream fos = new FileOutputStream(fout);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            /**
             * read until end of file
             */
            while ((line = bufferedReader.readLine()) != null) {

                /**
                 * format the input record and write to output record as below
                 * input -> Chelsea 2-1 Liverpool
                 * output -> Chelsea ,Liverpool,2,1
                 */
                String[] splitCharacter = line.split("-");

                String firstTeam = splitCharacter[0].substring(0, splitCharacter[0].length() - 1);

                String[] lastTeamName = splitCharacter[1].split(" ");

                String outputRecord = firstTeam + "," + lastTeamName[1] + "," +
                        splitCharacter[0].substring(splitCharacter[0].length() - 1) + "," + splitCharacter[1].substring(0, 1);

                bw.write(outputRecord);
                bw.newLine();

            }

            /**
             * closing the files
             */
            bufferedReader.close();
            bw.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file " + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");

        }

    }
}
