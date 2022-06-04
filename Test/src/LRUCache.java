import java.util.HashMap;
import java.util.Map;

public class LRUCache<T>{
    private final int capacity;
    private final Map<String, Node> hashmap;
    private final DoublyLinkedList doublyLinkedList;
    private int size;

   public LRUCache(final int capacity){
       this.capacity=capacity;
       hashmap = new HashMap<>();
       doublyLinkedList = new DoublyLinkedList();
       size=0;
   }

   public T get(final String k){
Node node = hashmap.get(k);

if (node==null) return null;
       doublyLinkedList.moveNodetoFront(node);
return node.value;


   }

   public void put(final String key, final T value){
       Node currNode = hashmap.get(key);
       if(currNode!=null){
           currNode.value=value;
           doublyLinkedList.moveNodetoFront(currNode);
       }

       if(size==capacity){
           String removeKey= doublyLinkedList.getRearNodeKey();
           doublyLinkedList.deleteNodeFromRear();
           hashmap.remove(removeKey);
           size--;
       }

       Node newNode = new Node(key, value);
       doublyLinkedList.addNodetoFront(newNode);
       hashmap.put(key,newNode);
       size++;

   }

   public void delete(final String key){
       Node toBeDeletedNode=hashmap.get(key);
       if(toBeDeletedNode==null){
           System.out.println("Key donot exist");
           return;
       }
       doublyLinkedList.removeNode(toBeDeletedNode);
       hashmap.remove(key);
       size--;
   }

   private class Node
   {
       String key;
       T value;
       Node next,prev;
       public Node(final String key, final T value){
           this.key=key;
           this.value=value;
           this.next=null;
           this.prev=null;
       }
   }

   private class DoublyLinkedList{
       private Node front,rear;

       public DoublyLinkedList(){
           front=rear=null;
       }
       public void addNodetoFront(Node node){
           if(rear==null){
               front=rear=node;
               return;
           }
           node.next=front;
           front.prev=node;
           front=node;

       }
       public void moveNodetoFront(Node node){
           if(front==node){
               return;
           }
           if(rear==node){
               node.prev.next=null;
               rear=node.prev;
           }
           else {
               node.prev.next=node.next;
               node.next.prev=node.prev;
           }

           addNodetoFront(node);

       }
       public void deleteNodeFromRear(){
           if(rear==null){
               return;
           }
           System.out.println("Removing key"+ rear.key);
           if(front==rear){
               front=rear=null;
           }
            rear=rear.prev;
            rear.next=null;
       }

       public String getRearNodeKey(){
return  rear.key;
       }

       public void removeNode(Node node){
           System.out.println("Deleting the node *"+ node.key);
           if(front==node){
               front=node.next;
               return;
           }
           if(rear==node){
               deleteNodeFromRear();
               return;
           }
           node.prev.next=node.next;
           node.next.prev=node.prev;
       }
   }
}
