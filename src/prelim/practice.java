package prelim;

public class practice {

    public static class Bag {
        private String type;
        private String brand;
        private int pockets;

        public Bag() {
            type = "backpack";
            brand = "unbranded";
            pockets = 2;
        }

        public Bag(String type, String brand, int pockets) {
            this.type = type;
            this.brand = brand;
            this.pockets = pockets;
        }

        public String getType() {
            return type;
        }

        public String getBrand() {
            return brand;
        }

        public int getPockets() {
            return pockets;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public void setPockets(int pockets) {
            this.pockets = pockets;
        }

        public String toString() {
            return brand + ", " + type + ", " + pockets + " pockets";
        }
    }

    public static void main(String[] args) {
        MySinglyLinkedList<Bag> bagList = new MySinglyLinkedList<Bag>();
        // type, brand, pockets
        Bag bag1 = new Bag("backpack", "jansport", 5);
        Bag bag2 = new Bag("sling", "nike", 5);
        Bag bag3 = new Bag("knapsack", "adidas", 5);
        Bag bag4 = new Bag("carry-on", "dickies", 5);
        Bag bag5 = new Bag("luggage", "penshoppe", 5);
        Bag bag6 = new Bag("fanny", "gap", 5);
        Bag bag7 = new Bag("fanny", "adison", 5);
        bagList.sortedInsert(bag1);
        bagList.sortedInsert(bag2);
        bagList.sortedInsert(bag3);
        bagList.sortedInsert(bag4);
        bagList.sortedInsert(bag5);
        bagList.sortedInsert(bag6);
        bagList.sortedInsert(bag7);
        System.out.println(bagList);


    }
}
