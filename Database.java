import java.util.List;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Database
{
	public static List< List<String> > data;

	public Database(String fName) throws Exception
	{
		data = new ArrayList< List<String> >();


		FileInputStream fin = new FileInputStream(fName);
        InputStreamReader istream = new InputStreamReader(fin);
        BufferedReader stdin = new BufferedReader(istream);


        /* Populate 'data' List with each mushroom's attribute values */
        String line;
        while ((line = stdin.readLine()) != null)
        {
            List<String> mushroom = new ArrayList<String>();
            String[] temp = line.split("\\s+");

            for (String attrVal : temp) mushroom.add(attrVal);

            if (mushroom.isEmpty()) continue;

            data.add(mushroom);
        }


        /* Close input stream readers */
        fin.close();
        istream.close();
        stdin.close();
	}
}