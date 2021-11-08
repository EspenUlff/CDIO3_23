public class Package {
}

/*
package pkg1

class A {
  void foo();
  public void bar() {};
}

package pkg1

public class B extends A{

}

package pkg2

public class C {
  public void doSomething() {
   B b = new B();
   b.bar(); //ok
   b.foo(); //won't work, since foo() is not visible outside of package 'pkg1'

   A a = new A(); //won't work since A is not visible outside of package 'pkg1'
   a.bar(); //won't work, since a cannot be created
  }
}
 */