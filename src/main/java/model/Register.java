package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Comparator;

@Data
@AllArgsConstructor
@Builder
public class Register {

    private Product product;
    private int selledQuantity;
    private double totalSelledQuantity;

    public Register(Product product, int selledQuantity) {
        this.product = product;
        this.selledQuantity = selledQuantity;
        this.totalSelledQuantity = 0;
    }

    public static Comparator<Register> nameComparator = new Comparator<Register>() {

        public int compare(Register r1, Register r2) {
            String productName1 = r1.getProduct().getProductName();
            String productName2 = r2.getProduct().getProductName();

            return productName1.compareToIgnoreCase(productName2);
        }
    };


}
