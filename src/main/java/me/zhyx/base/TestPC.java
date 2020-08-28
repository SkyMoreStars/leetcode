package me.zhyx.base;

/**
 * @author: yx.zh
 * @date: 2020-06-21 08:43
 **/
public class TestPC {
    public static void main(String[] args) {
        ProductContainer productContainer = new ProductContainer();
        new Thread(new Producer(productContainer)).start();
        new Thread(new Consumer(productContainer)).start();

    }
}

/**
 * 产品
 */
class Product {
    int id;
    String name;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Product setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }
}

/**
 * 生产者
 */
class Producer implements Runnable {
    ProductContainer productContainer;

    public Producer(ProductContainer productContainer) {
        this.productContainer = productContainer;
    }

    @Override
    public void run() {
        /**
         * 生产1000个产品
         */
        for (int i = 0; i < 1000; i++) {
            Product product = new Product(i, "第" + i + "个产品");
            try {
                productContainer.push(product);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 消费者
 */
class Consumer implements Runnable {
    ProductContainer productContainer;

    public Consumer(ProductContainer productContainer) {
        this.productContainer = productContainer;
    }

    @Override
    public void run() {
        /**
         * 消费1000个产品
         */
        for (int i = 0; i < 1000; i++) {
            try {
                Product pop = productContainer.pop();
                System.out.println("消费了第" + pop.getId() + "个产品");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 产品容器
 */
class ProductContainer {
    Product[] products = new Product[10];
    private int count;

    public synchronized void push(Product product) throws InterruptedException {
        /**
         * 容器满了通知生产者等待，通知消费者消费
         */
        if (count == products.length - 1) {
            System.out.println("仓库满了,等待消费者消费");
            wait();
        }
        products[count] = product;
        System.out.println("生产了第" + product.getId() + "个产品");
        count++;
        notifyAll();
    }

    /**
     * 消费者消费
     *
     * @return
     */
    public synchronized Product pop() throws InterruptedException {
        /**
         * 判断能否消费
         */
        if (count == 0) {
            System.out.println("消费完毕等待生产");
            wait();
        }
        /**
         * 消费
         */
        count--;
        Product product = products[count];
        notifyAll();
        return product;

    }
}