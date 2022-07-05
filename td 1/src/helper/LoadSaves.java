package helper;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadSaves {
    //static String name;
    static String Filepath ="./res/test.txt";
    //static String NFilepath= "./res/" + name + ".txt";
    public static BufferedImage getSpriteAtlas(){
        BufferedImage img =null;
        System.out.println("Load image");
        InputStream is = LoadSaves.class.getClassLoader().getResourceAsStream("res/spriteatlas.png");
        try{
            img = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return img;
    }
    public static void CreateFile(){
        System.out.println("Create file");
        File txtFile = new File(Filepath);
        try {
            txtFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void WriteToFile(File f, int[] idArr){
        System.out.println("Write to file");
        File txtFile = new File(Filepath);
        try {
            PrintWriter pw =new PrintWriter(f);
            for(Integer i :idArr){
                pw.println(i);
            }
            pw.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void SaveLevel(String name,int[][] idArr){
        System.out.println("Save level");
        File LevelFile = new File("./res/" + name + ".txt");
        if(LevelFile.exists()){
            WriteToFile(LevelFile,Utilz.TwoDto1DintArr(idArr));
            System.out.println("Zapisano plik");
        }else{
            System.out.println("Plik: "+name+ " nie istnieje");
            return;
        }
    }
    public static ArrayList<Integer> ReadFromFile(File file){
        ArrayList<Integer> list = new ArrayList<>();
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                list.add(Integer.parseInt(sc.nextLine()));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public static void CreateLevel(String name, int[] idArr){
        System.out.println(name);
        File new_level= new File("td 1/src/res/" + name + ".txt");;
        if(new_level.exists()){
            System.out.println("Plik: "+name+ " istnieje");
        }else{
            try {
                new_level.createNewFile();
            } catch (IOException e) {
                System.out.println(new_level);
                throw new RuntimeException(e);
            }

        }
        //WriteToFile(NewLevel, idArr);
    }
    public static int[][] GetLevelData(String name){
        System.out.println("Get Level Data");
        File lvlFile = new File("./res/" + name + ".txt");
        System.out.println("pobrano plik: "+ name+".txt");
        if(lvlFile.exists()){
            System.out.println("Plik: "+name+ " istnieje");
            ArrayList<Integer> list = ReadFromFile(lvlFile);
            return Utilz.ArrayListTo2D(list,20,20);
        }else{
            System.out.println("Plik: "+name+ " nie istnieje");
            return null;
        }
    }
}
