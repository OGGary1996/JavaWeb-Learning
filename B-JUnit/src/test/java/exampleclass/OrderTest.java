package exampleclass;

import org.junit.jupiter.api.*;

import java.util.Objects;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // 指定测试方法的执行顺序
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderTest {
    // 根据测试方法的个数决定构造器执行的个数
    public OrderTest(){
        System.out.println("Constructor: Creating an instance of OrderTest");
    }

    // 指定共享资源
    @BeforeAll
    static void setup(){
        // 在创建测试类实例执行之前运行一次
        System.out.println("Setting up resources for tests...");
        System.out.println("======================================");
    }
    @AfterAll
    static void cleanup(){
        // 清理资源
        System.out.println("Cleaning up resources after all tests...");
        System.out.println("======================================");
    }

    // 指定每个方法之前的初始化
    @BeforeEach
    void init(){
        // 在每个测试方法执行之前运行，并且听过HashCode验证是否每次都创建了新的测试类实例
        System.out.println("Initializing before each test...");
        System.out.println("HashCode of current instance: " + Objects.hashCode(this));
    }

    @AfterEach
    void tearDown(){
        // 在每个测试方法执行之后运行
        System.out.println("Cleaning up after each test...");
    }

    // 模拟方法
    @Test
    @Order(1) // 指定测试方法的执行顺序
    void testOrderCreation() {
        // 测试订单创建逻辑
        System.out.println("Testing order creation...");
        // 这里可以添加实际的测试逻辑
        Assertions.assertTrue(true, "Order should be created successfully");
    }
    @Test
    @Order(2) // 指定测试方法的执行顺序
    void testOrderCancellation() {
        // 测试订单取消逻辑
        System.out.println("Testing order cancellation...");
        // 这里可以添加实际的测试逻辑
        Assertions.assertTrue(true, "Order should be cancelled successfully");
    }
    @Test
    @Order(3) // 指定测试方法的执行顺序
    void testOrderUpdate() {
        // 测试订单更新逻辑
        System.out.println("Testing order update...");
        // 这里可以添加实际的测试逻辑
        Assertions.assertTrue(true, "Order should be updated successfully");
    }
}
