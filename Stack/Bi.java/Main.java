
public class Main {
    public static void main(String[] args) {
        System.out.println("==================== Decimal => Binary ======================");
    Converter converter = new Converter();
    converter.decimalToBinary(23);  // Should print: 10111
    System.out.println(" ");
    
        System.out.println("==================== Binary => Decimal ======================");

    converter.binaryToDecimal("10111"); 
}
}
