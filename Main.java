import java.io.*;

public class Main
{
	public static void main(String[] args)
	{
		/* Incorrect execution command */
        if (args.length != 3) {
            System.out.println("Err: Incorrect command line arguments");
            System.out.println("Proper command: $ java Main [training dataset filename] [test dataset filename] [output filename]");
            System.exit(0);
        }


        /* Create database objects from training and test data */
        Database dbTrain = null;
        Database dbTest = null;

        try {
        	dbTrain = new Database(args[0]);
        	dbTest = new Database(args[1]);
        } catch (Exception e) {
        	e.printStackTrace();
        }


        /* Run C45 algorithm */



        /* Print results to output file */
        File fOut = new File(args[2]);
        try {
            PrintWriter pw = new PrintWriter(fOut);

            // TODO
            //pw.print();

            pw.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
	}
}