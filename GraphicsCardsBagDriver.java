package assignment4;

public class GraphicsCardsBagDriver {
    public static void main(String[] args) {
        /* GraphicsCards Class Test(s)
        Test GraphicsCards object(s) - constructor test */
        GraphicsCards testGraphicsCards1 = new GraphicsCards("GTX 1060", 5);
        GraphicsCards equalGraphicsCards1 = new GraphicsCards("GTX 1060", 5);
        GraphicsCards equalGraphicsCards2 = new GraphicsCards("GTX 1060", 5);
        GraphicsCards compareToGraphicsCards1 = new GraphicsCards("a", 1);
        GraphicsCards compareToGraphicsCards2 = new GraphicsCards("b", 1);
        
        // Method GraphicsCards setName/getName test
        testGraphicsCards1.setName("code1");
        assert testGraphicsCards1.getName().equals("code1") : 
            "Failure : GraphicsCards setName or getName";
        
        // Method GraphicsCards setQuanity/ge5 test
        testGraphicsCards1.setQuanity(1);
        assert testGraphicsCards1.getQuanity() == 1 : 
            "Failure : GraphicsCards setQuanity or getQuanity";

        // Method GraphicsCards toString test
        assert testGraphicsCards1.toString().equals("code1 1") : 
            "Failure : GraphicsCards toString";

        // Method GraphicsCards eqauls test
        assert equalGraphicsCards1.equals(equalGraphicsCards2) == true : 
            "Failure : GraphicsCards equals";

        // Method GraphicsCards equals test
        assert compareToGraphicsCards1.compareTo(compareToGraphicsCards2) == 
            -1 :"Failure : GraphicsCards compareTo";
        // End of GraphicsCards class test.

        /* Due to time constraints AND because all the funciton will be used and
        therefore tested in GraphicsCardsBSTLinkedBag, I decided not to 
        individually test every method in GraphicsCardsBTNode.*/

        GraphicsCardsBSTLinkedBag test = new GraphicsCardsBSTLinkedBag();
        GraphicsCardsBSTLinkedBag test5 = new GraphicsCardsBSTLinkedBag();

        GraphicsCards test1 = new GraphicsCards("GTX", 1);
        GraphicsCards test2 = new GraphicsCards("RTX", 3);
        GraphicsCards test3 = new GraphicsCards("GTX", 1);
        GraphicsCards test4 = new GraphicsCards("RTX1", 2);
        // ddding test.
        test.add(test1);
        test.add(test2);
        test.add(test3);
        test.add(test4);
        // size test.
        System.out.println(test.size());
        // search test.
        test.search("GTX");
        // countOccurrences test.
        System.out.println(test.countOccurrences(new GraphicsCardsBTNode(test1)));
        // contains test.
        System.out.println(test.contains("RTX1"));
        // countRange test.
        // System.out.println(test.countRange(new GraphicsCards("GTX", 2), new GraphicsCards("GTX", 3)));
        // total test.
        System.out.println(test.total());
        // removing test.
        test.remove(test2);
        // displaying test.
        test.displayLowToHigh();
        // addAll test.
        test5.addAll(test);


    }
}
