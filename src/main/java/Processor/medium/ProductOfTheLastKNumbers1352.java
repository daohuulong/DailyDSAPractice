package Processor.medium;

import java.util.ArrayList;
import java.util.List;

public class ProductOfTheLastKNumbers1352 {
    public static class ProductOfNumbers {
        List<Integer> product;
        int lastZeroNumberIndex;

        public ProductOfNumbers() {
            this.product = new ArrayList<>();
            this.product.add(1);
            this.lastZeroNumberIndex = Integer.MIN_VALUE;
        }

        public void add(int num) {
            if (num == 0) {
                this.lastZeroNumberIndex = this.product.size();
                this.product.add(1);
            } else {
                int lastProduct = this.product.get(this.product.size() - 1);
                this.product.add(num * lastProduct);
            }
        }

        public int getProduct(int k) {
            int firstIndexOfKProducts = this.product.size() - k;
            if (firstIndexOfKProducts <= this.lastZeroNumberIndex)
                return 0;
            int divIndexAtK = this.product.get(firstIndexOfKProducts - 1);
            return this.product.get(this.product.size() - 1) / divIndexAtK;
        }
    }

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
}
