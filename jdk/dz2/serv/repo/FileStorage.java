package serv.repo;

import java.io.FileReader;
import java.io.FileWriter;

public class FileStorage implements Repository<String> {
    private static final String LOG_PATH = "src/history.txt";


    @Override
    public void save(String text){
        try (FileWriter writer = new FileWriter(LOG_PATH, true)){
            writer.write(text);
            writer.write("\\n");
        } catch (Exception e){
            // e.printStackTrace();
            System.out.println("save history chat");
        }
    }

    @Override
    public String load(){
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(LOG_PATH);){
            int c;
            while ((c = reader.read()) != -1){
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e){

            System.out.println("Transfer history");
            return null;
        }
    }
}

