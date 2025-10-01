package lab8_2;

import java.util.Iterator;

public class NameRepository implements Containers {
    
    // final เพื่อให้ Anonymous Inner Class เข้าถึงได้
    final String[] names = {"John", "May", "Ryan"}; 

    @Override
    public Iterator getIterator() {
        
        // การสร้าง Anonymous Inner Class เพื่อ Implement Iterator
        return new Iterator() { 
            
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < names.length;
            }

            @Override
            public Object next() {
                if (this.hasNext()) {
                    return names[index++];
                }
                return null;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException(); 
            }
        };
    }
}
