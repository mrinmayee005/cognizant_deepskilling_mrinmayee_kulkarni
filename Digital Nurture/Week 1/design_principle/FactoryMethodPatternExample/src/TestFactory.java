public class TestFactory {
    public static void main(String[] args) {

        DocumentFactory factory;

        // Create Word Document
        factory = new WordFactory();
        Document doc1 = factory.createDocument();
        doc1.open();

        // Create PDF Document
        factory = new PdfFactory();
        Document doc2 = factory.createDocument();
        doc2.open();

        // Create Excel Document
        factory = new ExcelFactory();
        Document doc3 = factory.createDocument();
        doc3.open();
    }
}