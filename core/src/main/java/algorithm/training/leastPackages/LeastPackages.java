package algorithm.training.leastPackages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * find least packages which contains all products.
 * products: a, b, c, d, e, f, g, h.
 * package:
 * 1: a, b, c, d, e, g.
 * 2: a, b, c, d, f.
 * 3: e, g, h.
 * leastPackages: [2, 3].
 */
public class LeastPackages {
    class Product{

    }

    class Package implements Comparable<Package>{
        private List<Product> products;

        @Override
        public int compareTo(Package o) {
            return this.products.size() - o.products.size();
        }
    }

    List<Product> allProducts;
    List<Package> allPackages;

    public List<Package> findLeastPackages() {
        Collections.sort(allPackages);
        List<Package> leastPackages = new ArrayList<>();
        for(Package packet : allPackages){
            if(allProducts.removeAll(packet.products)){
                leastPackages.add(packet);
//
            }
        }
        return leastPackages;
    }
}
