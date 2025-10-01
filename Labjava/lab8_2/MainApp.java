package lab8_2;

import java.util.Iterator;

public class MainApp {
    public static void main(String[] args) {
        
        NameRepository namesRepository = new NameRepository();

        System.out.println("Names in repository:");
        // วนลูปเพื่อดึงค่าจาก Iterator
        for (Iterator iter = namesRepository.getIterator(); iter.hasNext();){
            String name = (String) iter.next();
            System.out.println("Name: " + name);
        }
    }
}
