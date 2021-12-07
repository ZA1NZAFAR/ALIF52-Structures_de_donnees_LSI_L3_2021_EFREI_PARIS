public class MAIN {
    public static void main(String[] args) {
        System.out.println("TESTS Pile Array");
        PileArrayImplementation pileArrayImplementation = new PileArrayImplementation();
        pileArrayImplementation.push(5);
        pileArrayImplementation.push(6);
        pileArrayImplementation.push(7);
        System.out.println(pileArrayImplementation);
        System.out.println(pileArrayImplementation.top());
        pileArrayImplementation.pop();
        System.out.println(pileArrayImplementation);
        pileArrayImplementation.push(7);
        System.out.println(pileArrayImplementation);


        System.out.println("TESTS Pile Linked List");
        PileLinkedListImplementation pileLinkedListImplementation = new PileLinkedListImplementation();
        pileLinkedListImplementation.push(5);
        pileLinkedListImplementation.push(6);
        pileLinkedListImplementation.push(7);
        System.out.println(pileLinkedListImplementation);
        System.out.println(pileLinkedListImplementation.top());
        pileLinkedListImplementation.pop();
        System.out.println(pileLinkedListImplementation);

        System.out.println("TESTS Pile with a File");
        PileFileImplementation pileFileImplementation = new PileFileImplementation();
        pileFileImplementation.push(5);
        pileFileImplementation.push(6);
        pileFileImplementation.push(7);
        pileFileImplementation.push(8);
        pileFileImplementation.push(9);
        System.out.println(pileFileImplementation);
        pileFileImplementation.pop();
        System.out.println(pileFileImplementation);
        System.out.println(pileFileImplementation.top());
    }
}
