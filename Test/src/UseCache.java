import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UseCache {
    public static void main(String[] args) throws IOException {
        LRUCache<Integer> cache = new LRUCache<Integer>(3);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int choice =1;
        while(choice!=0){
            System.out.println("Press 1 for Put\nPress 2. for Get\nPress 3. to Delete\n Press 0 to Exit.");
            choice= Integer.parseInt(br.readLine());
            String key;
            int value;

            switch (choice){
                case 1:
                    System.out.println("Enter the key");
                    key=br.readLine();
                    System.out.println("Enter the value");
                  value= Integer.parseInt(br.readLine());
                    cache.put(key,value);
                    System.out.println("Inserted into cache");
                    break;
                case 2:
                    System.out.println("Enter Key");
                    key=br.readLine();
                    System.out.println("Value is "+ cache.get(key) +"\n");
                    break;
                case 3:
                    System.out.println("Enter key to delete ");
                    key=br.readLine();
                    cache.delete(key);
                    System.out.println("Deleted");
                    break;
                case 0:
                    System.out.println("Thanks for using the cache");
                    break;

            }
        }
    }
}
