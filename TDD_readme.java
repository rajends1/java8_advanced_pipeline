mport org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.BDDMockito.given;

//import static org.testng.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MockitTest {


    private static final long FIRST_NUMBER = 12L;
    private static final long SECOND_NUMBER = 8L;
    @Mock
    private NumberSource source;

/*
I/P | ACTAUL_ADD_FUN_DESIGN_RESULT  | O/P (EXPECTED)

1,2   | a  | 1 -> fail as expected is 3 (1+2) 
1,2  | a+b  |  3  ->pass after correcting code design to a+b from just "a" formula

 */
    //given- INPUT
    @Before
    public void beforeEachTest() {
        // Calculator calculator = new Calculator(source);
        // long result = calculator.fetchTwoAndAdd();
       // Given Initial condition -INPUT
        MockitoAnnotations.initMocks(this);
      //  Mockito.when(source.fetchNextNumber()).thenReturn(FIRST_NUMBER,SECOND_NUMBER);
        //   String result=;
        // Mockito.when(calculator.getResult("test")).thenReturn("yyy");
    }

    @Test
    public void shouldReturnGivenValueUsingBDDSemantics() {

        //given - given dynamically by mock  parameter of method or url input data 
        //  Flower flowerMock = mock(Flower.class);
        given(source.fetchNextNumber()).willReturn(FIRST_NUMBER, SECOND_NUMBER);


        //when -- calculation operation or method functionality inside method or url operation results will be
        Calculator calculator = new Calculator(source);
        //  long result = calculator.fetchTwoAndAdd();
        long result = calculator.fetchTwoAndAdd();

       //then  -actual Design  or URl function or Operation function 
      //  assertThat(result + "", is("20"));
        //         ACTUAL_DESIGN_FN_res . O_P_EXPECTED

assertThat(result,is(FIRST_NUMBER+SECOND_NUMBER));
}

}
------------------

 
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

//import static org.testng.Assert.assertEquals;

public class MockitTest {


    private static final long FIRST_NUMBER = 12L;
    private static final long SECOND_NUMBER = 8L;
    @Mock
    private NumberSource source;

/*
I/P | ACTAUL_ADD_FUN_DESIGN_RESULT  | O/P (EXPECTED)

1,2   | a  | 1 -> fail as expected is 3 (1+2)
1,2  | a+b  |  3  ->pass after correcting code design to a+b from just "a" formula

 */
    //given- INPUT
    @Before
    public void beforeEachTest() {
        // Calculator calculator = new Calculator(source);
        // long result = calculator.fetchTwoAndAdd();
       // Given Initial condition -INPUT
        MockitoAnnotations.initMocks(this);
      //  Mockito.when(source.fetchNextNumber()).thenReturn(FIRST_NUMBER,SECOND_NUMBER);
        //   String result=;
        // Mockito.when(calculator.getResult("test")).thenReturn("yyy");
    }

    @Test
    public void shouldReturnGivenValueUsingBDDSemantics() {

        //given - given dynamically by mock  parameter of method or url input data
        //  Flower flowerMock = mock(Flower.class);
        given(source.fetchNextNumber()).willReturn(FIRST_NUMBER, SECOND_NUMBER);

        List ls= new ArrayList();
        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.add(4);

        //when -- calculation operation or method functionality inside method or url operation results will be
        Calculator calculator = new Calculator(source);
        //  long result = calculator.fetchTwoAndAdd();
        long result = calculator.fetchTwoAndAdd();
       System.out.println(calculator.sumStream(ls));
       //then  -actual Design  or URl function or Operation function
      //  assertThat(result + "", is("20"));
        //         ACTUAL_DESIGN_FN_res . O_P_EXPECTED
        List<String> lines = Arrays.asList("spring", "node", "mkyong");

        List<String> res = lines.stream()                // convert list to stream
                .filter(line -> !"mkyong".equals(line))     // we dont like mkyong
                .collect(Collectors.toList());              // collect the output and convert streams to a List

        res.forEach(System.out::println);                //output : spring, node
       
        Greetings greetingsInstance=n -> System.out.println("Hello World " + n);
        greet(greetingsInstance, "Tom");
        Runnable hellow = () -> System.out.println("hellow");
      
      /*
       List list = new ArrayList();

        list.add(15);
        list.add(5);
        list.add(10);
        list.add(25);
        list.add(60);
       */
      
        // int sum = list.stream().filter(i -> i > 10).mapToInt(i -> i).sum();

      //  System.out.println(sum);

        assertThat(result,is(FIRST_NUMBER+SECOND_NUMBER));
    }
    private static void greet(Greetings greetingsInstance, String name) {
        greetingsInstance.sayHello(name);
    }
}



https://www.viewfromthecodeface.com/how-to-write-a-tdd-unit-test-with-java/E.g. thenReturn() may be missing.


mock input number of parameters in functions/methods .

the calculation needs to be  use appropriate parametrs to calculate appropriate value 


---------------
say expected = para1/FIRST_NUMBER +para2/SECOND_NUMBER contsnt = 6 . in order to pass  

 mock sends 2 diff para with  when().return (para1,para2)  -> (2,4)  and if inside methods calculated para1+para2  will be 6 The test passes as below 

method result is  2+4=6 which is equal to expected value defined setup contsant  = para1+para2 contsnt = 6 . test passes 
@Mock
private NumberSource source ;

@Before
public void beforeEachTest() {
    MockitoAnnotations.initMocks(this);
    
Mockito.when(source.fetchNextNumber()).thenReturn(FIRST_NUMBER,SECOND_NUMBER);

}


calculater..

  public long fetchTwoAndAdd() {
        // return 20L;
        return source.fetchNextNumber() + source.fetchNextNumber();
    }
}
test PASSED with exit 0 ..
Process finished with exit code 0

---------------------
say expected =  para1/FIRST_NUMBER +para2/SECOND_NUMBER contsnt = 6 . in order to fail 

mock sends only 1 para1  then it is like  when().return (para1)  ->  (2)  and if inside methods calculated para1+para1  will be 4 The test passes as below 

method result is  2+2=4 which is NOT equal to expected value defined setup contsant  = para1+para2 contsnt = 6 . test fails as 4 is NOT Eq. 6 
import org.junit.Before;
import org.junit.Test;

import  org.mockito.Mock;
import  org.mockito.MockitoAnnotations;
import  org.mockito.Mockito;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculaterTest {

    private static final long FIRST_NUMBER = 12L;
    private static final long SECOND_NUMBER = 8L;

    // write a stub object
    @Mock
    private NumberSource source ;

    @Before
    public void beforeEachTest() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(source.fetchNextNumber()));
    }

    @Test
    public void addsTwoNumbers(){

        Calculator calculator = new Calculator(source);
        long result = calculator.fetchTwoAndAdd();

        assertThat(result,is(FIRST_NUMBER+SECOND_NUMBER));
    }

}


public class Calculator {
    private  NumberSource source ;

    public Calculator( final NumberSource source ) {
        this.source = source;
    }


    public long fetchTwoAndAdd() {
        // return 20L;
        return source.fetchNextNumber() + source.fetchNextNumber();
    }
}


java.lang.AssertionError: 
Expected: is <20L>
     but: was <24L>
Expected :is <20L>
     
Actual   :<24L>

--------------------------------------------------------------


Examples of correct stubbing:
    when(mock.isOk()).thenReturn(true);
    when(mock.isOk()).thenThrow(exception);
    doThrow(exception).when(mock).someVoidMethod();
Hints:
 1. missing thenReturn()
 2. although stubbed methods may return mocks, you cannot inline mock creation (mock()) call inside a thenReturn method (see issue 53)


	at Calculator.fetchTwoAndAdd(Calculator.java:11)
	at CalculaterTest.addsTwoNumbers(CalculaterTest.java:29)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:26)
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)
	at com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)
	at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)
	at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)

org.mockito.exceptions.base.MockitoException: 
Cannot call real method on java interface. Interface does not have any implementation!
Calling real methods is only possible when mocking concrete classes.
  //correct example:
  when(mockOfConcreteClass.doStuff()).thenCallRealMethod();

	at CalculaterTest.beforeEachTest(CalculaterTest.java:22)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
	at org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:24)
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)
	at com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)
	at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)
	at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)


Process finished with exit code -1
