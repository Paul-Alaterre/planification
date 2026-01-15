package  scheduling.factoredconstraints;
import schedulingtests.factoredconstraints.MeetConstraintTests;
import schedulingtests.factoredconstraints.PrecedenceConstraintTests;
import schedulingtests.factoredconstraints.PrecedenceConstraintWithGapTests;

/**
*La classe de tests
*/

public class Test {
    public static void main(String[] args) {
        boolean ok = true;
		// Precedence constraints
		PrecedenceConstraintTests precedenceConstraintTester
		= new PrecedenceConstraintTests();
		ok = ok && precedenceConstraintTester.testGetFirst();
		ok = ok && precedenceConstraintTester.testGetSecond();
		ok = ok && precedenceConstraintTester.testExtends();
		ok = ok && precedenceConstraintTester.testIsSatisfied();
		// Meet constraints
		MeetConstraintTests meetConstraintTester = new MeetConstraintTests();
		ok = ok && meetConstraintTester.testGetFirst();
		ok = ok && meetConstraintTester.testGetSecond();
		ok = ok && meetConstraintTester.testExtends();
		ok = ok && meetConstraintTester.testIsSatisfied();
		// Precedence constraints with gap
		PrecedenceConstraintWithGapTests precedenceConstraintWithGapTester
		= new PrecedenceConstraintWithGapTests();
		ok = ok && precedenceConstraintWithGapTester.testExtends();
		ok = ok && precedenceConstraintWithGapTester.testGetFirst();
		ok = ok && precedenceConstraintWithGapTester.testGetSecond();
		ok = ok && precedenceConstraintWithGapTester.testIsSatisfied();
		System.out.println(ok ? "All tests passed" : "At least one test failed");
    }
}
