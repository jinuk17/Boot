package pub.jayden.boot.practice;

import lombok.*;

import java.math.BigDecimal;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by jaydenuk on 2015. 11. 25..
 */
@Data
public class TestApp {

    public static void main(String[] args) throws Exception {
//        MyResource myResource = null;
//        try{
//            myResource = new MyResource();
//            System.out.println(myResource.getResource());
//        }finally {
//            if(myResource != null){
//                try {
//                    myResource.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        test(()->(AutoCloseable & TypeA & TypeB)(()->System.out.println("I'm a really cool closing method!!")));

        System.out.println(productFunction.apply("Product", new Product(1L, "A", new BigDecimal(100))));

        try {
            try(MyResource myResource = new MyResource()){
                System.out.println(myResource.getResource());
            }finally {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Stream.of(
                new Product(1L, "A", new BigDecimal("10")),
                new Product(2L, "B", new BigDecimal("50")),
                new Product(3L, "C", new BigDecimal("90"))
        ).map(product -> productFunction.apply("Item", product))
                .forEach(value -> System.out.println(value));
    }

    static BiFunction<String, Product, String> productFunction = (prefix, product) -> prefix + ":" + product.toString();


    private static <T extends AutoCloseable & TypeA & TypeB> void test(Supplier<T> resource) throws Exception {
        try(T t = resource.get()){
            t.runA();
            t.runB();
        }finally {
            System.out.println("I'm finally.");
        }
    }

}

@AllArgsConstructor
@Data
class Product{
    private Long id;
    private String name;
    private BigDecimal price;
}


interface TypeA{
    default void runA(){
        System.out.println("TypeA.runA()...");
    }
}

interface TypeB{
    default void runB(){
        System.out.println("TypeB.runB()...");
    }
}



class MyResource implements AutoCloseable{

    public String getResource(){
        return "Something";
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing resource");
    }
}