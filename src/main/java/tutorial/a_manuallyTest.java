package tutorial;
/*
 * JUnit 是一个用于编写和运行单元测试的开源框架，它是专为 Java 编程语言设计的。
 * 单元测试是测试代码最小单元（通常是类或方法）的过程，JUnit 提供了一个标准化的方法来帮助开发人员确保代码按照预期运行。
 */

 /*
  * 如果不使用JUnit，我们可以手动测试代码。手动测试是指开发人员通过调用方法并检查输出来测试代码。
  * 但是，手动测试是一种低效的测试方法，因为它需要大量的时间和精力。
  * 手动步骤：
    * prepare(test environment, write test method )准备测试环境 创建object，针对不同的unit写不同的测试method
    * provide testing inpout 提供测试用的输入，变量
    * run the test 运行测试
    * provide expected out put 提供预期的输出
    * perform assertion 判断输出
    * report the result of test based on assertion 基于判断提供测试结果
    * 重复步骤，直到所有方法都被测试
  */
  import exampleclass.Calculators;
public class a_manuallyTest {
    public static void main(String[] args){
        // create an object of the class
        Calculators calc1 = new Calculators();
        // test add method
        int result1 = calc1.add(3, 5);
        // assert the result
        if (result1 == 8){
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
    }
}
