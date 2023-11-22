import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int challengeOneAnswer = challengeOne("InputOneTwo.txt");
        int challengeTwoAnswer = challengeTwo("InputOneTwo.txt");
        int challengeThreeAnswer = challengeThree("InputThreeFour.txt");
        int challengeFourAnswer = challengeFour("InputThreeFour.txt");
        writeFileAllAnswers("AdventureTime.txt", challengeOneAnswer, challengeTwoAnswer, challengeThreeAnswer, challengeFourAnswer);
    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(fileName);
        int countIncrease = 0;
        int[] array = readFile(fileName);
        for (int i = 0; i<array.length-1; i++){
            if(array[i+1]>array[i]) countIncrease++;
        }
        return countIncrease;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        int sum1;
        int sum2;
        Scanner scanner = new Scanner(fileName);
        int countIncrease = 0;
        int[] array = readFile(fileName);
        for (int i = 0; i<array.length-3; i++){
            sum1 = array[i] + array[i+1] + array[i+2];
            sum2 = array[i+1] + array[i+2] + array[i+3];
            if(sum2>sum1) countIncrease++;
        }
        return countIncrease;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(fileName);
        int count = 0;
        int depth = 0;
        String[] array = readFileTwo(fileName);
        for (int i = 0; i<array.length; i++) {
            String[] check = array[i].split(" ", 2);
            if (check[0].equals("forward")) count += Integer.parseInt(check[1]);
            else if (check[0].equals("down")) depth += Integer.parseInt(check[1]);
            else if (check[0].equals("up")) depth -= Integer.parseInt(check[1]);
        }
        return count*depth;
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(filename);
        int count = 0;
        int depth = 0;
        int aim = 0;
        String[] array = readFileTwo(filename);
        for (int i = 0; i<array.length; i++) {
            String[] check = array[i].split(" ", 2);
            if (check[0].equals("forward")){
                depth += (aim * Integer.parseInt(check[1]));
                count += Integer.parseInt(check[1]);
            }
            else if (check[0].equals("down")){
                aim += Integer.parseInt(check[1]);
            }
            else if (check[0].equals("up")){
                aim -= Integer.parseInt(check[1]);
            }
        }
        return count*depth;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }
    private static String[] readFileTwo(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        String[] data = new String[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextLine();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}