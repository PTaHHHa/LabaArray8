import java.beans.XMLEncoder;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[]args) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Element1");
        list.add("Element2");
        list.add("Element3");
        System.out.println(list);
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("1.Add element");
            System.out.println("2.Remove element");
            System.out.println("3.Reverse list");
            System.out.println("4.Search in list");
            System.out.println("5.Reading file into List");
            System.out.println("6.Get length of elements in List");
            System.out.println("7.List to XML");
            String choice = input.nextLine();
            if (choice.equals("1")){
                while (true){
                    System.out.println("Input element to add or press 'Enter' to leave");
                    String user = input.nextLine();
                    if(!user.equals("")) {
                        if (list.size() < 5) {
                            list.add(user);
                            System.out.println(list);
                        }
                        else{
                            list.remove(0);
                            list.add(user);
                            System.out.println(list);
                        }
                    }
                    else
                        break;
                }
            }
            if (choice.equals("2")){
                if (list.size()==0){
                    System.out.println("Your list is empty. You should add elements first");
                }
                else {
                    while (true){
                        System.out.println(list);
                        System.out.println("Input element to remove from list or press 'Enter' to leave");
                        String user = input.nextLine();
                        if(!user.equals("")) {
                            if(list.contains(user)) {
                                list.remove(user);
                                System.out.println(list);
                            } else {
                                System.out.println("Element doesn't exist in list");
                            }
                        }
                        else
                            break;
                    }
                }
            }
            if (choice.equals("3")){
                ArrayList<String> new_list = new ArrayList<>();
                System.out.println(list);
                new_list = list;
                System.out.println("Reversed list");
                Collections.reverse(new_list);
                System.out.println(new_list);
            }
            if(choice.equals("4")){
                System.out.println(list);
                System.out.println("Searching...");
                String user = input.nextLine();
                int index1 = list.indexOf(user);
                if(index1 == -1){
                    System.out.println("The element "+user+" is not in List");
                }
                else
                    System.out.println("The element "+user+" is in List");
            }
            if(choice.equals("5")){
                try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\IT HYPE\\Desktop\\LabaArray\\src\\text.txt")))
                {
                    String sCurrentLine;
                    while ((sCurrentLine = br.readLine()) != null) {
                        String[]splitted=sCurrentLine.split(" ");
                        System.out.println(Arrays.toString(splitted));
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(choice.equals("6")){
                ArrayList<String> new_list = new ArrayList<>();
                new_list=list;
                for(int i=0;i<list.size();i++){
                    Integer a = list.get(i).length();
                    new_list.set(i,a.toString());
                }
                System.out.println(new_list);
            }
            if(choice.equals("7")){
                XMLEncoder e = new XMLEncoder(new BufferedOutputStream(
                        new FileOutputStream("Test.xml")));
                e.writeObject(list);
                e.close();
                System.out.println("Check Test.xml file");
            }
        }
    }
}
